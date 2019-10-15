package com.hzydbs.controller;

import com.hzydbs.model.FileInfo;
import com.hzydbs.response.Response;
import com.hzydbs.service.FileInfoService;
import com.hzydbs.utils.FastDFSClient;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * author: San Jinhong
 * date: 2019/10/12 13:08
 **/
@RestController
@RequestMapping("fileInfo")
public class FileInfoController {

	private static final Logger LOGGER = LoggerFactory.getLogger(FileInfoController.class);

	@Autowired
	private FileInfoService fileInfoService;

	@RequestMapping("uploadFile")
	public Response uploadFile(@ApiParam(value = "参数", name = "params")@RequestBody Map<String, String> params){
		Response response = new Response();
		Map<String, Object> responseData = new HashMap<>();
		String localFilePath = params.get("localFilePath");
		String filePattern = params.get("filePattern");
		int id = fileInfoService.uploadFile(localFilePath, filePattern);
		responseData.put("id", id);
		response.setData(responseData);
		return response;
	}

	@RequestMapping("showFile")
	public Response showFile(@ApiParam(value = "文件id", name = "fileId") @RequestParam String fileId){
		Response response = new Response();

		return response;
	}

	@RequestMapping("downloadFile")
	public void downloadFile(@ApiParam(value = "参数", name = "params")@RequestBody Map<String, String> params){
		String fileId = params.get("fileId");
		String filePath = params.get("filePath");
		String fileName = params.get("fileName");
		fileInfoService.downloadFile(filePath, fileName, fileId);
	}

	@RequestMapping("logicalDelete")
	public void logicalDelete(@ApiParam(value = "参数", name = "params")@RequestBody Map<String, String> params){
		String fileId = params.get("fileId");
		//更新逻辑删除状态为1：已删除
		fileInfoService.updateIsDelete(fileId, 1);
	}

	@RequestMapping("withdrawDetete")
	public void withdrawLogicalDetete(@ApiParam(value = "参数", name = "params")@RequestBody Map<String, String> params){
		String fileId = params.get("fileId");
		//更新逻辑删除状态为0：未删除
		fileInfoService.updateIsDelete(fileId, 0);
	}
}
