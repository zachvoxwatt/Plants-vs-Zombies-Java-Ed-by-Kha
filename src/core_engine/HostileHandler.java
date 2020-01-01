package core_engine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Random;

import javax.swing.Timer;

import entities.*;
import misc.Actions;

public class HostileHandler implements Runnable, Actions {
	
	private boolean l1scanner = false, l2scanner = false, l3scanner = false, l4scanner = false, l5scanner = false;
	private int z_ini_x = 1250;
	private int world_delay;
	
	private Timer startSpawn, delayedSpawnTimer;
	private Random rand = new Random();
	private Thread hh;
	private ArrayList<Generic> horde1 = new ArrayList<Generic>();
	private ArrayList<Generic> horde2 = new ArrayList<Generic>();
	private ArrayList<Generic> horde3 = new ArrayList<Generic>();
	private ArrayList<Generic> horde4 = new ArrayList<Generic>();
	private ArrayList<Generic> horde5 = new ArrayList<Generic>();

	public HostileHandler()
	{
		ActionListener hostileSpawner = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int lane = rand.nextInt(5) + 1;
				
				switch (lane)
				{
				case 1:
					horde1.add(new Zombie( lane, z_ini_x ));
					break;
					
				case 2:
					horde2.add(new Zombie( lane, z_ini_x));
					break;
					
				case 3:
					horde3.add(new Zombie( lane, z_ini_x));
					break;
					
				case 4:
					horde4.add(new Zombie( lane, z_ini_x));
					break;
					
				case 5:
					horde5.add(new Zombie( lane, z_ini_x));
					break;
				}
			}
		};
	
		ActionListener startSpawnHostile = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int lane = rand.nextInt(5) + 1;
				addHostile(lane);
				delayedSpawnTimer.start();
				startSpawn.stop();
			}
		};

		startSpawn = new Timer(12500, startSpawnHostile);
		delayedSpawnTimer = new Timer(19500, hostileSpawner);
		
		start();
	}
	
	@Override
	public void move() 
	{
		try
		{
			for (Generic h: horde1)
			{
				h.move();
				if (h.getX() < -50)
				{
					h.setDeath(true);
				}
			}
			
			for (Generic h: horde2)
			{
				h.move();
				if (h.getX() < -50)
				{
					h.setDeath(true);
				}
			}
			
			for (Generic h: horde3)
			{
				h.move();
				if (h.getX() < -50)
				{
					h.setDeath(true);
				}
			}
			
			for (Generic h: horde4)
			{
				h.move();
				if (h.getX() < -50)
				{
					h.setDeath(true);
				}
			}
			
			for (Generic h: horde5)
			{
				h.move();
				if (h.getX() < -50)
				{
					h.setDeath(true);
				}
			}
		}
		
		catch (ConcurrentModificationException cme) {}
	}
	
	@Override
	public void run() 
	{
		try
		{	
			while (true)
			{
				deathListener();
				move();
				
				try
				{
					Thread.sleep(world_delay);
				}
				
				catch (InterruptedException e) {}
			}
		}
		catch (ConcurrentModificationException cme) {}
	}

	public void start()
	{
		hh = new Thread(this, "4-HostileHandler");
			hh.start();
	}

	public void addHostile(int i)
	{
		switch (i)
		{
		case 1:
			horde1.add(new Zombie( i, z_ini_x ));
			break;
			
		case 2:
			horde2.add(new Zombie( i, z_ini_x));
			break;
			
		case 3:
			horde3.add(new Zombie( i, z_ini_x));
			break;
			
		case 4:
			horde4.add(new Zombie( i, z_ini_x));
			break;
			
		case 5:
			horde5.add(new Zombie( i, z_ini_x));
			break;
		}
	}
	
	public boolean L1Detector()
	{
		for (Generic h: horde1)
		{
			if (-50 <= h.getX() && h.getX() <= 1280 && h.getDeath() == false)
			{
				System.out.printf("L1 detected%n");
				this.l1scanner = true;
			}
			
			else this.l1scanner = false;
		}
		
		return this.l1scanner;
	}
	
	public boolean L2Detector()
	{
		for (Generic h: horde2)
		{
			if (-50 <= h.getX() && h.getX() <= 1280 && h.getDeath() == false)
			{
				System.out.printf("L2 detected%n");
				this.l2scanner = true;
			}
			
			else this.l2scanner = false;
		}
		
		return this.l2scanner;
	}
	
	public boolean L3Detector()
	{
		for (Generic h: horde3)
		{
			if (-50 <= h.getX() && h.getX() <= 1280 && h.getDeath() == false)
			{
				System.out.printf("L3 detected%n");
				this.l3scanner = true;
			}
			
			else this.l3scanner = false;
		}
		
		return this.l3scanner;
	}
	
	public boolean L4Detector()
	{
		for (Generic h: horde4)
		{
			if (-50 <= h.getX() && h.getX() <= 1280 && h.getDeath() == false)
			{
				System.out.printf("L4 detected%n");
				this.l4scanner = true;
			}
			
			else this.l4scanner = false;
		}
		
		return this.l4scanner;
	}
	
	public boolean L5Detector()
	{
		for (Generic h: horde5)
		{
			if (-50 <= h.getX() && h.getX() <= 1280 && h.getDeath() == false)
			{
				System.out.printf("L5 detected%n");
				this.l5scanner = true;
			}
			
			else this.l5scanner = false;
		}
		
		return this.l5scanner;
	}
	
	public void deathListener()
	{
		for (Generic h: horde1)
		{
			if (h.getDeath() == true)
			{
				h.stop();
			}
		}
		
		for (Generic h: horde2)
		{
			if (h.getDeath() == true)
			{
				h.stop();
			}
		}
		
		for (Generic h: horde3)
		{
			if (h.getDeath() == true)
			{
				h.stop();
			}
		}
		
		for (Generic h: horde4)
		{
			if (h.getDeath() == true)
			{
				h.stop();
			}
		}
		
		for (Generic h: horde5)
		{
			if (h.getDeath() == true)
			{
				h.stop();
			}
		}
	}

	public ArrayList<Generic> getZombies1()
	{
		return this.horde1;
	}
	
	public ArrayList<Generic> getZombies2()
	{
		return this.horde2;
	}
	
	public ArrayList<Generic> getZombies3()
	{
		return this.horde3;
	}
	
	public ArrayList<Generic> getZombies4()
	{
		return this.horde4;
	}
	
	public ArrayList<Generic> getZombies5()
	{
		return this.horde5;
	}
	
	public void startSpawn()
	{
		startSpawn.start();
	}
	
	public void retrieveWorldDelay(int i)
	{
		this.world_delay = i;
	}

	@Override
	public void stop() {}
}
