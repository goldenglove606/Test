package AIOHerb.util;

import org.powerbot.game.api.util.SkillData;
import org.powerbot.game.api.util.Timer;

public class Variables {
	public static Potion pot;
	public static UnfPotion unfPot;
	public static Grimy grimy;
	
	public static final int VIAL_OF_WATER = 227; 

	public static boolean isBank = false;
	
	public static final String VERSION = "1.6";
	public static String status;
	public static boolean guiWait = true;
	public static boolean quit = false;
	public static String chosen;
	public static boolean gotExp = false;

	
	public static final Timer runTime = new Timer(0);
	public static long startTime;
	public static int startExp;
	public static int expGained;
	public static int currentLevel;
	public static int experienceHour;
	public static SkillData sd = new SkillData();
	public static int whatToDo = 0;
	public static int potionsMade;
	public static int potionsHour;
}
