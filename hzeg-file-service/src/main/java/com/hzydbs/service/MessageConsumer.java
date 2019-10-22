package com.hzydbs.service;

import com.alibaba.fastjson.JSONObject;
import com.hzydbs.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.concurrent.DelayQueue;

/**
 * author: San Jinhong
 * date: 2019/10/22 10:53
 **/
@Component
public class MessageConsumer implements Runnable{

	private static Logger logger = LoggerFactory.getLogger(MessageConsumer.class);

	private static DelayQueue<Message> queue = new DelayQueue<>();    //延时队列

	public static DelayQueue<Message> getQueue() {
		return queue;
	}

	@Override
	public void run() {
		while (true){
			logger.info("=============删除文件延迟任务开始========================");
			try {
				Message message = queue.take();
				logger.info("=====定时任务message:{}", JSONObject.toJSONString(message));
			} catch (InterruptedException e) {
				logger.info("====延时队列执行出错====: {}", e.getMessage());
			}
			logger.info("=============删除文件延迟任务结束========================");
		}
	}
}
