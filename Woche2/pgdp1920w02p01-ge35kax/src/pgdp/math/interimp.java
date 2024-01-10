package pgdp.math;

public class interimp {
	inter a=new inter() {
		public boolean test(Object r) {
			return (r!=null);
		}
	};
	public static boolean check(Object a, inter p) {
		return p.test(a);
	}
	public static void main(String[]args) {
		String[]a=new String[] {"abc", "def"};
		Object[] b=a;
		System.out.println(b[0]);
		b[0]
		
	}
}
