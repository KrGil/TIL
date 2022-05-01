package patterns.decorator_design_patterns;

public class CoffeeTest {
    public static void main(String[] args) {
        Coffee etiopiaAmericano = new EtiopiaAmericano();
        etiopiaAmericano.brewing();
        System.out.println();

        Coffee kenyaLatte = new Latte(new KenyaAmericano());
        kenyaLatte.brewing();
        System.out.println();

        Mocha kenyaMocha = new Mocha(new Latte(new KenyaAmericano()));
        kenyaMocha.brewing();
        System.out.println();

        WhippedCream etiopiaWhippedMocha =
                new WhippedCream(new Mocha(new Latte( new EtiopiaAmericano())));
        etiopiaWhippedMocha.brewing();
        System.out.println();

    }
}
