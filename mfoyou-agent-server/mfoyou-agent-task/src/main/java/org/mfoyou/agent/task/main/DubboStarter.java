package org.mfoyou.agent.task.main;

import java.util.concurrent.atomic.AtomicInteger;

import org.mfoyou.agent.utils.common.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class DubboStarter {
	static Logger logger = Logger.getLogger(DubboStarter.class);
	
	public static ApplicationContext ac ;

	private static void startDubbo(String[] args) throws InterruptedException {
		ac = new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		
		Runtime.getRuntime().addShutdownHook(new Thread(new Runnable() {
            private volatile boolean hasShutdown = false;
            private AtomicInteger shutdownTimes = new AtomicInteger(0);

            @Override
            public void run() {
                synchronized (this) {
                	logger.info("shutdown hook was invoked, " + this.shutdownTimes.incrementAndGet());
                    if (!this.hasShutdown) {
                        this.hasShutdown = true;
                        long begineTime = System.currentTimeMillis();
                        long consumingTimeTotal = System.currentTimeMillis() - begineTime;
                        logger.info("shutdown hook over, consuming time total(ms): " + consumingTimeTotal);
                    }
                }
            }
        }, "ShutdownHook"));
		TaskController taskController =  ac.getBean("taskController", TaskController.class);
		taskController.init();
	}

	public static void main(String[] args) throws InterruptedException {
		startDubbo(args);
	}

}
