import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int elementCount = sc.nextInt();
        int[] myArray = new int[elementCount];

        for (int i = 0; i < elementCount; i++) {
            myArray[i] = sc.nextInt();
        }

        int triplesCount = 0;

        for (int i = 0; i < elementCount - 2; i++) {
            int firstNeighbor = myArray[i + 1];
            int secondNeighbor = myArray[i + 2];

            if (myArray[i] == firstNeighbor - 1 && myArray[i] == secondNeighbor - 2) {
                triplesCount++;
            }
        }

        System.out.println(triplesCount);
    }
}