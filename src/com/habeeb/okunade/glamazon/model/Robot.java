package com.habeeb.okunade.glamazon.model;

import java.util.*;

public class Robot{
	
	private int locX;					//Robot x-coordinate location
	private int locY;					//Robot y-coordinate location
	private int grid;					//Robot maximum location. No. of grid
	private int x, y;					//Robot initial location [x,y]
	
	private List<List<Integer>> giftPicked; //Stored the location of gift picked.
	
	public Robot(int locX, int locY, int grid){
		this.locX = x = locX;
		this.locY = y = locY;
		this.grid = grid;
		this.giftPicked = new ArrayList<>();
	}
	
	public void moveRight(){
		if(locX < grid)
			locX++;
		else
			System.out.println ("R: Robot cannot move outside the grid. Robot is back at:["+(getLocX())+","+(getLocY())+"]");
	}
	
	public void moveLeft(){
		if(locX > 0)
			locX--;
		else
			System.out.println ("L: Robot cannot move outside the grid. Robot is back at:["+(getLocX())+","+(getLocY())+"]");
	}
	
	public void moveUp(){
		if(locY > 0)
			locY--;
		else
			System.out.println ("U: Robot cannot move outside the grid. Robot is back at:["+(getLocX())+","+(getLocY())+"]");
	}
	
	public void moveDown(){
		if(locY < grid)
			locY++;
		else
			System.out.println ("D: Robot cannot move outside the grid. Robot is back at:["+(getLocX())+","+(getLocY())+"]");
	}
	
	public int getLocX(){
		return locX;
	}
	
	public int getLocY(){
		return locY;
	}
	
	public int getGrid(){
		return grid;
	}
	
	public void pickGift(List<Integer> gift){
		if(!giftPicked.contains(gift))
			giftPicked.add(gift);
		else
			System.out.println("Gift was present at this location, but already picked");
	}
	
	public List<List<Integer>> getGiftPicked(){
		return giftPicked;
	}
	
	public String getRobotInitialLocation(){
		return "Starting position: ["+x+","+y+"]";
	}
	
	public String getRobotCurrentLocation(){
		return "Robot can be found at: ["+locX+","+locY+"]";
	}
	
	
}
