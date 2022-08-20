package se_design_pattern.adapter;

import se_design_pattern.animals.Goose;
import se_design_pattern.animals.Quackable;

public class GooseAdapter implements Quackable {
    private Goose goose;

    public GooseAdapter(Goose goose) {
        this.goose = goose;
    }


    @Override
    public void quack() {
        goose.honk();
    }
}
