package CollectionFrameWork_gui;

import javax.swing.*;
import java.util.HashMap;
import java.util.Objects;

public class ShoppingCart extends JFrame {
    private JPanel tablepanel;
    private JRadioButton addToCartRadioButton;
    private JRadioButton addToCartRadioButton1;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JComboBox comboBox4;
    private JRadioButton addToCartRadioButton2;
    private JRadioButton addToCartRadioButton3;
    private JLabel item1;
    private JLabel price1;
    private JLabel item2;
    private JLabel p2;
    private JLabel item3;
    private JLabel p3;
    private JLabel item4;
    private JLabel p4;
    private JLabel calculatedamount;
    private HashMap<String,Integer> products; //prod nd price
    private HashMap<String, Integer> cart; // Product nd quantity

    public ShoppingCart() {
        products = new HashMap<>();
        cart = new HashMap<>();

        // Add products with prices
        products.put("Mango Juice", Integer.valueOf(220));  // Price in cents to avoid decimals
        products.put("Banana Shake", Integer.valueOf(240));
        products.put("Cold Coffee", Integer.valueOf(560));
        products.put("Margarita", Integer.valueOf(350));

        setTitle("K22 4821 - Shopping Cart");
        setContentPane(tablepanel);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        setVisible(true);

        addToCartRadioButton.addActionListener(e -> addItemToCart("Mango Juice", Integer.parseInt(Objects.requireNonNull(comboBox1.getSelectedItem()).toString())));
        addToCartRadioButton1.addActionListener(e -> addItemToCart("Banana Shake", Integer.parseInt(Objects.requireNonNull(comboBox2.getSelectedItem()).toString())));
        addToCartRadioButton2.addActionListener(e -> addItemToCart("Cold Coffee", Integer.parseInt(Objects.requireNonNull(comboBox3.getSelectedItem()).toString())));
        addToCartRadioButton3.addActionListener(e -> addItemToCart("Margarita", Integer.parseInt(Objects.requireNonNull(comboBox4.getSelectedItem()).toString())));
    }

    private void addItemToCart(String product, int quant) {
        if (quant == 0) {
            cart.remove(product);
        } else {
            cart.put(product, Integer.valueOf(quant));  //autoboxing works here
        }
        updateTotalPrice();
    }

    private void updateTotalPrice() {
        int totalPrice = 0;

        for (String product : cart.keySet()) {
            int quantity =cart.get(product);
            int price =products.get(product);


            totalPrice  += quantity * price;
        }
        calculatedamount.setText("Total: $"+totalPrice);
    }

    public static void main(String[] args) {

ShoppingCart shoppingCart = new ShoppingCart();
    }
}
