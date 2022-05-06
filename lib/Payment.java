public class Payment {

    public static int totalPrice() {
        int totalPrice = 0;

        int numOfAdults = Integer.parseInt(BookMoviePanel.adultTextField.getText());
        int numOfKids = Integer.parseInt(BookMoviePanel.kidsTextField.getText());
        int moviePrice = 50;

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
