abstract public class Menu {

    String name;
    int price;

    Menu(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public Menu() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return this.price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Menu name(String name) {
        setName(name);
        return this;
    }

    public Menu price(int price) {
        setPrice(price);
        return this;
    }

    @Override
    public String toString() {
        return "{" +
                " name='" + getName() + "'" +
                ", price='" + getPrice() + "'" +
                "}";
    }

}
