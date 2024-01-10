package pgdp.adventuin;

import pgdp.color.RgbColor;

public final class Adventuin {
	private final String name;
	private final int height;
	private final HatType hatType;
	private final RgbColor color;
	private final Language language;
	
	public Adventuin(String name,int height,  RgbColor color,HatType hatType,Language language) {
		this.name=name;
		this.height=height;
		this.hatType=hatType;
		this.color=color;
		this.language=language;
	}
	
	
	public String getName() {
		return this.name;
	}
	
	public int getHeight() {
		return this.height;
	}
	
	public HatType getHatType() {
		return this.hatType;
	}
	
	public RgbColor getColor() {
		return this.color;
	}
	public Language getLanguage() {
		return this.language;
	}
	
}
