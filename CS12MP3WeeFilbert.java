public class CS12MP3WeeFilbert{

	public static void main(String[] args){
		
		boolean your_turn = true;
		String ans=" ";

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

		bg.music();

		while(!o.q.isEmpty()&&character.hp>0){
			if(your_turn){
				mw.delay(20);
				if(!character.stunned){
					ans = character.choice;

					if(ans.equals("A")){
						character.use_basic();
						o.user_action=1;
						o.attackFront();
						o.user_action=0;
						character.choice=" ";
						your_turn = false;
					}else if(ans.equals("B")){
						if(character.use_special()){
							o.user_action=2;
							o.attackFront();
							o.user_action=0;
						}
						character.choice=" ";
						your_turn = false;
					}else if(ans.equals("C")){
						if(character.use_reckless()){
							o.user_action=3;
							o.attackFront();
							o.user_action=0;
							character.stunned=true;
						}
						character.choice=" ";
						your_turn = false;
					}else if(ans.equals("D")){
						character.use_heal();
						character.choice=" ";
						your_turn = false;
					}else if(ans.equals("E")){
						character.use_reload();
						character.choice=" ";
						your_turn = false;
					}
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
		if(character.hp<=0){
			System.out.println("YOU LOSE!");
		} else{
			System.out.println("YOU WIN!");
		}
		System.exit(0);
	}
}