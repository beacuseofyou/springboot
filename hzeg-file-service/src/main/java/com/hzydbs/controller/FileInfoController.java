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
		String localFilePath = params.get("localFilePath");
		String filePattern = params.get("filePattern");
		fileInfoService.uploadFile(localFilePath,filePattern);
		return response;
	}

	@RequestMapping("getFileInfoById")
	public Response getFileInfoById(@RequestParam Integer id){
		Response response = new Response();
		Map<String, Object> responseData = new HashMap<>();
		FileInfo fileInfo =  fileInfoService.getFileInfoById(id);
		responseData.put("fileInof", fileInfo);
		response.setData(responseData);
		return response;
	}

	@RequestMapping("findFileUrlById")
	public String findFileUrlById(@RequestParam Integer id){
		return fileInfoService.findFileUrlById(id);
	}

}
