package Flowers;

import java.util.ArrayList;

public class Flowers {
    private static ArrayList<Flower> flowers;
    private static ArrayList<Flower> freshFlowers;
    public static void main(String[] args) {
        Flower flower1 = new Rose();
        flower1.setPrice(15);
        flower1.setName("Red Rose");
        flower1.setDiscountFactor(1);
        flower1.setDayOfLife(3);

        Flower flower2 = new Tulip();
        flower2.setPrice(12);
        flower2.setName("Pink Tulip ");
        flower2.setDiscountFactor(2);
        flower2.setDayOfLife(1);


        Flower flower3 = new Chamomile();
        flower3.setPrice(10);
        flower3.setName("White Chamomile");
        flower3.setDiscountFactor(3);
        flower3.setDayOfLife(2);

        flowers = new ArrayList<>();
        flowers.add(flower1);
        flowers.add(flower2);
        flowers.add(flower3);

        Accessories accessories = new PaperWrap();
        accessories.setPrice(2.5);

        Bouquet bouquet = new Bouquet();
        System.out.println("Цена букета : " + bouquet.getPrice(flowers, accessories) + "$");

        System.out.println(sortFreshFlowers(1).toString());
    }

        public static ArrayList<Flower> sortFreshFlowers(int dayOfLife){
           freshFlowers = new ArrayList<>();
          for(Flower flower : flowers){
              if (flower.getDayOfLife()<=dayOfLife)
                  freshFlowers.add(flower);}
          return freshFlowers;
    }
}

abstract class Flower {

    private String name;
    private double price;

    private int dayOfLife;
    private double discountFactor;

    public void setName(String name) {
        this.name = name;
    }

    public void setDayOfLife(int dayOfLife) {
        this.dayOfLife = dayOfLife;
    }



    public void setPrice(double price) {

        this.price = price;
    }

    public void setDiscountFactor(double discountFactor) {
        this.discountFactor = discountFactor;
    }

    public double getPrice() {
        return price - ((dayOfLife-1) * discountFactor);

    }

    public int getDayOfLife() {
        return dayOfLife;
    }

    @Override
    public String toString() {
        return "Flower{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", dayOfLife=" + dayOfLife +
                ", discountFactor=" + discountFactor +
                '}';
    }
}
class Rose extends Flower {


}
class Tulip extends Flower {

}

class Chamomile extends Flower {


}
abstract class Accessories{
    private double price;


    public void setPrice(double price) {
        this.price = price;

    }
    public double getPrice(){
        return price;
    }
}

class Ribbon extends Accessories {


}

class PaperWrap extends Accessories {


}
class Box extends Accessories {


}
class Card extends Accessories {


}
class Bouquet {
    public double getPrice(ArrayList<Flower> flowers, Accessories accessories){
        int price=0;
        for (Flower flower: flowers)
            price+=flower.getPrice();

        return price+accessories.getPrice();
    }
}
