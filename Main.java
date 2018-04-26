public class Main{
	public static void main(String[] args){
		
		Opponents o = new Opponents();

		final MarioWindow mw = new MarioWindow();
		mw.add(o);


		(new Thread(){
			public void run(){
				mw.startGame();
			}
		}).start();
	}
}