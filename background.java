import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class background extends GameObject{
	
	BufferedImage box;
	BufferedImage bg;

	public background(){
		box = MarioWindow.getImage("check.png");
		bg = MarioWindow.getImage("wallpaper.png");
	}

	public void paint(Graphics2D g){
		g.drawImage(bg,0,0,null);
		g.drawImage(box,0,450,null);
	}
}