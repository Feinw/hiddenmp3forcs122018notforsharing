import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.*;

public class Opponent extends GameObject{
	int hp;
	int x_place;
	int y_place;
	int bullets;
	boolean is_alive;
	boolean stunned;
	int last_action;

	public Opponent(){
		hp = 100;
		bullets = 6;
		is_alive = false;
		stunned = false;
		last_action = 0;
		x_place=100;
		y_place=100;
	}

	public void use_basic(){
		last_action=1;
	}

	public boolean use_special(){
		last_action = 2;
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
		last_action = 3;
		stunned=true;
		if((new Random().nextInt(100)+1) < 50){
			return false;
		} else {
		return true;
		}
	}

	public void use_heal(){
		last_action = 4;
		hp+=13;
		if(hp>100){
			hp=100;
		}
	}

	public void use_reload(){
		last_action = 5;
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

}