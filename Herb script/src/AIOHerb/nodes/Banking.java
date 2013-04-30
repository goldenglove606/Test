package AIOHerb.nodes;

import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;

import AIOHerb.util.Condition;
import AIOHerb.util.Methods;
import AIOHerb.util.Variables;

public class Banking extends Node {
	

	@Override
	public boolean activate() {
		return Variables.isBank || Bank.isOpen();
	}

	@Override
	public void execute() {
		Variables.status = "Banking";
		if(!Bank.isOpen() && Bank.getNearest() != null) {
			Bank.open();
			Methods.dynamicSleep(new Condition() {

				@Override
				public boolean validate() {
					return Bank.isOpen();
				}
				}, 2000);
		}
		/*
		 * Start Bank 1 method
		 * 
		 */
		
		else if(Variables.whatToDo == 1) {
			Bank.depositInventory();
			if(!Methods.dynamicSleep(new Condition() {
				@Override
				public boolean validate() {
					return !Inventory.isFull();
				}
			}, 2000)) {
				Bank.depositInventory();
			}
			
			Bank.withdraw(Variables.pot.getHerb(), 9);
			if(!Methods.dynamicSleep(new Condition() {
				@Override
				public boolean validate() {
					return Inventory.contains(Variables.pot.getHerb());
				}
			}, 2000) ) {
				Bank.withdraw(Variables.pot.getHerb(), 9);
			}
			
			Bank.withdraw(Variables.pot.getIngre(), 9);
			if(!Methods.dynamicSleep(new Condition() {
				@Override
				public boolean validate() {
					return Inventory.contains(Variables.pot.getIngre());
				}
			}, 2000)) {
				Bank.withdraw(Variables.pot.getIngre(), 9);
			}
			
			Bank.withdraw(Variables.VIAL_OF_WATER, 9);
			if(!Methods.dynamicSleep(new Condition() {
				@Override
				public boolean validate() {
					return Inventory.contains(Variables.VIAL_OF_WATER);
				}
			}, 2000)) {
				Bank.withdraw(Variables.VIAL_OF_WATER, 9);
			}
			Bank.close();
			if(!Methods.dynamicSleep(new Condition() {
				@Override
				public boolean validate() {
					return !Bank.isOpen();
				}
				}, 2000)) {
				Bank.close();
			}
					
			Variables.isBank = false;
		}
		
		/*
		 * Start bank 2 method
		 * 
		 */
		
		else if(Variables.whatToDo == 2) {
			Bank.depositInventory();
			if(!Methods.dynamicSleep(new Condition() {
				@Override
				public boolean validate() {
					return !Inventory.isFull();
				}
			}, 2000)) {
				Bank.depositInventory();
			}
			
			Bank.withdraw(Variables.unfPot.getHerb(), 14);			
			if(!Methods.dynamicSleep(new Condition() {
				@Override
				public boolean validate() {
					return Inventory.contains(Variables.unfPot.getHerb());
				}
			}, 2000)) {
				Bank.withdraw(Variables.unfPot.getHerb(), 14);
			}
					
			Bank.withdraw(Variables.VIAL_OF_WATER, 14);
			if(!Methods.dynamicSleep(new Condition() {
					@Override
					public boolean validate() {
						return Inventory.contains(Variables.VIAL_OF_WATER);
					}
				}, 2000)) {
				Bank.withdraw(Variables.VIAL_OF_WATER, 14);
			}
				
			Bank.close();
			if(!Methods.dynamicSleep(new Condition() {
			@Override
			public boolean validate() {
				return !Bank.isOpen();
			}
		}, 2000)) {
				Bank.close();
			}

			Variables.isBank = false;
		}
		
		/*
		 * Start bank 3 method
		 * 
		 */
		else if(Variables.whatToDo == 3) {
			Bank.depositInventory();
			if(!Methods.dynamicSleep(new Condition() {
				@Override
				public boolean validate() {
					return !Inventory.isFull();
				}
			}, 2000)) {
				Bank.depositInventory();
			}

			Bank.withdraw(Variables.grimy.getGrimyID(), 0);
			if(!Methods.dynamicSleep(new Condition() {
				@Override
				public boolean validate() {
					return Inventory.contains(Variables.grimy.getGrimyID());
				}
			}, 2000)) {
				Bank.withdraw(Variables.grimy.getGrimyID(), 0);
			}

			Bank.close();
			
			if(!Methods.dynamicSleep(new Condition() {
				@Override
				public boolean validate() {
					return !Bank.isOpen();
				}
				}, 2000)) {
					Bank.close();
			}

			Variables.isBank = false;
		}
	}
}
