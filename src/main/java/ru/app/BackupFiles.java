package ru.app;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BackupFiles {

    /**
     * Создаёт копии файлов с расширением *.txt в отдельную папку backup_txt.
     * @param directory принимает на вход путь до целевой директории.
     */
    public static void backupFilesTxt(String directory) {
        new File(directory + "/backup_txt").mkdir();

        List<String> list = new ArrayList<>();
        File[] dir;
        try {
            File path = new File(new File(".").getCanonicalPath());
            dir = path.listFiles();
            for (File file : dir) {
                if (file.isDirectory())
                    continue;
                if (file.getName().endsWith(".txt")) {
                    list.add(file.getName());
                }
            }
        } catch (IOException e) {
            System.out.println("Нет подходящих файлов для создания резервной копии!");
        }

        try {
            SimpleDateFormat formatForDateNow = new SimpleDateFormat("dd.MM.yyyy");
            String currentDate = formatForDateNow.format(new Date()).replace(".", "_");
            for (String file : list) {
                BufferedReader reader = new BufferedReader(new FileReader(directory + "/" + file));
                new File("/backup_txt/" + currentDate + "_" + file);
                BufferedWriter writer = new BufferedWriter(new FileWriter(directory + "/backup_txt/" + currentDate + "_" + file));

                for (String line : reader.lines().toList()) {
                    writer.write(line);
                    writer.write(System.getProperty("line.separator"));
                }

                reader.close();
                writer.close();
            }

            if (list.isEmpty()) {
                System.out.println("Нечего сохранять, целевая директория пуста.");
            } else {
                System.out.println("Резервные копии успешно созданы!");
            }
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла.");
            e.printStackTrace();
        }
    }
}
