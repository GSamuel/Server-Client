package com.gshoogeveen.serverclient;

public class MultipleMain
{
	public static void main(String args[])
	{
		new Thread(new ServerMain()).start();
		new Thread(new ClientMain()).start();
		new Thread(new ClientMain()).start();
		new Thread(new ClientMain()).start();
		new Thread(new ClientMain()).start();
		new Thread(new ClientMain()).start();
	}
}
