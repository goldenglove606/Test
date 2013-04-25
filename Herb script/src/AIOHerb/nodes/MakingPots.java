package AIOHerb.nodes;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;
import org.powerbot.game.api.util.Timer;

import AIOHerb.util.Condition;
import AIOHerb.util.Const;
import AIOHerb.util.Methods;
import AIOHerb.util.Potion;
import AIOHerb.util.UnfPotion;


public class MakingPots extends Node {
	//public static Potion pot;
	//public static UnfPotion unfPot;

	@Override
	public boolean activate() {

		return !Const.isBank && !Bank.isOpen() && (Const.whatToDo == 2 || Const.whatToDo ==1);

	}

	@Override
	public void execute() {
		if(Const.whatToDo == 1) {
			Const.status = "Making pots";
			if(Inventory.contains(Const.pot.getHerb()) && Inventory.contains(Const.vialOfWaterID) &&
					Inventory.contains(Const.pot.getHerb())){

				Inventory.getItem(Const.pot.getHerb()).getWidgetChild().interact("Use");
				Inventory.getItem(Const.vialOfWaterID).getWidgetChild().interact("Use");

	            final Timer timer = new Timer(2500);
	            while (!Widgets.get(548,34).validate() && timer.isRunning()) {
	                Task.sleep(50);
	            }
	            
				Widgets.get(548, 34).interact("Make");
				
				Methods.dynamicSleep(new Condition() {
					@Override
					public boolean validate() {
						return Inventory.contains(Const.pot.getHerb());
					}
					}, 2000);

				
				 Inventory.getItem(Const.pot.getIngre()).getWidgetChild().interact("Use");
		         Inventory.getItem(Const.pot.getUnf()).getWidgetChild().interact("Use");
		         sleep(800,1000);
		         
		         final Timer timer2 = new Timer(2500);
		         while (!Widgets.get(548).validate() && timer2.isRunning()) {
		                Task.sleep(50);
		         }
		            
		         Widgets.get(548, 34).interact("Make");
					Methods.dynamicSleep(new Condition() {
						@Override
						public boolean validate() {
							return Inventory.contains(Const.pot.getIngre());
						}
						}, 2000);       
			}
			else if(!Inventory.contains(Const.pot.getHerb()) || !Inventory.contains(Const.vialOfWaterID)||
							!Inventory.contains(Const.pot.getIngre())) {
				Const.isBank = true;
			}
			else {
				//Shouldnt get this far but it might
				Task.sleep(200,300);
			}
		}
		else if(Const.whatToDo == 2) {
			Const.status = "Making unf";
			if(Inventory.getCount(Const.unfPot.getHerb()) == 14 && Inventory.getCount(Const.vialOfWaterID) == 14) {
				Inventory.getItem(Const.unfPot.getHerb()).getWidgetChild().interact("Use");
                Inventory.getItem(Const.vialOfWaterID).getWidgetChild().interact("Use");
                Task.sleep(300,600);
				
	            final Timer timer = new Timer(2500);
	            while (!Widgets.get(548,34).validate() && timer.isRunning()) {
	                Task.sleep(50);
	            }
	            
                Widgets.get(548, 34).interact("Make");
				Methods.dynamicSleep(new Condition() {
					@Override
					public boolean validate() {
						return !Inventory.contains(Const.vialOfWaterID);
					}
					}, 2000);  
			}
            else if(!Inventory.contains(Const.unfPot.getHerb()) || !Inventory.contains(Const.vialOfWaterID)) {
            	Const.isBank = true;
            }
            else {
                Task.sleep(100,200);
        }
		}
		
	}
	
}
