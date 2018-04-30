import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.*;

public class you extends GameObject{
	int hp;
	int max_hp;
	int bullets;
	String last_action;
	boolean is_alive;
	boolean stunned;

	BufferedImage pic;

	public you(){
		hp = 500;
		max_hp = 500;
		bullets = 6;
		is_alive = true;
		stunned = false;
		last_action = "";

		pic = MarioWindow.getImage("pikachu.png");
	}

	public void paint(Graphics2D g){
		g.setColor(new Color(255,255,255));
		g.fillRoundRect(250,330,530,100,15,15);
		g.setColor(new Color(0,0,0));
		g.setFont(new Font("Times New Roman", Font.BOLD, 20));
		g.drawString("HP: "+Integer.toString(hp)+"/500",270,375);
		g.drawString("Special Attack Charge: "+Integer.toString(bullets),270,405);
		g.drawString("Stunned: "+Boolean.toString(stunned).toUpperCase(),530,375);
		g.drawString("Last Action: "+last_action,530,405);
		g.setColor(new Color(0,0,0));
		g.fillRect(380,360,130,20);
		if(hp>500*0.5){g.setColor(new Color(0,255,0));}else if(hp>500*0.3){g.setColor(new Color(255,255,0));}else{g.setColor(new Color(255,0,0));}
		g.fillRect(380,360,hp*130/500,20);
		g.drawImage(pic,50,300,null);
	}

	public void use_basic(){
		last_action="Basic Attack";
	}

	public boolean use_special(){
		last_action="Special Attack";
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
		last_action="Reckless Attack";
		stunned=true;
		if((new Random().nextInt(100)+1) < 50){
			return false;
		} else {
		return true;
		}
	}

	public void use_heal(){
		last_action="Heal";
		hp+=30;
		if(hp>max_hp){
			hp=max_hp;
		}
	}

	public void use_reload(){
		last_action="Reload";
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