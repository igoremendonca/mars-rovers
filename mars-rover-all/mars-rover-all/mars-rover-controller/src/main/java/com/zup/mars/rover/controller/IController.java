package com.zup.mars.rover.controller;

import java.util.List;

import com.zup.mars.rover.entity.Command;
import com.zup.mars.rover.entity.Rover;
import com.zup.mars.rover.exception.InvalidAtributeRoverException;
import com.zup.mars.rover.exception.InvalidDirectionException;

public interface IController {

	/**
	 * Method that build a Rover with a argument strint
	 * @param argumRover
	 * @return
	 * @throws InvalidAtributeRoverException
	 * @throws InvalidDirectionException
	 */
	Rover buildRover(String argumRover, Integer limitX, Integer limitY) throws InvalidAtributeRoverException, InvalidDirectionException;
	
	/**
	 * Method that build a Command List with a argument String
	 * @param argumCommandList
	 * @return
	 */
	List<Command> buildCommandList(String argumCommandList);

	/**
	 * Method that get the limit of the space by axis
	 * @param line
	 * @param c
	 * @return
	 */
	Integer getLimit(String line, char c);
}
