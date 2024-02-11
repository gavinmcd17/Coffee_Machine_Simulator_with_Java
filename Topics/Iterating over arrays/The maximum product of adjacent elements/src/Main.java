import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int elementNumber = sc.nextInt();
        int[] myArray = new int[elementNumber];

        sc.nextLine();

        String[] elements = sc.nextLine().split(" ");

        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = Integer.parseInt(elements[i]);
        }

        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < elementNumber - 1; i++) {
            int product = myArray[i] * myArray[i + 1];
            if (product > maxProduct) {
                maxProduct = product;
            }
        }

        System.out.println(maxProduct);
    }
}