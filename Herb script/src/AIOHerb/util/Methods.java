package AIOHerb.util;



import org.powerbot.game.api.util.Timer;


public class Methods {

	public static boolean dynamicSleep(boolean cond, int wait) {
		Timer time = new Timer(wait);
		while(time.isRunning()) {
			if(cond){
				return true;
			}
		}
		return false;
	}
	
	
}