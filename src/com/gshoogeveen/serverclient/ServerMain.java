package com.gshoogeveen.serverclient;

import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

import com.gshoogeveen.serverclient.server.Server;
import com.gshoogeveen.serverclient.views.CustomFrame;

public class ServerMain
{
	public static void main(String[] args)
	{
		CustomFrame frame = new CustomFrame();
		
		ConcurrentHashMap<Socket,Integer> connMap = new ConcurrentHashMap<>();

		new Server(connMap).start();
		
		while(true)
		{
			for(Socket s: connMap.keySet())
				;
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
