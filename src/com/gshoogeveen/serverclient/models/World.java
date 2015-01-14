package com.gshoogeveen.serverclient.models;

import java.io.Serializable;
import java.util.ArrayList;

public class World implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -318804855221865507L;
	
	private ArrayList<Entity> entities;
	
	public World()
	{
		entities= new ArrayList<Entity>();
	}
	
	public void addEntity(Entity e)
	{
		entities.add(e);
	}

	public Entity getEntity(int index)
	{
		return entities.get(index);
	}
	
	public ArrayList<Entity> getEntities()
	{
		return entities;
	}
}
