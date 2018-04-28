import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class Node{
	Opponent data;
	Node next;
	public Node(Opponent pasok){
		data=pasok;
	}
	
	public void visualizeNode(Graphics2D g,int ctr){
		g.setColor(new Color(255,255,255));
		g.drawString("HP: "+data.hp,data.x_place+10+(ctr*70),data.y_place-20);
		if(ctr==0){
			g.setColor(new Color(0,0,0));
		} else{
			g.setColor(new Color(255,0,0));
		}
		g.fillRect(data.x_place+(ctr*70),data.y_place,50,50);
		//System.out.println("place: "+data.x_place+(ctr*50));
	}
	
}