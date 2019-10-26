package com.hzydbs.model;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * author: San Jinhong
 * date: 2019/10/22 10:48
 **/
public class Message implements Delayed {
	private long expire;
	private long delayTime;
	private String message;

	public Message(){

	}

	public Message(long delayTime, String message){
		this.expire = System.currentTimeMillis() + delayTime;
		this.message = message;
	}

	public long getExpire() {
		return expire;
	}

	public void setExpire(long expire) {
		this.expire = expire;
	}

	public long getDelayTime() {
		return delayTime;
	}

	public void setDelayTime(long delayTime) {
		this.delayTime = delayTime;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public long getDelay(TimeUnit unit) {
		return unit.convert(this.expire - System.currentTimeMillis() , TimeUnit.MILLISECONDS);
	}

	@Override
	public int compareTo(Delayed o) {
		return (int) (this.getDelay(TimeUnit.MILLISECONDS) -o.getDelay(TimeUnit.MILLISECONDS));
	}
}
