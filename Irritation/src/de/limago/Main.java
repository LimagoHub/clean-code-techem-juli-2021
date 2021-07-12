package de.limago;

public class Main {

    public static void main(String[] args) {
	    new B();
    }
}

class A {

    public A() {
        System.out.println("Ctor A");
        extracted1();
    }

    public void foo() {
        extracted1();
    }

    private void extracted1() {
        System.out.println("Hier ist A");
    }
}
class B extends A {

    public B() {
        System.out.println("Ctor B");
    }

    public void foo() {
        extracted();
    }

    private void extracted() {
        System.out.println("Hier ist B");
    }
}
