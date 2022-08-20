package se_design_pattern.animals;

import java.sql.SQLOutput;

public class MallarDuck implements Quackable {
    @Override
    public void quack() {
        System.out.println("Quack");
    }
}
