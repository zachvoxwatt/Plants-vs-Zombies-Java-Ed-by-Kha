package core_engine;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import entities.Generic;
import entities.Lawnkiller;
import entities.Pea;
import entities.Sun;
import misc.GraphicsManager;
import misc.RenderingMethods;
import misc.SeedPack;

//This class handles the Logic and Rendering of the World
@SuppressWarnings(value = {"serial"})
public class World extends JPanel implements MouseMotionListener, MouseListener, Runnable {
	
	private int key, click_x_check, click_y_check, px, py;
	private boolean spawnNOW = false, lock1 = false;
	private static int world_delay = 20; //Higher this value, slower the world
	private static int cur_seed = 100;

	private GraphicsManager gm = new GraphicsManager();
	private JLayeredPane lmg = new JLayeredPane();
	private RenderingMethods rm = new RenderingMethods();
	private Thread artist_thinker;
	private SunHandler sun = new SunHandler();
	private HostileHandler hh = new HostileHandler();
	private HeroHandler HH = new HeroHandler();
	private LawnkillerHandler lk = new LawnkillerHandler();
	private PlantingHandler ph = new PlantingHandler();
	private GUI_Manager gui = new GUI_Manager(world_delay, cur_seed);
	
	private ArrayList<Pea> proj;
	private ArrayList<Generic> horde1; private ArrayList<Generic> horde2; private ArrayList<Generic> horde3;
	private ArrayList<Generic> horde4; private ArrayList<Generic> horde5;
	private ArrayList<Generic> plants1; private ArrayList<Generic> plants2; private ArrayList<Generic> plants3;
	private ArrayList<Generic> plants4; private ArrayList<Generic> plants5;
	private ArrayList<Lawnkiller> lks;
	private ArrayList<Sun> seeds;
	private ArrayList<SeedPack> packs;
	
	public World()
	{
		super();
			setLayout(null);
			setBounds(0, 0, 1280, 720);
			setOpaque(false);
			
		initialContentPanes();
			horde1 = hh.getZombies1(); horde2 = hh.getZombies2(); horde3 = hh.getZombies3();
			horde4 = hh.getZombies4(); horde5 = hh.getZombies5();
			
			plants1 = HH.getPlants1(); plants2 = HH.getPlants2(); plants3 = HH.getPlants3();
			plants4 = HH.getPlants4(); plants5 = HH.getPlants5();
	
		proj = HH.getPeas();
		sun.retrieveWorldDelay(world_delay);
		seeds = sun.getListOfSeeds();
		HH.getListOfSeeds(seeds);
		lks = lk.getLawnkillers();
		packs = gui.getSeedPacks();
		
			ph.retrievePlants1(plants1); ph.retrievePlants2(plants2); ph.retrievePlants3(plants3); 
			ph.retrievePlants4(plants4); ph.retrievePlants5(plants5);
		ph.retrievePacks(packs);
		
		
		start();
	}
	
