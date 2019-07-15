package com.shenzk.base.java8.domain;

import java.util.ArrayList;
import java.util.List;

public class Father{
	public String name;
	public List<Child> childs = new ArrayList<Child>();
	public Father(String name) {
		this.name = name;
	}
}