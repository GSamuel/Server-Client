package com.gshoogeveen.serverclient.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ConnectionHandler implements Runnable
{
	private Socket clientSocket;
	private DataOutputStream output;
	private DataInputStream input;
	private ConcurrentLinkedQueue<Integer> fifoList;
	private boolean closeStream;

	public ConnectionHandler(Socket clientSocket)
	{
		this.clientSocket = clientSocket;
		fifoList = new ConcurrentLinkedQueue<Integer>();
		initStream();
	}

	private void initStream()
	{
		try
		{
			output = new DataOutputStream(clientSocket.getOutputStream());
			input = new DataInputStream(clientSocket.getInputStream());
			closeStream = false;

			new Thread(this).start();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	public void sendData(int num)
	{
		if (!closeStream)
		{
			try
			{

				output.writeInt(num);
				output.flush();
			} catch (IOException e)
			{
				e.printStackTrace();
				closeStream = true;
			}
		}
	}

	public void processInput()
	{
		while (!fifoList.isEmpty())
			System.out.println(fifoList.remove());
	}

	public boolean isClosed()
	{
		return closeStream;
	}

	public Socket getSocket()
	{
		return clientSocket;
	}

	public void close()
	{
		closeStream = true;
	}

	@Override
	public void run()
	{
		int num;
		while (!closeStream)
		{
			try
			{
				if (input.available() >= 4)
				{
					num = input.readInt();
					fifoList.add(num);
				}
			} catch (IOException e)
			{
				e.printStackTrace();
				closeStream = true;
			}
		}

		try
		{
			output.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

		try
		{
			input.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}

	}

}
