import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int counter = 0;
        Product productOne = new Product(10, 5000000, "Product 1");
        Product productTwo = new Product(10, 5000000, "Product 1");
        Product productThree = new Product(10, 5000000, "Product 1");
        Product productFour = new Product(10, 5000000, "Product 1");
        ArrayList<Product> inventory = new ArrayList<>(Arrays.asList(
                productOne, productTwo, productThree, productFour
        ));
        ArrayList<Product> cart = new ArrayList<>();
        try (Scanner parser = new Scanner(System.in)) {
            String outputChatbox = "Are you a customer or an administrative member? 1. Customer | 2. Administrative member";
            System.out.println(outputChatbox);
            int selection = parser.nextInt();
            String[] dataValues;
            String data;
            if (selection == 1) {
                counter = 0;
                while (counter < 3) {
                    outputChatbox = "What do you want to do?: 1. Add product to your cart | 2. View product | 3. Clear product | 0. EXIT TO MAIN MENU";
                    System.out.println(outputChatbox);
                    selection = parser.nextInt();
                    switch(selection) {
                        case 1:
                            System.out.println("The store has the current products: ");
                            if (inventory.size() > 0) {
                                for (int i = 0; i < inventory.size(); i++) {
                                    System.out.println("Index: " + i + inventory.get(i));
                                }
                            } else {
                                System.out.println("This company has no products. We are so sorry! EXITING");
                                System.exit(-1);
                            }
                            outputChatbox = "Insert the IDs (index) of the products that you want to add to your cart SEPARATED BY A COMMA:";
                            System.out.println(outputChatbox);
                            data = parser.next();
                            dataValues = data.split(",");
                            for (int i = 0; i < dataValues.length; i++) {
                                int productIndex = Integer.parseInt(dataValues[i]);
                                cart.add(inventory.get(productIndex));
                            }
                            outputChatbox = dataValues.length + " products added to your cart successfully.";
                            System.out.println(outputChatbox);
                            break;
                        case 2:
                            System.out.println("Products in cart: ");
                            if (cart.size() > 0) {
                                for (int i = 0; i < cart.size(); i++) {
                                    System.out.println("Index: " + i + " " + cart.get(i));
                                }
                            } else {
                                System.out.println("0 products in your cart.");
                            }
                            break;
                        case 3:
                            System.out.println("Products in cart: ");
                            if (cart.size() > 0) {
                                for (int i = 0; i < inventory.size(); i++) {
                                    System.out.println("DELETION INDEX: " + i + " " + inventory.get(i));
                                }
                            } else {
                                System.out.println("0 products in your cart. Cannot delete what does not exist.");
                                System.exit(-1);
                            }
                            outputChatbox = "According to the previous list, insert the INDEX of the product that you want to delete or press 5 to exit:";
                            System.out.println(outputChatbox);
                            selection = parser.nextInt();
                            if (selection == 5) {
                                System.exit(-1);
                            }
                            if (selection >= inventory.size()) {
                                outputChatbox = "Index does not exist. Exiting.";
                                System.out.println(outputChatbox);
                                System.exit(-1);
                            } else {
                                inventory.remove(selection);
                                outputChatbox = "Product with INDEX " + selection + " deleted from inventory successfully.";
                                System.out.println(outputChatbox);
                            }
                            break;
                        case 4:
                            outputChatbox = "EXITING PROGRAM";
                            System.out.println(outputChatbox);
                            System.exit(-1);
                            break;
                    }
                    counter++;
                }
            } else {
                counter = 0;
                while (counter < 5) {
                    outputChatbox = "What do you want to do?: 1. Add products to inventory | 2. View products | 3. Delete product | 4. EXIT PROGRAM";
                    System.out.println(outputChatbox);
                    selection = parser.nextInt();
                    int productId = inventory.size() - 1;
                    switch(selection) {
                        case 1:
                            outputChatbox = "How many products will you add to inventory?";
                            System.out.println(outputChatbox);
                            int totalProducts = parser.nextInt();
                            if (totalProducts < 2) {
                                System.exit(-1);
                            }
                            int counterTwo = 0;
                            while (counterTwo < totalProducts) {
                                outputChatbox = "Product #" + counterTwo + 1 + ": Insert the quantity, price and name of the product separated by a comma:";
                                System.out.println(outputChatbox);
                                data = parser.next();
                                dataValues = data.split(",");
                                int quantity = Integer.parseInt(dataValues[0]);
                                double price = Double.parseDouble(dataValues[1]);
                                String name = dataValues[2];
                                Product product = new Product(quantity, price, name);
                                inventory.add(product);
                                outputChatbox = "Product with ID " + counterTwo + " added to inventory successfully.";
                                System.out.println(outputChatbox);
                                counterTwo++;
                            }

                            break;
                        case 2:
                            System.out.println("Products in inventory: ");
                            if (inventory.size() > 0) {
                                for (int i = 0; i < inventory.size(); i++) {
                                    System.out.println("Index: " + i + " " + inventory.get(i));
                                }
                            } else {
                                System.out.println("0 products in the company's inventory.");
                            }
                            break;
                        case 3:
                            System.out.println("Products in inventory: ");
                            if (inventory.size() > 0) {
                                for (int i = 0; i < inventory.size(); i++) {
                                    System.out.println("DELETION INDEX: " + i + " " + inventory.get(i));
                                }
                            } else {
                                System.out.println("0 products in the company's inventory. Cannot delete what does not exist.");
                                System.exit(-1);
                            }
                            outputChatbox = "According to the previous list, insert the INDEX of the product that you want to delete or press 5 to exit:";
                            System.out.println(outputChatbox);
                            selection = parser.nextInt();
                            if (selection == 5) {
                                System.exit(-1);
                            }
                            if (selection >= inventory.size()) {
                                outputChatbox = "Index does not exist. Exiting.";
                                System.out.println(outputChatbox);
                                System.exit(-1);
                            } else {
                                inventory.remove(selection);
                                outputChatbox = "Product with INDEX " + selection + " deleted from inventory successfully.";
                                System.out.println(outputChatbox);
                            }
                            break;
                        case 4:
                            outputChatbox = "EXITING PROGRAM";
                            System.out.println(outputChatbox);
                            System.exit(-1);
                            break;
                    }
                    counter++;
                }
            }
        }
    }
}