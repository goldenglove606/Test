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


public class MakingPots extends Node {
	//public static Potion pot;
	//public static UnfPotion unfPot;

	@Override
	public boolean activate() {

		return !Variables.isBank && !Bank.isOpen() && (Variables.whatToDo == 2 || Variables.whatToDo ==1);

	}

	@Override
	public void execute() {
		if(Variables.whatToDo == 1) {
			boolean isHerbInInv = Inventory.getCount(Variables.pot.getHerb()) == 9;
			boolean isVialInInv = Inventory.getCount(Variables.VIAL_OF_WATER) == 9;
			boolean isIngreInInv = Inventory.getCount(Variables.pot.getIngre()) == 9;
			boolean validated = false;
			
			
			Variables.status = "Making pots";
			if(isHerbInInv && isVialInInv && isIngreInInv) {
				
						Inventory.getItem(Variables.pot.getHerb()).getWidgetChild().interact("Use");
						Inventory.getItem(Variables.VIAL_OF_WATER).getWidgetChild().interact("Use");
						Task.sleep(500,800);
						
						validated = Methods.dynamicSleep(new Condition() {
							@Override
							public boolean validate() {
							
								return Widgets.get(548,34).validate();
							}
							}, 2000);
						
						if(!validated) {
			            	Inventory.getItem(Variables.pot.getHerb()).getWidgetChild().interact("Use");
			                Inventory.getItem(Variables.VIAL_OF_WATER).getWidgetChild().interact("Use");
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
								return Inventory.getCount(Variables.pot.getHerb()) == 0;
							}
						}, 10000);
						
						if(!validated) {
							Widgets.get(548, 34).interact("Make");
							Methods.dynamicSleep(new Condition() {
								@Override
								public boolean validate() {
									return !Inventory.contains(Variables.VIAL_OF_WATER);
								}
								}, 10000); 
						}
						
	
				 Inventory.getItem(Variables.pot.getIngre()).getWidgetChild().interact("Use");
		         Inventory.getItem(Variables.pot.getUnf()).getWidgetChild().interact("Use");
		         Task.sleep(800,1000);
		         
		         validated = Methods.dynamicSleep(new Condition() {
						@Override
						public boolean validate() {
						
							return Widgets.get(548,34).validate();
						}
						}, 2000);
		         
		         if(!validated) {
		            	Inventory.getItem(Variables.pot.getIngre()).getWidgetChild().interact("Use");
		                Inventory.getItem(Variables.pot.getUnf()).getWidgetChild().interact("Use");
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
							return Inventory.getCount(Variables.pot.getIngre()) == 0;
						}
						}, 10000);   
					if(!validated) {
						Widgets.get(548, 34).interact("Make");
						Methods.dynamicSleep(new Condition() {
							@Override
							public boolean validate() {
								return Inventory.getCount(Variables.pot.getIngre()) == 0;
							}
							}, 10000); 
					}
			}
			else if(!Inventory.contains(Variables.pot.getHerb()) || !Inventory.contains(Variables.VIAL_OF_WATER)||
							!Inventory.contains(Variables.pot.getIngre())) {
				Variables.isBank = true;
			}
			else {
				//Shouldnt get this far but it might
				Task.sleep(200,300);
			}
		}
		
		else if(Variables.whatToDo == 2) {
			Variables.status = "Making unf";
			boolean isHerbInInv = Inventory.getCount(Variables.unfPot.getHerb()) == 14;
			boolean isVialInInv = Inventory.getCount(Variables.VIAL_OF_WATER) == 14;
            boolean validated = false;
			
			if(isHerbInInv && isVialInInv) {
				Inventory.getItem(Variables.unfPot.getHerb()).getWidgetChild().interact("Use");
                Inventory.getItem(Variables.VIAL_OF_WATER).getWidgetChild().interact("Use");
                Task.sleep(300,600);
                
				validated = Methods.dynamicSleep(new Condition() {
					@Override
					public boolean validate() {
					
						return Widgets.get(548,34).validate();
					}
					}, 2000);
                
	            if(!validated) {
	            	Inventory.getItem(Variables.unfPot.getHerb()).getWidgetChild().interact("Use");
	                Inventory.getItem(Variables.VIAL_OF_WATER).getWidgetChild().interact("Use");
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
						return !Inventory.contains(Variables.VIAL_OF_WATER);
					}
					}, 2000); 
				if(!validated) {
					Widgets.get(548, 34).interact("Make");
					Methods.dynamicSleep(new Condition() {
						@Override
						public boolean validate() {
							return !Inventory.contains(Variables.VIAL_OF_WATER);
						}
						}, 2000); 
				}
			}
            else if(!Inventory.contains(Variables.unfPot.getHerb()) || !Inventory.contains(Variables.VIAL_OF_WATER)) {
            	Variables.isBank = true;
            }
            else {
                Task.sleep(100,200);
            }
		}
		
	}
	
}
