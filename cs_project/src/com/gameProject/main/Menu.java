package com.gameProject.main;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import com.gameProject.main.Game.STATE;

public class Menu extends MouseAdapter{
	private Game game;
	private Handle handler;
	private HeadsUp hud;

	public Menu(Game game, Handle handler,HeadsUp hud) {
		this.game = game;
		this.handler = handler;
		this.hud = hud;
	}


	public void mousePressed(MouseEvent e) {
		int mx = e.getX();
		int my = e.getY();

		//play
		if(game.gameState == STATE.Menu) {
			if(mouseOver(mx,my,215, 110, 200, 64)) {
				game.gameState = STATE.Game;
				hud.setLevel(1);
				hud.setScore(0);
				handler.addObject(new Player(Game.WIDTH/2 -32,Game.HEIGHT/2 -32, ID.Player,this.handler));//middle
				handler.addObject(new BasicEnemy(450, 76, ID.BasicEnemy,this.handler));
			}

			//help
			if(mouseOver(mx,my,215, 210, 200, 64)) 
				game.gameState = STATE.Help;
			
			//quit
			if(mouseOver(mx,my,215, 310, 200, 64)) 
				System.exit(1);
			
			//credit
			if(mouseOver(mx,my,245, 410, 140, 30)) 
				game.gameState = STATE.Thanks;
			
		}
		//end game
		if(hud.HEALTH <= 0) {
			game.gameState = STATE.End;
		}

		//back to menu
		if(game.gameState == STATE.Help ||game.gameState == STATE.Thanks || game.gameState == STATE.End) {
			if(mouseOver(mx,my,20, 400, 150, 35)) {
				game.gameState = STATE.Menu;
			}
		}

	} 

	public void mouseReleased(MouseEvent e) {

	}

	private boolean mouseOver(int mx, int my, int x, int y, int width, int height) {
		if(mx > x && mx< x + width) {
			if(my > y && my< y +height ) {
				return true;
			}return false;
		}return false;
	}


	public void tick() {

	}
	public void render(Graphics g) {
		Font fnt = new Font("comic sans ms", 1, 50);
		Font fnt1 = new Font("comic sans ms", 1, 30);
		Font fnt2 = new Font("comic sans ms", 1, 17);
		Font fnt3 = new Font("comic sans ms", 1, 25);
		Font fnt4 = new Font("comic sans ms", 1, 14);
		Font fnt5 = new Font("comic sans ms", 1, 16);
		
		//menu pg
		if(game.gameState == STATE.Menu) {
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("(•-•✿)", 227, 70);

			g.setFont(fnt1);
			g.setColor(Color.white);
			g.drawString("Play", 283, 153);
			g.drawString("Help", 283, 253);
			g.drawString("Quit", 283, 353);
			g.setFont(fnt2);
			g.drawString("Credits", 285, 432);

			g.setColor(new Color(57,118,65));
			g.drawRect(215, 110, 200, 64); //play

			g.drawRect(215, 210, 200, 64); //help

			g.drawRect(215, 310, 200, 64); //quit
			
			g.drawRect(245, 410, 140, 30); //credit
		}
		
		//help pg
		else if(game.gameState == STATE.Help) {
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("How to Play", 170, 70);
			g.setFont(fnt2);
			g.drawString("Use WASD keys to move your player and dodge enemies", 90, 160);
			g.drawString("There are three types of enemies: ", 90, 200);
			g.drawString("* basic enemies - move randomly ", 150, 230);
			g.drawString("* fast enemies - move quickly in zig zag pattern ", 150, 260);
			g.drawString("* smart enemies - follows player ", 150, 290);
			g.drawString("Collect the yellow coins to boost Health!", 90, 330);
			g.drawString("To exit the game mid-game, press esc key", 90, 370);

			g.drawString("Back to Menu", 37, 425);
			g.setColor(new Color(57,118,65));
			g.drawRect(20, 400, 150, 35); 
		}
		
		//credit pg
		else if(game.gameState == STATE.Thanks) {
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Credits", 230, 70);
			g.setFont(fnt1);
			g.drawString("made by: Me, Myself, and I :P", 90, 130);
			g.setFont(fnt3);
			g.drawString("thanks to: ", 110, 165);
			g.setFont(fnt5);
			g.drawString("* my parents for inspiration", 120, 190);
			g.drawString("* RealTutsGML for an extremely helpful tutorial", 120, 220);
			g.drawString("* & Mr.Hanson for pushing me to explore things out of my", 120, 250);
			g.drawString("  comfort zone and being an amazing teacher we all can rely on", 120, 270);
			g.setFont(fnt4);
			g.drawString("  ~and for teaching us to dodge a wrench rather than a ball :) ", 140, 290);
			
			
			
			g.drawString("Back to Menu", 46, 423);
			g.setColor(new Color(57,118,65));
			g.drawRect(20, 400, 150, 35); 
		}
		
		//end screen
		else if(game.gameState == STATE.End) {
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Game Over", 185, 70);
			g.setFont(fnt1);
			g.setColor(Color.white);
			g.drawString("Your Score was: " + hud.getScore()  , 150, 160);
			g.setFont(fnt2);
			g.drawString("Back to Menu", 37, 425);

			g.setColor(new Color(57,118,65));
			g.drawRect(20, 400, 150, 35); 
		}
	}


}
