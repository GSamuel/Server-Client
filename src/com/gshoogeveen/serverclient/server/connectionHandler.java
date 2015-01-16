package com.gshoogeveen.serverclient.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class connectionHandler implements Runnable
{
	private Socket clientSocket;
	public connectionHandler(Socket clientSocket)
	{
		this.clientSocket = clientSocket;
	}
	@Override
	public void run()
	{
		try
		{
			DataInputStream input = new DataInputStream(clientSocket.getInputStream());
			DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());
			
			while(true)
			{
				System.out.print(input.readByte());
			}
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	

}
