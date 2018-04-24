public class Node {
	Opponent data;
	Node next;
	public Node(Opponent pasok){
		data=pasok;
	}
	
	public void visualizeNode(){
		System.out.println(data);
	}
	
}