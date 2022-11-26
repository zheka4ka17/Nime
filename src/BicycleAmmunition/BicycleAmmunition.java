package BicycleAmmunition;

import java.util.ArrayList;

public class BicycleAmmunition {
    /*Мотоциклист. Определить иерархию амуниции. Экипировать мотоцикли-
ста. Подсчитать стоимость. Провести сортировку амуниции на основе веса.
Найти элементы амуниции, соответствующие заданному диапазону пара-
метров цены.*/
  private static  ArrayList<Ammunition> bicycleSet;
    public static void main(String[] args) {
        Ammunition helmet = new Helmet(3.2, 150, "Nike", "x1");
        Ammunition gloves = new Gloves(0.2, 20, "Adidas", "ad7");
        Ammunition trousers = new Trousers(1.5, 59, "New Balance", "i500");
        Ammunition jacket = new Jacket(1.1, 45.5, "Under armour", "Ua15");

        bicycleSet = new ArrayList<>();
        bicycleSet.add(helmet);
        bicycleSet.add(gloves);
        bicycleSet.add(trousers);
        bicycleSet.add(jacket);

        SetOfAmmunition setOfAmmunition = new SetOfAmmunition();
        System.out.println(setOfAmmunition.getPrice(bicycleSet) + "$");

        sortAmmunitionKg(0.5,10);
        System.out.println();
        sortAmmunitionPrice(10,50.8);
    }

    public static void sortAmmunitionPrice(double minPrice, double maxPrice) {
        for (Ammunition ammunition : bicycleSet)
            if (ammunition.getPrice() >= minPrice && ammunition.getPrice() <= maxPrice)
                System.out.println(ammunition.toString());

    }

    public static void sortAmmunitionKg(double minWeight, double maxWeight) {
    for (Ammunition ammunition : bicycleSet)
        if (ammunition.getWeight() >= minWeight && ammunition.getWeight() <= maxWeight)
            System.out.println(ammunition.toString());
}


    }

abstract class Ammunition{
    private double weight;
    private double price;
    private String firm;
    private String model;



    public Ammunition(double weight, double price, String firm, String model) {
        this.weight = weight;
        this.price = price;
        this.firm = firm;
        this.model = model;
    }


    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setFirm(String firm) {
        this.firm = firm;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Ammunition{" +
                "weight=" + weight +
                ", price=" + price +
                ", firm='" + firm + '\'' +
                ", model='" + model + '\'' +
                '}';
    }

    public double getWeight() {
        return weight;
    }

    public double getPrice() {
        return price;
    }

    public String getFirm() {
        return firm;
    }

    public String getModel() {
        return model;
    }
}
class Helmet extends Ammunition{


    public Helmet(double weight, double price, String firm, String model) {
        super(weight, price, firm, model);
    }
}
class Gloves extends Ammunition{

    public Gloves(double weight, double price, String firm, String model) {
        super(weight, price, firm, model);
    }
}
class Jacket extends Ammunition{

    public Jacket(double weight, double price, String firm, String model) {
        super(weight, price, firm, model);
    }
}
class Trousers extends Ammunition{

    public Trousers(double weight, double price, String firm, String model) {
        super(weight, price, firm, model);
    }
}
class SetOfAmmunition{
    public double getPrice(ArrayList<Ammunition> bicycleSet){
        double price = 0;
        for(Ammunition ammunition : bicycleSet)
          price += ammunition.getPrice();
    return price;}

}