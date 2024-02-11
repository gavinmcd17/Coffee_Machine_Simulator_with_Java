package machine;
import java.util.Scanner;

public class CoffeeMachine {
    private static int cashAmount = 550;
    private static int waterAmount = 400;
    private static int milkAmount = 540;
    private static int beanAmount = 120;
    private static int cupAmount = 9;

    public static void displayContents() {
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(waterAmount + " ml of water");
        System.out.println(milkAmount + " ml of milk");
        System.out.println(beanAmount + " g of coffee beans");
        System.out.println(cupAmount + " disposable cups");
        System.out.println("$" + cashAmount + " of money");
        System.out.println();
    }

    public static void buyCoffee(Scanner scanner) {
        System.out.println();
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, " +
                "back - to main menu:");
        String coffeeChoice = scanner.next();

        switch (coffeeChoice) {
            case "1" -> processCoffeeOrder(250, 0, 16,
                    4);
            case "2" -> processCoffeeOrder(350, 75, 20,
                    7);
            case "3" -> processCoffeeOrder(200, 100, 12,
                    6);
            case "back" -> { }
            default -> System.out.println("Invalid choice!");
        }
    }

    private static void processCoffeeOrder(int waterNeeded, int milkNeeded, int beansNeeded,
                                           int cashEarned) {
        if (hasEnoughResources(waterNeeded, milkNeeded, beansNeeded)) {
            System.out.println("I have enough resources, making you a coffee!");
            updateResources(waterNeeded, milkNeeded, beansNeeded, cashEarned);
            cupAmount--;
        } else {
            displayResourceShortage(waterNeeded, milkNeeded, beansNeeded);
        }
    }

    private static boolean hasEnoughResources(int waterNeeded, int milkNeeded, int beansNeeded) {
        return waterAmount - waterNeeded >= 0 && milkAmount - milkNeeded >= 0 && beanAmount -
                beansNeeded >= 0;
    }

    private static void updateResources(int waterNeeded, int milkNeeded, int beansNeeded,
                                        int cashEarned) {
        waterAmount -= waterNeeded;
        milkAmount -= milkNeeded;
        beanAmount -= beansNeeded;
        cashAmount += cashEarned;
    }

    private static void displayResourceShortage(int waterNeeded, int milkNeeded, int beansNeeded) {
        if (waterAmount - waterNeeded < 0) {
            System.out.println("Not enough water!");
        } else if (milkAmount - milkNeeded < 0) {
            System.out.println("Not enough milk!");
        } else {
            System.out.println("Not enough coffee beans!");
        }
    }



    public static void fillMachine(Scanner scanner) {
        System.out.println("Write how many ml of water you want to add:");
        waterAmount += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milkAmount += scanner.nextInt();
        System.out.println("Write how many grams of coffee bean you want to add:");
        beanAmount += scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        cupAmount += scanner.nextInt();
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean machineOn = true;

        while (machineOn) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String userInput = scanner.next();

            switch (userInput) {
                case "buy" -> {
                    buyCoffee(scanner);
                }
                case "fill" -> {
                    fillMachine(scanner);
                }
                case "take" -> {
                    System.out.println("I gave you " + cashAmount);
                    cashAmount -= cashAmount;
                }
                case "remaining" -> {
                    displayContents();
                }
                case "exit" -> {
                    machineOn = false;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}