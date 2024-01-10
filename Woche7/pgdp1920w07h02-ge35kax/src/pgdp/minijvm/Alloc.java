package pgdp.minijvm;
public class Alloc extends Instruction{
	int i;
	public Alloc(int i) {
		if(i>=0) {
		this.i=i;}
	}
	public void execute(Simulator simulator) {
		simulator.getStack().alloc(this.i);
	}
}