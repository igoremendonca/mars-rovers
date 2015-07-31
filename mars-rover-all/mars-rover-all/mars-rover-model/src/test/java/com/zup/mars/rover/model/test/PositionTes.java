package com.zup.mars.rover.model.test;

import java.util.logging.Logger;

import org.junit.Assert;
import org.junit.Test;

import com.zup.mars.rover.entity.Direction;
import com.zup.mars.rover.entity.Position;
import com.zup.mars.rover.exception.InvalidAtributeRoverException;
import com.zup.mars.rover.exception.InvalidDirectionException;

public class PositionTes {
	
	Logger logger = Logger.getLogger(PositionTes.class.getName());

	@Test
	public void testIntance() throws InvalidAtributeRoverException, InvalidDirectionException{
		logger.info("testIntance()");
		
		Position position = new Position(1, 2, Direction.NORTH, 5, 5);
		
		Assert.assertNotNull(position);
	}
	
	@Test(expected = InvalidAtributeRoverException.class)
	public void testIntanceInvalidAtribute() throws InvalidAtributeRoverException, InvalidDirectionException{
		logger.info("testIntanceInvalidAtribute()");
		
		@SuppressWarnings("unused")
		Position position = new Position(1, -6, Direction.SOUTH, 5, 5);	
	}
	
	@Test(expected = InvalidDirectionException.class)
	public void testIntanceInvalidDirection() throws InvalidAtributeRoverException, InvalidDirectionException{
		logger.info("testIntanceInvalidDirection()");
		
		@SuppressWarnings("unused")
		Position position = new Position(1, 6, null, 5, 5);
	}
}
