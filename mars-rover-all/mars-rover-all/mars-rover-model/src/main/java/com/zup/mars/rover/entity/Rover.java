package com.zup.mars.rover.entity;

import java.util.ArrayList;
import java.util.List;

import com.zup.mars.rover.exception.InvalidAtributeRoverException;
import com.zup.mars.rover.exception.InvalidDirectionException;

public class Rover {
	private Position position;
    private List<Command> commandList;

    public Rover(Integer coordx, Integer coody, char directionInitial, Integer limitX, Integer limitY)
        throws InvalidAtributeRoverException, InvalidDirectionException{
        commandList = new ArrayList<Command>();
        position = new Position(coordx, coody, Direction.parse(directionInitial), limitX, limitY);
    }

    public Position getPosition() {
		return position;
	}



	public void setPosition(Position position) {
		this.position = position;
	}



	public List<Command> getCommandList() {
		return commandList;
	}



	public void setCommandList(List<Command> commandList) {
		this.commandList = commandList;
	}

	public void processCommand(){
        for (Command command : commandList) {
			command.executeCommand(this.position);
		}
    }
}
