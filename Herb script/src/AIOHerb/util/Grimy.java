package AIOHerb.util;

public enum Grimy {
	
	GUAM(199,"Guam"),
	MARRENTILL(201,"Marrentill"),
	TARROMIN(203,"Tarromin"),
	HARRALANDER(205,"Harralander"),
	RANARR(207,"Ranarr"),
	TOADFLAX(3049,"Toadflax"),
	SPIRITWEED(12174,"Spiritweed"),
	IRIT(209,"Irit"),
	AVANTOE(211,"Avantoe"),
	KWUARM(213,"Kwuarm"),
	SNAPDRAGON(3051,"Snapdragon"),
	CADANTINE(215,"Cadantine"),
	LANTADYME(2485,"Lantadyme"),
	DWARFWEED(217,"Dwarfweed"),
	TORSTOL(219,"Torstol"),
	FELLSTALK(21626,"Fellstalk");
	
	private int grimyID; //grimy herb id
	private String name;
	
	Grimy(final int grimyID, final String name) {
		this.grimyID = grimyID;
		this.name = name;
	}
	
	public int getGrimyID() {
		return grimyID;
	}
	
	public String getName() {
		return name;
	}
}
