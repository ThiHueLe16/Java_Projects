package pgdp.polymorphie;

public class Poly {
    static void write(String s) {
        System.out.println(s);
    }

    static interface I1 {
        void f(I2 x, I3 y);
    }

    static class A implements I1 {
        public void f(I2 x, I3 y) {
            write("A.f(I2, I3)");
            x.f(this, y);
        }
    }

    static class B implements I1 {
        public void f(I2 x, I3 y) {
            write("B.f(I2, I3)");
            x.f(this, y);
        }
    }

    static interface I2 {
        void f(A a, I3 x);
        void f(B b, I3 x);
    }

    static class C implements I2 {
        public void f(A a, I3 x) {
            write("C.f(A, I3)");
            x.f(a, this);
        }

        public void f(B b, I3 x) {
            write("C.f(B, I3)");
            x.f(b, this);
        }
    }

    static class D implements I2 {
        public void f(A a, I3 x) {
            write("D.f(A, I3)");
            x.f(a, this);
        }

        public void f(B b, I3 x) {
            write("D.f(B, I3)");
            x.f((I1) b, this);
        }
    }

    static interface I3 {
        void f(A a, C c);
        void f(I1 b, I2 c);
        void f(A a, D d);
        void f(B b, D d);
    }

    static class E implements I3{
        public void f(A a, C c){
            write("E.f(A, C)");
        }

        public void f(I1 b, I2 c){
            write("E.f(I1, I2)");
        }

        public void f(A a, D d){
            write("E.f(A, D)");
        }

        public void f(B b, D d){
            write("E.f(B, D)");
        }
    }

    static class F extends E {
        static final E eobj = new E();

        @Override
        public void f(I1 b, I2 c) {
            write("F.f(I1, I2)");
            eobj.f(b, c);
        }

        @Override
        public void f(A a, C c) {
            write("F.f(A, C)");
        }
    }

    static class G extends F {
        @Override
        public void f(B b, D d) {
            write("G.f(B, D)");
            eobj.f(b, d);
        }

        @Override
        public void f(A a, D d) {
            write("G.f(A, D)");
            eobj.f(a, d);
        }
    }


    public static void main(String[] args) {
        A a = new A();
        I1 b = new B();
        B b2 = new B();
        I2 c = new C();
        C c2 = new C();
        I2 d = new D();
        D d2 = new D();
        I3 e = new E();
        E e2 = new E();
        F f = new F();
        G g = new G();
  
        write("Aufruf 1: e2.f(b2, c); ");
        e2.f(b2, c);    // Aufruf 1
       
        write("Aufruf 1: e2.f(b2, c); ");
        e2.f(b2, c);    // Aufruf 1
        write("-------------------------------------");
        write("Aufruf 2: g.f(b2, d2);");
        g.f(b2, d2);     // Aufruf 2
        write("-------------------------------------");
        write("Aufruf 3:  f.f(b2, c2); ");
        f.f(b2, c2);     // Aufruf 3
        write("-------------------------------------");
        write("Aufruf 4: a.f(c, e);");
        a.f(c, e);      // Aufruf 4
        write("-------------------------------------");
        write("Aufruf 5: b.f(d, e);");
        b.f(d, e);      // Aufruf 5
        write("-------------------------------------");
        write("Aufruf 6: c.f(a, e); ");
        c.f(a, e);      // Aufruf 6
        write("-------------------------------------");
        write("Aufruf 7: e.f(a, d);");
        e.f(a, d);      // Aufruf 7
        write("-------------------------------------");
        write("Aufruf 8: e.f(b, c); ");
        e.f(b, c);      // Aufruf 8
    }

}
