package com.zup.mars.rover.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.zup.mars.rover.controller.IController;
import com.zup.mars.rover.controller.impl.Controller;
import com.zup.mars.rover.entity.Rover;
import com.zup.mars.rover.exception.InvalidAtributeRoverException;
import com.zup.mars.rover.exception.InvalidDirectionException;

public class Main {

	public static void main(String[] args) {
		
		String pathInput = getPathInput(args);
		
		if(pathInput == null){
			System.out.println("Program's arguments Invalid");
		}
		
		try{
			FileReader arq = new FileReader(pathInput); 
			BufferedReader readLine = new BufferedReader(arq);
			IController controller = new Controller();
			
			//read the first line (Space)
			String line = readLine.readLine();
			
			Integer limitX = controller.getLimit(line, 'x');
			Integer limitY = controller.getLimit(line, 'y');
			
			Rover rover;
			line = readLine.readLine();
			
			do{
				rover = controller.buildRover(line, limitX, limitY);
				line = readLine.readLine();
				rover.setCommandList(controller.buildCommandList(line));
				rover.processCommand();
				System.out.println(rover.getPosition().printCurrentPosition());
				
				line = readLine.readLine();
				
			} while(line != null);
			
			arq.close();
			
		}catch (IOException e){
			System.err.printf("Open File Fail: %s.\n", e.getMessage());
		}catch (InvalidAtributeRoverException e){
			System.err.printf(e.getMessage());
		}catch (InvalidDirectionException e) {
			System.err.printf(e.getMessage());
		}
		
	}

	/**
	 * Method that get path of the input file
	 * @param args
	 * @return
	 */
	private static String getPathInput(String[] args) {
		
		for (String argumet : args) {
			
			if(argumet.toUpperCase().contains("PATH")){
				String[] arg = argumet.split("=");
				
				return arg[1];
			}
		}
		
		return null;
	}

}
