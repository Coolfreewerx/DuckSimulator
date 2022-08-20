package se_design_pattern.animals;

public class RubberDuck implements Quackable {
    @Override
    public void quack() {
        System.out.println("Squeak");
    }
}
