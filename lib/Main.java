import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.*;

public class Main {

    public static Connector database = new Connector();
    public static CardLayout cardLayout = new CardLayout();

    public static void main(String[] args) {

        Runner.runApp();

    }
}