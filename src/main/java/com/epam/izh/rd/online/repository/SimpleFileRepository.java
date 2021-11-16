package com.epam.izh.rd.online.repository;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

public class SimpleFileRepository implements FileRepository {

    /**
     * Метод рекурсивно подсчитывает количество файлов в директории
     *
     * @param path путь до директори
     * @return файлов, в том числе скрытых
     */
    @Override
    public long countFilesInDirectory(String path) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(path);
        File dir = new File(resource.getPath());

        File[] files = dir.listFiles();
        long count = 0;
        long l = 0;
        String str = null;
        String str2 = null;
        String str3 = null;

        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                File file = files[i];

                if (file.isFile()) {
                    count++;
                }

                if (file.isDirectory()) {
                    str = file.getPath();
                    str2 = file.getParent();
                    /*try {
                        str2 = URLDecoder.decode(file.getPath(), StandardCharsets.UTF_8.toString());
                    } catch (UnsupportedEncodingException e) {
                        e.printStackTrace();
                    }*/
                    str3 = path + "/" + file.getName();
                }
                    count += countFilesInDirectory(str3);
                }
            }

        return count;
    }

    /*private long getFile(File[] files, long count) {

        if (files != null)

        for (File f : files) {
            count++;
            File file = f;

                if (f.isDirectory()) {
                    //count += dir.listFiles().length;
                    getFile(file, count);
                } else {
                    count++;
                }
            }

        return count;
    }*/


    /**
     * Метод рекурсивно подсчитывает количество папок в директории, считая корень
     *
     * @param path путь до директории
     * @return число папок
     */
    @Override
    public long countDirsInDirectory(String path) {
        return 0;
    }

    /**
     * Метод копирует все файлы с расширением .txt
     *
     * @param from путь откуда
     * @param to   путь куда
     */
    @Override
    public void copyTXTFiles(String from, String to) {
        return;
    }

    /**
     * Метод создает файл на диске с расширением txt
     *
     * @param path путь до нового файла
     * @param name имя файла
     * @return был ли создан файл
     */
    @Override
    public boolean createFile(String path, String name) {
        return false;
    }

    /**
     * Метод считывает тело файла .txt из папки src/main/resources
     *
     * @param fileName имя файла
     * @return контент
     */
    @Override
    public String readFileFromResources(String fileName) {
        return null;
    }
}
