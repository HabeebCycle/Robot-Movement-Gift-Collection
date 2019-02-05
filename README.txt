Name: Habeeb Okunade
Phone: 0467099697
E-mail: habeeb.okunade@yahoo.com
Date: 29-Jan-2019;
Edited: 04-Feb-2019;

Solution to Glamazon Tech Challenge  (3 hours 40 minutes) + (30 minutes bug fixing)
******************************************************************************************************************************************************

The program folder contains 5 files and one folder that contains the package classes.

file 1: GiftCollection.java
file 2: Robot.java
file 3: RobotTester.java
file 4: TEST CASES.txt
file 5: README.txt	'*This file'

The RobotTester.java file should be used to run the program as follows:

Inside the main method, the GiftCollection class should be instantiated with the following 5 input to its constructor:
1. initial x-position of the robot
	int initX
2. initial y-position of the robot
	int initY
3. the number of grid
	int grid
4. the robot command as array of String	
	String rcommand[ ]
5. the locations of the gifts in x and y collection of lists
	List<List<Integer>> xyloc

Use the instantiated object to called getNumOfGiftAndRobotPosition() method of class GiftCollection as follows
	giftCollection.getNumOfGiftAndRobotPosition();
*****************************************************************************************************************************************************************

RobotTester.java file has been used to run several test cases and the output is locate in the 'TEST CASES.txt':


public static void main (String[] args) {
		
	int numOfGiftLost = 3;
	int numOfCommands = 30;
	int gridN = 4;
	int initX = getRandomX(gridN);
	int initY = getRandomY(gridN);
	String rCommand[] = generateRandomCommands(numOfCommands);
	List<List<Integer>> xyloc = getRandomLocation(numOfGiftLost, gridN);
	
	
	GiftCollection giftCollection = new GiftCollection(initX, initY, gridN, rCommand, xyloc);
	giftCollection.getNumOfGiftAndRobotPosition();	
}

//This code generates {num} random locations for the present with {grid} dimension
static List<List<Integer>> getRandomLocation(int num, int grid){
	List<List<Integer>> randomLoc = new ArrayList<>();
	while(randomLoc.size() < num){
		List<Integer> pos = Arrays.asList(getRandomX(grid), getRandomY(grid));
		if(!randomLoc.contains(pos))
			randomLoc.add(pos);
	}
	return randomLoc;
}

//This code generates random number for x between 0 and the {grid} (inclusive)
static int getRandomX(int grid){
	return (int)(Math.random()*(grid+1));
}

//This code generates random number for y between 0 and the {grid} (inclusive)
static int getRandomY(int grid){
	return (int)(Math.random()*(grid+1));
}

//This code generates {num} random command movements between [U,R,D,L]
static String[] generateRandomCommands(int num){
	String movement[] = {"U","R","D","L"};
	String commands[] = new String[num];
	for(int i=0; i<num; i++){
		commands[i] = movement[(int)(Math.random()*movement.length)];
	}
	return commands;
}