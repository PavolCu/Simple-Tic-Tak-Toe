import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        boolean result = checkNumbers();
        System.out.println(result);
    }

    public static boolean checkNumbers() {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();

        String[] numberStrings = input.split(" ");
        double[] numbers = new double[numberStrings.length];

        for (int i = 0; i < numberStrings.length; i++) {
            numbers[i] = Double.parseDouble(numberStrings[i]);
        }

        scanner.close();

        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] == numbers[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}


