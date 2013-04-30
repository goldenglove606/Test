package AIOHerb.nodes;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;
import org.powerbot.game.api.util.Timer;

import AIOHerb.util.Condition;
import AIOHerb.util.Variables;
import AIOHerb.util.Methods;

public class CleaningHerbs extends Node {

	@Override
	public boolean activate() {
		
		return Variables.whatToDo == 3 && !Variables.isBank && !Bank.isOpen();
	}

	@Override
	public void execute() {
		Variables.status = "Cleaning Herbs";
		if(Variables.whatToDo == 3) {
			boolean isGrimyInInv = Inventory.getCount(Variables.grimy.getGrimyID()) == 28;
			boolean validated = false;
			
			if(isGrimyInInv) {
				Inventory.getItem(Variables.grimy.getGrimyID()).getWidgetChild().interact("Clean");
				Task.sleep(300,600);
				
				validated = Methods.dynamicSleep(new Condition() {
					@Override
					public boolean validate() {
					
						return Widgets.get(548,34).validate();
					}
					}, 2000);
				
				 if(!validated) {
					 Inventory.getItem(Variables.grimy.getGrimyID()).getWidgetChild().interact("Clean");
		             Task.sleep(300,600);
		                
			            final Timer timer = new Timer(2500);
			            while (!Widgets.get(548,34).validate() && timer.isRunning()) {
			                Task.sleep(25);
			            }
		            }
				 
	               validated = Widgets.get(548, 34).interact("Make");
					Methods.dynamicSleep(new Condition() {
						@Override
						public boolean validate() {
							return !Inventory.contains(Variables.grimy.getGrimyID());
						}
						}, 2000);
					
					if(!validated) {
						Widgets.get(548, 34).interact("Make");
						Methods.dynamicSleep(new Condition() {
							@Override
							public boolean validate() {
								return !Inventory.contains(Variables.grimy.getGrimyID());
							}
							}, 2000); 
					}
				
				
			}
			else if(!Inventory.contains(Variables.grimy.getGrimyID())) {
	            	Variables.isBank = true;
	        }
	        else {
	                Task.sleep(100,200);
	        }
		}
		
	}
	
}
