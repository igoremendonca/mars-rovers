package com.zup.mars.rover.test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

import com.zup.mars.rover.entity.Command;
import com.zup.mars.rover.entity.Direction;
import com.zup.mars.rover.entity.Rover;
import com.zup.mars.rover.exception.InvalidAtributeRoverException;
import com.zup.mars.rover.exception.InvalidDirectionException;

public class MainTest {

	Logger logger = Logger.getLogger(MainTest.class.getName());
	
	@Test
	public void testProcess() throws InvalidAtributeRoverException, InvalidDirectionException{
		logger.info("testProcess()");
		
		Rover rover = new Rover(1, 2, Direction.NORTH.getInitial(), 5 , 5);
		List<Command> commandList = new ArrayList<Command>();
		commandList.add(Command.parse('L'));
		commandList.add(Command.parse('M'));
		commandList.add(Command.parse('L'));
		commandList.add(Command.parse('M'));
		commandList.add(Command.parse('L'));
		commandList.add(Command.parse('M'));
		commandList.add(Command.parse('L'));
		commandList.add(Command.parse('M'));
		commandList.add(Command.parse('M'));
		
		rover.setCommandList(commandList);
		rover.processCommand();
		
		Assert.assertTrue(rover.getPosition().getCoordX().equals(1));
		Assert.assertTrue(rover.getPosition().getCoordY().equals(3));
		Assert.assertTrue(rover.getPosition().getDirection().equals(Direction.NORTH));
		
		rover = new Rover(3, 3, Direction.EAST.getInitial(), 5, 5);
		commandList = new ArrayList<Command>();
		commandList.add(Command.parse('M'));
		commandList.add(Command.parse('M'));
		commandList.add(Command.parse('R'));
		commandList.add(Command.parse('M'));
		commandList.add(Command.parse('M'));
		commandList.add(Command.parse('R'));
		commandList.add(Command.parse('M'));
		commandList.add(Command.parse('R'));
		commandList.add(Command.parse('R'));
		commandList.add(Command.parse('M'));
		
		rover.setCommandList(commandList);
		rover.processCommand();
		
		Assert.assertTrue(rover.getPosition().getCoordX().equals(5));
		Assert.assertTrue(rover.getPosition().getCoordY().equals(1));
		Assert.assertTrue(rover.getPosition().getDirection().equals(Direction.EAST));
		
	}
}
