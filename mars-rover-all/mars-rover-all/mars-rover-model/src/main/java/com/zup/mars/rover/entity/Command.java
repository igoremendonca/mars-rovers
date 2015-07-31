package com.zup.mars.rover.entity;

public enum Command {

	LEFT('L'), RIGHT('R'), MOVE('M');

	private char initial;

	Command(char initial) {
		this.initial = initial;
	}

	public char getInitial() {
		return initial;
	}

	public static Command parse(char initial) {

		for (Command command : Command.values()) {
			if (command.getInitial() == initial) {
				return command;
			}
		}

		return null;
	}

	void executeCommand(Position position) {
		switch (this) {
		case RIGHT:
			position.changeDirectionRight();
			break;
		case LEFT:
			position.changeDirectionLeft();
			break;
		case MOVE:
			switch (position.getDirection()) {
			case NORTH:
				position.addCoordY();
				break;
			case SOUTH:
				position.dedCoordY();
				break;
			case EAST:
				position.addCoordX();
				break;
			
			case WEST:
				position.dedCoordX();
				break;
			}
		}
	}
}
