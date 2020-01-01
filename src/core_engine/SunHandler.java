package core_engine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Random;

import javax.swing.JPanel;
import javax.swing.Timer;

import entities.Sun;

//This class handles the Seeds
@SuppressWarnings({"serial"})
public class SunHandler extends JPanel implements MouseMotionListener, ActionListener, Runnable {
	
	private boolean gotSeed = false, got1stSeed = false, startFall = false, collected = false;
	private int spawnDelay, temp, world_delay;
	
	private Random rand = new Random();
	private Thread seed_handler;
	private Timer firstSeed, moveTimer;
	private ArrayList<Sun> seeds = new ArrayList<Sun>();
	
	public SunHandler()
	{
		super();
			setBounds(0, 0, 1280, 720);
			setOpaque(false);
		addMouseMotionListener(this);
		moveTimer = new Timer(world_delay + 20, this);
		temp = getRandomNo();
		start();
	}
	
	@Override
	public void run()
	{
		spawnDelay = temp + getRandomNo();
		deployFirstSeed();
		moveTimer.start();
		
		while (true)
		{
			TimeAdvance();
			
			try
			{
				Thread.sleep(spawnDelay);
			}
			
			catch (InterruptedException e) {}
			
			finally { spawnDelay = getRandomNo(); }
		}
	}
	
	public void deployFirstSeed()
	{
		ActionListener takeseed = new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				seeds.add(new Sun(true));
				firstSeedTaken();
				firstSeed.stop();
			}
		};
		
		firstSeed = new Timer(7000, takeseed);
			firstSeed.start();
		startFall = true;
	}
	
	public void firstSeedTaken()
	{
		this.got1stSeed = true;
	}
	
	private void TimeAdvance() 
	{
		if (this.got1stSeed == true) seeds.add(new Sun(true));
		
	}

	public void start()
	{
		seed_handler = new Thread(this, "6-SunSeedHandler");
			seed_handler.start();
	}
	
	public int getRandomNo()
	{
		return ( rand.nextInt(5) + 10 ) * 1000;
	}
	
	public boolean hasStartedFalling()
	{
		return this.startFall;
	}
	
	public ArrayList<Sun> getListOfSeeds()
	{
		return this.seeds;
	}
	
	public void gotSeed()
	{
		this.gotSeed = true;
	}
	
	public boolean hasSeed()
	{
		return this.gotSeed;
	}
	
	public void ungotSeed()
	{
		this.gotSeed = false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		try
		{
			for (Sun s: seeds)
			{
				if (s.isTypeFall() == true)
				{
					s.move();
					
					if (s.getYfall() >= s.getTargetY() && s.isCollected() == false)
					{
						s.stop();
					}
				}
				
				else
				{
					s.alt_move(s.getX(), s.getYpop());
					
					if (s.getYpop() >= s.getTargetYpop() && s.isCollected() == false)
					{
						s.stop();
					}
				}
					
				if (s.isStopped() == true)
				{
					s.startRemove();
					
					if (s.shouldRemove() == true)
					{
						seeds.remove(s);
					}
				}
					
				if (s.isCollected() == true)
				{
					s.toContainer();
					s.stopRemove();
					
					if (s.isHome() == true)
					{
						seeds.remove(s);
					}
				}
			}
		}
		
		catch (ConcurrentModificationException ae) {}
		
		finally {}
	}

	public void setCollected()
	{
		this.collected = true;
	}
	
	public void resetCollected()
	{
		this.collected = false;
	}
	
	public boolean returnCollected()
	{
		return this.collected;
	}
	
	public void retrieveWorldDelay(int i)
	{
		this.world_delay = i;
	}

	@Override
	public void mouseMoved(MouseEvent e) {}
	@Override
	public void mouseDragged(MouseEvent e) {}

}
