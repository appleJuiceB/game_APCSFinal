package com.gameProject.main;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handle {
	
	//linkedlist are faster than arraylist when deleting or adding elements
	LinkedList<GameObject> object = new LinkedList<GameObject>();
	public Handle() {
		// TODO Auto-generated constructor stub
	}
	public void tick() {
		for(int i = 0; i < object.size() ;i++) {
			GameObject temp = object.get(i);
			temp.tick();
		}
		
	}
	public void render(Graphics g) {
		for(int i = 0; i < object.size() ;i++) {
			GameObject temp = object.get(i);
			
			temp.render(g);
		}
	}
	
	public void addObject(GameObject x) {
		this.object.add(x);
	}
	
	public void removeObject(GameObject x) {
		this.object.remove(x);
	}
	public void clearScreen() {
		for(int i = 0; i < object.size(); i++) {
			GameObject temp = object.get(i);
			if(temp.getId() == ID.Player) {
				object.clear();
			}
		}
		
	}

}
