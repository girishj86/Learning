package com.learning.java8;

import java.util.function.Consumer;

public class ConsumerDemo {

	public static void main(String[] args) {
		Consumer<Integer> myConsumerLambda = (x) -> {
			System.out.println(x*x);
		};
		myConsumerLambda.accept(5);
		Consumer<String> myConsumer = new MyConsumer();
		myConsumer.accept("hello");

	}

}

class MyConsumer implements Consumer<String>{

	@Override
	public void accept(String t) {
		System.out.println(t+" "+t);
	}
	
}
