package entities;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

import misc.Actions;

public class Peashooter extends Generic implements ActionListener, Actions {

	private Timer t = new Timer(20, this);
	
	public Peashooter(double x, double y, int k)
	{
		super();
			setGrid(k);
			checkSetLane(k);
			setSide(side.HERO);
			setPlantType(plantType.peashooter);
			setX(x);
			setY(y);
			setLife(150);
			setPrice(50);
		t.start();
	}

	@Override
	public void stop() {}
	@Override
	public void move() {}

	@Override
	public void actionPerformed(ActionEvent arg0) 
	{
		switch (this.getLane())
		{
		case 1:
			if (this.shouldAttack1() == true)
				this.setAttacking(true);
			else this.setAttacking(false);
			break;
			
		case 2:
			if (this.shouldAttack2() == true)
				this.setAttacking(true);
			else this.setAttacking(false);
			break;
			
		case 3:
			if (this.shouldAttack3() == true)
				this.setAttacking(true);
			else this.setAttacking(false);
			break;
			
		case 4:
			if (this.shouldAttack4() == true)
				this.setAttacking(true);
			else this.setAttacking(false);
			break;
			
		case 5:
			if (this.shouldAttack5() == true)
				this.setAttacking(true);
			else this.setAttacking(false);
			break;
		}
	}
}
