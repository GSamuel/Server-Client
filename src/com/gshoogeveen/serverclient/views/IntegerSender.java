package com.gshoogeveen.serverclient.views;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.gshoogeveen.serverclient.server.ConnectionManager;

public class IntegerSender extends JPanel implements ActionListener
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1640123897655315089L;
	private ConnectionManager connectionManager;
	private JButton sendButton, closeButton;
	private JTextField input;

	public IntegerSender(ConnectionManager connectionManager)
	{
		this.connectionManager = connectionManager;
		this.setPreferredSize(new Dimension(400,400));
		
		input = new JTextField();
		input.setPreferredSize(new Dimension(50,25));
		add(input);
		
		sendButton = new JButton("send");
		sendButton.addActionListener(this);
		add(sendButton);
		
		closeButton = new JButton("close");
		closeButton.addActionListener(this);
		add(closeButton);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{

	}

	@Override
	public void actionPerformed(ActionEvent event)
	{	
		if(event.getActionCommand().compareTo("send")==0)
			connectionManager.send(Integer.valueOf(input.getText()));

		if(event.getActionCommand().compareTo("close")==0)
			connectionManager.close(0);
	}

	
	
}
