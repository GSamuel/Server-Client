package com.gshoogeveen.serverclient.views;

import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.FlowLayout;

import javax.swing.JFrame;

public class CustomFrame extends JFrame 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6740733060146770047L;

	public CustomFrame()
	{
		init();
	}

	private void init()
	{
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(800,600);
		this.getContentPane().setBackground(Color.WHITE);
		
		this.setLayout(new FlowLayout());
		
		this.setVisible(true);
		this.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
	}
}
