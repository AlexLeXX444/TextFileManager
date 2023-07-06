package ru.app;

import java.io.*;

public class FileConcatenator {

    /**
     * Создаёт файл содержащий склееное содержимое двух файлов.
     * Сначала идёт всё содержимое первого файла, затем второго.
     * @param firstFile - имя первого файла.
     * @param secondFile - имя второго файла.
     * @param outputFile - имя результирующего нового файла.
     */
    public static void concatenateFiles(String firstFile, String secondFile, String outputFile) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            appendFileContents(firstFile, writer);
            appendFileContents(secondFile, writer);

            writer.close();
            System.out.println("Файлы успешно объединены в " + outputFile);
        } catch (IOException e) {
            System.out.println("Ошибка при объединении файлов.");
        }
    }

    /**
     * Считываем построчно все символы из файла и записываем в переданный буфер.
     * @param filePath - получает на вход имя файла.
     * @param writer - получает на вход активный буфер.
     * @throws IOException - может выкинуть исключение.
     */
    private static void appendFileContents(String filePath, BufferedWriter writer) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filePath));
        String line;

        while ((line = reader.readLine()) != null) {
            writer.write(line);
        }

        reader.close();
    }

}
