package se_design_pattern.factories;

import se_design_pattern.animals.MallarDuck;
import se_design_pattern.animals.Quackable;
import se_design_pattern.animals.RedheadDuck;
import se_design_pattern.animals.RubberDuck;
import se_design_pattern.animals.decorated.QuackCounter;
import se_design_pattern.animals.decorated.QuackEcho;

public class CountAndEchoDuckFactory extends AbstractDuckFactory {

    @Override
    public Quackable createMallardDuck() {
        return new QuackCounter(new QuackEcho(new MallarDuck()));
    }

    @Override
    public Quackable createRedheadDuck() {
        return new QuackCounter(new QuackEcho(new RedheadDuck()));
    }

    @Override
    public Quackable createDuckCall() {
        return new QuackCounter(new QuackEcho(new RedheadDuck()));
    }

    @Override
    public Quackable createRubberDuck() {
        return new QuackCounter(new QuackEcho(new RubberDuck()));
    }
}
