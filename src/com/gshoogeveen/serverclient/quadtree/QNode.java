package com.gshoogeveen.serverclient.quadtree;

import java.util.ArrayList;

import com.gshoogeveen.serverclient.models.Entity;

public class QNode
{
	private ArrayList<Entity> bucket;
	private int maxBucketSize;
	private boolean isLeaf;
	private QNode parent;
	private Interval2DD boundBox;
	private QNode NW, NE, SE, SW; // four subtrees
	private int level;
	private int maxLevel;

	public QNode(QNode parent, Interval2DD boundBox, int maxBucketSize,
			int maxLevel)
	{
		this.parent = parent;
		this.boundBox = boundBox;
		this.maxBucketSize = maxBucketSize;
		this.isLeaf = true;
		this.level = 0;
		this.maxLevel = maxLevel;
	}

	private QNode(QNode parent, Interval2DD boundBox, int maxBucketSize,
			int maxLevel, int level)
	{
		this.parent = parent;
		this.boundBox = boundBox;
		this.maxBucketSize = maxBucketSize;
		this.isLeaf = true;
		this.level = level;
		this.maxLevel = maxLevel;
	}

	public void insert(Entity entity)
	{
		if (boundBox.contains(entity.getX(), entity.getY()))
		{
			if (isLeaf)
			{
				if (bucket == null)
				{
					bucket = new ArrayList<Entity>();
					bucket.add(entity);
				} else if (bucket.size() >= maxBucketSize && level < maxLevel)
				{
					this.divide();
					this.isLeaf = false;
					for (Entity e : bucket)
					{
						insertInQuads(e);
					}
					bucket.clear();
					bucket = null;

					insertInQuads(entity);
				} else
					bucket.add(entity);
			} else
			{
				insertInQuads(entity);
			}
		}

	}
	
	public void query2D(Interval2DD rect, ArrayList<Entity> list) {
		
		if(!boundBox.intersects(rect))
			return;
        
        if(isLeaf)
        {
        	if(bucket != null)
        for(Entity e:bucket)
        if (rect.contains(e.getX(),e.getY()))
        	list.add(e);
        }
        else
        {
        	NW.query2D(rect, list);
        	NE.query2D(rect, list);
        	SW.query2D(rect, list);
        	SE.query2D(rect, list);
        }
    }

	public int size()
	{
		if (isLeaf)
			if (bucket == null)
				return 0;
			else
				return bucket.size();
		else
			return NW.size() + NE.size() + SW.size() + SE.size();
	}

	public boolean isEmpty()
	{
		if (isLeaf)
			if (bucket == null || bucket.size() == 0)
				return true;
		return false;
	}

	private void insertInQuads(Entity entity)
	{
		NW.insert(entity);
		NE.insert(entity);
		SW.insert(entity);
		SE.insert(entity);
	}

	public void merge()
	{
		if (!isLeaf && size() <= maxBucketSize)
		{
			bucket = new ArrayList<Entity>();
			isLeaf = true;
			for (Entity e : NW.bucket)
			{
				bucket.add(e);
				NW = null;
			}
			for (Entity e : NE.bucket)
			{
				bucket.add(e);
				NE = null;
			}
			for (Entity e : SW.bucket)
			{
				bucket.add(e);
				SW = null;
			}
			for (Entity e : SE.bucket)
			{
				bucket.add(e);
				SE = null;
			}
		}
	}

	public void remove(Entity e)
	{
		if (bucket.remove(e))
		{
			if (parent != null)
				parent.merge();
		}

	}

	private void divide()
	{
		double centerX = boundBox.intervalX.center();
		double centerY = boundBox.intervalY.center();

		NW = new QNode(this, new Interval2DD(new IntervalD(
				boundBox.intervalX.low, centerX), new IntervalD(
				boundBox.intervalY.low, centerY)), maxBucketSize, maxLevel,
				level + 1);
		NE = new QNode(this, new Interval2DD(new IntervalD(centerX,
				boundBox.intervalX.high), new IntervalD(boundBox.intervalY.low,
				centerY)), maxBucketSize, maxLevel, level + 1);
		SW = new QNode(this, new Interval2DD(new IntervalD(
				boundBox.intervalX.low, centerX), new IntervalD(centerY,
				boundBox.intervalY.high)), maxBucketSize, maxLevel, level + 1);
		SE = new QNode(this, new Interval2DD(new IntervalD(centerX,
				boundBox.intervalX.high), new IntervalD(centerY,
				boundBox.intervalY.high)), maxBucketSize, maxLevel, level + 1);
	}

	public void destroy()
	{
		this.bucket.clear();
		this.bucket = null;
		this.parent = null;
		this.NW = null;
		this.NE = null;
		this.SW = null;
		this.SE = null;
	}
}
