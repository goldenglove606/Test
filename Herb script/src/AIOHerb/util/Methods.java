package AIOHerb.util;



import org.powerbot.core.script.job.Task;
import org.powerbot.game.api.util.Timer;

public class Methods {
    
    public static boolean dynamicSleep (final Condition c, final long timeout) {
	    final Timer timer = new Timer(timeout);
	    while (timer.isRunning() && !evaluate(c)) {
		    Task.sleep(10);
	    }
	    return evaluate(c);
    }
    
    private static boolean evaluate (final Condition... c) {
	    for (final Condition condition : c) {
		    if (!condition.validate()) { return false; }
	    }
	    return true;
    }
    
}