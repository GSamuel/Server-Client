package com.gshoogeveen.serverclient;

import com.gshoogeveen.serverclient.models.Entity;
import com.gshoogeveen.serverclient.models.World;
import com.gshoogeveen.serverclient.quadtree.Interval2DD;
import com.gshoogeveen.serverclient.quadtree.IntervalD;
import com.gshoogeveen.serverclient.quadtree.QNode;

public class ServerMain
{
	public static void main(String[] args)
	{
		World w = new World();
		//CustomFrame frame = new CustomFrame();

		Entity e = new Entity(0.5,1.5);
		Entity e2 = new Entity(1.5,0.5);
		Entity e3 = new Entity(1.5,1.5);
		
		QNode qtree = new QNode(null, new Interval2DD(new IntervalD(0.0,2.0), new IntervalD(0.0,2.0)),3, 10);
		qtree.insert(e);	
		qtree.insert(e2);
		qtree.insert(e3);

		w.addEntity(new Entity(0, 0));
		//new Server().start();
	}

}
