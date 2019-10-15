package com.hzydbs.service;

import com.hzydbs.dao.FileInfoDao;
import com.hzydbs.model.FileInfo;
import com.hzydbs.utils.DateUtil;
import com.hzydbs.utils.FastDFSClient;
import org.csource.common.NameValuePair;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.*;
import java.util.Date;
import java.util.List;

/**
 * author: San Jinhong
 * date: 2019/10/12 13:01
 **/
@Service
public class FileInfoService {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileInfoService.class);

	@Autowired
	private FileInfoDao fileInfoDao;

	/**
	 * @description: 上传文件
	 * @param localFilePath 本地文件路径
     * @param filePattern 文件格式
	 * @return: int t_file_info主键自增id
	 * @author: San Jinhong
	 * @date: 2019/10/15 9:10
	 */
	public int uploadFile(String localFilePath, String filePattern) {
		File file = new File(localFilePath);
		byte[] fileBytes = new byte[0];
		try {
			FileInputStream fis = new FileInputStream(file);
			fileBytes = new byte[fis.available()];
		} catch (IOException e) {
			e.printStackTrace();
		}

		String fileId = FastDFSClient.upload(fileBytes, filePattern, null);
		FileInfo fileInfo = new FileInfo();
		fileInfo.setFileId(fileId);
		fileInfo.setFileUrl("111");
		fileInfo.setFileType("1");
		fileInfo.setInvalidTime(DateUtil.getFormate(new Date()));
		fileInfo.setUploadTime(DateUtil.getFormate(new Date()));
		fileInfoDao.insertFileInfo(fileInfo);
		LOGGER.info("=============文件自增id:{}", fileInfo.getId());
		return fileInfo.getId();
	}

	/**
	 * @description: 下载文件
	 * @param filePath  文件路径
	 * @param fileName  文件名
	 * @param fileId  待下载的文件fileId
	 * @return: void
	 * @author: San Jinhong
	 * @date: 2019/10/14 17:22
	 */
	public void downloadFile(String filePath, String fileName, String fileId) {
		byte[] bytes = FastDFSClient.downloadFile(fileId);
		BufferedOutputStream bos = null;
		FileOutputStream fos = null;
		File file = null;
		try {
			File dir = new File(filePath);
			if(!dir.exists() && !dir.isDirectory()){//判断文件目录是否存在
				dir.mkdirs();
			}
			file = new File(filePath + File.separator + fileName);
			fos = new FileOutputStream(file);
			bos = new BufferedOutputStream(fos);
			bos.write(bytes);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (bos != null) {
				try {
					bos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			if (fos != null) {
				try {
					fos.close();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}
	}

	/**
	 * @description: 逻辑删除操作
	 * @param fileId 文件id
 	 * @param isDelete 逻辑删除状态
	 * @return: void
	 * @author: San Jinhong
	 * @date: 2019/10/15 10:34
	 */
	public void updateIsDelete(String fileId, int isDelete) {
		fileInfoDao.updateIsDeleteByFileId(fileId, isDelete);
	}

	/**
	 * @description: 定时任务：物理删除文件，并清除数据库的文件记录
	 * @param
	 * @return: void
	 * @author: San Jinhong
	 * @date: 2019/10/15 10:36
	 */
	@Transactional
	public void deleteFile() {
		//删除失效时间在前一天的文件记录
		fileInfoDao.deleteByValidTimeOrIsDelete();
		List<FileInfo> fileInfos = fileInfoDao.selectByInvalidTime();
		for (FileInfo fileInfo : fileInfos) {
			FastDFSClient.deleteFile(fileInfo.getFileId());
		}


	}
}
