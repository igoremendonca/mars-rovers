package com.zup.mars.rover.entity;

public enum Direction {

	NORTH ('N') {
		@Override
		public Direction moveToRight() {
			return EAST;
		}

		@Override
		public Direction moveToLeft() {
			return WEST;
		}
	},

	EAST ('E') {
		@Override
		public Direction moveToRight() {
			return SOUTH;
		}

		@Override
		public Direction moveToLeft() {
			return NORTH;
		}
	},

	SOUTH ('S') {
		@Override
		public Direction moveToRight() {
			return WEST;
		}

		@Override
		public Direction moveToLeft() {
			return EAST;
		}
	},

	WEST ('W') {
		@Override
		public Direction moveToRight() {
			return NORTH;
		}

		@Override
		public Direction moveToLeft() {
			return SOUTH;
		}
	};

	public abstract Direction moveToRight();

	public abstract Direction moveToLeft();
	
	private char initial;
	
	Direction(char inital){
		this.initial = inital;
	}

	public char getInitial() {
		return initial;
	}

	public void setInitial(char initial) {
		this.initial = initial;
	}
	
	public static Direction parse(char initial){
		for (Direction direction : Direction.values()) {
			if(direction.getInitial() == initial){
				return direction;
			}
		}
		
		return null;
	}
	
}
