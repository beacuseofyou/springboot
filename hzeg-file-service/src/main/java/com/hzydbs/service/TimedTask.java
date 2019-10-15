package com.hzydbs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * author: San Jinhong
 * date: 2019/10/15 9:54
 **/
@Configuration      //1.主要用于标记配置类
@EnableScheduling   // 2.开启定时任务
public class TimedTask {

	@Autowired
	private FileInfoService fileInfoService;

	//3.添加定时任务:每天凌晨执行一次
	@Scheduled(cron = "0 0 0 * * ?")
	private void deleteFile() {
		fileInfoService.deleteFile();
	}
}
