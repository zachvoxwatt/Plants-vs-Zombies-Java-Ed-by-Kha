package entities;

import misc.Actions;

public class Zombie extends Generic implements Actions {
	
	public Zombie(int i, double x)
	{
		super();
			setSide(side.HOSTILE);
			setLane(i);
		
		switch (i)
		{
			case 1:
				setY(115);
				break;
			
			case 2:
				setY(225);
				break;
			
			case 3:
				setY(331);
				break;
			
			case 4:
				setY(437);
				break;
			
			case 5:
				setY(547);
				break;
		}
			setX(x);
			setLife(200);
			setATT(1);
			setDEF(0);
			setVelo(0.7);
	}
	
	@Override
	public void move()
	{
		this.x -= this.velo;
	}
	
	@Override
	public void stop() 
	{
		this.velo = 0;
	}
	
	public void tp()
	{
		this.x = -1765; this.y = -2710;
	}
}
