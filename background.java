import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.io.*;
import java.net.URL;
import javax.sound.sampled.*;

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

	public void music() {
		try {
        	URL url = this.getClass().getClassLoader().getResource("bg.wav");
        	AudioInputStream audioIn = AudioSystem.getAudioInputStream(url);
        	Clip clip = AudioSystem.getClip();
        	clip.open(audioIn);
        	clip.loop(Clip.LOOP_CONTINUOUSLY);
    	} catch (UnsupportedAudioFileException e) {
        	e.printStackTrace();
        } catch (IOException e) {
        	e.printStackTrace();
        } catch (LineUnavailableException e) {
        	e.printStackTrace();
        }
    }
}