package com.learning.design.patterns.structural;

import java.util.Arrays;
import java.util.List;

public class AdapterPatternDemo {

	public static void main(String[] args) {
		MediaPlayer mp3Player = new MP3Player();
		mp3Player.play("MP3");
		mp3Player.play("MP4");
		MediaPlayer mp4Player = new MP4Adapter();
		mp4Player.play("MP3");
		mp4Player.play("MP4");
		
		//java examples
		Integer[] intArray = {1,2,3,4};
		List<Integer> numbers = Arrays.asList(intArray);
	}

}

interface MediaPlayer {
	void play(String audioType);
}

class MP3Player implements MediaPlayer {

	@Override
	public void play(String audioType) {
		if (audioType.equals("MP3")) {
			System.out.println("Playing MP3 songs");
		} else {
			System.out.println(" Not supported");
		}
	}
}

interface AdvancedMediaPlayer {
	void play(String audioType);
}

class MP4Player implements AdvancedMediaPlayer{

	@Override
	public void play(String audioType) {
		if(audioType.contentEquals("MP4")) {
			System.out.println("Playing MP4 songs");
		} else if(audioType.equals("MP3")) {
			System.out.println("Playing MP3 songs");
		} else {
			System.out.println("Not supported");
		}
	}
	
}

class MP4Adapter implements MediaPlayer{
	
	MP4Player mp4Player = new MP4Player();
	
	@Override
	public void play(String audioType) {
		if(audioType.equals("MP3")) {
			System.out.println("Playing MP3 songs");
		} else if(audioType.equals("MP4")) {
			mp4Player.play(audioType);
		} else {
			System.out.println("Not supported");
		}
	}
	
}