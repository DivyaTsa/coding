package com.test;

public class FishTest {

    public static void main(String[] args) {
        Fish hm = new Hammer(5);

        //hm.end();
        //hm.doFly();
        System.out.println(hm.length);

    }

}

class Fish {
    int length;

    Fish() {
        System.out.println("Fish1: length" + length);
        this.length += 10;
    }

    Fish(int length) {
        System.out.println("Fish2: length" + length);
        this.length += length;
    }

    public void start() {
        System.out.println("Fish Start");
    }

    public void end() {
        start();
    }
}

class Hammer extends Fish {
    Hammer() {
        this.length += 40;

    }

    Hammer(int length) {
        System.out.println("Hammer2: length" + length);
        this.length += length;
    }

    public void start() {
        System.out.println("Hammer Start");
    }

    public void doFly() {
        System.out.println("Hammer Fly");
    }

}
