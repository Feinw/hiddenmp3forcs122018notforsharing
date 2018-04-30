import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.*;

public class Opponent extends GameObject{
	int hp;
	int max_hp;
	int x_place;
	int y_place;
	int bullets;
	boolean is_alive;
	boolean stunned;
	String last_action;

	BufferedImage pic;

	public Opponent(){
		hp = 100;
		max_hp = 100;
		bullets = 6;
		is_alive = false;
		stunned = false;
		last_action = "";
		x_place=400;
		y_place=200;

		pic = MarioWindow.getImage("spearow.png");
	}

	public void use_basic(){
		last_action="Basic Attack";
	}

	public boolean use_special(){
		last_action = "Special Attack";
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
		last_action = "Reckless Attack";
		stunned=true;
		if((new Random().nextInt(100)+1) < 50){
			return false;
		} else {
		return true;
		}
	}

	public void use_heal(){
		last_action = "Heal";
		hp+=13;
		if(hp>max_hp){
			hp=max_hp;
		}
	}

	public void use_reload(){
		last_action = "Recharge";
		bullets=6;
	}

	public void got_basic(){
		hp-=15;
	}

	public void got_special(){
		hp-=20;
	}

	public void got_reckless(){
		hp-=50;
	}

}