	public void initialContentPanes()
	{
		lk.retrieveWorldDelay(world_delay);
		hh.retrieveWorldDelay(world_delay);
		HH.retrieveWorldDelay(world_delay);
		ph.retrieveWorldDelay(world_delay);
		
		addMouseListener(this);
		lmg.setLayout(null);
		lmg.setBounds(0, 0, 1280, 720);
			
	//initialize the layered pane		
			lmg.setLayout(null);
			lmg.setBounds(0, 0, 1280, 720);
			
	//adding child panes
			//GUI Pane
				lmg.add(gui, new Integer(4));
	//DisplayPanel adds the layered pane which holds all child pane
			add(lmg);
	}
	
//World Logic handler unit
	public void TimePassed()
	{
		lockStartSpawn();
		lkProx();
		lkKill();
		Pea_Func();
		Zombie_Func();
		Peashooter_Function1();
		Peashooter_Function2();
		Peashooter_Function3();
		Peashooter_Function4();
		Peashooter_Function5();
		
		if (gui.isPlanting() == false && gui.isExcavating() == false) disposeShovelCursor();
			
		else if (gui.isPlanting() == true && gui.isExcavating() == false) 
			{
				disposeShovelCursor();
				addMouseMotionListener(this);
			}
		
		else if (gui.isPlanting() == false && gui.isExcavating() == true) initialShovelCursor();
		
		repaint();
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
			
			finally {}
		}
		
	}
	
	public void Zombie_Func()
	{
		try
		{
			for (Generic h: horde1)
			{
				for (Generic p: plants1)
				{
					if (h.getX() - p.getX() < 5)
					{
						h.stop();
						h.setEating(true);
						
						if (h.isEating() == true)
						{
							p.decreaseLife((int) h.getATT());
							
							if (p.getLife() <= 0)
							{
								plants1.remove(p);
								h.setEating(false);
								h.setVelo(0.5);
							}
						}
					}
				}
			}
			
			for (Generic h: horde2)
			{
				for (Generic p: plants2)
				{
					if (h.getX() - p.getX() < 5)
					{
						h.stop();
						h.setEating(true);
						
						if (h.isEating() == true)
						{
							p.decreaseLife((int) h.getATT());
							
							if (p.getLife() <= 0)
							{
								plants2.remove(p);
								h.setVelo(0.5);
							}
						}
					}
				}
			}
			
			for (Generic h: horde3)
			{
				for (Generic p: plants3)
				{
					if (h.getX() - p.getX() < 5)
					{
						h.stop();
						h.setEating(true);
						
						if (h.isEating() == true)
						{
							p.decreaseLife((int) h.getATT());
							
							if (p.getLife() <= 0)
							{
								plants3.remove(p);
								h.setVelo(0.5);
							}
						}
					}
				}
			}
			
			for (Generic h: horde4)
			{
				for (Generic p: plants4)
				{
					if (h.getX() - p.getX() < 5)
					{
						h.stop();
						h.setEating(true);
						
						if (h.isEating() == true)
						{
							p.decreaseLife((int) h.getATT());
							
							if (p.getLife() <= 0)
							{
								plants4.remove(p);
								h.setVelo(0.5);
							}
						}
					}
				}
			}
			
			for (Generic h: horde5)
			{
				for (Generic p: plants5)
				{
					if (h.getX() - p.getX() < 5)
					{
						h.stop();
						h.setEating(true);
						
						if (h.isEating() == true)
						{
							p.decreaseLife((int) h.getATT());
							
							if (p.getLife() <= 0)
							{
								plants5.remove(p);
								h.setVelo(0.5);
							}
						}
					}
				}
			}
		}
		
		catch (ConcurrentModificationException cme) {}
	}
	
	public void Peashooter_Function1()
	{
		plants1 = HH.getPlants1();
		horde1 = hh.getZombies1();
		
		for (Generic p: plants1)
		{
			for (Generic h: horde1)
			{
				if (hh.L1Detector() == true && p.getX() <= h.getX() && h.getX() <= 1280 && p.getPlantType() == Generic.plantType.peashooter)
				{
					p.setShouldAttack1(true);
				}
				
				else p.setShouldAttack1(false);
				if (hh.L1Detector() == false) System.out.printf("Boo!%n");
			}
		}
	}
	
	public void Peashooter_Function2()
	{
		plants2 = HH.getPlants2();
		horde2 = hh.getZombies2();
		
		for (Generic p: plants2)
		{
			for (Generic h: horde2)
			{
				if (hh.L1Detector() == true && p.getX() <= h.getX() && h.getX() <= 1280 && p.getPlantType() == Generic.plantType.peashooter)
				{
					p.setShouldAttack2(true);
				}
				
				else p.setShouldAttack2(false);
				if (hh.L2Detector() == false) System.out.printf("Boo!%n");
			}
		}
	}
	
	public void Peashooter_Function3()
	{
		plants3 = HH.getPlants3();
		horde3 = hh.getZombies3();
		
		for (Generic p: plants3)
		{
			for (Generic h: horde3)
			{
				if (hh.L1Detector() == true && p.getX() <= h.getX() && h.getX() <= 1280 && p.getPlantType() == Generic.plantType.peashooter)
				{
					p.setShouldAttack3(true);
				}
				
				else p.setShouldAttack3(false);
				
				if (hh.L3Detector() == false) System.out.printf("Boo!%n");
			}
		}
	}
	
	public void Peashooter_Function4()
	{
		plants4 = HH.getPlants4();
		horde4 = hh.getZombies4();
		
		for (Generic p: plants4)
		{
			for (Generic h: horde4)
			{
				if (hh.L1Detector() == true && p.getX() <= h.getX() && h.getX() <= 1280 && p.getPlantType() == Generic.plantType.peashooter)
				{
					p.setShouldAttack4(true);
				}
				
				else p.setShouldAttack4(false);
				if (hh.L4Detector() == false) System.out.printf("Boo!%n");
			}
		}
	}
	
	public void Peashooter_Function5()
	{
		plants5 = HH.getPlants5();
		horde5 = hh.getZombies5();
		
		for (Generic p: plants5)
		{
			for (Generic h: horde5)
			{
				if (hh.L1Detector() == true && p.getX() <= h.getX() && h.getX() <= 1280 && p.getPlantType() == Generic.plantType.peashooter)
				{
					p.setShouldAttack5(true);
				}
				
				else p.setShouldAttack5(false);
				
				if (hh.L5Detector() == false) System.out.printf("Boo!%n");
			}
		}
	}
	
	public void Pea_Func()
	{
		try
		{
			for (Pea p: proj)
			{
				p.move();
				
				for (Generic h: horde1)
				{
					if (p.getX() > h.getX() && h.getX() - p.getX() < -10 && p.getLane() == h.getLane() && h.getDeath() == false)
					{
						h.decreaseLife(p.getDMG());
						proj.remove(p);
						
						if (h.getLife() <= 0 && h.getDeath() == false)
						{
							h.setDeath(true);
						}
					}
				}
				
				for (Generic h: horde2)
				{
					if (p.getX() > h.getX() && h.getX() - p.getX() < -10 && p.getLane() == h.getLane() && h.getDeath() == false)
					{
						h.decreaseLife(p.getDMG());
						proj.remove(p);
						
						if (h.getLife() <= 0 && h.getDeath() == false)
						{
							h.setDeath(true);
						}
					}
				}
				
				for (Generic h: horde3)
				{
					if (p.getX() > h.getX() && h.getX() - p.getX() < -10 && p.getLane() == h.getLane() && h.getDeath() == false)
					{
						h.decreaseLife(p.getDMG());
						proj.remove(p);
						
						if (h.getLife() <= 0 && h.getDeath() == false)
						{
							h.setDeath(true);
						}
					}
				}
				
				for (Generic h: horde4)
				{
					if (p.getX() > h.getX() && h.getX() - p.getX() < -10 && p.getLane() == h.getLane() && h.getDeath() == false)
					{
						h.decreaseLife(p.getDMG());
						proj.remove(p);
						
						if (h.getLife() <= 0 && h.getDeath() == false)
						{
							h.setDeath(true);
						}
					}
				}
				
				for (Generic h: horde5)
				{
					if (p.getX() > h.getX() && h.getX() - p.getX() < -10 && p.getLane() == h.getLane() && h.getDeath() == false)
					{
						h.decreaseLife(p.getDMG());
						proj.remove(p);
						
						if (h.getLife() <= 0 && h.getDeath() == false)
						{
							h.setDeath(true);
						}
					}
				}
				
				if (p.getX() > 1300) 
				{
					proj.remove(p);
				}
			}
		}
		
		catch (ConcurrentModificationException cme) {}
	}

	@Override
	public void mouseMoved(MouseEvent e) 
	{
		if (gui.isPlanting() == true && gui.isExcavating() == false) 
		{
			px = e.getX(); py = e.getY();
			ph.checkValidGrids(px, py);
		}
		
		if (gui.isPlanting() == false && gui.isExcavating() == true) ph.checkRemovingGrids(e.getX(), e.getY());
	}

	@Override
	public void mouseClicked(MouseEvent e)
	{
		this.click_x_check = e.getX(); this.click_y_check = e.getY();
		
		if (gui.isPlanting() == false && gui.isExcavating() == false)
		{	
			for (Sun i: seeds)
			{
				if (i.getX() <= this.click_x_check && i.getX() + 45 >= this.click_x_check && i.isCollected() == false && sun.returnCollected() == false)
				{
					if (i.getYfall() <= this.click_y_check && i.getYfall() + 45 >= this.click_y_check && i.isCollected() == false && sun.returnCollected() == false)
					{
						i.setCollected();
						takenSeedNaturally();
						sun.setCollected();
						sun.resetCollected();
						gui.updateSunSeedNaturally(25);
						
						if (lock1 == false) 
						{
							signalSpawn();
						}
					}
					
					if (i.getYpop() <= this.click_y_check && i.getYpop() + 45 >= this.click_y_check && i.isCollected() == false && sun.returnCollected() == false)
					{
						i.setCollected();
						takenSeedNaturally();
						sun.setCollected();
						sun.resetCollected();
						gui.updateSunSeedNaturally(25);
						
						if (lock1 == false) 
						{
							signalSpawn();
						}
					}
					
					resetPlantingMech();
				}
			}
		}
		
		if (gui.isExcavating() == true && gui.isPlanting() == false)
		{
			try
			{
				for (Generic p: plants1)
				{
					if (p.getGrid() == ph.getRemovingGrid())
					{
						ph.remove();
						resetPlantingMech();
					}
				}
				
				for (Generic p: plants2)
				{
					if (p.getGrid() == ph.getRemovingGrid())
					{
						ph.remove();
						resetPlantingMech();
					}
				}
				
				for (Generic p: plants3)
				{
					if (p.getGrid() == ph.getRemovingGrid())
					{
						ph.remove();
						resetPlantingMech();
					}
				}
				
				for (Generic p: plants4)
				{
					if (p.getGrid() == ph.getRemovingGrid())
					{
						ph.remove();
						resetPlantingMech();
					}
				}
				
				for (Generic p: plants5)
				{
					if (p.getGrid() == ph.getRemovingGrid())
					{
						ph.remove();
						resetPlantingMech();
					}
				}
			}
			
			catch (ConcurrentModificationException cme) {}
			
			finally
			{
				gui.resetShovelClick();
				gui.setExcavating(false);
				disposeShovelCursor();
				resetPlantingMech();
			}
		}
		
		if (gui.isPlanting() == true && gui.isExcavating() == false)
		{
			for (SeedPack p: packs)
			{
				if (p.isSelected() == true && World.cur_seed >= p.getPrice())
				{
					if (ph.checkGrid(ph.getSelectedGrid()) == true)
					{
						ph.plant();
						sunConsumed(p.getPrice());
						p.usedPack();
						ph.resetSelectedGrid();
					}
					
					else
					{
						gui.warn2_start();
						ph.resetSelectedGrid();
					}

					resetPlantingMech();
				}
				
				else if (p.isSelected() == true && World.cur_seed < p.getPrice())
				{
					resetPlantingMech();
					gui.warn1_start();
				}
			}
		}
	}
	
	public void sunConsumed(int i)
	{
		World.cur_seed -= i;
		gui.updateSunSeedUser(i);
	}
	
	public void resetPlantingMech()
	{
		gui.resetPacks();
		gui.setPlanting(false);
	}

	public void start()
	{
		artist_thinker = new Thread(this, "7-LogicPhysicsHandler");
			artist_thinker.start();
	}
	
	public int getWorldDelay()
	{
		return world_delay;
	}
	
	public int getCurSeed()
	{
		return cur_seed;
	}
	
	public void signalSpawn()
	{
		this.spawnNOW = true;
	}
	
	public void lockStartSpawn()
	{
		if (spawnNOW == true && lock1 == false)
		{
			hh.startSpawn();
			lock1 = true;
		}
	}
	
	public void lkProx()
	{
		for (Generic a: horde1)
		{
			for (Generic b: lks)
			{
				if (a.getX() - b.getX() < 20 && a.getLane() == b.getLane())
				{
					key = checkYCoor((int) a.getY());
					lk.startEngine(key);
				}
			}
		}
		
		for (Generic a: horde2)
		{
			for (Generic b: lks)
			{
				if (a.getX() - b.getX() < 20 && a.getLane() == b.getLane())
				{
					key = checkYCoor((int) a.getY());
					lk.startEngine(key);
				}
			}
		}
		
		for (Generic a: horde3)
		{
			for (Generic b: lks)
			{
				if (a.getX() - b.getX() < 20 && a.getLane() == b.getLane())
				{
					key = checkYCoor((int) a.getY());
					lk.startEngine(key);
				}
			}
		}
		
		for (Generic a: horde4)
		{
			for (Generic b: lks)
			{
				if (a.getX() - b.getX() < 20 && a.getLane() == b.getLane())
				{
					key = checkYCoor((int) a.getY());
					lk.startEngine(key);
				}
			}
		}
		
		for (Generic a: horde5)
		{
			for (Generic b: lks)
			{
				if (a.getX() - b.getX() < 20 && a.getLane() == b.getLane())
				{
					key = checkYCoor((int) a.getY());
					lk.startEngine(key);
				}
			}
		}
	}
	
	public void lkKill()
	{
		try
		{
			for (Generic h: horde1)
			{
				for (Generic lk: lks)
				{
					if (lk.isActivated() == true && h.getX() - lk.getX() < 5 && h.getLane() == lk.getLane())
					{
						h.setDeath(true);
					}
				}
			}
			
			for (Generic h: horde2)
			{
				for (Generic lk: lks)
				{
					if (lk.isActivated() == true && h.getX() - lk.getX() < 5 && h.getLane() == lk.getLane())
					{
						h.setDeath(true);
					}
				}
			}
			
			for (Generic h: horde3)
			{
				for (Generic lk: lks)
				{
					if (lk.isActivated() == true && h.getX() - lk.getX() < 5 && h.getLane() == lk.getLane())
					{
						h.setDeath(true);
					}
				}
			}
			
			for (Generic h: horde4)
			{
				for (Generic lk: lks)
				{
					if (lk.isActivated() == true && h.getX() - lk.getX() < 5 && h.getLane() == lk.getLane())
					{
						h.setDeath(true);
					}
				}
			}
			
			for (Generic h: horde5)
			{
				for (Generic lk: lks)
				{
					if (lk.isActivated() == true && h.getX() - lk.getX() < 5 && h.getLane() == lk.getLane())
					{
						h.setDeath(true);
					}
				}
			}
		}
		
		catch (ConcurrentModificationException cme) {}
	}
	
	public int checkYCoor(int x)
	{
		int temp = 0;
		
		switch (x)
		{
			case 115:
				temp = 1;
				break;
				
			case 225:
				temp = 2;
				break;
				
			case 331:
				temp = 3;
				break;
				
			case 437:
				temp = 4;
				break;
				
			case 547:
				temp = 5;
				break;
		}
		
		return temp;
	}
	
	public static void takenSeedNaturally()
	{
		cur_seed += 25;
	}

	@Override
	public void mouseDragged(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent arg0) {}
	@Override
	public void mouseExited(MouseEvent arg0) {}
	@Override
	public void mousePressed(MouseEvent arg0) {}
	@Override
	public void mouseReleased(MouseEvent arg0) {}
	
	
	public void initialShovelCursor()
	{
		addMouseMotionListener(this);
		Cursor c = Toolkit.getDefaultToolkit().createCustomCursor(gm.retrieveGraphics_GUI_ShovelCursor(), new Point(this.getX(), this.getY()), "Shovel");
		this.setCursor(c);
	}
	
	public void disposeShovelCursor()
	{
		removeMouseMotionListener(this);
		setCursor(Cursor.getDefaultCursor());
		gui.changeShovelButtonColor();
		repaint();
	}
	
