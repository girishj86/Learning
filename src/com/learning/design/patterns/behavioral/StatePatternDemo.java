package com.learning.design.patterns.behavioral;

public class StatePatternDemo {

	public static void main(String[] args) {
		WallFan fan = new BajajFan();
		fan.pull();
		fan.pull();
		fan.pull();
		fan.pull();
	}
}

interface WallFan {
	void pull();
}

class BajajFan implements WallFan {

	private FanState currentState = FanState.OFF;

	@Override
	public void pull() {
		FanState previousState = currentState;
		switch (currentState) {
		case OFF:
			this.currentState = FanState.LOW_SPEED;
			break;
		case LOW_SPEED:
			this.currentState = FanState.MEDIUM_SPEED;
			break;
		case MEDIUM_SPEED:
			this.currentState = FanState.HIGH_SPEED;
			break;
		case HIGH_SPEED:
			this.currentState = FanState.OFF;
			break;
		}
		System.out.println("Fan's state changed from " + previousState + " to " + currentState);
	}
}

enum FanState {
	OFF, LOW_SPEED, MEDIUM_SPEED, HIGH_SPEED;
}