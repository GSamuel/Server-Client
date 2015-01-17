package com.gshoogeveen.serverclient;

import com.gshoogeveen.serverclient.client.Client;
import com.gshoogeveen.serverclient.server.ConnectionManager;
import com.gshoogeveen.serverclient.views.CustomFrame;
import com.gshoogeveen.serverclient.views.IntegerSender;

public class ClientMain implements Runnable
{
	private ConnectionManager manager = new ConnectionManager();
	CustomFrame frame = new CustomFrame();

	public ClientMain()
	{
		new Client(manager, "192.168.0.16", 1205).connect();

		frame.add(new IntegerSender(manager));
		frame.revalidate();
		frame.setTitle("Client");
	}

	public static void main(String[] args)
	{
		new ClientMain();
	}

	@Override
	public void run()
	{
		while (true)
		{
			manager.read();
			frame.repaint();
		}
	}
}
