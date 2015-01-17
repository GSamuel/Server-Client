package com.gshoogeveen.serverclient.views;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.gshoogeveen.serverclient.server.ConnectionManager;

public class ConnectionManagerView extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1786835516097913620L;
	private ConnectionManager connectionManager;

	public ConnectionManagerView(ConnectionManager connectionManager)
	{
		this.connectionManager = connectionManager;
		this.setPreferredSize(new Dimension(700, 500));
	}

	@Override
	public void paintComponent(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		for (int i = 0; i < connectionManager.size(); i++)
		{
			g2d.drawString(""
					+ connectionManager.get(i).getSocket()
							.getRemoteSocketAddress(), 10, 20 * i + 20);
		}

	}

}
