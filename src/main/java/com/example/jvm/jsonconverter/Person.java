package com.example.jvm.jsonconverter;

import java.util.ArrayList;

//import java.util.ArrayList;

public class Person {

	public String name = "Piotr";
	public int indx = 195019;
	public String[] tab_str = {"A", "B"};
	public Integer[] tab_int = {1, 2};
	public ArrayList<String> list_str = new ArrayList<String>() {
		private static final long serialVersionUID = 1L;
		{
			add("A");
			add("B");
		}
	};
	public ArrayList<Integer> list_int = new ArrayList<Integer>() {
		private static final long serialVersionUID = 1L;
		{
			add(1);
			add(2);
		}
	};
	
}
