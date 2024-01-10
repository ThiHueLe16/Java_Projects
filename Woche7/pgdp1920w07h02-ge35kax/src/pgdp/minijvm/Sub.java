package pgdp.minijvm;
public class Sub extends Instruction{
public void execute(Simulator simulator) {
	int SPs=simulator.getStack().getStackPointer();
	if(SPs>0) {
		int a1=simulator.getStack().getValueAtIndex(SPs);
		int b1=simulator.getStack().getValueAtIndex(SPs-1);
		simulator.getStack().pop();
		simulator.getStack().pop();
		simulator.getStack().push(b1-a1);	
	}
	}
}