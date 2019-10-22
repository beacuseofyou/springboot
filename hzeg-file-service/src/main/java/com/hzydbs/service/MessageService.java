package com.hzydbs.service;

import com.hzydbs.model.Message;
import org.springframework.stereotype.Service;

/**
 * author: San Jinhong
 * date: 2019/10/22 10:57
 **/
@Service
public class MessageService {

	public void sendMessage(long delayTime, String msg){
		Message message = new Message(delayTime, msg);
		MessageConsumer.getQueue().add(message);
	}
}
