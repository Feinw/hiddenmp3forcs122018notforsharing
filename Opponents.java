import java.util.Random;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class Opponents extends GameObject{
	LinkedQueue q = new LinkedQueue();
	Random r = new Random();

	int user_action=0;

	public Opponents(){
		Opponent new1 = new Opponent();
		Opponent new2 = new Opponent();
		Opponent new3 = new Opponent();
		q.enqueue(new1);
		q.enqueue(new2);
		q.enqueue(new3);
	}

	public void paint(Graphics2D g){
		int ctr = q.visualizeQueue(g);
		g.drawString(Integer.toString(ctr),300,300);
	}

	public void run(){
		while(!q.isEmpty()){
			MarioWindow.delay(60000);
			int random = r.nextInt(100)+1;
			if(random <= 5){
				Opponent arriving = new Opponent();
				q.enqueue(arriving);
				System.out.println("new Opponent");
			}
		}
	}

	public void attackFront(){
		Opponent front = q.peek();
		if(user_action == 1){
			front.got_basic();
		}else if(user_action == 2){
			front.got_special();
		}else if(user_action == 3){
			front.got_reckless();
		}
		if(front.hp <= 0){
			System.out.println("Dead 1");
			q.dequeue();
			if(q.isEmpty()){
				System.out.println("Done");
				System.exit(0);
			} 
		}
	}
}