package com.gshoogeveen.serverclient.models;

import java.io.Serializable;

public class Message implements Serializable
{
	private static final long serialVersionUID = 5329985412990306518L;
	double x,y;
	public Message(double x, double y)
	{
		this.x = x;
		this.y = y;
	}
	
	public double getX()
	{
		return x;
	}
	
	public double getY()
	{
		return y;
	}
}
