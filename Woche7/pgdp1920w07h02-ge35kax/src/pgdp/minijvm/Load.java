package pgdp.minijvm;
public class Load extends Instruction{
	int i;
	public Load(int i) {
		if(i>=0) {
		this.i=i;}
	}
public void execute(Simulator simulator) {
	if(i>=0 && i<=simulator.getStack().getStackPointer()) {
		int wertL=simulator.getStack().getValueAtIndex(this.i);
		simulator.getStack().push(wertL);}
	System.out.println(simulator.getStack().getStackPointer());
	System.out.println(simulator.getStack().getValueAtIndex(simulator.getStack().getStackPointer()));
	}
}