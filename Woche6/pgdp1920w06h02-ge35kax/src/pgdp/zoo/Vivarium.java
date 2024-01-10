package pgdp.zoo;
public class Vivarium{
	private int area;
	private int constructionYear;
	private Animal[] inhabitants;
	public Vivarium(Animal[] inhabitants, int area, int constructionYear){
		this.inhabitants=inhabitants;
		this.area=area;
		this.constructionYear=constructionYear;
	}
	public String toString() {
		String vivarium="[area: "+this.area+", constructionYear: "+this.constructionYear+", animals: "+this.inhabitants[0].toString();
		for(int i=1;i<this.inhabitants.length;i++){
			vivarium+=", "+this.inhabitants[i].toString();
		}
		vivarium+="]";
		return vivarium;
	}
	public int getCosts() {
		int kosten=0;
		for(int i=0;i<this.inhabitants.length;i++) {
			kosten+=this.inhabitants[i].getFoodCosts();
		}
		kosten+=900+this.area*100+this.area*5*(2019-this.constructionYear);
		return kosten;
	}
}