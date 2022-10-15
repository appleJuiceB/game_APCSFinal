package com.gameProject.main;
//TRYING WITHOUT ANY HELP
	import java.awt.Color;
	import java.awt.Graphics;
	import java.awt.Graphics2D;
	import java.awt.Rectangle;
	import java.util.Random;

	public class PowerUp extends GameObject{
		Random r = new Random();
		Handle handler;
		public PowerUp(int x, int y, ID id, Handle handler) {
			super(x,y,id);
			this.handler = handler;
		
					velX = 0;   
					velY = 0;
		}
		public Rectangle getBound() {
			return new Rectangle ((int)x,(int)y,28, 28 );
		}

		public void tick() {
			
			x = Game.clamp(x, 0, Game.WIDTH - 32);
			y = Game.clamp(y, 54, Game.HEIGHT -53);


		}
		
		public void render(Graphics g) {
		
			g.setColor(new Color(255,200,125));
			g.fillOval((int)x, (int)y, 28, 28);
		}

	}


