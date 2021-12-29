import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final int SIZE = 8;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[][] colors = new int [SIZE][SIZE];
        Random random = new Random();
        for (int i = 0; i< SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                colors[i][j] = random.nextInt(256);
            }
        }

        System.out.println("Наша случайная матрица");
        System.out.println("--------------------");
        printMatrix(colors); // здесь мы распечатываем нашу случайную матрицу
        System.out.println("--------------------");

        while(true) {
            System.out.println("Введите 90/180/270, чтобы преобразовать эту матрицу:");

            String input = scanner.nextLine(); // вводим нужный вариант угла

            if ("end".equals(input)) {
                break;
            }

            int[][] rotatedColors = new int[SIZE][SIZE]; // наша новая матрица для вращения
            for (int i = 0; i < SIZE; i++) {
                for (int j = 0; j < SIZE; j++) {
                    switch (input) {
                        case "90":
                            rotatedColors[i][j] = colors[SIZE - 1 - j][i];
                            break;

                        case "180":
                            rotatedColors[i][j] = colors[SIZE - 1 - i][SIZE - 1 - j];
                            break;

                        case "270":
                            rotatedColors[i][j] = colors[j][SIZE - 1 - i];
                            break;

                        default:
                            break;
                    }
                }
            }
            System.out.println("Дана следующая матрица:");
            printMatrix(colors); // исходная матрица
            System.out.println("Вывод:");
            printMatrix(rotatedColors); // здесь мы распечатываем повернутую матрицу в зависимости от выбранного угла
            System.out.println("--------------------");
        }
        System.out.println("Программа закрыта!"); // выход из программы
    }

    private static void printMatrix(int[][] colors) { // метод для создания матрицы
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                System.out.format("%4d", colors[i][j]);
            }
            System.out.println();
        }
    }
}
