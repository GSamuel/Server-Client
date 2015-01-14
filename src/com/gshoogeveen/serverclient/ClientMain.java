package com.gshoogeveen.serverclient;

import com.gshoogeveen.serverclient.client.Client;
import com.gshoogeveen.serverclient.models.World;
import com.gshoogeveen.serverclient.views.CustomFrame;
import com.gshoogeveen.serverclient.views.WorldView;


public class ClientMain
{

	public static void main(String[] args)
	{
		World w = new World();
		
		CustomFrame frame = new CustomFrame();
		frame.add(new WorldView(w));
		
		new Client().start();
	}

}
