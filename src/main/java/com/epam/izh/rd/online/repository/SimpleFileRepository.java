package com.epam.izh.rd.online.repository;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

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
        File dir = null;
        if (resource != null) {
            dir = new File(resource.getPath());
        } else {
            dir = new File(path);
        }

        File[] files = dir.listFiles();
        long count = 0;

        if (files != null) {
            for (int i = 0; i < files.length; i++) {
                File file = files[i];

                if (file.isFile()) {
                    count++;
                }

                if (file.isDirectory()) {
                    count += countFilesInDirectory(file.getPath());
                }

            }
        }

        return count;
    }

    /**
     * Метод рекурсивно подсчитывает количество папок в директории, считая корень
     *
     * @param path путь до директории
     * @return число папок
     */
    @Override
    public long countDirsInDirectory(String path) {
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(path);
        File dir = null;
        long count = 0;
        if (resource != null) {
            dir = new File(resource.getPath());
            count++;
        } else {
            dir = new File(path);
        }

        File[] files = dir.listFiles();

        if (files != null) {
            File file = null;
            for (int i = 0; i < files.length; i++) {
                file = files[i];

                if (file.isDirectory()) {
                    count++;
                    count += countDirsInDirectory(file.getPath());
                }

            }
        }

        return count;
    }

    /**
     * Метод копирует все файлы с расширением .txt
     *
     * @param from путь откуда
     * @param to   путь куда
     */
    @Override
    public void copyTXTFiles(String from, String to) {
        String filePathFrom = new File(from).getAbsolutePath();
        String filePathTo = new File(to).getAbsolutePath();

        Path fromPath = Paths.get(filePathFrom);
        Path toPath = Paths.get(filePathTo);

        File dir = new File(filePathTo);
        String parent = dir.getParent();

        File dirExists = new File(parent);
        if (dirExists.exists()) {
            try {
                Files.copy(fromPath, toPath, StandardCopyOption.COPY_ATTRIBUTES);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            boolean mkdir = dirExists.mkdir();
            if (mkdir == true) {
                try {
                    Files.copy(fromPath, toPath, StandardCopyOption.COPY_ATTRIBUTES);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

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
        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource(path);
        File dir = new File(resource.getPath());

        File file = new File( dir.toString() + "\\" + name);
        String strPathFile = file.getAbsolutePath();
        File pathFile = new File(strPathFile);

        boolean result = false;

        try {
            result = pathFile.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    /**
     * Метод считывает тело файла .txt из папки src/main/resources
     *
     * @param fileName имя файла
     * @return контент
     */
    @Override
    public String readFileFromResources(String fileName) {
        File file = new File(
                getClass().getClassLoader().getResource(fileName).getFile()
        );

        String pathFile = file.toString();

        String readLine = null;
        try {
            FileReader reader = new FileReader(pathFile);
            BufferedReader bufferedReader = new BufferedReader(reader);
            readLine = bufferedReader.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return readLine;
    }
}
