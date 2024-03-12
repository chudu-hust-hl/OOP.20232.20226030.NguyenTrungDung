package week1;

import java.util.Arrays;
import java.util.Scanner;

public class numericArray {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();

        double[] numbers = new double[size];

        System.out.println("Enter the array elements:");
        for (int i = 0; i < size; i++) {
            System.out.print("Enter element " + (i + 1) + ": ");
            numbers[i] = scanner.nextDouble();
        }

        Arrays.sort(numbers);

        System.out.println("Sorted array:");
        for (double number : numbers) {
            System.out.print(number + " ");
        }
        System.out.println();

        double sum = 0;
        for (double number : numbers) {
            sum += number;
        }

        double average = sum / numbers.length;
        
        System.out.println("Sum of array elements: " + sum);
        System.out.println("Average value of array elements: " + average);

        scanner.close();
    }
}
