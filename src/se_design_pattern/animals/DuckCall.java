package se_design_pattern.animals;

public class DuckCall implements Quackable {
    @Override
    public void quack() {
        System.out.println("Kwak");
    }
}
