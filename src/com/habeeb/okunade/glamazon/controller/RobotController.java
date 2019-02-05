package com.habeeb.okunade.glamazon.controller;

import java.util.*;

import com.habeeb.okunade.glamazon.model.Robot;

public class RobotController{
	
	private List<List<Integer>> xyGift;	//Location of the gifts [[x1,y1],[x2,y2],[x3,y3],...]
	private String robotCommand[];		//Set of movement command for the robot [UDLR]
	
	private int numGiftPicked;			//Number of gift picked up by the robot
	private Robot robot;				//Instance of robot movement.
	
	/* GiftCollection constructor
	 * locX: integer - Robot initial x-coordinate location
	 * locY: integer - Robot initial y-coordinate location
	 * numGrid: integer - Number of grids n dimension for the robot movement
	 * robotCommand: - Set of movement command for the robot [UDLR]
	 * xyGift: list - Location of the gifts [[x1,y1],[x2,y2],[x3,y3],...]
	 */
	public RobotController(int locX, int locY, int numGrid, String robotCommand[], List<List<Integer>> xyGift){
		this.xyGift = xyGift;
		this.robotCommand = robotCommand;
		
		setRobotProperties(locX, locY, numGrid);
	}
	
	private void setRobotProperties(int x, int y, int n){
		//Initial x location of the robot must not be less than zero or greater than num of grid
		if(x < 0)
			x = 0;
		else if(x > n)
			x = n;
		
		//Initial y location of the robot must not be less than zero or greater than num of grid
		if(y < 0)
			y = 0;
		else if(y > n)
			y = n;
		
		robot = new Robot(x, y, n);			
	}
	
	private void getNumOfGift(){
		numGiftPicked = robot.getGiftPicked().size();
	}
	
	public void getNumOfGiftAndRobotPosition(){
		if(robot.getGrid() > 0){
			startMovement();
		}else{
			System.out.println ("Number of grid should be greater than zero");
		}
	}
	
	private void startMovement(){
		checkGiftPresent();		//Check if gift is present at starting position.
		for(String command : robotCommand){
			if(command.equalsIgnoreCase("D")){
				robot.moveDown();
			}else if(command.equalsIgnoreCase("U")){
				robot.moveUp();
			}else if(command.equalsIgnoreCase("L")){
				robot.moveLeft();
			}else if(command.equalsIgnoreCase("R")){
				robot.moveRight();
			}else{
				continue;
			}
			checkGiftPresent();
		}
		getNumOfGift();
		reportSituation();
	}
	
	private void checkGiftPresent(){
		for(List<Integer> xy : xyGift){
			if((robot.getLocX() == (int)xy.get(0)) && (robot.getLocY() == (int)xy.get(1))){
				robot.pickGift(xy);
				break;
			}
		}
	}
	
	private void reportSituation(){
		System.out.println ("+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println ("INPUT DATA");
		System.out.println ("Number of grid: "+robot.getGrid());
		System.out.println ("Number of gift lost: "+xyGift.size());
		System.out.println (robot.getRobotInitialLocation());
		System.out.println ("Gift positions: "+xyGift);
		System.out.println ("Robot Commands: "+Arrays.asList(robotCommand));
		System.out.println ("\nOUTPUT DATA");
		System.out.println ("Gift Picked: "+numGiftPicked+" presents");
		System.out.println (robot.getRobotCurrentLocation());
	}
}