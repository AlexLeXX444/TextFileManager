package ru.app;

import java.io.File;
import java.util.Objects;

public class FilesTree {

    /**
     * Проверяет, является ли указанный каталог директориеё и существует ли вообще.
     * @param dir путь к каталогу в виде строки;
     * @param indentLevel уровень вложения, начальный указать "0".
     */
    public static void printDirectoryTree(String dir, int indentLevel) {
        File directory = new File(dir);

        if (!directory.exists()) {
            System.out.println("Неверно указан путь.");
            return;
        }
        if (!directory.isDirectory()) {
            System.out.println("Указали на файл.");
            return;
        }

        printDirectoryTree(directory, indentLevel);
    }

    /**
     * Метод отображает в консоли дерево каталогов.
     * @param directory путь к каталогу в виде строки;
     * @param indentLevel уровень вложенности, относительно которого отображаются отступы.
     */
    private static void printDirectoryTree(File directory, int indentLevel) {
        File[] files = directory.listFiles();

        for (int i = 0; i < Objects.requireNonNull(files).length; i++) {
            File file = files[i];

            printIndent(indentLevel);

            if (i == files.length - 1) {
                System.out.println("└── " + file.getName());
                if (file.isDirectory()) {
                    printDirectoryTree(file, indentLevel + 1);
                }
            } else {
                System.out.println("├── " + file.getName());
                if (file.isDirectory()) {
                    printDirectoryTree(file, indentLevel + 1);
                }
            }
        }
    }

    /**
     * Распечатывает отступ с вертикальной чертой.
     * @param indentLevel на вход получает целое число, сколько раз распечатать.
     */
    private static void printIndent(int indentLevel) {
        for (int i = 0; i < indentLevel; i++) {
            System.out.print("│  ");
        }
    }
}