package patterns.decorator_design_patterns;

public class Latte extends Decorator{
    public Latte(Coffee coffee) {
        super(coffee);
    }

    public void brewing(){
        super.brewing();
        System.out.println("Add Milk");
    }
}
