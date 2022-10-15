package com.gameProject.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class SmartEnemy extends GameObject{
	Handle handler;
	private GameObject player;

	public SmartEnemy(int x, int y, ID id, Handle handler) {
			super(x,y,id); 
			
			this.handler = handler;
			
			for(int i = 0; i<handler.object.size();i++) {
				if(handler.object.get(i).getId() == ID.Player) player = handler.object.get(i);
			} 
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
		
		//follows player
		float difx = x - player.getX() - 16;
		float dify = y - player.getY() - 16;
		
		float dist = (float) Math.sqrt((x-player.getX())*(x-player.getX()) + (y-player.getY())*(y-player.getY()));
		
		velX = (float)((-1/dist * difx));
		velY = (float)((-1/dist * dify));

		
		handler.addObject(new Trail(x,y, ID.Trail,new Color (227,70,92) ,16,16,0.05f,handler));

		
		
	}

	@Override
	public void render(Graphics g) {
		g.setColor(new Color (227,70,92));
		g.fillRect((int)x,(int) y, 16, 16); 
		
	}

}

