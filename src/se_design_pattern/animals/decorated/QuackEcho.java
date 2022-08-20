package se_design_pattern.animals.decorated;

import se_design_pattern.animals.Quackable;

public class QuackEcho implements Quackable {
    private Quackable duck;

    public QuackEcho(Quackable duck) {
        this.duck = duck;
    }

    @Override
    public void quack() {
        duck.quack();

        System.out.println("Echo:");
        duck.quack();
    }
}