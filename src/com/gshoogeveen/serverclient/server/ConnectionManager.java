package com.gshoogeveen.serverclient.server;

import java.util.Vector;

public class ConnectionManager
{
	private Vector<ConnectionHandler> connections;
	
	public ConnectionManager()
	{
		connections = new Vector<ConnectionHandler>();
	}
	
	public void add(ConnectionHandler handler)
	{
		connections.add(handler);
	}
	
	public void send(int num)
	{
		for(int i = 0; i <connections.size(); i++)
			connections.get(i).sendData(num);
	}
	
	public void read()
	{
		for(int i = 0; i <connections.size(); i++)
			connections.get(i).processInput();
	}
	
	public int size()
	{
		return connections.size();
	}
	
	public void close(int index)
	{
		connections.get(index).close();
	}
	
	public ConnectionHandler get(int index)
	{
		return connections.get(index);
	}
}
