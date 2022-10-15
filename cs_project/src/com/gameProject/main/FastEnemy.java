package com.gameProject.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class FastEnemy extends GameObject{
	Handle handler;

	public FastEnemy(int x, int y, ID id, Handle handler) {
			super(x,y,id); 
			this.handler = handler;
			
			velX = 2;
			velY = 9;
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
		g.setColor(new Color(255,103,108));
		g.fillRect((int)x,(int) y, 16, 16); //change to rec 
		
	}

}

