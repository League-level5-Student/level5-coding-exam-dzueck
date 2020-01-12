package Coding_Exam_A;

import java.awt.Color;
import java.util.Scanner;

import javax.swing.JOptionPane;

import org.jointheleague.graphical.robot.Robot;

public class CodingExamA {
	public static void main(String[] args) {
		/*
		 * Write a program that asks the user for three pieces of information.
		 * 1. How many robots
		 * 2. The color of the shapes
		 * 3. How many sides each shape will have
		 * 
		 * Once the information has been collected, the program will then make the requested number of robots
		 * each draw the requested shape in the requested color. The robots should execute at the same time so 
		 * Threads will need to be used. Arrange the robots so that the shapes do not overlap.
		 * For full credit, define the Thread functions using lambdas.
		 * 
		 * See the Coding_Exam_A_Demo.jar for an example of what the finished product should look like.
		 */
		int numRobots = Integer.parseInt(JOptionPane.showInputDialog("How many robots nerd?"));
		String color = JOptionPane.showInputDialog("What color nerd? (blue, red, or Yellow)");
		int numSides = Integer.parseInt(JOptionPane.showInputDialog("How many sides nerd?"));
		Thread[] threads = new Thread[numRobots];
		for(int i = 0; i < numRobots; i++) {
			Robot r = new Robot();
			r.setY(50);
			r.setX(50 + 200 * i);
			threads[i] = new Thread(() -> {
					runRobot(numSides, r, color);
				}
			);
		}
		for(int i = 0; i < numRobots; i++) {
			
			threads[i].start();
		}
	}
	

	public static void runRobot(int sides, Robot r, String color){
		r.setSpeed(10);
		if(color.equalsIgnoreCase("blue")) {
			r.setPenColor(Color.BLUE);
		}
		else if(color.equalsIgnoreCase("red")) {
			r.setPenColor(Color.RED);
		}
		else if(color.equalsIgnoreCase("Yellow")) {
			r.setPenColor(Color.YELLOW);
		}
		r.penDown();
		r.turn(90);
		
		int angle = 360/sides;
		for(int i = 0; i < sides; i++) {
			r.move(100);
			r.turn(angle);
		}
	}
}
