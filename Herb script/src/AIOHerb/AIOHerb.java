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
import AIOHerb.util.Const;
import AIOHerb.util.GUI;
import AIOHerb.util.Potion;
import AIOHerb.util.UnfPotion;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@Manifest(authors ={"Goldenglove605"}, name = "GoldenHerb2", description = "Makes Potions")

public class AIOHerb extends ActiveScript implements MessageListener, PaintListener {
	
	// private Tree jobs = null;
	
	 private Client client = Bot.client();
	    private final List<Node> jobsCollection = Collections.synchronizedList(new ArrayList<Node>());
	    
	    public synchronized final void provide(final Node... jobs) {
	        for (final Node job : jobs) {
	        	Const.status = "adding jobs";
	            if (!jobsCollection.contains(job)) {
	                jobsCollection.add(job);
	            }
	        }
	    }
	    
	    public void onStart() {
	    	
	    	Mouse.setSpeed(Speed.FAST);
	    	Const.startTime = System.currentTimeMillis();
	    	Const.startExp = Skills.getExperience(Skills.HERBLORE);
	    	
	    	
	        //Const.status = "Starting";
	        Camera.setPitch(true); 
	        GUI gui = new GUI();
	        gui.setVisible(true);
	        while(Const.guiWait){
	            Task.sleep(100);
	        }
	        System.out.println("Done Waiting......");
	        provide(new Banking(), new MakingPots(), new CleaningHerbs());
	    }
	    
	    public int loop() {

	   
	        try {
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
	                    	Const.status = "Executing";
	                        node.execute();
	                        return Random.nextInt(50, 100);
	                    }

	                }
	            }
	            return Random.nextInt(50, 100);


	        } catch (NullPointerException e) {
	            e.printStackTrace();
	        }
	        return Random.nextInt(50, 100);
	    }

		@Override
		public void onRepaint(Graphics g1) {
	        Graphics2D g = (Graphics2D)g1;
	        Const.expGained = Skills.getExperience(Skills.HERBLORE) - Const.startExp;
	        Const.currentLevel = Skills.getLevel(Skills.HERBLORE);
	        Const.experienceHour = (int) (Const.expGained * 3600000D / (System
	                        .currentTimeMillis() - Const.startTime));
	        Const.potionsHour = (int) (Const.potionsMade * 3600000D / (System
	                        .currentTimeMillis() - Const.startTime));
	       
	        g.setColor(Color.YELLOW);
	        g.drawLine(Mouse.getX() - 5, Mouse.getY() - 5, Mouse.getX() + 5, Mouse.getY() + 5);
	        g.drawLine(Mouse.getX() - 5, Mouse.getY() + 5, Mouse.getX() + 5, Mouse.getY() - 5);
	        g.setBackground(Color.GREEN);
	        g.setColor(new Color(0, 0, 0, 85));
            g.fillRoundRect(5, 20, 150, 144, 15, 25);
            g.setColor(Color.WHITE);
            g.drawString(Const.runTime.toElapsedString(), 15, 35);
            g.drawString("Exp Gained: " + Const.expGained, 15, 50);
    	    g.drawString("Current Level:" + Const.currentLevel, 15, 65);
    	    g.drawString("Exp per hour: " +  Const.experienceHour, 15, 80);
    	    g.drawString("TNL: " + Time.format(Const.sd.timeToLevel(Rate.HOUR, Skills.HERBLORE)), 15, 95);
    	    g.drawString("Status: " + Const.status, 15, 110);
    	    g.drawString("Version: " + Const.version, 15, 125);
    	    if(Const.whatToDo == 3) {
    	    	g.drawString("Cleaned: " + Const.potionsMade,15,140);
    	    	g.drawString("Clean per hour: " + Const.potionsHour,15,155);
    	    }
    	    else if(Const.whatToDo == 2 || Const.whatToDo == 1) {
    		    g.drawString("Potions made: "+ Const.potionsMade ,15, 140);
    		    g.drawString("Potions per hour: " + Const.potionsHour,15 , 155);
    	    }
			
		}

		@Override
		public void messageReceived(MessageEvent e) {
			if(Const.whatToDo == 2) {
				if(e.getMessage().contains("You mix")) {
					Const.potionsMade ++;
				}
			}
			else if(Const.whatToDo == 3){
				if(e.getMessage().contains("clean the dirt")){
					Const.potionsMade ++;
				}
			}
			else {
				if(e.getMessage().contains("(3)")) {
					Const.potionsMade++;
				}
			}
			
		}
}
