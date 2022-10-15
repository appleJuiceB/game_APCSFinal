package com.gameProject.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject{
	Handle handler;

	public BasicEnemy(int x, int y, ID id, Handle handler) {
			super(x,y,id); 
			this.handler = handler;
			
			velX = 5;
			velY = 5;
	}
	public Rectangle getBound() {
		return new Rectangle ((int)x,(int)y,16,16);
	}


	@Override
	public void tick() {
		x+=velX;
		y+=velY;
		//makes it bouncy :)
		if(y<=54|| y>Game.HEIGHT -32) velY *=-1;
		if(x<=0|| x>Game.WIDTH) velX *=-1;
		
		
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect((int)x, (int)y, 16, 16); //change to rec 
		
	}

}
