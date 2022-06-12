package com.GeekBreins.HomeWork1.Participart;

public class Human implements Participant {

    private final String name;
    private final int jumpHeight;
    private final int runDistance;

    public Human(String name, int jumpHeight, int runDistance) {
        this.name = name;
        this.jumpHeight = jumpHeight;
        this.runDistance = runDistance;
    }

    @Override
    public int jumpHeight() {
        System.out.printf("Numan %S может прыгнуть на %d%n",this.name,this.jumpHeight);
        return this.jumpHeight;
    }

    @Override
    public int runDistance() {
        System.out.printf("Human %S может пробежать %d%n",this.name,this.runDistance);
        return this.runDistance;
    }
    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", jumpHeight=" + jumpHeight +
                ", runDistance=" + runDistance +
                '}';
    }
}
