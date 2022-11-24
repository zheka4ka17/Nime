package Flowers;

import java.util.ArrayList;

public class Flowers {
    public static void main(String[] args) {
        Flower flower1  =new Rose();
        flower1.setPrice(15);
        Flower flower2 = new Tulip();
        flower2.setPrice(10);
        Flower flower3 = new Chamomile();
        flower3.setPrice(8);

        ArrayList<Flower> flowers = new ArrayList<>();
        flowers.add(flower1);
        flowers.add(flower2);
        flowers.add(flower3);

        Accessories accessories = new PaperWrap();
        accessories.setPrice(2.5);

        Bouquet bouquet= new Bouquet();
        System.out.println("Цена букета : " +bouquet.getPrice(flowers, accessories )+"$");



    }
}
class Flower{
    private String color;

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private double price;


}
class Rose extends Flower{

}



class Tulip extends Flower{

}
class Chamomile extends Flower{

}
class Accessories{
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private double price;

}

class Ribbon extends Accessories{

}

class PaperWrap extends Accessories{

}
class Box extends Accessories{

}
class Card extends Accessories{

}
class Bouquet {
    public double getPrice(ArrayList<Flower> flowers, Accessories accessories){
        int price=0;
        for (Flower flower: flowers)
            price+=flower.getPrice();

        return price+accessories.getPrice();
    }
}
