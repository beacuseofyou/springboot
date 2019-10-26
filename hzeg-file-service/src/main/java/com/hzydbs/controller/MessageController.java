package com.hzydbs.controller;

import com.hzydbs.response.Response;
import com.hzydbs.service.MessageService;
import com.hzydbs.utils.ErrorCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


/**
 * author: San Jinhong
 * date: 2019/10/22 10:59
 **/

@RestController
@RequestMapping("message")
public class MessageController {

	@Autowired
	private MessageService messageService;

	@GetMapping("test")
	public Response test(@RequestParam ("delayTime") long delayTime, @RequestParam("message") String message){
		Response response = new Response();
		messageService.sendMessage(delayTime, message);
		response.setCode(ErrorCode.OK.value);
		response.setMessage(ErrorCode.OK.memo);
		return response;
	}
}
