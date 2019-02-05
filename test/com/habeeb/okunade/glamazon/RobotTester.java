package com.habeeb.okunade.glamazon;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

import com.habeeb.okunade.glamazon.model.Robot;

@RunWith(JUnitPlatform.class)
@DisplayName("Robot Tester")
class RobotTester {
	
	private static Robot robot;
	
	@BeforeAll
	public static void beforeAll() {
	  System.out.println("**--- Robot Tester ---**");
	  robot = new Robot(0,0,3);
	}
	
	@Test
	@DisplayName("Robot cannot move out of the grid when at the upper-left edge")
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
	
	@Test
	@DisplayName("Robot cannot move out of the grid when at the upper-left edge")
	  public static void testRobotCanMoveInsideGrid() {
	    // Test case with the age is a numeric string
	    robot.moveRight();
	    robot.moveDown();
	    assertAll("Do many assertions.", () -> {
	      assertNotNull(robot);
	      assertEquals(1, robot.getLocX(), "Robot can move right");
	      assertEquals(1, robot.getLocY(), "Robot cannot move down");
	    });
	}
	
	

}
