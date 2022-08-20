package se_design_pattern.factories;

import se_design_pattern.animals.*;

public class DuckFactory extends AbstractDuckFactory {

    @Override
    public Quackable createMallardDuck() {
        return new MallarDuck();
    }

    @Override
    public Quackable createRedheadDuck() {
        return new RedheadDuck();
    }

    @Override
    public Quackable createDuckCall() {
        return new DuckCall();
    }

    @Override
    public Quackable createRubberDuck() {
        return new RubberDuck();
    }
}
