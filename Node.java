import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class Node extends GameObject{
	Opponent data;
	Node next;
	public Node(Opponent pasok){
		data=pasok;
	}
	
	public void visualizeNode(Graphics2D g){
		System.out.println(data);
		g.drawString(Integer.toString(data.hp),50,100);
	}
	
}