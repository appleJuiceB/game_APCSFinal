package com.gameProject.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject{
	Random r = new Random();
	Handle handler;
	public Player(int x, int y, ID id, Handle handler) {
		super(x,y,id);
		this.handler = handler;
	}
	public Rectangle getBound() {
		return new Rectangle ((int)x,(int)y,32,32);
	}

	public void tick() {
		x+=velX;
		y+= velY;

		x = Game.clamp(x, 0, Game.WIDTH - 32);
		y = Game.clamp(y, 54, Game.HEIGHT -53);

		handler.addObject(new Trail(x,y, ID.Trail,new Color(247,240,227) ,32,32,0.05f,handler));
		collision();


	}

	private void collision() {
		for(int i = 0; i< handler.object.size(); i++) {
			GameObject temp = handler.object.get(i);

			if(temp.getId() == ID.BasicEnemy || temp.getId() == ID.FastEnemy ||temp.getId() == ID.SmartEnemy) { //temp now enemy
				if(getBound().intersects(temp.getBound())) 
					//collision code
					HeadsUp.HEALTH -=1;
			}
			if(temp.getId() == ID.PowerUp) { 
				if(getBound().intersects(temp.getBound())) {
					//collision code
					HeadsUp.HEALTH +=10;
					handler.removeObject(temp);
					i--;
				}
			}
		}
	}
	public void render(Graphics g) {
		//		collision bound outline
		//		Graphics2D g2d =  (Graphics2D) g;
		//		g.setColor(Color.BLUE );
		//		g2d.draw(getBound());
		//		
		g.setColor(new Color(247,240,227));
		g.fillRect((int)x, (int)y, 32, 32);
	}

}
