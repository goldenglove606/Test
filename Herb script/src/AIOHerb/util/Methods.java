package AIOHerb.util;



import org.powerbot.core.script.job.Task;
import org.powerbot.game.api.util.Timer;

public class Methods {
    
    public static boolean dynamicSleep (final Condition c, final long timeout) {
	    final Timer timer = new Timer(timeout);
	    while (timer.isRunning() && !c.validate()) {
		    Task.sleep(10);
	    }
	    return c.validate();
    }
    
}


