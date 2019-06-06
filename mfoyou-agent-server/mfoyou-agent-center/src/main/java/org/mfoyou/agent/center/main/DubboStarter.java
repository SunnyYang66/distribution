package org.mfoyou.agent.center.main;

import org.springframework.context.support.ClassPathXmlApplicationContext;

//import net.paoding.rose.scanning.context.RoseAppContext;

public class DubboStarter {
	private static void startDubbo(String[] args) {
		//RoseAppContext context = new RoseAppContext();
		//context.start();
		new ClassPathXmlApplicationContext("classpath:/applicationContext.xml");
		com.alibaba.dubbo.container.Main.main(args);
	}

	public static void main(String[] args) {
		startDubbo(args);
	}
}
