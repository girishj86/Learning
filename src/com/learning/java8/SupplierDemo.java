package com.learning.java8;

import java.util.Random;
import java.util.function.Supplier;

public class SupplierDemo {

	public static void main(String[] args) {
		Supplier mySupplier = new MySupplier();
		System.out.println(mySupplier.get());
		
		Supplier myLambdaSupplier = () -> {
			Random random = new Random();
			return random.nextInt(50);
		};
		System.out.println(myLambdaSupplier.get());

	}

}

class MySupplier implements Supplier<Integer>{
	
	@Override
	public Integer get() {
		Random random = new Random();
		return random.nextInt(100);
	}
	
}