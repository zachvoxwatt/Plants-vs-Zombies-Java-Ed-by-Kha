package entities;

public abstract class Generic {
	
	private boolean isActivated = false, isEating = false, isProducing = false, isAttacking = false, seedout = false;
	private boolean shouldAttack1 = false, shouldAttack2 = false, shouldAttack3 = false, shouldAttack4 = false, shouldAttack5 = false;
	private boolean isDead = false;
	protected double x, y, life, att, def, velo, charge_time;
	private int lane, grid, price;
	
	public enum plantType { non, sunflower, peashooter }
	public enum side { NON, HOSTILE, HERO, SUPPORTER, LAWNKILLER }
	
	private side type = side.NON;
	private plantType ptype = plantType.non;
	
	public abstract void move();
	
	public void checkSetLane(int i)
	{
		if (i >= 1 && i <= 10) this.setLane(1);
		else if (i >= 11 && i <= 20) this.setLane(2);
		else if (i >= 21 && i <= 30) this.setLane(3);
		else if (i >= 31 && i <= 40) this.setLane(4);
		else if (i >= 41 && i <= 50) this.setLane(5);
	}
	public void setSide(side i)
	{
		this.type = i;
	}
	public void setX(double i)
	{
		this.x = i;
	}
	public void setY(double i)
	{
		this.y = i;
	}
	public void setLife(double i)
	{
		this.life = i;
	}
	public void setATT(double i)
	{
		this.att = i;
	}
	public void setDEF(double i)
	{
		this.def = i;
	}
	public void setVelo(double i)
	{
		this.velo = i;
	}
	public void setLane(int i)
	{
		this.lane = i;
	}
	public void setActivated() 
	{
		this.isActivated = true;
	}
	public void setChargeTime(double i)
	{
		this.charge_time = i;
	}
	public void setEating(boolean i)
	{
		this.isEating = i;
	}
	public void setGrid(int i)
	{
		this.grid = i;
	}
	public void setPlantType(plantType p)
	{
		this.ptype = p;
	}
	public void setPrice(int i)
	{
		this.price = i;
	}
	public void setProducing(boolean i)
	{
		this.isProducing = i;
	}
	public void setSunOut(boolean i)
	{
		this.seedout = i;
	}
	public void setAttacking(boolean i)
	{
		this.isAttacking = i;
	}
	public void setShouldAttack1(boolean i)
	{
		this.shouldAttack1 = i;
	}
	public void setShouldAttack2(boolean i)
	{
		this.shouldAttack2 = i;
	}
	public void setShouldAttack3(boolean i)
	{
		this.shouldAttack3 = i;
	}
	public void setShouldAttack4(boolean i)
	{
		this.shouldAttack4 = i;
	}
	public void setShouldAttack5(boolean i)
	{
		this.shouldAttack5 = i;
	}
	public void decreaseLife(int i)
	{
		this.life -= i;
	}
	public void setDeath(boolean i)
	{
		this.isDead = i;
	}
	
	
	public boolean getDeath()
	{
		return this.isDead;
	}
	public boolean shouldAttack1()
	{
		return this.shouldAttack1;
	}
	public boolean shouldAttack2()
	{
		return this.shouldAttack2;
	}
	public boolean shouldAttack3()
	{
		return this.shouldAttack3;
	}
	public boolean shouldAttack4()
	{
		return this.shouldAttack4;
	}
	public boolean shouldAttack5()
	{
		return this.shouldAttack5;
	}
	public plantType getPlantType()
	{
		return this.ptype;
	}
	public side getSide()
	{
		return this.type;
	}
	public double getX()
	{
		return this.x;
	}
	public double getY()
	{
		return this.y;
	}
	public double getLife()
	{
		return this.life;
	}
	public double getATT()
	{
		return this.att;
	}
	public double getDEF()
	{
		return this.def;
	}
	public double getVelo()
	{
		return this.velo;
	}
	public int getLane()
	{
		return this.lane;
	}
	public boolean isActivated() 
	{
		return isActivated;
	}
	public boolean isEating()
	{
		return this.isEating;
	}
	public double getChargeTime()
	{
		return this.charge_time;
	}
	public int getGrid()
	{
		return this.grid;
	}
	public int getPrice()
	{
		return this.price;
	}
	public boolean isProducing()
	{
		return this.isProducing;
	}
	public boolean getSunOut()
	{
		return this.seedout;
	}
	public boolean isAttacking()
	{
		return this.isAttacking;
	}
	
	public void stop()
	{
		this.velo = 0;
	}
}
