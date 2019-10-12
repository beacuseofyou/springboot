package com.hzydbs.service;

import com.hzydbs.dao.FileInfoDao;
import com.hzydbs.model.FileInfo;
import com.hzydbs.utils.FastDFSClient;
import org.csource.common.NameValuePair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * author: San Jinhong
 * date: 2019/10/12 13:01
 **/
@Service
public class FileInfoService {

	@Autowired
	private FileInfoDao fileInfoDao;

	public FileInfo getFileInfoById(Integer id) {
		FileInfo fileInfo = fileInfoDao.findById(id);
		return fileInfo;
	}

	public String findFileUrlById(Integer id) {
		return fileInfoDao.findFileUrlById(id);
	}

	public void uploadFile(String localFilePath, String filePattern) {
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
		fileInfoDao.insertFileInfo();
	}
}
