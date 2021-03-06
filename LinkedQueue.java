import java.awt.*;
import java.awt.image.*;
import javax.swing.*;
import java.util.Random;

public class LinkedQueue extends GameObject{
	Node head;
	Node tail;
	int ctr=0;
	
	Random r = new Random();

	public void enqueue(Opponent i){
		Node bago= new Node(i);
		if(head==null){
			head=bago;
			tail=bago;
		} else{
			tail.next=bago;
			tail=bago;
		}
	}
	public Opponent dequeue(){
		if (head!=null){
			Opponent result=head.data;
			head=head.next;
			if(head==null){
				tail=null;
			}
			return result;
		} else{
			return null;
		}
	}

	public Opponent peek(){
		if(head!=null){
			Opponent result = head.data;
			return result;
		} else{
			return null;
		}
	}

	public int visualizeQueue(Graphics2D g){
		Node rover=head;
		ctr=-1;
		while(rover!=null){
			ctr+=1;
			rover.visualizeNode(g,ctr);
			rover=rover.next;
		}
		return ctr+1;
		
	}
	
	public boolean isEmpty(){
		return head==null;
	}

	public int all_out(){
		int damage = 0;

		Node rover=head;
		while(rover!=null){
			Opponent current_opponent = rover.data;
			int move = r.nextInt(5);
			// System.out.println(move);
			if(!current_opponent.stunned){
				if(move==0){
					current_opponent.use_basic();
					damage+=10;
				}else if(move==1){
					if(current_opponent.use_special()){
						damage+=13;
					}
				}else if(move==2){
					if(current_opponent.use_reckless()){
						damage+=30;
						current_opponent.stunned=true;
					}
				}else if(move==3){
					current_opponent.use_heal();
				}else if(move==4){
					current_opponent.use_reload();
				}
			} else{
				current_opponent.stunned=false;
			}
			rover=rover.next;
		}
		return damage;
	}
}