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

public class CleaningHerbs extends Node {

	@Override
	public boolean activate() {
		
		return Const.whatToDo == 3 && !Const.isBank && !Bank.isOpen();
	}

	@Override
	public void execute() {
		Const.status = "Cleaning Herbs";
		if(Const.whatToDo == 3) {
			if(Inventory.getCount(Const.grimy.getGrimyID()) == 28) {
				Inventory.getItem(Const.grimy.getGrimyID()).getWidgetChild().interact("Clean");
				Task.sleep(300,600);
				
				 final Timer timer = new Timer(2500);
		            while (!Widgets.get(548,34).validate() && timer.isRunning()) {
		                Task.sleep(50);
		            }
		            Widgets.get(548, 34).interact("Make");
					
					Methods.dynamicSleep(new Condition() {
						@Override
						public boolean validate() {
							return Inventory.getCount(Const.grimy.getGrimyID()) != 28;
						}
						}, 2000);
			}
			else if(!Inventory.contains(Const.grimy.getGrimyID())) {
	            	Const.isBank = true;
	        }
	        else {
	                Task.sleep(100,200);
	        }
		}
		
	}
	
}
