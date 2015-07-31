package com.zup.mars.rover.model.test;

import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

import com.zup.mars.rover.entity.Direction;
import com.zup.mars.rover.entity.Rover;
import com.zup.mars.rover.exception.InvalidAtributeRoverException;
import com.zup.mars.rover.exception.InvalidDirectionException;

public class RoverTest {

	Logger logger = Logger.getLogger(RoverTest.class.getName());
	
	@Test
	public void testIntance() throws InvalidAtributeRoverException, InvalidDirectionException{
		logger.info("testIntance()");
		
		Rover rover = new Rover(1, 3, Direction.NORTH.getInitial(), 5, 5);
		
		Assert.assertNotNull(rover);
	}
	
	@Test(expected = InvalidDirectionException.class)
	public void testIntanceInvalidDirection() throws InvalidAtributeRoverException, InvalidDirectionException{
		logger.info("testIntanceInvalidDirection()");
		
		@SuppressWarnings("unused")
		Rover rover = new Rover(1, 3, 'I', 5,5);
		
	}
}
