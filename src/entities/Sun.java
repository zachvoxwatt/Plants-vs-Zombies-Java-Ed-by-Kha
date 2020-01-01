package entities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.Timer;

import misc.Actions;

public class Sun implements Actions, ActionListener {

	private boolean getCoors = false;
	private boolean isCollected = false, isHome = false, isStopped = false, left, gotTurn, needsRemoving = false, falls;
	private double x, sy, ny = -60, tar_y, tars_y, f_velo = 1.25, og_x, og_sy;
	private double home_x = 80, home_y = 20, return_velo = 25, dx, dy, dir;
	private Random rand = new Random();
	private Timer remove = new Timer(8500, this);
	
	public Sun(double x, double y) 
	{
		this.falls = false;
		this.x = x;
		this.sy = y;
	}
	
	public Sun(boolean s)
	{
		this.falls = s;
		this.x = rand.nextInt(850) + 250;
		this.tar_y = rand.nextInt(440) + 160;
	}
	
	@Override
	public void move() 
	{
		this.ny += f_velo;
	}
	
	public void alt_move(double x, double y)
	{
		if (this.getCoors == false)
		{
			this.tars_y = rand.nextInt(25) + 25;
			this.og_x = x; this.og_sy = y;
			this.getCoors = true;
		}
		
		if (this.gotTurn == false)
		{
			this.left = rand.nextBoolean();
			this.gotTurn = true;
		}
		
		if (this.left == true)
		{
			if (this.og_x - this.x < 20)
			{
				this.sy -= f_velo;
				this.x -= f_velo;
			}
			
			else if (this.sy - this.og_sy < this.tars_y)
			{
				this.sy += f_velo;
			}
		}
		
		if (this.left == false)
		{
			if (this.x - this.og_x < 20)
			{
				this.sy -= f_velo;
				this.x += f_velo;
			}
			
			else if (this.sy - this.og_sy < this.tars_y)
			{
				this.sy += f_velo;
			}
		}
		
	}
	
	public void toContainer()
	{
		if (isHome() == false)
		{
			dx = this.x - home_x;
			
			if (this.falls == true)
			{	
				dy = this.ny - home_y;
			}
			
			else if (this.falls == false)
			{
				dy = this.sy - home_y;
			}
			
			dir = Math.atan( dy / dx );
		
			if (this.falls == true)
			{
				this.x -= return_velo * Math.cos(dir);
				this.ny -= return_velo * Math.sin(dir);
			}
			
			else
			{
				this.x -= return_velo * Math.cos(dir);
				this.sy -= return_velo * Math.sin(dir);
			}
		}
	}
	
	public boolean isHome()
	{
		if (this.x < 100 && this.x > 0 && this.ny > 0 && this.ny < 50 || this.sy > 0 && this.sy < 20) return true;
		
		else return false;
	}
	
	public boolean getHomeStatus()
	{
		return this.isHome;
	}

	@Override
	public void stop() 
	{
		if (this.falls == true)
		{
			this.f_velo = 0;
			this.isStopped = true;
		}
		
		else
		{
			this.isStopped = true;
		}
	 }
	
	public double getX()
	{
		return this.x;
	}
	
	public double getYfall()
	{
		return this.ny;
	}
	
	public double getYpop()
	{
		return this.sy;
	}
	
	public double getTargetY()
	{
		return this.tar_y;
	}
	
	public double getTargetYpop()
	{
		return this.tars_y;
	}
	public boolean isStopped()
	{
		return this.isStopped;
	}
	
	public boolean shouldRemove()
	{
		return this.needsRemoving;
	}
	
	public void setCollected()
	{
		this.isCollected = true;
	}
	
	public boolean isCollected()
	{
		return this.isCollected;
	}
	
	public void startRemove()
	{
		this.remove.start();
	}
	
	public void stopRemove()
	{
		this.remove.stop();
	}
	
	public void setFalls(boolean i)
	{
		this.falls = i;
	}
	
	public boolean isTypeFall()
	{
		return this.falls;
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		this.needsRemoving = true;
		this.remove.stop();
	}
}
