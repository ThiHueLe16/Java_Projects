package pgdp.stack;

public class BracketStack {
	private char[] stack;
    private int stackpointer = 0;
    
    //Kontruktor
    public BracketStack(int a) {
    	this.stack=new char[a];
    }

    private static boolean matches(char open, char close) {
        return open == '(' && close == ')' || open == '[' && close == ']' || open == '{' && close == '}';
    }
	public void push(char value) {//legt einen Wert auf dem Stack
		stack[stackpointer++]=value;
	}
	public char pop() {//nimmt den obersten Wert vom Stack und gibt ihn zurück
		return(stack[--stackpointer]);
	}
	public char peek() {//gibt den obersten Wert zurück, ohne ihn vom Stack zu nehmen
		return(stack[stackpointer-1]);
	}
	public boolean isEmpty() {
		return stackpointer==0;
	}
	public static boolean checkBraces(String input) {
		BracketStack keller=new BracketStack(input.length());
		for(int i=0; i<input.length();i++) {
			char Wert=input.charAt(i);
			if(Wert=='['|| Wert=='('||Wert =='{') {
				keller.push(Wert);
			}
			else if((Wert==')'||Wert=='}'||Wert==']')&&(keller.isEmpty()||!keller.matches(keller.pop(), Wert))) {
				return false;
			}
		}
		return keller.isEmpty();
	}
	
}