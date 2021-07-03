package com.learning.java8;

import java.util.function.Function;

public class FunctionalInterfaceDemo {

	public static void main(String[] args) {
		MyFunctionalInterface myFunctionalInterface = () -> {
			System.out.println("my functional interface");
			return "retVal";
		};
		System.out.println(myFunctionalInterface.myMethod());
		
		Function<String,String> myFunction = new MyFunction();
		System.out.println(myFunction.apply("hi"));

	}

}

class MyFunction implements Function<String,String>{

	@Override
	public String apply(String t) {
		return "in myFunction class: "+t;
	}
	
}

@FunctionalInterface
interface MyFunctionalInterface {
	
	String myMethod();
}