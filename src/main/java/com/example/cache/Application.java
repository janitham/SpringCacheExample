package com.example.cache;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.example.cache.book.BookDao;

public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		BookDao obj = (BookDao) context.getBean("bookDao");

		for (int i = 0; i < 5; i++) {
			log.debug("Result : {}", obj.findByName("Mother"));
			slowBy2Secs();
		}

		((ConfigurableApplicationContext) context).close();
	}

	public static void slowBy2Secs() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}