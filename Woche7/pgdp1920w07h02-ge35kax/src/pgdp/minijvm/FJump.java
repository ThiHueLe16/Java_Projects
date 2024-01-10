package pgdp.minijvm;
public class FJump extends Instruction{
	int i;
	public FJump(int i) {
		this.i=i;
	}
	public void execute(Simulator simulator) {
		int SPf=simulator.getStack().getStackPointer();
		if(SPf>-1) {
			int f=simulator.getStack().getValueAtIndex(SPf);
			simulator.getStack().pop();
			if(f==0) {
				simulator.setProgramCounter(this.i);
				
			}
		}
	}
}