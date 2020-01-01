package entities;

public class Pea {
	
	private int x, y, velo = 4, lane, damage;
	
	public Pea(int x, int y, int z)
	{
		setLane(z);
		setDMG(20);
		this.x = x;
		this.y = y;
	}
	
	public void move()
	{
		this.x += velo;
	}
	
	public void setDMG(int i)
	{
		this.damage = i;
	}
	
	public int getDMG()
	{
		return this.damage;
	}
	
	public void setX(int i)
	{
		this.x = i;
	}

	public void setY(int i)
	{
		this.y = i;
	}
	
	public int getX()
	{
		return this.x;
	}
	
	public int getY()
	{
		return this.y;
	}
	
	public void setLane(int i)
	{
		this.lane = i;
	}
	
	public int getLane()
	{
		return this.lane;
	}
}
