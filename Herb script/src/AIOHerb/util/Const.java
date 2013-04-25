package AIOHerb.util;

import java.awt.Font;
import java.util.ArrayList;

import org.powerbot.game.api.util.SkillData;
import org.powerbot.game.api.util.Timer;

public class Const  {

	public static Potion pot;
	public static UnfPotion unfPot;
	
	public static final int vialOfWaterID = 227; 

	public static boolean isBank = false;
	
	public static final Font font1 = new Font("Verdana", 0, 20);
	public static final String version = "1.5";
	public static String status;
	public static boolean guiWait = true;
	public static boolean quit = false;
	public static String chosen;

	
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
