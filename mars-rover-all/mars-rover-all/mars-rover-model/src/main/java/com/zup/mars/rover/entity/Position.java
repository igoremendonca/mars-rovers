package com.zup.mars.rover.entity;

import com.zup.mars.rover.exception.InvalidAtributeRoverException;
import com.zup.mars.rover.exception.InvalidDirectionException;

public class Position {

	private Integer coordX;
	private Integer coordY;
	private Direction direction;
	private Integer limitcoordX;
	private Integer limitCoordY;

	public Position(Integer x, Integer y, Direction direction, Integer limitCoordX, Integer limitCoordY)
			throws InvalidAtributeRoverException, InvalidDirectionException {
		if (x < 0 || y < 0 || limitCoordX < 0 || limitCoordY < 0 || 
			x > limitCoordX || y > limitCoordY) {
			throw new InvalidAtributeRoverException("The rover's position are invalid!");
		} else if(direction == null){
			throw new InvalidDirectionException("The rover's direction are invalid!");
		}
		else{
			coordX = x;
			coordY = y;
			this.direction = direction;
			this.limitcoordX = limitCoordX;
			this.limitCoordY = limitCoordY;
		}
	}
	
	public String printCurrentPosition(){
		return coordX.toString() + " " + coordY.toString() + " " + direction.getInitial();
	}

	protected void addCoordX() {
		this.coordX = coordX++ > limitcoordX ? limitcoordX : coordX++;
	}

	protected void dedCoordX() {
		coordX = coordX-- < 0 ? 0 : coordX--;
	}

	protected void addCoordY() {
		coordY = coordY++ > limitCoordY ? limitCoordY : coordY++;
	}

	protected void dedCoordY() {
		coordY = coordY-- < 0 ? 0 : coordY--;
	}

	protected void changeDirectionRight() {
		direction = direction.moveToRight();
	}

	protected void changeDirectionLeft() {
		direction = direction.moveToLeft();
	}

	public Integer getCoordX() {
		return coordX;
	}

	public void setCoordX(Integer coordX) {
		this.coordX = coordX;
	}

	public Integer getCoordY() {
		return coordY;
	}

	public void setCoordY(Integer coordY) {
		this.coordY = coordY;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public Integer getLimitcoordX() {
		return limitcoordX;
	}

	public void setLimitcoordX(Integer limitcoordX) {
		this.limitcoordX = limitcoordX;
	}

	public Integer getLimitCoordY() {
		return limitCoordY;
	}

	public void setLimitCoordY(Integer limitCoordY) {
		this.limitCoordY = limitCoordY;
	}
	
	
}
