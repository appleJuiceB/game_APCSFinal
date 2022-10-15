package com.gameProject.main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas{

	private static final long serialVersionUID = -1411614973366729205L;

	public Window(int width, int height, String title, Game game) {
		// TODO Auto-generated constructor stub
		JFrame frame = new JFrame(title);
		 
		frame.setPreferredSize( new Dimension(width,height));
		frame.setMaximumSize( new Dimension(width,height));
		frame.setMinimumSize( new Dimension(width,height));
		//like x button to exit 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//can not resize window
		frame.setResizable(false);
		//start in middle
		frame.setLocationRelativeTo(null);
		frame.add(game);
		//see frame
		frame.setVisible(true);
		game.start();
		
		
		
	}

}
