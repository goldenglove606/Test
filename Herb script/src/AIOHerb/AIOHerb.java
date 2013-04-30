package AIOHerb;

//n
import org.powerbot.core.Bot;
import org.powerbot.core.event.events.MessageEvent;
import org.powerbot.core.event.listeners.MessageListener;
import org.powerbot.core.event.listeners.PaintListener;
import org.powerbot.core.script.ActiveScript;
import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.input.Mouse.Speed;
import org.powerbot.game.api.methods.tab.Skills;
import org.powerbot.game.api.methods.widget.Camera;
import org.powerbot.game.api.methods.widget.WidgetCache;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.util.SkillData.Rate;
import org.powerbot.game.api.util.Time;
import org.powerbot.game.client.Client;

import AIOHerb.nodes.Banking;
import AIOHerb.nodes.CleaningHerbs;
import AIOHerb.nodes.MakingPots;
import AIOHerb.util.GUI;
import AIOHerb.util.Variables;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;


@Manifest(authors ={"Goldenglove605"}, name = "AIO Herb", description = "Makes Potions")

public class AIOHerb extends ActiveScript implements MessageListener, PaintListener {
	
	
	 private Client client = Bot.client();
	    private final List<Node> jobsCollection = Collections.synchronizedList(new ArrayList<Node>());
	    
	   /* public synchronized final void provide(final Node... jobs) {
	        for (final Node job : jobs) {
	            if (!jobsCollection.contains(job)) {
	                jobsCollection.add(job);
	            }
	        }
	    }*/
	    
	    public void onStart() {
	    	
	    	Mouse.setSpeed(Speed.FAST);
	    	if(Game.isLoggedIn()) {
	    	Variables.startTime = System.currentTimeMillis();
	    	Variables.startExp = Skills.getExperience(Skills.HERBLORE);
	    	Variables.gotExp = true;
	    	}
	    	
	    	SwingUtilities.invokeLater(new Runnable() {
	    		public void run() {
	    		GUI gui = new GUI();
	    		gui.setVisible(true);
	    		}
	    		});
					
				

	    	 
	        /*GUI gui = new GUI();
	        gui.setVisible(true);*/
	        while(Variables.guiWait){
	            Task.sleep(100);
	        }
	        
	        jobsCollection.add(new Banking());
	        jobsCollection.add(new MakingPots());
	        jobsCollection.add(new CleaningHerbs());
	        //provide(new Banking(), new MakingPots(), new CleaningHerbs());
	    }
	    
	    public int loop() {

	   
	            if (Game.getClientState() != Game.INDEX_MAP_LOADED) {
	                return 1000;
	            }

	            if (client != Bot.client()) {
	                WidgetCache.purge();
	                Bot.context().getEventManager().addListener(this);
	                client = Bot.client();
	            } 

	            if (Game.isLoggedIn()) {
	                for (Node node : jobsCollection) {
	                    if (node!= null && node.activate()) {
	                    	Variables.status = "Executing";
	                        node.execute();
	                        return Random.nextInt(50, 100);
	                    }

	                }
	            }
	            return Random.nextInt(50, 100);

	    }

		@Override
		public void onRepaint(Graphics g1) {
	        Graphics2D g = (Graphics2D)g1;
	        Variables.expGained = Skills.getExperience(Skills.HERBLORE) - Variables.startExp;
	        Variables.currentLevel = Skills.getLevel(Skills.HERBLORE);
	        Variables.experienceHour = (int) (Variables.expGained * 3600000D / (System
	                        .currentTimeMillis() - Variables.startTime));
	        Variables.potionsHour = (int) (Variables.potionsMade * 3600000D / (System
	                        .currentTimeMillis() - Variables.startTime));
	       
	        g.setColor(Color.YELLOW);
	        g.drawLine(Mouse.getX() - 10, Mouse.getY(), Mouse.getX() + 10, Mouse.getY());
	        g.drawLine(Mouse.getX(), Mouse.getY() - 10, Mouse.getX(), Mouse.getY() + 10);
	        g.setBackground(Color.GREEN);
	        g.setColor(new Color(0, 0, 0, 85));
            g.fillRoundRect(5, 20, 150, 144, 15, 25);
            g.setColor(Color.WHITE);
            g.drawString(Variables.runTime.toElapsedString(), 15, 35);
            g.drawString("Exp Gained: " + Variables.expGained, 15, 50);
    	    g.drawString("Current Level:" + Variables.currentLevel, 15, 65);
    	    g.drawString("Exp per hour: " +  Variables.experienceHour, 15, 80);
    	    g.drawString("TNL: " + Time.format(Variables.sd.timeToLevel(Rate.HOUR, Skills.HERBLORE)), 15, 95);
    	    g.drawString("Status: " + Variables.status, 15, 110);
    	    g.drawString("Version: " + Variables.VERSION, 15, 125);
    	    if(Variables.whatToDo == 3) {
    	    	g.drawString("Cleaned: " + Variables.potionsMade,15,140);
    	    	g.drawString("Clean per hour: " + Variables.potionsHour,15,155);
    	    }
    	    else if(Variables.whatToDo == 2 || Variables.whatToDo == 1) {
    		    g.drawString("Potions made: "+ Variables.potionsMade ,15, 140);
    		    g.drawString("Potions per hour: " + Variables.potionsHour,15 , 155);
    	    }
			
		}

		@Override
		public void messageReceived(MessageEvent e) {
			if(Variables.whatToDo == 2) {
				if(e.getMessage().contains("You mix")) {
					Variables.potionsMade ++;
				}
			}
			else{
				if(e.getMessage().contains("clean the dirt") || e.getMessage().contains("(3)")){
					Variables.potionsMade ++;
				}
			}
			
		}
}
