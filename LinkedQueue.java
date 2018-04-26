import java.awt.*;
import java.awt.image.*;
import javax.swing.*;

public class LinkedQueue extends GameObject{
	Node head;
	Node tail;
	int ctr=0;
	
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

	public void visualizeQueue(Graphics2D g){
		Node rover=head;
		ctr=-1;
		while(rover!=null){
			ctr+=1;
			rover.visualizeNode(g,ctr);
			rover=rover.next;
		}
		
	}
	
	public boolean isEmpty(){
		return head==null;
	}
}