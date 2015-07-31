package com.zup.mars.rover.test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.zup.mars.rover.controller.impl.Controller;
import com.zup.mars.rover.entity.Command;
import com.zup.mars.rover.entity.Direction;
import com.zup.mars.rover.entity.Rover;
import com.zup.mars.rover.exception.InvalidAtributeRoverException;
import com.zup.mars.rover.exception.InvalidDirectionException;

public class ControllerTest {

	Controller controller;
	Logger logger = Logger.getLogger(ControllerTest.class.getName());
	
	@Before
	public void init(){
		controller = new Controller();
	}
	
	@Test
	public void testBuildRover() throws InvalidAtributeRoverException, InvalidDirectionException{
		logger.info("testBuildRover()");
		
		String argum = "1 4 N";
		
		Rover rover = controller.buildRover(argum, 5, 5);
		Rover prove = new Rover(1, 4, Direction.NORTH.getInitial(), 5, 5);
		
		Assert.assertTrue(rover.getPosition().getCoordX().equals(prove.getPosition().getCoordX()));
		Assert.assertTrue(rover.getPosition().getCoordY().equals(prove.getPosition().getCoordY()));
		Assert.assertTrue(rover.getPosition().getDirection().equals(prove.getPosition().getDirection()));
	}
	
	@Test
	public void testBuildRoverNoEguals() throws InvalidAtributeRoverException, InvalidDirectionException{
		logger.info("testBuildRoverNoEguals()");
		
		String argum = "1 4 E";
		
		Rover rover = controller.buildRover(argum, 5, 5);
		Rover prove = new Rover(1, 4, Direction.SOUTH.getInitial(), 5, 5);
		
		Assert.assertTrue(rover.getPosition().getCoordX().equals(prove.getPosition().getCoordX()));
		Assert.assertTrue(rover.getPosition().getCoordY().equals(prove.getPosition().getCoordY()));
		Assert.assertTrue(!rover.getPosition().getDirection().equals(prove.getPosition().getDirection()));
		
	}
	
	@Test
	public void testBuildCommandList(){
		logger.info("testBuildCommandList()");
		
		String argumCommand = "RRMMLLMRM";
		List<Command> commandList = controller.buildCommandList(argumCommand);
		List<Command> commandListProve = new ArrayList<Command>();
		
		commandListProve.add(Command.RIGHT);
		commandListProve.add(Command.RIGHT);
		commandListProve.add(Command.MOVE);
		commandListProve.add(Command.MOVE);
		commandListProve.add(Command.LEFT);
		commandListProve.add(Command.LEFT);
		commandListProve.add(Command.MOVE);
		commandListProve.add(Command.RIGHT);
		commandListProve.add(Command.MOVE);
		
		Assert.assertEquals(commandList, commandListProve);
	}
}
