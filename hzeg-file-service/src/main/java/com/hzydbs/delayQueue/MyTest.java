package com.hzydbs.delayQueue;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

/**
 * author: San Jinhong
 * date: 2019/10/21 11:41
 **/
public class MyTest {

	@Test
	public void test() throws InterruptedException {
		// 创建延时队列
		DelayQueue<Message> queue = new DelayQueue<Message>();
		// 添加延时消息,m1 延时3s
		Message m1 = new Message(1, "world", 1000);
		// 添加延时消息,m2 延时10s
		Message m2 = new Message(2, "hello", 3000);
		//将延时消息放到延时队列中
		queue.offer(m2);
		queue.offer(m1);
		// 启动消费线程 消费添加到延时队列中的消息，前提是任务到了延期时间
		ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-call-runner-%d").build();
		ExecutorService executorService = new ThreadPoolExecutor(2,10,0L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(),namedThreadFactory);
		executorService.execute(new Consumer(queue));
		executorService.shutdown();
		Thread.sleep(5000);
	}
}
