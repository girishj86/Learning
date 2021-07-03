package com.learning.java8;

import java.util.function.Predicate;

public class PredicateDemo {

	public static void main(String[] args) {
		Predicate<String> myPredicate = new MyPredicate();
		System.out.println(myPredicate.test("hi"));
		System.out.println(myPredicate.test("hello"));
		
		Predicate<Integer> myLambdaPredicate = (x) -> x==5;
		System.out.println(myLambdaPredicate.test(5));
		System.out.println(myLambdaPredicate.test(6));
 
	}

}

class MyPredicate implements Predicate<String> {

	@Override
	public boolean test(String t) {
		return t.contentEquals("hi");
	}
	
}