package se_design_pattern.animals.composites;

import se_design_pattern.animals.Quackable;

import java.util.ArrayList;

public class Flock implements Quackable {
    ArrayList<Quackable> quackers = new ArrayList<>();

    public void add(Quackable quacker) {
        quackers.add(quacker);
    }

    @Override
    public void quack() {
        for (Quackable quacker : quackers) {
            quacker.quack();
        }
    }
}
