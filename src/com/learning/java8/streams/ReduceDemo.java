package com.learning.java8.streams;

import java.util.Arrays;
import java.util.List;

public class ReduceDemo {

	public static void main(String[] args) {
		int[] numbers = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		int sum = Arrays
					.stream(numbers)
					.reduce(0, ((a,b)-> (a+b)));
		System.out.println(sum);
		int max = Arrays
					.stream(numbers)
					.reduce(Integer.MIN_VALUE, ((a,b)->{
						if(a>b) return a; else return b;
					}));
		System.out.println(max);
		
		List<Person> personList = Arrays.asList(new Person("ajay",30), new Person("akshay",45),new Person("vijay",40));
		personList.stream()
									.reduce((a,b)->{
										if(a.age>b.age)
											return a;
										else
											return b;
									})
									.ifPresent(x -> System.out.println(x.name));

	}

}

class Person {
	String name;
	int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
}
