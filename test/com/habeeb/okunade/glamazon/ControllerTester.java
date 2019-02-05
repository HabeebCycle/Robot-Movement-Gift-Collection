package com.habeeb.okunade.glamazon;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.habeeb.okunade.glamazon.controller.RobotController;

class ControllerTester {

	private static RobotController robotController;
	private static List<List<Integer>> xyloc = new ArrayList<>();
	private static String rCommand[];
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		rCommand = new String[]{"D","D","R","D","R","U","U","U"};
		xyloc.add(Arrays.asList(0,1));
		xyloc.add(Arrays.asList(1,2));
		xyloc.add(Arrays.asList(2,0));
		xyloc.add(Arrays.asList(4,2));
		//Presents Location: [[0,1],[1,2],[2,0],[3,2]]
	}

	@BeforeEach
	void setUp() throws Exception {
		robotController = new RobotController(0,0,3,rCommand,xyloc);
	}

	@Test
	void testRobotController() {
		assertNotNull(robotController);
	}

	@Test
	void testGetNumOfGiftAndRobotPosition() {
		assertNotNull(robotController);
		robotController.getNumOfGiftAndRobotPosition();
		assertEquals("Number of Gift present", 3, robotController.getNumOfGift());
		assertEquals("Robot x position now", 2, robotController.getCurrentRobot().getLocX());
		assertEquals("Robot y position now", 0, robotController.getCurrentRobot().getLocY());
	}
	

}
