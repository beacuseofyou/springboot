package com.hzydbs.model;

import lombok.Data;

/**
 * author: San Jinhong
 * date: 2019/10/12 12:53
 **/
@Data
public class FileInfo {

	private Integer id;
	//文件id
	private String fileId;
	//文件访问路径
	private String fileUrl;
	//文件类型：1 七天 2 永久
	private String fileType;
	//文件上传时间
	private String uploadTime;
	//文件失效时间
	private String invalidTime;
	//逻辑删除：0 未删除 1 已删除
	private int isDelete;
	//用户id
	private String appId;
}
