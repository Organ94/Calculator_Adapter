import Calculator.IntsCalculator;
import Interfaces.Ints;
import Logger.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    protected static final Scanner SCANNER = new Scanner(System.in);

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        Logger logger = new Logger(new ListStorageAdapter(list));
        Ints intsCalc = new IntsCalculator();
        logger.log("Запуск программы \"Калькулятор\"...");
        logger.log("Программа \"Калькулятор\" запущена\n");
        while (true) {
            System.out.println("Выберите желаемую операцию:");
            System.out.println(Menu());
            System.out.print(">>");
            String inputStr = SCANNER.nextLine().trim();
            int[] arg;
            switch (inputStr) {
                case "1":
                    arg = operands("\"Сумма\"", logger);
                    logger.log("Результат вычисления суммы: " + intsCalc.sum(arg[0], arg[1]) + "\n");
                    break;
                case "2":
                    arg = operands("\"Произведение\"", logger);
                    logger.log("Результат вычисления произведения: " + intsCalc.mult(arg[0], arg[1]) + "\n");
                    break;
                case "3":
                    arg = operands("\"Возведение в степень\"", logger);
                    logger.log("Результат вычисления возведения в степень: " + intsCalc.pow(arg[0], arg[1]) + "\n");
                    break;
                case "4":
                    System.out.println("История операций:\n");
                    for (String value : list) {
                        System.out.println(value);
                    }
                    break;
                case "5":
                    break;
                default:
                    logger.log("Вы ввели " + inputStr +
                            "\nОперации под таким номером не существует\n" +
                            "Попробуйте еще раз!\n");
            }
            if (inputStr.equals("5")) break;
        }
        logger.log("Программа завершена!");
    }

    private static String Menu() {
        return "1. Сумма\n" +
                "2. Произведение\n" +
                "3. Возведение в степень\n" +
                "4. Показать историю операций\n" +
                "5. Выход";
    }

    private static int[] operands(String nameOperation, Logger logger) {
        logger.log("Операция " + nameOperation);
        logger.log("Введите первый и второй операнд через пробел:");
        int[] arg = null;
        try {
            String[] input = SCANNER.nextLine().trim()
                    .replaceAll("\\s+", " ")
                    .split(" ");
            arg = new int[input.length];
            for (int i = 0; i < input.length; i++) {
                arg[i] = Integer.parseInt(input[i]);
            }
            logger.log("Вы ввели " + arg[0] + " и " + arg[1]);
        } catch (NumberFormatException e) {
            logger.log("Неверный формат данных!");
        }
        return arg;
    }
}
