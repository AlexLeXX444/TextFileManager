package ru.app;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 1.  (done) Создать 2 текстовых файла, примерно по 50-100 символов в каждом(особого значения не имеет);
 2.  (done) Написать метод, «склеивающий» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго;
 3.* (done) Написать метод, который проверяет, присутствует ли указанное пользователем слово в файле (работаем только с латиницей);
 4.* (done) Написать метод, проверяющий, есть ли указанное слово в папке.
 */

/**
 * 1. Написать функцию, создающую резервную копию всех файлов в директории(без поддиректорий) во вновь созданную папку ./backup;
 * 2. Доработайте класс Tree и метод print который мы разработали на семинаре. Ваш метод должен распечатать полноценно
 *    дерево директорий и файлов относительно корневой директории;
 * 3***. Предположить, что числа в исходном массиве из 9 элементов имеют диапазон[0, 3] и представляют собой, например,
 *       состояния ячеек поля для игры в крестикинолики, где
 *          0 – это пустое поле,
 *          1 – это поле с крестиком,
 *          2 – это поле с ноликом,
 *          3 – резервное значение.
 *       Такое предположение позволит хранить в одном числе типа int всё поле 3х3.
 *       Записать в файл 9 значений так, чтобы они заняли три байта.
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
        BackupFiles.backupFilesTxt(".");
    }



}
