package ru.app;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SearchInFolder {

    /**
     * Проверяет каталог файлов и ищет построчно в каждом файле вхождение полученной строки.
     * Проверяет только файлы с расширением *.txt.
     * @param searchString - принимает на вход строку для поиска.
     */
    public static void searchAllFiles(String searchString) {
        List<String> list = new ArrayList<>();
        File[] dir;
        try {
            File path = new File(new File(".").getCanonicalPath());
            dir = path.listFiles();
            for (File file : dir) {
                if (file.isDirectory())
                    continue;
                if (file.getName().contains(".txt")) {
                    if (SearchInFile.searchString(file.getName(), searchString)) {
                        list.add(file.getName());
                    }
                }
            }
        } catch (IOException e) {
            System.out.println("Нечего проверять!");
        }

        if (!list.isEmpty()) {
            for (String file : list) {
                System.out.println("Найдено в файле: " + file);
            }
        } else {
            System.out.println("Вхождений нет!");
        }
    }
}