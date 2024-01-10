package pgdp.minijvm;
public class Halt extends Instruction{
	public void execute(Simulator simulator) {
		simulator.setHalted(true);
	}
}