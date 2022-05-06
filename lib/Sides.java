import java.util.ArrayList;

public class Sides extends Menu {

    public static ArrayList<Sides> sidesArr = new ArrayList<Sides>();

    Sides(String name, int price) {
        super(name, price);

    }
    
    public static void setSides(){
        sidesArr.add(new Sides("Popcorn", 19));
        sidesArr.add(new Sides("Fries", 29));
        sidesArr.add(new Sides("Nachos", 24));
        sidesArr.add(new Sides("Chips", 9));
    }

}
