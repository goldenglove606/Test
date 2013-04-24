package AIOHerb.nodes;

import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.methods.widget.Bank;

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
			Methods.dynamicSleep(!Bank.isOpen(), 4000);
		}
		else if(Const.whatToDo == 1) {
			Bank.withdraw(Const.pot.getHerb(), 9);
			Methods.dynamicSleep(Inventory.contains(Const.pot.getHerb()),2000);
			Bank.withdraw(Const.pot.getIngre(), 9);
			Methods.dynamicSleep(Inventory.contains(Const.pot.getIngre()), 2000);
			Bank.close();
			Methods.dynamicSleep(Bank.isOpen(), 2000);	
			Const.isBank = false;
		}
		else if(Const.whatToDo == 2) {
			Bank.depositInventory();
			Methods.dynamicSleep(!Inventory.isFull(),2000);
			Bank.withdraw(Const.unfPot.getHerb(), 14);
			Methods.dynamicSleep(Inventory.contains(Const.unfPot.getHerb()),2000);
			Bank.withdraw(Const.vialOfWaterID, 14);
			Methods.dynamicSleep(Inventory.contains(Const.vialOfWaterID),200);
			Bank.close();
			Methods.dynamicSleep(Bank.isOpen(), 2000);
			Const.isBank = false;
		}
	}
}
