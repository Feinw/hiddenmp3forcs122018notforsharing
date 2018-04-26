import java.util.Random;
import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class Opponents extends GameObject{
	LinkedQueue q = new LinkedQueue();
	Random r;

	public Opponents(){
		Opponent new1 = new Opponent();
		q.enqueue(new1);
	}

	public void paint(Graphics2D g){
		q.visualizeQueue(g);
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
		System.out.println("1");
	}

	public void attackFront(int num){
		Opponent front = q.peek();
		// if(num == 1){
		// 	front.hp -= 10;
		// } else if(num == 2){
		// 	front
		// }
		if(front.hp == 0){
			System.out.println("Dead 1");
			q.dequeue();
			if(q.isEmpty()){
				System.out.println("Done");
				System.exit(0);
			} 
		}
	}
}