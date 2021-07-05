package com.learning.design.patterns.structural;

import java.util.ArrayList;
import java.util.List;

public class CompositePatternDemo {

	public static void main(String[] args) {
		Folder main = new Folder("Main Folder");
		Folder folder1 = new Folder("Folder1");
		Folder folder11 = new Folder("Folder11");
		Folder folder2 = new Folder("Folder2");

		File file1 = new File("File1");
		file1.add("first level file");

		File file21 = new File("File21");
		file21.add("second level file");

		main.add(folder1);
		main.add(folder2);
		main.add(file1);

		folder1.add(folder11);
		folder2.add(file21);

		main.print();
		System.out.println("---------");
		folder1.print();
		System.out.println("---------");
		folder2.print();

	}

}

abstract class FileType {
	String name;
	StringBuilder text;

	public abstract void add(Object content);

	public abstract void remove(Object content);

	public abstract void print();

}

class File extends FileType {

	public File(String name) {
		this.name = name;
		this.text = new StringBuilder();
	}

	@Override
	public void add(Object content) {
		text.append(content.toString());
	}

	@Override
	public void remove(Object content) {
		text = new StringBuilder(text.toString().replace(content.toString(), ""));

	}

	@Override
	public void print() {
		System.out.println("File name = "+name+", Content = "+text.toString());

	}

}

class Folder extends FileType {

	public Folder(String name) {
		this.name = name;
	}

	List<Folder> folders = new ArrayList<Folder>();
	List<File> files = new ArrayList<File>();

	@Override
	public void add(Object content) {
		if (content instanceof Folder) {
			folders.add((Folder) content);
		} else if (content instanceof File) {
			files.add((File) content);
		} else {
			throw new RuntimeException("Invalid content");
		}

	}

	@Override
	public void remove(Object content) {
		if (content instanceof Folder) {
			folders.remove((Folder) content);
		} else if (content instanceof File) {
			files.remove((File) content);
		} else {
			throw new RuntimeException("Invalid content");
		}

	}

	@Override
	public void print() {
		System.out.println("Directory name = "+this.name);
		if (!folders.isEmpty()) {
			System.out.println("Folders are ");
			folders.stream().forEach((x) -> x.print());
		}
		if (!files.isEmpty()) {
			System.out.println("Files are ");
			files.stream().forEach((x) -> x.print());
		}
	}

}