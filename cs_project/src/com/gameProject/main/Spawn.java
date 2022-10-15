package com.gameProject.main;

import java.util.Random;

public class Spawn {
	private Handle handler;
	private HeadsUp hud;

	private int scorekeep = 0;
	private Random r = new Random();

	public Spawn(Handle handler, HeadsUp hud) {
		this.handler = handler;
		this.hud = hud;
	}

	public void tick() {
		scorekeep++;

		if(scorekeep >= 300) {
			//every 300 nanosec level increase and one more enemy added
			scorekeep = 0;
			hud.setLevel(hud.getLevel()+1);

			//every "int" round new enemy added
			if(hud.getLevel()% 2== 0) 
				addBasic();
			if(hud.getLevel()% 3== 0) 
				addFast();
			if(hud.getLevel()%5 == 0) 
				addSmart();
			if(hud.getLevel()% 3 == 0) 
				addPowerUp();
		}
	}
	

	private void addBasic() {
		GameObject temp =	new BasicEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.BasicEnemy,this.handler);
		handler.addObject(temp);
		if(temp.getY()<55 || temp.getVelY() > Game.HEIGHT-20) {
			handler.removeObject(temp);
			addBasic();
		}
	}
	private void addFast() {
		GameObject temp = new FastEnemy(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.FastEnemy,this.handler);
		handler.addObject(temp);
		if(temp.getY()<55 || temp.getVelY() > Game.HEIGHT-20) {
			handler.removeObject(temp);
			addFast();
		}
	}
	private void addSmart() {
		GameObject temp = new SmartEnemy(350,350, ID.FastEnemy,this.handler);
		handler.addObject(temp);
		if(temp.getY()<55 || temp.getVelY() > Game.HEIGHT-20) {
			handler.removeObject(temp);
			addSmart();
		}
	}
	
	private void addPowerUp() {
		GameObject temp =	new PowerUp(r.nextInt(Game.WIDTH),r.nextInt(Game.HEIGHT), ID.PowerUp,this.handler);
		handler.addObject(temp);
		if(temp.getY()<55 || temp.getVelY() > Game.HEIGHT-20) {
			handler.removeObject(temp);
			addPowerUp();
		}		
	}

}
