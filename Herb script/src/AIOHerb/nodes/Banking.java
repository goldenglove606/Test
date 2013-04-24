package AIOHerb.nodes;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;

import AIOHerb.util.Condition;
import AIOHerb.util.Const;
import AIOHerb.util.Methods;

public class Banking extends Node {
	

	@Override
	public boolean activate() {
		return Const.isBank || Bank.isOpen();
	}

	@Override
	public void execute() {
		Const.status = "Banking";
		if(!Bank.isOpen() && Bank.getNearest() != null) {
			Bank.open();
			Methods.dynamicSleep(new Condition() {

				@Override
				public boolean validate() {
					return Bank.isOpen();
				}
				}, 9000);
		}
		else if(Const.whatToDo == 1) {
			Bank.withdraw(Const.pot.getHerb(), 9);
			
			Methods.dynamicSleep(new Condition() {
				@Override
				public boolean validate() {
					return Inventory.contains(Const.pot.getHerb());
				}
			}, 9000);
			
			Bank.withdraw(Const.pot.getIngre(), 9);
			
			Methods.dynamicSleep(new Condition() {
				@Override
				public boolean validate() {
					return Inventory.contains(Const.pot.getIngre());
				}
			}, 9000);
				
			Bank.close();
			
			Methods.dynamicSleep(new Condition() {
				@Override
				public boolean validate() {
					return !Bank.isOpen();
				}
			}, 9000);
			
			Const.isBank = false;
		}
		else if(Const.whatToDo == 2) {
			Bank.depositInventory();
			Methods.dynamicSleep(new Condition() {
				@Override
				public boolean validate() {
					return !Inventory.isFull();
				}
			}, 9000);

			Bank.withdraw(Const.unfPot.getHerb(), 14);
			
			Methods.dynamicSleep(new Condition() {
				@Override
				public boolean validate() {
					return Inventory.contains(Const.unfPot.getHerb());
				}
			}, 9000);
			
			if(Inventory.contains(Const.unfPot.getHerb())) {
				Bank.withdraw(Const.vialOfWaterID, 14);
				Methods.dynamicSleep(new Condition() {
					@Override
					public boolean validate() {
						return Inventory.contains(Const.vialOfWaterID);
					}
				}, 9000);
				
			}
			else {
				Bank.withdraw(Const.unfPot.getHerb(), 14);
				Methods.dynamicSleep(new Condition() {
					@Override
					public boolean validate() {
						return Inventory.contains(Const.unfPot.getHerb());
					}
				}, 9000);
			}
			
			if(!Inventory.contains(Const.vialOfWaterID)) {
				Bank.withdraw(Const.vialOfWaterID, 14);
				Methods.dynamicSleep(new Condition() {
				@Override
				public boolean validate() {
					return Inventory.contains(Const.vialOfWaterID);
				}
			}, 9000);

			}

			Bank.close();
			Methods.dynamicSleep(new Condition() {
			@Override
			public boolean validate() {
				return !Bank.isOpen();
			}
		}, 9000);
			
			if(Bank.isOpen()) {
				Bank.close();
				Methods.dynamicSleep(new Condition() {
					@Override
					public boolean validate() {
						return !Bank.isOpen();
					}
				}, 9000);

			}
			Const.isBank = false;
		}
	}
}
