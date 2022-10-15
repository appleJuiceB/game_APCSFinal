package com.gameProject.main;

import java.awt.Graphics;
import java.awt.Rectangle;

public abstract class GameObject {
	//protected - only accessed by object that inherit game object
	protected float x,y;
	protected ID id;
	protected float velX, velY; //speed
	public GameObject(float x, float y,  ID id) {
		this.x = x;
		this.y = y;
		this.id = id;
	}
	
	public abstract void tick();
	public abstract void render(Graphics g); 
	//rect to handle collisions, will us .intersect boolean 
	public abstract Rectangle getBound();
	
	//getters
	public float getX() {
		return x;
	}
	public float getY() {
		return y;
	}
	public ID getId() {
		return id;
	}
	public float getVelX() {
		return velX;
	}
	public float getVelY() {
		return velY;
	}
	
	//setters
	public void setX(int x) {
		this.x = x;
	}
	public void setY(int y) {
		this.y = y;
	}
	public void setId(ID id) {
		this.id = id;
	}
	public void setVelX(int velX) {
		this.velX = velX;
	}
	public void setVelY(int velY) {
		this.velY = velY;
	}
	

}
