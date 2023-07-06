package ru.app;

import java.io.*;

public class SearchInFile {

    /**
     * Ищет вхождление строки файле, перебирая его построчно.
     *
     * @param fileName     - имя файла в котором будем искать;
     * @param searchString - строка, которую будем искать;
     */
    public static boolean searchString(String fileName, String searchString) {
        File file = new File(fileName);

        try(BufferedReader reader = new BufferedReader(new FileReader(file))) {
            for(String line : reader.lines().toList()) {
                if(line.contains(searchString)) {
                    //System.out.println("Строка найдена");
                    return true;
                }
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла!");
        }

        //System.out.println("Строка не найдена.");
        return false;
    }
}
