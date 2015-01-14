package com.gshoogeveen.serverclient;

import java.util.ArrayList;

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
		
		Interval2DD rect = new Interval2DD(new IntervalD(0.0,0.1), new IntervalD(0.0,0.1));

		
		QNode qtree = new QNode(null, new Interval2DD(new IntervalD(0.0,5.0), new IntervalD(0.0,5.0)),4, 10);
		for(int i =0; i < 1000000; i++)
		{
			qtree.insert(new Entity(Math.random()*5, Math.random()*5));
		}

		
		ArrayList<Entity> list = new ArrayList<Entity>();

		long start = System.currentTimeMillis();
		qtree.query2D(rect, list);
		long diff = System.currentTimeMillis()-start;
		System.out.println(diff +" "+ list.size() );
		
		for(Entity en:list)
			System.out.println(en.getX()+" "+en.getY());

		w.addEntity(new Entity(0, 0));
		//new Server().start();
	}

}
