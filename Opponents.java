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
		g.setColor(new Color(50,50,50));
		g.setFont(new Font("Comic Sans MS",Font.BOLD,20));
		g.drawString("Number of Spearow in",100,150);
		g.drawString("Spearow hoard: "+ctr,100,180);
	}

	public void run(){
		while(!q.isEmpty()){
			MarioWindow.delay(60000);
			int random = r.nextInt(100)+1;
			// System.out.println(random);
			if(random <= 5){
				Opponent arriving = new Opponent();
				q.enqueue(arriving);
				System.out.println("The Spearow hoard called for backup!");
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
			System.out.println("A wild Spearow fainted!");
			q.dequeue();
		}
	}
}