package ru.app;

import java.util.Random;

/**
 1.  (done) Создать 2 текстовых файла, примерно по 50-100 символов в каждом(особого значения не имеет);
 2.  (done) Написать метод, «склеивающий» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
 3.* (done) Написать метод, который проверяет, присутствует ли указанное пользователем слово в файле (работаем только с латиницей).
 4.* (done) Написать метод, проверяющий, есть ли указанное слово в папке
 */

public class App 
{

    private static final Random random = new Random();

    private static final int FILE_LENGTH = 100; // количество символов в генерируемых файлах.
    private static final String TO_SEARCH = "GeekBrains"; // строка для поиска.

    public static void main( String[] args ) {
        RandomTextFileGenerator.generateFile("file_01.txt", FILE_LENGTH);
        RandomTextFileGenerator.generateFile("file_02.txt", FILE_LENGTH);
        FileConcatenator.concatenateFiles("file_01.txt", "file_02.txt", "file_concate_result.txt");
        SearchInFile.searchString("file_01.txt", TO_SEARCH);
        SearchInFolder.searchAllFiles(".");
        SearchInFolder.searchAllFiles(TO_SEARCH);
    }



}
