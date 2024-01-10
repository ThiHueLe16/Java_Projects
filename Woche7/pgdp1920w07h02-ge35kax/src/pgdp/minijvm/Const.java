package pgdp.minijvm;
public class Const extends Instruction{
	public int i;
	public Const(int i) {
		this.i=i;
	}
	public void execute(Simulator simulator) {
		simulator.getStack().push(this.i);
	}
}