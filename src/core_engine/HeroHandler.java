package core_engine;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Timer;

import entities.Generic;
import entities.Pea;
import entities.Sun;
import misc.Actions;

public class HeroHandler implements ActionListener, Actions, Runnable {

	private int world_delay;
	
	private Timer shootTimer1, shootTimer2, shootTimer3, shootTimer4, shootTimer5;
	private Thread HH;
	private ArrayList<Pea> proj = new ArrayList<Pea>();
	private ArrayList<Generic> plants1 = new ArrayList<Generic>();
	private ArrayList<Generic> plants2 = new ArrayList<Generic>();
	private ArrayList<Generic> plants3 = new ArrayList<Generic>();
	private ArrayList<Generic> plants4 = new ArrayList<Generic>();
	private ArrayList<Generic> plants5 = new ArrayList<Generic>();
	private ArrayList<Sun> suns;
	
	public HeroHandler()
	{
		Pea_Func();
		start();
	}
	
	@Override
	public void run() 
	{
		while (true)
		{
			TimePassed();
			try
			{
				Thread.sleep(world_delay);
			}
			
			catch (InterruptedException e) {}
		}
	}
	
	public void Pea_Func()
	{
			shootTimer1 = new Timer(1500, new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						for (Generic p: plants1)
						{
							if (p.getPlantType() == Generic.plantType.peashooter && p.shouldAttack1() == true)
							{
								proj.add(new Pea((int) p.getX() + 60, (int) p.getY() + 10, p.getLane()));
							}
						}
					}
				}
			);
			
			shootTimer2 = new Timer(1500, new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						for (Generic p: plants2)
						{
							if (p.getPlantType() == Generic.plantType.peashooter && p.shouldAttack2() == true)
							{
								proj.add(new Pea((int) p.getX() + 60, (int) p.getY() + 10, p.getLane()));
							}
						}
					}
				}
			);
			
			shootTimer3 = new Timer(1500, new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						for (Generic p: plants3)
						{
							if (p.getPlantType() == Generic.plantType.peashooter && p.shouldAttack3() == true)
							{
								proj.add(new Pea((int) p.getX() + 60, (int) p.getY() + 10, p.getLane()));
							}
						}
					}
				}
			);
			
			shootTimer4 = new Timer(1500, new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						for (Generic p: plants4)
						{
							if (p.getPlantType() == Generic.plantType.peashooter && p.shouldAttack4() == true)
							{
								proj.add(new Pea((int) p.getX() + 60, (int) p.getY() + 10, p.getLane()));
							}
						}
					}
				}
			);
			
			shootTimer5 = new Timer(1500, new ActionListener()
				{
					@Override
					public void actionPerformed(ActionEvent e)
					{
						for (Generic p: plants5)
						{
							if (p.getPlantType() == Generic.plantType.peashooter && p.shouldAttack5() == true)
							{
								proj.add(new Pea((int) p.getX() + 60, (int) p.getY() + 10, p.getLane()));
							}
						}
					}
				}
			);
		
		shootTimer1.start(); shootTimer2.start(); shootTimer3.start(); shootTimer4.start(); shootTimer5.start();
	}
	
	public void TimePassed()
	{
		validateSunflower();
		sunflower_Func();
	}
	
	public void validateSunflower()
	{
		for (Generic p: plants1)
		{
			if (p.getPlantType() == Generic.plantType.sunflower && p.isProducing() == false)
			{
				p.setProducing(true);
			}
		}
		
		for (Generic p: plants3)
		{
			if (p.getPlantType() == Generic.plantType.sunflower && p.isProducing() == false)
			{
				p.setProducing(true);
			}
		}
		
		for (Generic p: plants2)
		{
			if (p.getPlantType() == Generic.plantType.sunflower && p.isProducing() == false)
			{
				p.setProducing(true);
			}
		}
		
		for (Generic p: plants4)
		{
			if (p.getPlantType() == Generic.plantType.sunflower && p.isProducing() == false)
			{
				p.setProducing(true);
			}
		}
		
		for (Generic p: plants5)
		{
			if (p.getPlantType() == Generic.plantType.sunflower && p.isProducing() == false)
			{
				p.setProducing(true);
			}
		}
	}
	
	public void sunflower_Func()
	{
		for (Generic p: plants1)
		{
			if (p.getPlantType() == Generic.plantType.sunflower && p.getSunOut() == true)
			{
				suns.add(new Sun(p.getX(), p.getY()));
				p.setSunOut(false);
			}
		}
		
		for (Generic p: plants2)
		{
			if (p.getPlantType() == Generic.plantType.sunflower && p.getSunOut() == true)
			{
				suns.add(new Sun(p.getX(), p.getY()));
				p.setSunOut(false);
			}
		}
		
		for (Generic p: plants3)
		{
			if (p.getPlantType() == Generic.plantType.sunflower && p.getSunOut() == true)
			{
				suns.add(new Sun(p.getX(), p.getY()));
				p.setSunOut(false);
			}
		}
		
		for (Generic p: plants4)
		{
			if (p.getPlantType() == Generic.plantType.sunflower && p.getSunOut() == true)
			{
				suns.add(new Sun(p.getX(), p.getY()));
				p.setSunOut(false);
			}
		}
		
		for (Generic p: plants5)
		{
			if (p.getPlantType() == Generic.plantType.sunflower && p.getSunOut() == true)
			{
				suns.add(new Sun(p.getX(), p.getY()));
				p.setSunOut(false);
			}
		}
	}
	
	public void start()
	{
		HH = new Thread(this, "3-HeroHandler");
		HH.start();
	}
	
	public ArrayList<Generic> getPlants1()
	{
		return this.plants1;
	}
	
	public ArrayList<Generic> getPlants2()
	{
		return this.plants2;
	}
	
	public ArrayList<Generic> getPlants3()
	{
		return this.plants3;
	}
	
	public ArrayList<Generic> getPlants4()
	{
		return this.plants4;
	}
	
	public ArrayList<Generic> getPlants5()
	{
		return this.plants5;
	}
	
	public void getListOfSeeds(ArrayList<Sun> a)
	{
		this.suns = a;
	}
	
	public ArrayList<Pea> getPeas()
	{
		return this.proj;
	}
	
	public void retrieveWorldDelay(int i)
	{
		this.world_delay = i;
	}
	
		@Override
	public void stop() {}
	@Override
	public void move() {}
	@Override
	public void actionPerformed(ActionEvent e) {}
}
