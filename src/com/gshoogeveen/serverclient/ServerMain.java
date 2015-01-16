package com.gshoogeveen.serverclient;

import com.gshoogeveen.serverclient.server.Server;
import com.gshoogeveen.serverclient.views.CustomFrame;

public class ServerMain
{
	public static void main(String[] args)
	{
		CustomFrame frame = new CustomFrame();

		new Server().start();
		
		while(true)
		{
			try
			{
				Thread.sleep(750);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

}
