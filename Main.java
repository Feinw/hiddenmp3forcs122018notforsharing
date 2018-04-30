import java.util.*;

public class Main{
	public static void main(String[] args){
		
		Scanner scan = new Scanner(System.in);
		boolean your_turn = true;

		Opponents o = new Opponents();
		you character = new you();
		background bg = new background();

		final MarioWindow mw = new MarioWindow();
		mw.add(bg);
		mw.add(o);
		mw.add(character);


		(new Thread(){
			public void run(){
				mw.startGame();
			}
		}).start();

		while(!o.q.isEmpty()&&character.hp>=0){
			if(your_turn){
				if(!character.stunned){
					char ans = scan.nextLine().charAt(0);

					if(ans=='a'){
						character.use_basic();
						o.user_action=1;
						o.attackFront();
						o.user_action=0;
					}else if(ans=='b'){
						if(character.use_special()){
							o.user_action=2;
							o.attackFront();
							o.user_action=0;
						}
					}else if(ans=='c'){
						if(character.use_reckless()){
							o.user_action=3;
							o.attackFront();
							o.user_action=0;
							character.stunned=true;
						}
					}else if(ans=='d'){
						character.use_heal();
					}else if(ans=='e'){
						character.use_reload();
					}

					ans=' ';
					your_turn = false;
				} else{
					character.stunned=false;
					your_turn = false;
				}
			} else{
				int damage = o.q.all_out();
				character.got_damaged(damage);
				your_turn = true;
			}
		}
		System.exit(0);
	}
}