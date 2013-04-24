package AIOHerb.util;

public enum Potion {

	ATTACKPOTION(249,221,91, "Attack Potion"),
	RANGINGPOTION(249, 1951,91, "Ranging Potion"),
	MAGICPOTION(253,1474,95,"Magic Potion"),
	STREGNTHPOTION(253,225,95,"Strength Potion"),
	DEFENCEPOTION(251,948,93,"Defence Potion"),
	ANTIPOISONPOTION(251,935,93,"Anti-poison Potion"),
	PRAYERPOTION(257,231,99,"Prayer Potion"),
	SUPERATTACKPOTION(259,221,101,"Super Attack Potion"),
	SUPERSTRENGTHPOTION(263,225,105,"Super Strength Potion"),
	SUPERRESTOREPOTION(3000,223,3004,"Super Restore Potion"),
	SUPERDEFENCEPOTION(265,239,107,"Super Defence Potion"),
	SUPERRANGINGPOTION(267,245,109,"Super Ranging Potion"),
	SUPERMAGICPOTION(2481,3138,2483,"Super Magic Potion"),
	ZAMORAKBREWPOTION(269,247,111,"Zamorak Brew Potion"),
	SARADOMINBREWPOTION(2998,6693,3002,"Saradomin Brew Potion");
	
	private int herb; //herb id
	private int ingre; //ingredient to use
	private int unf; //unf to use
	private String name; //potion name
	
	 Potion(final int herb, final int ingre, final int unf, final String name) {
		this.herb = herb;
		this.ingre = ingre;
		this.unf = unf;
		this.name = name;
	}
	 
	 public int getHerb() {
		 return herb;
	 }
	 
	 public int getIngre() {
		 return ingre;
	 }
	 
	 public int getUnf() {
		 return unf;
	 }
	 
	 public String getName() {
		 return name;
	 }
}
