package com.gameProject.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = -2600813937267631418L;

	public static final int WIDTH = 640;
	public static final int	HEIGHT = WIDTH / 12 * 9;

	private boolean running = false;
	private Thread thread;
	private Handle handler; 
	private HeadsUp hud;
	private Spawn spawn;
	private Menu menu;
	
	public enum STATE{
		Menu,
		Help,
		End,
		Thanks,
		Game
	}
	public STATE gameState = STATE.Menu;
	
	
	public Game() {
		handler = new Handle();
		hud = new HeadsUp();
		menu = new Menu(this, handler, hud);
		this.addKeyListener(new KeyInput(handler, this));
		this.addMouseListener(menu);
		
		new Window(WIDTH, HEIGHT,":)", this);
		
		spawn = new Spawn(handler,hud);
		
//		if(gameState == STATE.Game) {
//		handler.addObject(new Player(WIDTH/2 -32,HEIGHT/2 -32, ID.Player,this.handler));//middle
//		handler.addObject(new BasicEnemy(450, 76, ID.BasicEnemy,this.handler));
//		}
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;

	}
	public synchronized  void stop() {
		try {
			thread.join();
			running = false;
		}
		catch(Exception e) {
			e.printStackTrace();
		}

	}
	
	//game loop = loop to update itself 
	public void run() {
		this.requestFocus(); //dont need to click on screen to control
		//long : data type with values wider than provide in int
		long lastTime = System.nanoTime();
		double amtTic = 60.0;
		double ns = 1000000000 / amtTic;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frame = 0;
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime)/ns;
			lastTime = now;
			while(delta >= 1) {
				tick();
				delta--;
			}
			if(running)
				render();
			frame++;

			if(System.currentTimeMillis() - timer > 1000) {
				timer+=1000;
				//System.out.println("FPS: "+ frame);
				frame = 0;
			}
		}
		stop();

	}

	private void render() {

		//buffer Strat used in visual graphics
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			//significantly drops the fps
			this.createBufferStrategy(3);
			return;
		}
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.pink);
		g.fillRect(0, 0, WIDTH, HEIGHT );
		handler.render(g);
		if(gameState == STATE.Game) {
		hud.render(g); //health
		handler.render(g);
		}
		else if(gameState == STATE.Menu ||gameState == STATE.Help || gameState == STATE.Thanks|| gameState == STATE.End ) {
			menu.render(g);
		}
		g.dispose();
		bs.show();

	}

	private void tick() {
		handler.tick();
		if(gameState == STATE.Game) {
		hud.tick();
		spawn.tick();
		}
		else if(gameState == STATE.Menu || gameState == STATE.End ) {
			menu.tick();
		}
		if(hud.HEALTH <= 0) {
			hud.HEALTH =100;
			gameState = STATE.End;
			handler.clearScreen();
		}
		
	}

	public static float clamp(float y, float min, float max) {
		if(y>=max) 
			return y = max;
		
		else if(y <= min) 
			return y= min;
		
		else
			return y;
	}

	public static void main(String args[]) {
		new Game();

	}
}


