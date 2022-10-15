package com.gameProject.main;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import com.gameProject.main.Game.STATE;

public class KeyInput extends KeyAdapter{
	
	private Handle handler;
	private Game game;
	
	public KeyInput(Handle handler, Game game) {
		this.handler = handler;
		this.game = game;

	}
	
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		for(int i = 0; i<handler.object.size();i++) {
			GameObject temp = handler.object.get(i);
			if(temp.getId() == ID.Player) {
				//key event for player
				if(key == KeyEvent.VK_W) temp.setVelY(-5); //up
				if(key == KeyEvent.VK_S) temp.setVelY(5); //down
				if(key == KeyEvent.VK_A) temp.setVelX(-5); //left
				if(key == KeyEvent.VK_D) temp.setVelX(5); //right
			}
			//shut game
			if(key == KeyEvent.VK_ESCAPE) {
				handler.clearScreen();
				game.gameState = STATE.Menu;
			}
		}
	}
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		
		for(int i = 0; i<handler.object.size();i++) {
			GameObject temp = handler.object.get(i);
			if(temp.getId() == ID.Player) {
				//key event for player
				if(key == KeyEvent.VK_W) {
					temp.setVelY(0); //up
				}
				if(key == KeyEvent.VK_S) {
					temp.setVelY(0); //down
				}
				if(key == KeyEvent.VK_A) {
					temp.setVelX(0); //left
				}
				if(key == KeyEvent.VK_D) {
					temp.setVelX(0); //right
				}
			}
		}
		
	}

}
