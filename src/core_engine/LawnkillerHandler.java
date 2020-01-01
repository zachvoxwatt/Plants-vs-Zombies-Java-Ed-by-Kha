package core_engine;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import entities.*;
import misc.Actions;

public class LawnkillerHandler implements Actions, Runnable {
	
	private int world_delay;
	private ArrayList<Lawnkiller> killers = new ArrayList<Lawnkiller>();
	private Thread lkh;
	
	public LawnkillerHandler()
	{
		killers.add(new Lawnkiller(1));
		killers.add(new Lawnkiller(2));
		killers.add(new Lawnkiller(3));
		killers.add(new Lawnkiller(4));
		killers.add(new Lawnkiller(5));
		
		start();
	}
	
	@Override
	public void run()
	{
		while (true)
		{
			move();
			
			try
			{
				Thread.sleep(world_delay);
			}
			
			catch (InterruptedException e) {}	
		}
	}
	
	public void start()
	{
		lkh = new Thread(this, "5-LawnkillerHandler");
			lkh.start();
	}

	@Override
	public void move() 
	{
		try
		{
			for (Generic l: killers)
			{
				if (l.isActivated() == true)
				{
					l.move();
				}
				
				if (l.getX() > 1280)
				{
					killers.remove(l);
				}
			}
		}
		
		catch (ConcurrentModificationException cme) {}
	}
	
	@Override
	public void stop() {}
	
	public void startEngine(int i)
	{
		for (Generic k: killers)
		{
			if (k.getLane() == i)
			{
				k.setActivated();
			}
		}
	}
	
	public ArrayList<Lawnkiller> getLawnkillers()
	{
		return this.killers;
	}
	
	public void retrieveWorldDelay(int i)
	{
		this.world_delay = i;
	}
}
