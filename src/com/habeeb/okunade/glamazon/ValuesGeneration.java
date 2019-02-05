package com.habeeb.okunade.glamazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ValuesGeneration {

	public static List<List<Integer>> getRandomLocation(int num, int grid){
		List<List<Integer>> randomLoc = new ArrayList<>();
		while(randomLoc.size() < num){
			List<Integer> pos = Arrays.asList(getRandomX(grid), getRandomY(grid));
			if(!randomLoc.contains(pos))
				randomLoc.add(pos);
		}
		return randomLoc;
	}
	
	//This code generates random number for x between 0 and the {grid} (inclusive)
	public static int getRandomX(int grid){
		return (int)(Math.random()*(grid+1));
	}
	
	//This code generates random number for y between 0 and the {grid} (inclusive)
	public static int getRandomY(int grid){
		return (int)(Math.random()*(grid+1));
	}
	
	//This code generates {num} random command movements between [U,R,D,L]
	public static String[] generateRandomCommands(int num){
		String movement[] = {"U","R","D","L"};
		String commands[] = new String[num];
		for(int i=0; i<num; i++){
			commands[i] = movement[(int)(Math.random()*movement.length)];
		}
		return commands;
	}
}
