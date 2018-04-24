public class LinkedQueue{
	Node head;
	Node tail;
	int ctr=0;
	
	public void enqueue(Opponent i){
		Node bago= new Node(i);
		if(head==null){
			head= bago;
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
			return "none";
		}
	}



	public Opponent peek(){
		if(head!=null){
			Opponent result = head.data;
			return result;
		} else{
			return "none";
		}
	}

	public void visualizeQueue(){
		Node rover=head;
		ctr=0;
		while(rover!=null){
			rover.visualizeNode();
			rover=rover.next;
			ctr=ctr+=1;
		}
		
	}
	
	public boolean isEmpty(){
		return head==null;
	}
}