//Rendering handler
		@Override
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			try
			{
				for (Generic p: plants1)
				{
					switch (p.getPlantType())
					{
						case sunflower:
							rm.gr_Sunflower(g, p.getX(), p.getY());
							break;
							
						case peashooter:
							if (p.shouldAttack1() == false)
							{
								rm.gr_Peashooter(g, p.getX(), p.getY(), false);
							}
							else rm.gr_Peashooter(g, p.getX(), p.getY(), true);
							break;
							
						default:
							break;
					}
				}
				
				for (Generic p: plants2)
				{
					switch (p.getPlantType())
					{
						case sunflower:
							rm.gr_Sunflower(g, p.getX(), p.getY());
							break;
							
						case peashooter:
							if (p.shouldAttack2() == false)
							{
								rm.gr_Peashooter(g, p.getX(), p.getY(), false);
							}
							else rm.gr_Peashooter(g, p.getX(), p.getY(), true);
							break;
							
						default:
							break;
					}
				}
				
				for (Generic p: plants3)
				{
					switch (p.getPlantType())
					{
						case sunflower:
							rm.gr_Sunflower(g, p.getX(), p.getY());
							break;
							
						case peashooter:
							if (p.shouldAttack3() == false)
							{
								rm.gr_Peashooter(g, p.getX(), p.getY(), false);
							}
							else rm.gr_Peashooter(g, p.getX(), p.getY(), true);
							break;
							
						default:
							break;
					}
				}
				
				for (Generic p: plants4)
				{
					switch (p.getPlantType())
					{
						case sunflower:
							rm.gr_Sunflower(g, p.getX(), p.getY());
							break;
							
						case peashooter:
							if (p.shouldAttack4() == false)
							{
								rm.gr_Peashooter(g, p.getX(), p.getY(), false);
							}
							else rm.gr_Peashooter(g, p.getX(), p.getY(), true);
							break;
							
						default:
							break;
					}
				}
				
				for (Generic p: plants5)
				{
					switch (p.getPlantType())
					{
						case sunflower:
							rm.gr_Sunflower(g, p.getX(), p.getY());
							break;
							
						case peashooter:
							if (p.shouldAttack5() == false)
							{
								rm.gr_Peashooter(g, p.getX(), p.getY(), false);
							}
							else rm.gr_Peashooter(g, p.getX(), p.getY(), true);
							break;
							
						default:
							break;
					}
				}
			}
			
			catch (ConcurrentModificationException cme) {}
			
			try
			{
				for (Generic h: horde1)
				{
					if (h.getDeath() == false)
					{
						if (h.isEating() == false)
						{
							rm.gr_Zombie(g, h.getX(), h.getY(), false);
						}
						
						else rm.gr_Zombie(g, h.getX(), h.getY(), true);
					}
				}
				
				for (Generic h: horde2)
				{
					if (h.getDeath() == false)
					{
						if (h.isEating() == false)
						{
							rm.gr_Zombie(g, h.getX(), h.getY(), false);
						}
						
						else rm.gr_Zombie(g, h.getX(), h.getY(), true);
					}
				}
				
				for (Generic h: horde3)
				{
					if (h.getDeath() == false)
					{
						if (h.isEating() == false)
						{
							rm.gr_Zombie(g, h.getX(), h.getY(), false);
						}
						
						else rm.gr_Zombie(g, h.getX(), h.getY(), true);
					}
				}
				
				for (Generic h: horde4)
				{
					if (h.getDeath() == false)
					{
						if (h.isEating() == false)
						{
							rm.gr_Zombie(g, h.getX(), h.getY(), false);
						}
						
						else rm.gr_Zombie(g, h.getX(), h.getY(), true);
					}
				}
				
				for (Generic h: horde5)
				{
					if (h.getDeath() == false)
					{
						if (h.isEating() == false)
						{
							rm.gr_Zombie(g, h.getX(), h.getY(), false);
						}
						
						else rm.gr_Zombie(g, h.getX(), h.getY(), true);
					}
				}
			}
			
			catch (ConcurrentModificationException cme) {}
			
			try
			{
				for (Pea p: proj)
				{
					rm.gr_Pea(g, p.getX(), p.getY());
				}
			}
			
			catch (ConcurrentModificationException cme) {}
			
			try
			{
				for (Generic l: lks)
				{
					rm.gr_Lawnkiller(g, l.getX(), l.getY());
				}
			}
			
			catch (ConcurrentModificationException cme) {}
			
			try
			{
				for (Sun s: seeds)
				{
					if (s.isTypeFall() == true)
					{
						rm.gr_Sun(g, s.getX(), s.getYfall());
					}
					
					else
					{
						rm.gr_Sun(g,s.getX(), s.getYpop());
					}
				}
			}
			
			catch (ConcurrentModificationException cme) {}
			
			rm.gr_misc_showGrids(g, false);
		}
}
