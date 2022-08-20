package se_design_pattern;


import se_design_pattern.adapter.GooseAdapter;
import se_design_pattern.adapter.PigeonAdapter;
import se_design_pattern.animals.*;
import se_design_pattern.animals.composites.Flock;
import se_design_pattern.animals.composites.LeaderFlock;
import se_design_pattern.animals.decorated.QuackCounter;
import se_design_pattern.animals.decorated.QuackEcho;
import se_design_pattern.factories.AbstractDuckFactory;
import se_design_pattern.factories.CountAndEchoDuckFactory;
import se_design_pattern.factories.CountingDuckFactory;
import se_design_pattern.factories.DuckFactory;

public class DuckSimulator {
    public static void main(String[] args) {
        DuckSimulator duckSimulator = new DuckSimulator();
        duckSimulator.simulateCompositePattern2();

    }

    private void simulate(Quackable duck) {
        duck.quack();
    }

    private void simulateAdapterPattern() {
        Quackable mallardDuck = new MallarDuck();
        Quackable redHeadDuck = new RedheadDuck();
        Quackable duckCall = new DuckCall();
        Quackable rubberDuck = new RubberDuck();
        Quackable gooseAdapter = new GooseAdapter(new Goose());
        Quackable pigeonAdapter = new PigeonAdapter(new Pigeon());

        simulate(mallardDuck);
        simulate(redHeadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseAdapter);
        simulate(pigeonAdapter);
    }

    // Echo then Counter
    // Quacked 6 times.
    private void simulateDecoratorPattern1() {
        Quackable mallardDuck = new QuackCounter(new MallarDuck());
        Quackable redHeadDuck = new QuackCounter(new RedheadDuck());
        Quackable duckCall = new QuackCounter(new DuckCall());
        Quackable rubberDuck = new QuackCounter(new RubberDuck());
        Quackable gooseAdapter = new GooseAdapter(new Goose());
        Quackable pigeonAdapter = new PigeonAdapter(new Pigeon());

        Quackable mallardDecorator = new QuackCounter(new QuackEcho(new MallarDuck()));

        System.out.println("\nDuck Simulator: With Decorator");

        simulate(mallardDuck);
        simulate(redHeadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseAdapter);
        simulate(pigeonAdapter);
        simulate(mallardDecorator);

        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times.");
    }

    // Counter then Echo
    // Quacked 5 times.
    private void simulateDecoratorPattern2() {
        Quackable mallardDuck = new QuackCounter(new MallarDuck());
        Quackable redHeadDuck = new QuackCounter(new RedheadDuck());
        Quackable duckCall = new QuackCounter(new DuckCall());
        Quackable rubberDuck = new QuackCounter(new RubberDuck());
        Quackable gooseAdapter = new GooseAdapter(new Goose());
        Quackable pigeonAdapter = new PigeonAdapter(new Pigeon());

        Quackable redHeadDecorator = new QuackEcho(new QuackCounter(new RedheadDuck()));

        System.out.println("\nDuck Simulator: With Decorator");

        simulate(mallardDuck);
        simulate(redHeadDuck);
        simulate(duckCall);
        simulate(rubberDuck);
        simulate(gooseAdapter);
        simulate(pigeonAdapter);
        simulate(redHeadDecorator);

        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times.");
    }

    private void simulateAbstractFactoryPattern() {
        AbstractDuckFactory duckFactory = new DuckFactory();
        AbstractDuckFactory countingDuckFactory = new AbstractDuckFactory() {
            @Override
            public Quackable createMallardDuck() {
                return null;
            }

            @Override
            public Quackable createRedheadDuck() {
                return null;
            }

            @Override
            public Quackable createDuckCall() {
                return null;
            }

            @Override
            public Quackable createRubberDuck() {
                return null;
            }
        };
        AbstractDuckFactory countAndEchoDuckFactory = new CountAndEchoDuckFactory();

        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redHeadDuck = countingDuckFactory.createRedheadDuck();
        Quackable duckCall = countAndEchoDuckFactory.createDuckCall();
        Quackable rubberDuck = countAndEchoDuckFactory.createRubberDuck();

        System.out.println("\nDuck Simulator: With Abstract Factory");

        simulate(mallardDuck);
        simulate(redHeadDuck);
        simulate(duckCall);
        simulate(rubberDuck);

        System.out.println("The ducks quacked " + QuackCounter.getQuacks() + " times.");
    }

    private void simulateCompositePattern1() {
        AbstractDuckFactory duckFactory = new DuckFactory();
        AbstractDuckFactory countingDuckFactory = new AbstractDuckFactory() {
            @Override
            public Quackable createMallardDuck() {
                return null;
            }

            @Override
            public Quackable createRedheadDuck() {
                return null;
            }

            @Override
            public Quackable createDuckCall() {
                return null;
            }

            @Override
            public Quackable createRubberDuck() {
                return null;
            }
        };

        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redHeadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = countingDuckFactory.createDuckCall();
        Quackable rubberDuck = countingDuckFactory.createRubberDuck();

        Flock flock = new Flock();
        flock.add(mallardDuck);
        flock.add(redHeadDuck);
        flock.add(duckCall);
        flock.add(rubberDuck);

        flock.quack();
    }

    private void simulateCompositePattern2() {
        AbstractDuckFactory duckFactory = new DuckFactory();
        AbstractDuckFactory countingDuckFactory = new AbstractDuckFactory() {
            @Override
            public Quackable createMallardDuck() {
                return null;
            }

            @Override
            public Quackable createRedheadDuck() {
                return null;
            }

            @Override
            public Quackable createDuckCall() {
                return null;
            }

            @Override
            public Quackable createRubberDuck() {
                return null;
            }
        };

        Quackable mallardDuck = duckFactory.createMallardDuck();
        Quackable redHeadDuck = duckFactory.createRedheadDuck();
        Quackable duckCall = countingDuckFactory.createDuckCall();
        Quackable rubberDuck = countingDuckFactory.createRubberDuck();

        LeaderFlock flock = new LeaderFlock();
        flock.add(mallardDuck);
        flock.add(redHeadDuck);
        flock.add(duckCall);
        flock.add(rubberDuck);

        flock.quack();
    }

}
