import java.util.Scanner;

public class Level1 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Voting Eligibility");
            System.out.println("2. Number Check");
            System.out.println("3. Multiplication Table (1–10)");
            System.out.println("4. Store Numbers & Sum");
            System.out.println("5. Table from 6 to 9");
            System.out.println("6. Mean Height");
            System.out.println("7. Odd & Even Arrays");
            System.out.println("8. Factors of Number");
            System.out.println("9. 2D to 1D Array");
            System.out.println("10. FizzBuzz");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1: ageVoting(); break;
                case 2: numberCheck(); break;
                case 3: multiplicationTable(); break;
                case 4: storeNumbers(); break;
                case 5: table6to9(); break;
                case 6: meanHeight(); break;
                case 7: oddEvenArray(); break;
                case 8: factorsOfNumber(); break;
                case 9: twoDToOneD(); break;
                case 10: fizzBuzz(); break;
                case 0:
                    System.out.println("Exiting program...");
                    return;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    // 1. Voting eligibility
    public static void ageVoting() {
        int[] ages = new int[10];
        System.out.println("Enter ages of 10 students:");
        for (int i = 0; i < ages.length; i++)
            ages[i] = sc.nextInt();

        for (int age : ages) {
            if (age < 0)
                System.out.println("Invalid age");
            else if (age >= 18)
                System.out.println("Age " + age + " can vote");
            else
                System.out.println("Age " + age + " cannot vote");
        }
    }

    // 2. Number check
    public static void numberCheck() {
        int[] arr = new int[5];
        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < arr.length; i++)
            arr[i] = sc.nextInt();

        for (int num : arr) {
            if (num > 0) {
                if (num % 2 == 0)
                    System.out.println(num + " is positive and even");
                else
                    System.out.println(num + " is positive and odd");
            } else if (num < 0)
                System.out.println(num + " is negative");
            else
                System.out.println("Number is zero");
        }

        if (arr[0] == arr[4])
            System.out.println("First and last are equal");
        else if (arr[0] > arr[4])
            System.out.println("First is greater");
        else
            System.out.println("Last is greater");
    }

    // 3. Multiplication table
    public static void multiplicationTable() {
        System.out.println("Enter number:");
        int num = sc.nextInt();

        for (int i = 1; i <= 10; i++)
            System.out.println(num + " * " + i + " = " + (num * i));
    }

    // 4. Store numbers
    public static void storeNumbers() {
        double[] arr = new double[10];
        double total = 0;
        int index = 0;

        System.out.println("Enter numbers (stop with 0 or negative):");

        while (true) {
            double num = sc.nextDouble();
            if (num <= 0 || index == 10)
                break;

            arr[index++] = num;
        }

        for (int i = 0; i < index; i++) {
            System.out.println(arr[i]);
            total += arr[i];
        }

        System.out.println("Total = " + total);
    }

    // 5. Table 6 to 9
    public static void table6to9() {
        System.out.println("Enter number:");
        int num = sc.nextInt();

        for (int i = 6; i <= 9; i++)
            System.out.println(num + " * " + i + " = " + (num * i));
    }

    // 6. Mean height
    public static void meanHeight() {
        double[] heights = new double[11];
        double sum = 0;

        System.out.println("Enter 11 heights:");
        for (int i = 0; i < heights.length; i++) {
            heights[i] = sc.nextDouble();
            sum += heights[i];
        }

        System.out.println("Mean height = " + (sum / heights.length));
    }

    // 7. Odd and even arrays
    public static void oddEvenArray() {
        System.out.println("Enter a natural number:");
        int n = sc.nextInt();

        if (n <= 0) {
            System.out.println("Invalid input");
            return;
        }

        int[] odd = new int[n / 2 + 1];
        int[] even = new int[n / 2 + 1];
        int oi = 0, ei = 0;

        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0)
                even[ei++] = i;
            else
                odd[oi++] = i;
        }

        System.out.print("Odd: ");
        for (int i = 0; i < oi; i++)
            System.out.print(odd[i] + " ");

        System.out.print("\nEven: ");
        for (int i = 0; i < ei; i++)
            System.out.print(even[i] + " ");
    }

    // 8. Factors
    public static void factorsOfNumber() {
        System.out.println("Enter number:");
        int num = sc.nextInt();

        int[] factors = new int[100];
        int index = 0;

        for (int i = 1; i <= num; i++) {
            if (num % i == 0)
                factors[index++] = i;
        }

        System.out.print("Factors: ");
        for (int i = 0; i < index; i++)
            System.out.print(factors[i] + " ");
    }

    // 9. 2D to 1D
    public static void twoDToOneD() {
        System.out.println("Enter rows and columns:");
        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] matrix = new int[r][c];

        System.out.println("Enter elements:");
        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                matrix[i][j] = sc.nextInt();

        int[] arr = new int[r * c];
        int index = 0;

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                arr[index++] = matrix[i][j];

        System.out.print("1D array: ");
        for (int num : arr)
            System.out.print(num + " ");
    }

    // 10. FizzBuzz
    public static void fizzBuzz() {
        System.out.println("Enter number:");
        int n = sc.nextInt();

        for (int i = 0; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0)
                System.out.println("Position " + i + " = FizzBuzz");
            else if (i % 3 == 0)
                System.out.println("Position " + i + " = Fizz");
            else if (i % 5 == 0)
                System.out.println("Position " + i + " = Buzz");
            else
                System.out.println("Position " + i + " = " + i);
        }
    }
}