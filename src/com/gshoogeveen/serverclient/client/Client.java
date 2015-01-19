package com.gshoogeveen.serverclient.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import com.gshoogeveen.serverclient.server.ConnectionHandler;
import com.gshoogeveen.serverclient.server.ConnectionManager;

public class Client
{
	private ConnectionManager connectionManager;
	private String adress;
	private int port;

	public Client(ConnectionManager connectionManager,String adress, int port)
	{
		this.connectionManager = connectionManager;
		this.adress = adress;
		this.port = port;
	}
	
	public void connect()
	{
		Socket clientSocket = null;
		try
		{
			System.out.println("connection to server");
			clientSocket = new Socket(adress, port);
			System.out.println(clientSocket.getInetAddress().getHostName());
			System.out.println("connected to server");

			connectionManager.add(new ConnectionHandler(clientSocket));
			
		} catch (UnknownHostException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

}
