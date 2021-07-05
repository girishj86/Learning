package com.learning.design.patterns.creational;

import java.io.Serializable;

public class SingletonDemo {
	public static void main(String[] args) {
		EagerlyInitializedSingleton eagerlyInitializedSingleton = EagerlyInitializedSingleton.getInstance();
		LazilyInitializedSingleton lazilyInitializedSingleton = LazilyInitializedSingleton.getInstance();
		StaticClassSingleton staticClassSingleton = StaticClassSingleton.getInstance();
		
		EnumSingleton enumSingleton = EnumSingleton.INSTANCE;
		enumSingleton.otherMethods();
		
		//java examples
		Runtime runtime = Runtime.getRuntime();
		System.getSecurityManager();
	}
}

class EagerlyInitializedSingleton {

	//Eagerly initialized
	private static EagerlyInitializedSingleton singleton = new EagerlyInitializedSingleton();

	private EagerlyInitializedSingleton() {

	}

	static EagerlyInitializedSingleton getInstance() {
		return singleton;
	}
}

class LazilyInitializedSingleton implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;
	private static LazilyInitializedSingleton singleton = null;

	private LazilyInitializedSingleton() {

	}

	static LazilyInitializedSingleton getInstance() {
		if (singleton == null) {
			synchronized (LazilyInitializedSingleton.class) {
				if (singleton == null) {
					singleton = new LazilyInitializedSingleton();
				}
			}
		}
		return singleton;
	}

	// prevent cloning
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	// avoid creating another instance during serialization
	private Object readResolve() {
		return singleton;
	}
}

class StaticClassSingleton implements Serializable {

	private static final long serialVersionUID = 1L;

	private StaticClassSingleton() {

	}

	// called lazily, thread safe
	private static class StaticSingleton {
		private static final StaticClassSingleton SINGLETON = new StaticClassSingleton();
	}

	public static StaticClassSingleton getInstance() {
		return StaticSingleton.SINGLETON;

	}

}

// thread safe
enum EnumSingleton {
	INSTANCE;
	
	public void otherMethods() {
		System.out.println("Singleton created using ENUM");
	}
}