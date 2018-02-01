package com.example.cache.movie;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

import com.example.cache.Application;

@Repository("bookDao")
public class BookDaoImpl implements BookDao {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	@Cacheable(value = "movieFindCache", key = "#name")
	public Book findByName(String name) {
		log.debug("Accessing database");
		return new Book(1, name);
	}

}