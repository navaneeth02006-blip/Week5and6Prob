import java.util.Scanner;

public class level2 {

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== LEVEL 2 MENU =====");
            System.out.println("1. Employee Bonus");
            System.out.println("2. Youngest & Tallest Friend");
            System.out.println("3. Largest & Second Largest Digit");
            System.out.println("4. Dynamic Digit Array");
            System.out.println("5. Reverse Number");
            System.out.println("6. BMI (1D Arrays)");
            System.out.println("7. BMI (2D Arrays)");
            System.out.println("8. Student Grades (1D)");
            System.out.println("9. Student Grades (2D)");
            System.out.println("10. Digit Frequency");
            System.out.println("0. Exit");

            int choice = sc.nextInt();

            switch (choice) {
                case 1: employeeBonus(); break;
                case 2: friends(); break;
                case 3: largestDigits(); break;
                case 4: dynamicDigits(); break;
                case 5: reverseNumber(); break;
                case 6: bmi1D(); break;
                case 7: bmi2D(); break;
                case 8: grades1D(); break;
                case 9: grades2D(); break;
                case 10: digitFrequency(); break;
                case 0: return;
                default: System.out.println("Invalid choice");
            }
        }
    }

    // 1. Employee Bonus
    public static void employeeBonus() {
        double[] salary = new double[10];
        double[] years = new double[10];
        double[] bonus = new double[10];
        double[] newSalary = new double[10];

        double totalBonus = 0, totalOld = 0, totalNew = 0;

        for (int i = 0; i < 10; i++) {
            System.out.println("Enter salary and years:");
            salary[i] = sc.nextDouble();
            years[i] = sc.nextDouble();

            if (salary[i] < 0 || years[i] < 0) {
                System.out.println("Invalid input, re-enter");
                i--;
                continue;
            }
        }

        for (int i = 0; i < 10; i++) {
            if (years[i] > 5)
                bonus[i] = salary[i] * 0.05;
            else
                bonus[i] = salary[i] * 0.02;

            newSalary[i] = salary[i] + bonus[i];

            totalBonus += bonus[i];
            totalOld += salary[i];
            totalNew += newSalary[i];
        }

        System.out.println("Total Bonus: " + totalBonus);
        System.out.println("Total Old Salary: " + totalOld);
        System.out.println("Total New Salary: " + totalNew);
    }

    // 2. Friends
    public static void friends() {
        String[] names = {"Amar", "Akbar", "Anthony"};
        int[] age = new int[3];
        double[] height = new double[3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter age and height of " + names[i]);
            age[i] = sc.nextInt();
            height[i] = sc.nextDouble();
        }

        int minAgeIndex = 0, maxHeightIndex = 0;

        for (int i = 1; i < 3; i++) {
            if (age[i] < age[minAgeIndex])
                minAgeIndex = i;
            if (height[i] > height[maxHeightIndex])
                maxHeightIndex = i;
        }

        System.out.println("Youngest: " + names[minAgeIndex]);
        System.out.println("Tallest: " + names[maxHeightIndex]);
    }

    // 3. Largest & second largest digit
    public static void largestDigits() {
        int num = sc.nextInt();
        int[] digits = new int[10];
        int index = 0;

        while (num != 0 && index < 10) {
            digits[index++] = num % 10;
            num /= 10;
        }

        int max = 0, second = 0;

        for (int i = 0; i < index; i++) {
            if (digits[i] > max) {
                second = max;
                max = digits[i];
            } else if (digits[i] > second && digits[i] != max) {
                second = digits[i];
            }
        }

        System.out.println("Largest: " + max);
        System.out.println("Second Largest: " + second);
    }

    // 4. Dynamic digit array
    public static void dynamicDigits() {
        int num = sc.nextInt();
        int max = 10;
        int[] digits = new int[max];
        int index = 0;

        while (num != 0) {
            if (index == max) {
                max += 10;
                int[] temp = new int[max];
                for (int i = 0; i < digits.length; i++)
                    temp[i] = digits[i];
                digits = temp;
            }

            digits[index++] = num % 10;
            num /= 10;
        }

        int maxVal = 0, second = 0;

        for (int i = 0; i < index; i++) {
            if (digits[i] > maxVal) {
                second = maxVal;
                maxVal = digits[i];
            } else if (digits[i] > second && digits[i] != maxVal) {
                second = digits[i];
            }
        }

        System.out.println("Largest: " + maxVal);
        System.out.println("Second Largest: " + second);
    }

    // 5. Reverse number
    public static void reverseNumber() {
        int num = sc.nextInt();
        int temp = num, count = 0;

        while (temp != 0) {
            count++;
            temp /= 10;
        }

        int[] digits = new int[count];
        temp = num;

        for (int i = 0; i < count; i++) {
            digits[i] = temp % 10;
            temp /= 10;
        }

        System.out.print("Reversed: ");
        for (int i = 0; i < count; i++)
            System.out.print(digits[i]);
    }

    // 6. BMI 1D
    public static void bmi1D() {
        int n = sc.nextInt();
        double[] weight = new double[n];
        double[] height = new double[n];
        double[] bmi = new double[n];
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextDouble();
            height[i] = sc.nextDouble();

            bmi[i] = weight[i] / (height[i] * height[i]);

            if (bmi[i] < 18.5)
                status[i] = "Underweight";
            else if (bmi[i] < 25)
                status[i] = "Normal";
            else
                status[i] = "Overweight";
        }

        for (int i = 0; i < n; i++) {
            System.out.println(weight[i] + " " + height[i] + " " + bmi[i] + " " + status[i]);
        }
    }

    // 7. BMI 2D
    public static void bmi2D() {
        int n = sc.nextInt();
        double[][] data = new double[n][3];
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            data[i][0] = sc.nextDouble(); // weight
            data[i][1] = sc.nextDouble(); // height

            data[i][2] = data[i][0] / (data[i][1] * data[i][1]);

            if (data[i][2] < 18.5)
                status[i] = "Underweight";
            else if (data[i][2] < 25)
                status[i] = "Normal";
            else
                status[i] = "Overweight";
        }

        for (int i = 0; i < n; i++) {
            System.out.println(data[i][0] + " " + data[i][1] + " " + data[i][2] + " " + status[i]);
        }
    }

    // 8. Grades 1D
    public static void grades1D() {
        int n = sc.nextInt();

        double[] percent = new double[n];
        String[] grade = new String[n];

        for (int i = 0; i < n; i++) {
            int p = sc.nextInt();
            int c = sc.nextInt();
            int m = sc.nextInt();

            percent[i] = (p + c + m) / 3.0;

            if (percent[i] >= 90) grade[i] = "A";
            else if (percent[i] >= 75) grade[i] = "B";
            else if (percent[i] >= 50) grade[i] = "C";
            else grade[i] = "Fail";
        }

        for (int i = 0; i < n; i++)
            System.out.println(percent[i] + " " + grade[i]);
    }

    // 9. Grades 2D
    public static void grades2D() {
        int n = sc.nextInt();
        int[][] marks = new int[n][3];
        double[] percent = new double[n];
        String[] grade = new String[n];

        for (int i = 0; i < n; i++) {
            marks[i][0] = sc.nextInt();
            marks[i][1] = sc.nextInt();
            marks[i][2] = sc.nextInt();

            percent[i] = (marks[i][0] + marks[i][1] + marks[i][2]) / 3.0;

            if (percent[i] >= 90) grade[i] = "A";
            else if (percent[i] >= 75) grade[i] = "B";
            else if (percent[i] >= 50) grade[i] = "C";
            else grade[i] = "Fail";
        }

        for (int i = 0; i < n; i++)
            System.out.println(percent[i] + " " + grade[i]);
    }

    // 10. Digit frequency
    public static void digitFrequency() {
        int num = sc.nextInt();
        int[] freq = new int[10];

        while (num != 0) {
            int d = num % 10;
            freq[d]++;
            num /= 10;
        }

        for (int i = 0; i < 10; i++) {
            if (freq[i] > 0)
                System.out.println(i + " -> " + freq[i]);
        }
    }
}