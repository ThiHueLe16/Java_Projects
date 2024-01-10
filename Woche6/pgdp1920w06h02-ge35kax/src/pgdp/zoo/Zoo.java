package pgdp.zoo;
class Zoo{
	private Vivarium[] vivaria;
	public Zoo(Vivarium[] vivaria){
		this.vivaria=vivaria;
	}
	public String toString(){
		String zoo="{"+this.vivaria[0].toString();
		for (int i=1; i<this.vivaria.length;i++) {
			zoo+=", "+this.vivaria[i].toString();
		}
		zoo+="}";
		return zoo;
	}
	
	public int getCosts() {
		int sumCost=0;
		for(int i=0; i<this.vivaria.length;i++) {
			sumCost+=this.vivaria[i].getCosts();
		}
		return sumCost;
	}
}
