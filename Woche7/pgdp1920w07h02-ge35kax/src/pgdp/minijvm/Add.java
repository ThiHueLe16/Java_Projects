package pgdp.minijvm;
public class Add extends Instruction{
	public void execute(Simulator simulator) {
		int SPa=simulator.getStack().getStackPointer();
		if(SPa>0) {
			int a=simulator.getStack().getValueAtIndex(SPa);
			int b=simulator.getStack().getValueAtIndex(SPa-1);
			simulator.getStack().pop();
			simulator.getStack().pop();
			simulator.getStack().push(a+b);
		}
	}
}