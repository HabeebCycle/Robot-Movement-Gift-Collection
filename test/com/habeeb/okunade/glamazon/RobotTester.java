package com.habeeb.okunade.glamazon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.habeeb.okunade.glamazon.model.Robot;

@DisplayName("Robot Tester")
class RobotTester {
	
	private static Robot robot;
	
	@BeforeAll
	public static void beforeAll() {
	  System.out.println("**--- Robot Tester ---**");
	  robot = new Robot(0,0,3);
	}
	
	@Test
	@DisplayName("Robot cannot move out of the grid when at the edge")
	  public static void testRobotCannotMoveOutOfGrid() {
	    // Test case with the age is a numeric string
	    robot.moveLeft();
	    robot.moveUp();
	    assertAll("Do many assertions.", () -> {
	      assertNotNull(robot);
	      assertEquals(0, robot.getLocX(), "Robot cannot move left");
	      assertEquals(0, robot.getLocY(), "Robot cannot move up");
	    });
	}

}
