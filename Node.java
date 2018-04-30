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
		if(ctr==0){
			g.setColor(new Color(255,0,0));
		} else{
			g.setColor(new Color(0,255,0));
		}
		g.drawImage(data.pic,data.x_place+(ctr*105),data.y_place,null);

		g.setColor(new Color(255,255,255));
		g.fillRoundRect(data.x_place+(ctr*105),100,90,90,15,15);
		g.setColor(new Color(0,0,0));
		g.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		g.drawString("HP: "+data.hp,data.x_place+10+(ctr*105),120);
		g.drawString("Charge: "+data.bullets,data.x_place+10+(ctr*105),140);
		g.drawString("Last Action:",data.x_place+10+(ctr*105),160);
		g.drawString(data.last_action,data.x_place+10+(ctr*105),180);

	}
	
}