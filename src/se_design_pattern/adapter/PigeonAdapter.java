package se_design_pattern.adapter;

import se_design_pattern.animals.Pigeon;
import se_design_pattern.animals.Quackable;

public class PigeonAdapter implements Quackable {
    private Pigeon pigeon;

    public PigeonAdapter(Pigeon pigeon) {
        this.pigeon = pigeon;
    }

    @Override
    public void quack() {
        pigeon.coo();
        pigeon.coo();
    }
}
