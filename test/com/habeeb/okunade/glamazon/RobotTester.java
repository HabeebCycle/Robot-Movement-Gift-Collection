package com.habeeb.okunade.glamazon;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

import com.habeeb.okunade.glamazon.model.Robot;

@RunWith(JUnitPlatform.class)
@SuiteDisplayName("Robot Tester")
class RobotTester {
	
	private Robot robot;
	
	
	@Test
	@DisplayName("Robot left movement")
	  void testMoveLeft() {
	    assertNull(robot);
	    robot = new Robot(0,0,3);
	    // Move robot to the left at position[0,0]
	    robot.moveLeft();
	    assertEquals("Robot cannot move left", 0, robot.getLocX());
	    assertEquals("Robot cannot move left", 0, robot.getLocY());
	    
	    assertNotNull(robot);
	    robot = new Robot(2,2,3);
	    // Move robot to the left at position[2,2]
	    robot.moveLeft();
	    assertEquals("Robot can move left", 1, robot.getLocX());
	    assertEquals("Robot can move left", 2, robot.getLocY());
	}
	
	@Test
	@DisplayName("Robot upward movement")
	  void testMoveUp() {
	    assertNull(robot);
	    robot = new Robot(0,0,3);
	    // Move robot to the up at position[0,0]
	    robot.moveUp();
	    assertEquals("Robot cannot move up", 0, robot.getLocX());
	    assertEquals("Robot cannot move up", 0, robot.getLocY());
	    
	    assertNotNull(robot);	    
	    robot = new Robot(2,2,3);
	    // Move robot to the up at position[2,2]
	    robot.moveUp();
	    assertEquals("Robot can move up", 2, robot.getLocX());
	    assertEquals("Robot can move up", 1, robot.getLocY());
	}
	
	@Test
	@DisplayName("Robot right movement")
	  void testMoveRight() {
	    assertNull(robot);
	    robot = new Robot(0,0,3);
	    // Move robot to the right from position[0,0]
	    robot.moveRight();
	    assertEquals("Robot can move right", 1, robot.getLocX());
	    assertEquals("Robot can move right", 0, robot.getLocY());
	    
	    assertNotNull(robot);
	    robot = new Robot(3,0,3);
	    // Move robot to the right from position[3,0]
	    robot.moveRight();
	    assertEquals("Robot cannot move right", 3, robot.getLocX());
	    assertEquals("Robot cannot move right", 0, robot.getLocY());
	}
	
	@Test
	@DisplayName("Robot can move down of the grid when at the upper-left edge")
	  void testMoveDown() {
	    assertNull(robot);
	    robot = new Robot(0,0,3);
	    // Move robot to the right from position[0,0]
	    robot.moveDown();
	    assertEquals("Robot can move down", 0, robot.getLocX());
	    assertEquals("Robot can move down", 1, robot.getLocY());

	    assertNotNull(robot);
	    robot = new Robot(0,3,3);
	    // Move robot to the right from position[0,3]
	    robot.moveDown();
	    assertEquals("Robot cannot move down", 0, robot.getLocX());
	    assertEquals("Robot cannot move down", 3, robot.getLocY());
	}
		
	@Test
	@DisplayName("Robot cannot pick more than one gift at the same location")
	 void testPickGift() {
	    assertNull(robot);
	    robot = new Robot(0,0,3);
	    // Robot cannot pick same gift twice in the same location
	    robot.pickGift(Arrays.asList(1,2));
	    assertEquals("Robot can pick", 1, robot.getGiftPicked().size());

	    robot.pickGift(Arrays.asList(1,2));
	    assertEquals("Robot cannot pick", 1, robot.getGiftPicked().size());
	    
	    robot.pickGift(Arrays.asList(1,0));
	    assertEquals("Robot can pick", 2, robot.getGiftPicked().size());
	}

}
