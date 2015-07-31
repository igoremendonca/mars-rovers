package com.zup.mars.rover.controller.impl;

import java.util.ArrayList;
import java.util.List;

import com.zup.mars.rover.controller.IController;
import com.zup.mars.rover.entity.Command;
import com.zup.mars.rover.entity.Rover;
import com.zup.mars.rover.exception.InvalidAtributeRoverException;
import com.zup.mars.rover.exception.InvalidDirectionException;

public class Controller implements IController {

	public Rover buildRover(String argumRover, Integer limitX, Integer limitY) throws InvalidAtributeRoverException, InvalidDirectionException {
		
		String coordenadas[] = argumRover.split(" ");
        Integer x = 0;
        Integer y = 0;
        char direct;
        
        x = Integer.parseInt(coordenadas[0]);
        y = Integer.parseInt(coordenadas[1]);
        direct = coordenadas[2].toString().charAt(0);
        
        return new Rover(x, y, direct, limitX, limitY);
       
	}

	public List<Command> buildCommandList(String argumCommandList) {
		List<Command> commandList = new ArrayList<Command>();
        char commads[] = argumCommandList.toCharArray();
        
        for (char c : commads) {
        	commandList.add(Command.parse(c));
		}
        
        return commandList;
	}

	public Integer getLimit(String line, char c) {
		
		Integer limit = 0;
		
		if(line != null){
			String[] listLimit = line.split(" ");
			
			if(c == 'x'){
				return Integer.parseInt(listLimit[0]);
			}
			else{
				return Integer.parseInt(listLimit[1]);
			}
		}
		
		return limit;
	}

	
}
