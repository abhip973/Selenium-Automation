package JavaConcepts;

import java.util.Scanner;

public class Arrays {
    public static void main(String[] args) {

//        Problem 1: Take an array of names as input from the user and print them on the screen.
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the size of the array");
        int size = sc.nextInt();

        String[] names = new String[size];

        //input
        for (int i = 0; i < size; i++) {
            System.out.println("Please enter the name " + i);
            names[i] = sc.next();
        }

        //output
        for (int i = 0; i < size; i++) {
            System.out.println("The name of " + i + " index is: ");
            System.out.println(names[i]);
        }

        maxMin();

    }

    public static void maxMin() {
        //        Problem 2: Find the maximum & minimum number in an array of integers.
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the size: ");
        int size = sc.nextInt();

        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            numbers[i] = sc.nextInt();
        }
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;

        System.out.println("Max integer value is: " + max + " Min integer value is: " + min);

        for (int i = 0; i < size; i++) {
            if (numbers[i] < min) {
                min = numbers[i];
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }

            System.out.println("Largest number is: " + max);
            System.out.println("Smallest number is: " + min);

        }
    }
}
