package com.gshoogeveen.serverclient.views;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.gshoogeveen.serverclient.models.Entity;
import com.gshoogeveen.serverclient.models.World;

public class WorldView extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8708159424661756197L;
	
	private World w;

	public WorldView(World w)
	{
		this.w = w;
		this.setPreferredSize(new Dimension(700,500));
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		
		g2d.drawRect(0, 0, this.getWidth()-1, this.getHeight()-1);
		
		for(Entity e: w.getEntities())
			g2d.fillRect((int)e.getX(), (int)e.getY(), 10, 10);
			
	}
}
