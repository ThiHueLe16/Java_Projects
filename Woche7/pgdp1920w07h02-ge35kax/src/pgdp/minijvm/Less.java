package pgdp.minijvm;
public class Less extends Instruction{
	public void execute(Simulator simulator) {
		int SPle=simulator.getStack().getStackPointer();
		if(SPle>0) {
			int a=simulator.getStack().getValueAtIndex(SPle);
			int b=simulator.getStack().getValueAtIndex(SPle-1);
			if(b<a) {
				simulator.getStack().pop();
				simulator.getStack().pop();
				simulator.getStack().push(1);
				}
			else {
				simulator.getStack().pop();
				simulator.getStack().pop();
				simulator.getStack().push(0);
			}
		}
	}
}