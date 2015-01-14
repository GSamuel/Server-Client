package com.gshoogeveen.serverclient;

import com.gshoogeveen.serverclient.models.Entity;
import com.gshoogeveen.serverclient.models.World;
import com.gshoogeveen.serverclient.quadtree.Interval;
import com.gshoogeveen.serverclient.quadtree.Interval2D;
import com.gshoogeveen.serverclient.quadtree.QuadTree;
import com.gshoogeveen.serverclient.server.Server;
import com.gshoogeveen.serverclient.views.CustomFrame;

public class ServerMain
{
	public static void main(String[] args)
	{
		World w = new World();
		CustomFrame frame = new CustomFrame();
		
		Entity e = new Entity(1.5,2.5);
		
		QuadTree<Double, Entity> qTree = new QuadTree<Double, Entity>();
		qTree.insert(e.getX(),e.getY(),e);
		qTree.insert(0.01,5.0, new Entity(1.5,2.5));
		
		qTree.query2D(new Interval2D<Double>(new Interval<Double>(0.0,5.0), new Interval<Double>(0.0,5.0)));
		
		w.addEntity(new Entity(0, 0));
		new Server().start();
	}

}
