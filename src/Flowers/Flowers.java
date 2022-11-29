package Flowers;

import java.util.ArrayList;
/*1. Цветочница. Определить иерархию цветов. Создать несколько объектов-
цветов. Собрать букет (используя аксессуары) с определением его стоимо-
сти. Провести сортировку цветов в букете на основе уровня свежести.*/
public class Flowers {
    private static ArrayList<Flower> flowers;
    private static ArrayList<Flower> freshFlowers;
    public static void main(String[] args) {
        Flower flower1 = new Rose();
        flower1.setPrice(15);
        flower1.setName("Red");
        flower1.setDiscountFactor(1);
        flower1.setDayOfLife(3);

        Flower flower2 = new Tulip();
        flower2.setPrice(12);
        flower2.setName("Pink ");
        flower2.setDiscountFactor(2);
        flower2.setDayOfLife(1);


        Flower flower3 = new Chamomile();
        flower3.setPrice(10);
        flower3.setName("White");
        flower3.setDiscountFactor(3);
        flower3.setDayOfLife(2);

        flowers = new ArrayList<>();
        flowers.add(flower1);
        flowers.add(flower2);
        flowers.add(flower3);

        Accessories accessories = new PaperWrap();
        accessories.setPrice(2.5);

        Bouquet bouquet = new Bouquet();
        bouquet.printBouquet(flowers, accessories);
        System.out.println("Цена букета : " + bouquet.getPrice(flowers, accessories) + "$");


       sortFreshFlowers(2);
    }

        public static void sortFreshFlowers(int dayOfLife){
            System.out.println("Свежесть цветов "+ dayOfLife + " дня, и свежее");
           freshFlowers = new ArrayList<>();
          for(Flower flower : flowers) {
              if (flower.getDayOfLife() <= dayOfLife) {
                  freshFlowers.add(flower);
                  if (flower instanceof Rose)
                      System.out.println(((Rose) flower).name +" "+ ((Rose) flower).getPrice()+"$");
                  else if (flower instanceof Tulip)
                      System.out.println(((Tulip) flower).name + " "+((Tulip) flower).getPrice()+"$");
                  else if (flower instanceof Chamomile)
                      System.out.println(((Chamomile) flower).name +" "+ ((Chamomile) flower).getPrice()+"$");
              }
          }
    }
}

abstract class Flower {

  private String name;
   private String color;
    private double price;

    private int dayOfLife;
    private double discountFactor;

    public void setName(String color) {
        this.name = color;
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
static final String name= "Rose";

    }

class Tulip extends Flower {
    static final String name= "Tulip";

}

class Chamomile extends Flower {
    static final String name= "Chamomile";


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
    static final String name= "Ribbon";

}

class PaperWrap extends Accessories {
    static final String name= "PaperWrap";

}
class Box extends Accessories {
    static final String name= "Box";

}
class Card extends Accessories {
    static final String name= "Card";

}
class Bouquet {
    public double getPrice(ArrayList<Flower> flowers, Accessories accessories) {
        int price = 0;
        for (Flower flower : flowers)
            price += flower.getPrice();

        return price + accessories.getPrice();
    }

    public void printBouquet(ArrayList<Flower> flowers, Accessories accessories) {
        System.out.println("Букет состоит из: ");
        for (Flower flower : flowers) {
            if (flower instanceof Rose)
                System.out.print(((Rose) flower).name + " " + ((Rose) flower).getDayOfLife()+" day(s), ");
            else if (flower instanceof Tulip)
                System.out.print(((Tulip) flower).name + " " + ((Tulip) flower).getDayOfLife()+" day(s), ");
            else if (flower instanceof Chamomile)
                System.out.print(((Chamomile) flower).name + " " + ((Chamomile) flower).getDayOfLife()+" day(s), ");
        }
        if (accessories instanceof Ribbon)
            System.out.println(((Ribbon) accessories).name );
        else if (accessories instanceof Box)
            System.out.println(((Box) accessories).name );
        else if (accessories instanceof Card)
            System.out.println(((Card) accessories).name );
       else if (accessories instanceof PaperWrap)
            System.out.println(((PaperWrap) accessories).name );

    }
}