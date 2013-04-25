package AIOHerb.util;

import java.awt.Font;
import java.util.ArrayList;

import org.powerbot.game.api.util.SkillData;
import org.powerbot.game.api.util.Timer;

public class Const  {

	public static Potion pot;
	public static UnfPotion unfPot;
	
	public static int vialOfWaterID = 227; 
	
	public static int guamPotionID = 91;
//	public static int attackPotionID = 121;
//	public static int rangingPotionID = 27506;
	public static int guamID = 249;
	public static int eyeOfNewtID = 221;
	public static int redberriesID = 1951;
		
	public static int tarrominPotionID = 95;
//	public static int magicPotionID = 27514;
//	public static int strengthPotionID = 115;
	public static int tarrominID = 253;
	public static int beadID = 1474;
	public static int limpID = 225;
		
	public static int marrentillPotionID = 93;	
//	public static int defencePotionID = 133;
//	public static int antipoisonID = 175;
	public static int marrentillID = 251;
	public static int bearfurID = 948;
	public static int groundunicornID = 935;
		
//	public static int harralanderID = 255;
	
	public static int ranarrPotionID = 99;
//	public static int prayPotionID = 139;
	public static int ranarrID = 257;
	public static int snapeGrassID = 231;
		
	public static int iritPotionID = 101;	
//	public static int superAttackPotionID = 145;	
//	public static int toadflaxID = 2998;
	public static int iritID = 259;
	
	public static int kwuarmPotionID = 105;
	public static int kwuarmID = 263;
	
	public static int snapdragonPotionID = 3004;
	public static int snapdragonID = 3000;
	public static int redspidereggsID = 223;
	
	public static int toadflaxPotionID = 3002;
	public static int toadflaxID = 2998;
	
	public static int spiritweedID = 12172;
	
	public static int cadantinePotionID = 107;
	public static int cadantineID = 265;
	public static int whiteberriesID = 239; 

	public static int dwarfweedPotionID = 109;
	public static int dwarfweedID = 267;
	public static int wineOfZamorakID = 245; 

	public static int lantadymePotionID = 2483;
	public static int lantadymeID = 2481;
	public static int potatocactusID = 3138; 
	
	public static int torstolPotionID = 111;
	public static int torstolID = 269;
	public static int jangerberriesID = 247;
	
	public static int crushednestID = 6693;
	
	public static int unfToMake;
//	public static int potionToMAke;
	public static int herbToUse;
	public static int grimyHerbToUse;
	public static int ingreToUse;
	public static boolean isBank = false;
	
	public static Font font1 = new Font("Verdana", 0, 20);
	public static String version = "1.5";
	public static String status;
	public static boolean guiWait = true;
	public static boolean quit = false;
	public static int count = 0;
	
	public static Timer runTime = new Timer(0);
	public static long startTime;
	public static int startExp;
	public static int expGained;
	public static int currentLevel;
	public static int experienceHour;
	public static SkillData sd = new SkillData();
	public static int whatToDo = 0;
	public static boolean cleanHerbs = false;
	public static int potionsMade;
	public static int potionsHour;
	
	//grimy ids
	public static int grimyGuam = 199;
	public static int grimyMarrentill = 201;
	public static int grimyTarromin = 203;
	public static int grimyHarralander = 205;
	public static int grimyRanarr = 207;
	public static int grimyToadflax = 3049;
	public static int grimySpiritweed = 12174;
	public static int grimyIrit = 209;
	public static int grimyAvantoe = 211;
	public static int grimyKwuarm = 213;
	public static int grimySnapdragon = 3051;
	public static int grimyCadantine = 215;
	public static int grimyLantadyme = 2485;
	public static int grimyDwarfweed = 217;
	public static int grimyTorstol = 219;
	public static int grimyFellstalk = 21626;
}
