package pgdp.minijvm;
public class Store extends Instruction{
	int i;
	public Store(int i) {
		if(i>0) {
		this.i=i;}
	}
	public void execute(Simulator simulator) {
		
		int SPl=simulator.getStack().getStackPointer();
		if(SPl>=0) {
		int wertS=simulator.getStack().getValueAtIndex(SPl);
		simulator.getStack().pop();
		simulator.getStack().setValueAtIndex(this.i,wertS);}
		//System.out.println(simulator.getStack().getStackPointer());
		//System.out.println(simulator.getStack().getValueAtIndex(simulator.getStack().getStackPointer()));
	}
}