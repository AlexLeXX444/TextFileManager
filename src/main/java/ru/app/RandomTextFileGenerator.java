package ru.app;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomTextFileGenerator {
    /**
     * Создаёт файл и заполняет его символами латиницы в верхнем и нижнем регистре.
     * @param fileName - принимает строку - имя файла;
     * @param characterCount - принимает число - количество символов, которое запишем в файл;
     */
    public static void generateFile(String fileName, int characterCount){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));

            for (int i = 0; i < characterCount; i++) {
                char randomChar = getRandomCharacter();
                writer.write(randomChar);
            }

            writer.close();
            System.out.println("Файл успешно создан: " + fileName);
        } catch (IOException e) {
            System.out.println("Ошибка при создании файла.");
        }
    }

    /**
     * Возвращает случайный символ латиницы в верхнем или нижнем регистре.
     * @return - возвращает символ.
     */
    private static char getRandomCharacter() {
        Random random = new Random();
        boolean useUpperCase = random.nextBoolean();
        if (useUpperCase) {
            return (char) (random.nextInt(26) + 'A');
        } else {
            return (char) (random.nextInt(26) + 'a');
        }
    }
}
