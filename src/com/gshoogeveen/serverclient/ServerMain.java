package com.gshoogeveen.serverclient;

import com.gshoogeveen.serverclient.server.ConnectionManager;
import com.gshoogeveen.serverclient.server.Server;
import com.gshoogeveen.serverclient.views.ConnectionManagerView;
import com.gshoogeveen.serverclient.views.CustomFrame;
import com.gshoogeveen.serverclient.views.IntegerSender;

public class ServerMain implements Runnable
{
	private ConnectionManager manager = new ConnectionManager();
	CustomFrame frame = new CustomFrame();

	public ServerMain()
	{
		new Server(manager, 1205).start();
		
		frame.add(new IntegerSender(manager));
		frame.add(new ConnectionManagerView(manager));
		frame.revalidate();
		frame.setTitle("Server");
	}

	public static void main(String[] args)
	{
		new ServerMain();
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
