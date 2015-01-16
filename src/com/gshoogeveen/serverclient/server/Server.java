package com.gshoogeveen.serverclient.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ConcurrentHashMap;

public class Server implements Runnable
{
	private boolean started = false;
	//private ConcurrentHashMap<Socket, Integer> connMap;
	/*
	public Server(ConcurrentHashMap<Socket, Integer> connMap)
	{
		this.connMap = connMap;
	}*/

	public void start()
	{
		if (!started)
			new Thread(this).start();
		started = true;
	}

	@SuppressWarnings("resource")
	@Override
	public void run()
	{
		ServerSocket server = null;
		try
		{
			server = new ServerSocket(1205);
			System.out.println("server made");
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		while (true)
		{
			Socket clientSocket = null;
			System.out.println("wait for client");
			try
			{
				clientSocket = server.accept();

				System.out.println("client connected");

				System.out.println(clientSocket.getRemoteSocketAddress());
				System.out.println("server added to list");
				//connMap.put(serverSocket, (int)(Math.random()*100));
				
				new Thread(new connectionHandler(clientSocket)).start();
				
			} catch (IOException e)
			{
				e.printStackTrace();

				try
				{
					clientSocket.close();
				} catch (IOException e1)
				{
					e1.printStackTrace();
					System.exit(0);
				}
			}

		}

	}

}
