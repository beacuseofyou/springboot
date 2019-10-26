package com.hzydbs.config;

import com.google.common.util.concurrent.ThreadFactoryBuilder;
import com.hzydbs.service.MessageConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

@Component
public class StartUpRunner implements CommandLineRunner {

    private static final Logger LOGGER = LoggerFactory.getLogger(StartUpRunner.class);

    @Autowired
	private MessageConsumer messageConsumer;


    @Override
    public void run(String... args) throws Exception {
		//开启延时队列执行进程
		ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("thread-call-runner-%d").build();
		ExecutorService executorService = new ThreadPoolExecutor(2,10,0L,TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>(),namedThreadFactory);
		executorService.execute(messageConsumer);
    }
}
