package com.gameProject.main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Trail extends GameObject{
	private float alpha = 1;
	private Handle handler;
	private Color color;
	private float life;
	private int width,height;
	//life 0.01-0.1, shorter the number longer life of trial

	public Trail(float x, float y, ID id,Color color,int width, int height, float life, Handle handler) {
		super(x,y,id);
		this.handler = handler;
		this.color = color;
		this.width = width;
		this.height = height;
		this.life = life;
	}




	public void tick() {
		if (alpha > life) alpha -=life - 0.001f;
		else handler.removeObject(this);
		
	}

	
	public void render(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(makeTransparent(alpha));
		
		g.setColor(color);
		g.fillRect((int)x, (int)y, width,height);
		//makes  things we want transparent
		g2d.setComposite(makeTransparent(1));

		
	}

	//AlphaComposite implements basic alpha compositing rule for combining src and dest color to
	//get blending + transparency effect
	private AlphaComposite makeTransparent(float alpha) {
		int type = AlphaComposite.SRC_OVER;
		return(AlphaComposite.getInstance(type, alpha));
		
	}
	public Rectangle getBound() {
		return null;
	}

}
