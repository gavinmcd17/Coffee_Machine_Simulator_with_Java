import java.util.Arrays;

public class Main {

    // Function to calculate the trapped water
    public static int calculateTrappedWater(int[] wallHeights) {
        // TODO: Iterate over the array and calculate the total volume of water that can be trapped.
        // Hints:
        // - Create two auxiliary arrays leftMax and rightMax to store the height of the tallest wall to the left and right of every wall.
        // - Initialize the first element of leftMax as the first wall, and the last element of rightMax as the last wall.
        // - Compute the remaining elements in both arrays from the given inputs of wallHeights array.
        // - The amount of water at i-th index will be min(leftMax[i], rightMax[i]) - wallHeights[i]. 
        // - Compute total amount of trapped water and return it.

    }

    public static void main(String[] args) {

        // Test case
        // Input array of non-negative integers representing the heights of walls.
        int[] wallHeights = new int[]{/*TODO: Add the wallHeights here*/};

        // Call the method and print the result
        System.out.println(calculateTrappedWater(wallHeights));
    }
}