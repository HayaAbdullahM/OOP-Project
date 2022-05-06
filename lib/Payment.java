public class Payment {

    public static int totalPrice(int numOfAdults, int numOfKids, int moviePrice) {
        int totalPrice = 0;

        totalPrice += numOfAdults * moviePrice;
        totalPrice += numOfKids * moviePrice * 0.75;
        totalPrice += getMenuTotal();

        return totalPrice;
    }

    public static int getMenuTotal() {
        int menuPrice = 0;

        for (int i = 0; i < MenuPanel.totalSides.size(); i++) {
            switch (MenuPanel.totalSides.get(i)) {
                case "Water":
                    menuPrice += 3;
                    break;
                case "Soft Drinks":
                case "Slashes":
                case "Fresh Juice":
                    menuPrice += 10;
                    break;
                case "Chips":
                case "Nachos":
                case "Fries":
                case "Popcorn":
                    menuPrice += 15;

                default:
                    break;
            }
        }

        return menuPrice;
    }

}
