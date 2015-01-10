package com.gshoogeveen.serverclient.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server implements Runnable
{
	private boolean started = false;

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
			Socket serverSocket = null;
			System.out.println("wait for client");
			try
			{
				serverSocket = server.accept();

				System.out.println("client connected");

				System.out.println(serverSocket.getRemoteSocketAddress());
				System.out.println("server closed");
				serverSocket.close();
			} catch (IOException e)
			{
				e.printStackTrace();

				try
				{
					serverSocket.close();
				} catch (IOException e1)
				{
					e1.printStackTrace();
					System.exit(0);
				}
			}

		}

	}

}
