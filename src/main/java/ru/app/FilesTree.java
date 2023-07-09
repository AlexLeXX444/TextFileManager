package ru.app;

import java.io.File;
import java.util.Objects;

public class FilesTree {
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

    private static void printIndent(int indentLevel) {
        for (int i = 0; i < indentLevel; i++) {
            System.out.print("│  ");
        }
    }
}