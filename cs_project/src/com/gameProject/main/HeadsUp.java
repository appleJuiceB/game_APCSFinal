package com.gameProject.main;

import java.awt.Color;
import java.awt.Graphics;

public class HeadsUp {
	public static float HEALTH = 100;
	
	private int score = 0;
	private int level = 1;

	public void tick() {
 
		HEALTH = Game.clamp(HEALTH, 0, 100);
		score++;
		
	}
	
	public void render(Graphics g) {
		 g.setColor(new Color(160,250,199));
		 g.fillRect(0, 0, Game.WIDTH, 54);
		 g.setColor(new Color(57,118,65));
		 g.fillRect(15,15, 200, 32);
		 g.setColor(new Color(245,240,210)); 
		 g.fillRect(15,15, (int)HEALTH *2, 32);
		 g.setColor(new Color(57,118,65));
		 g.drawRect(15,15, 200, 32);
		 g.setColor(Color.DARK_GRAY);
		 g.drawString("Health:", 15, 13);
		 g.drawString("Score: " + score, 250 , 27);
		 g.drawString("Level: " + level, 250 , 45);
		 
	 }

	
	public int getScore() {
		return score;
	}
	public int getLevel() {
		return level;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	
	

}
