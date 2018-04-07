package com.example.cache.book;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Book implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Book(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}