import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // put your code here
        // You can use scanner.nextBoolean() to read a boolean value

        int numCups = scanner.nextInt();

        boolean isWeekend = scanner.nextBoolean();

        boolean isSuccessful = checkPartySuccess(numCups, isWeekend);
        System.out.println(isSuccessful);
    }

    public static boolean checkPartySuccess(int numCups, boolean isWeekend) {
        if (isWeekend) {
            return numCups >= 15 && numCups <= 25;
        } else {
            return numCups >= 10 && numCups <= 20;
        }
    }
}