package pgdp.minijvm;
public class Jump extends Instruction{
	int i;
	public Jump(int i) {
		
		if(i>0) {
		this.i=i;}
	}
	public void execute(Simulator simulator) {
		simulator.setProgramCounter(this.i);
	}
}