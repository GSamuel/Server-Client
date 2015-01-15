package com.gshoogeveen.serverclient.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client implements Runnable
{
	private boolean started = false;

	public void start()
	{
		if (!started)
			new Thread(this).start();
		started = true;
	}

	@Override
	public void run()
	{
		Socket clientSocket = null;
		try
		{
			System.out.println("connection to server");
			//clientSocket = new Socket("192.168.2.38", 1205);
			clientSocket = new Socket("192.168.1.44", 1205);
			System.out.println("connected to server");
			Thread.sleep(2000);
			System.out.println("close connection");
			clientSocket.close();
			System.out.println("connection closed");

		} catch (UnknownHostException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		} catch (InterruptedException e)
		{
			e.printStackTrace();
		} finally
		{

			try
			{
				if (clientSocket != null)
					clientSocket.close();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}

	}

}
