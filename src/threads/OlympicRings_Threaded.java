package threads;

import java.awt.Color;

import org.jointheleague.graphical.robot.Robot;

public class OlympicRings_Threaded {
	// Make A Program that uses Threads and robots to draw the Olympic rings. One robot should draw one ring simultaneously with the other 4 robots.
	public static void main(String[] args){
		Robot blue = new Robot(400,300);
		Robot black = new Robot(775,300);
		Robot red = new Robot(1150,300);
		Robot yellow = new Robot(570,500);
		Robot green = new Robot(950,500);
		
		blue.setSpeed(10);
		black.setSpeed(10);
		red.setSpeed(10);
		yellow.setSpeed(10);
		green.setSpeed(10);
		
		blue.penDown();
		black.penDown();
		red.penDown();
		yellow.penDown();
		green.penDown();
		
		blue.setPenWidth(3);
		black.setPenWidth(3);
		red.setPenWidth(3);
		yellow.setPenWidth(3);
		green.setPenWidth(3);
		
		blue.setPenColor(Color.BLUE);
		black.setPenColor(Color.BLACK);
		red.setPenColor(Color.RED);
		yellow.setPenColor(Color.YELLOW);
		green.setPenColor(Color.GREEN);
		
		new Thread(()->{
			for(int i = 0; i < 360; i++){
				blue.move(3);
				blue.turn(1);
			}
		}).start();
		
		new Thread(()->{
			for(int i = 0; i < 360; i++){
				black.move(3);
				black.turn(1);
			}
		}).start();
		
		new Thread(()->{
			for(int i = 0; i < 360; i++){
				red.move(3);
				red.turn(1);
			}
		}).start();
		
		new Thread(()->{
			for(int i = 0; i < 360; i++){
				yellow.move(3);
				yellow.turn(1);
			}
		}).start();
	
		new Thread(()->{
			for(int i = 0; i < 360; i++){
				green.move(3);
				green.turn(1);
			}
		}).start();
		
	}
}

