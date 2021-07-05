package com.learning.design.patterns.structural;

import java.util.Base64;
import java.util.HashSet;
import java.util.Set;

public class DecoratorPatternDemo {

	public static void main(String[] args) {

		BasicReaderWriter basicReaderWriter = new BasicReaderWriter();
		basicReaderWriter.write("hello");
		System.out.println(basicReaderWriter.read("hi"));

		ReverseDecorator reverseDecorator = new ReverseDecorator(new BasicReaderWriter());
		reverseDecorator.write("hello");
		System.out.println(reverseDecorator.getDatabase());
		System.out.println(reverseDecorator.read("hello"));

		EncodedDecorator encodedDecorator = new EncodedDecorator(new ReverseDecorator(new BasicReaderWriter()));
		encodedDecorator.write("hello");
		System.out.println(encodedDecorator.getDatabase());
		System.out.println(encodedDecorator.read("hi"));
		
		// java examples
		/*
		 * All subclasses of java.io.InputStream, OutputStream, Reader and Writer have
		 * constructors that accept objects of their own type.
		 * 
		 * java.util.Collections, methods checkedXXX(), synchronizedXXX() and
		 * unmodifiableXXX().
		 * 
		 * javax.servlet.http.HttpServletRequestWrapper and HttpServletResponseWrapper
		 */
		
	}

}

interface ReaderWriter {
	boolean read(String s);

	void write(String s);

	Set<String> getDatabase();
}

class BasicReaderWriter implements ReaderWriter {

	Set<String> database = new HashSet<String>();

	@Override
	public boolean read(String s) {
		return database.contains(s);
	}

	@Override
	public void write(String s) {
		database.add(s);
	}

	@Override
	public Set<String> getDatabase() {
		return database;
	}
}

class ReverseDecorator implements ReaderWriter {
	ReaderWriter readerWriter;
	StringBuilder sb = new StringBuilder();

	public ReverseDecorator(ReaderWriter readerWriter) {
		this.readerWriter = readerWriter;
	}

	@Override
	public boolean read(String s) {
		sb.setLength(0);
		return readerWriter.read(sb.append(s).reverse().toString());
	}

	@Override
	public void write(String s) {
		sb.setLength(0);
		readerWriter.write(sb.append(s).reverse().toString());
	}

	@Override
	public Set<String> getDatabase() {
		return readerWriter.getDatabase();
	}
}

class EncodedDecorator implements ReaderWriter {
	ReaderWriter readerWriter;

	public EncodedDecorator(ReaderWriter readerWriter) {
		this.readerWriter = readerWriter;
	}

	@Override
	public boolean read(String s) {
		String encodedString = new String(Base64.getEncoder().encode(s.getBytes()));
		return readerWriter.read(encodedString);
	}

	@Override
	public void write(String s) {
		String encodedString = new String(Base64.getEncoder().encode(s.getBytes()));
		readerWriter.write(encodedString);
	}

	@Override
	public Set<String> getDatabase() {
		return readerWriter.getDatabase();
	}
}