package AIOHerb.util;

public enum UnfPotion {
	
	RANARR(257,"Ranarr Unf"),
	TOADFLAX(2998,"Toadflax Unf"),
	SPIRITWEED(12172,"Spiritweed Unf"),
	CADANTINE(265,"Cadantine Unf");

	private int herb;
	private String name;
	
	
	
	UnfPotion(final int herb, final String name){
		this.herb = herb;
		this.name = name;	
	}
	
	public int getHerb() {
		return herb;
	}
	
	public String getName() {
		return name;
	}
	
}
