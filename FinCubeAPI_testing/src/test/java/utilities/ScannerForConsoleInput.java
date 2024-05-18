package utilities;

import java.util.Scanner;

public class ScannerForConsoleInput {

    public static String getConsoleInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите строку: ");
        String userInput = scanner.nextLine();
        return userInput;
    }
}
