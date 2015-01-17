package com.gshoogeveen.serverclient.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable
{
	private ConnectionManager connectionManager;
	private boolean started = false;
	private int port;
	
	public Server(ConnectionManager connectionManager, int port)
	{
		this.connectionManager = connectionManager;
		this.port = port;
	}
	
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
			server = new ServerSocket(port);
			System.out.println("server made");
		} catch (IOException e)
		{
			e.printStackTrace();
		}


		Socket clientSocket = null;
		
		while (true)
		{
			try
			{
				System.out.println("wait for client");
				clientSocket = server.accept();
				System.out.println("client connected");
				System.out.println(clientSocket.getRemoteSocketAddress());
				
				connectionManager.add(new ConnectionHandler(clientSocket));
				
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
