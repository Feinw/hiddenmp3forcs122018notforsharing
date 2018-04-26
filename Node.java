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
		g.drawString("HP: "+data.hp,data.x_place+10+(ctr*20),data.y_place-20);
		g.fillRect(data.x_place,data.y_place,50,50);
	}
	
}