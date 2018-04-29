import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.*;

public class you extends GameObject{
	int hp;
	int bullets;
	int last_action;
	boolean is_alive;
	boolean stunned;

	public you(){
		hp = 100;
		bullets = 6;
		is_alive = true;
		stunned = false;
		last_action = 0;
	}

	public void paint(Graphics2D g){
		g.setColor(new Color(0,255,0));
		g.fillRect(10,200,50,50);
		g.drawString(Integer.toString(hp),10,180);
	}

	public void use_basic(){
		last_action=1;
	}

	public boolean use_special(){
		last_action=2;
		bullets-=1;
		if(bullets>0){
			bullets-=1;
			if((new Random().nextInt(100)+1) < 20){
				return false;
			} else {
			return true;
			}
		}
		else{return false;}
	}

	public boolean use_reckless(){
		last_action=3;
		stunned=true;
		if((new Random().nextInt(100)+1) < 50){
			return false;
		} else {
		return true;
		}
	}

	public void use_heal(){
		last_action=4;
		hp+=13;
		if(hp>100){
			hp=100;
		}
	}

	public void use_reload(){
		last_action=5;
		bullets=6;
	}

	public void got_basic(){
		hp-=10;
	}

	public void got_special(){
		hp-=15;
	}

	public void got_reckless(){
		hp-=30;
	}
	public void got_damaged(int damage){
		hp-=damage;
	}
}