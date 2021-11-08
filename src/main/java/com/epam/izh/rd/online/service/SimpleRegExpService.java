package com.epam.izh.rd.online.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SimpleRegExpService implements RegExpService {

    /**
     * Метод должен читать файл sensitive_data.txt (из директории resources) и маскировать в нем конфиденциальную информацию.
     * Номер счета должен содержать только первые 4 и последние 4 цифры (1234 **** **** 5678). Метод должен содержать регулярное
     * выражение для поиска счета.
     *
     * @return обработанный текст
     */
    @Override
    public String maskSensitiveData() {
        String readLine = null;
        try (FileReader reader = new FileReader("C:\\data\\java-data-handling-template\\src\\main\\resources\\sensitive_data.txt");
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            readLine = bufferedReader.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String numberRegex = "\\d{4}\\s+\\d{4}\\s+\\d{4}\\s+\\d{4}";
        Pattern pattern = Pattern.compile(numberRegex);
        Matcher matcher = pattern.matcher(readLine);
        int nAccountNumbers = 0;
        int temp = 0;
        int temp2 = 0;
        String tempStr = null;
        String tempStr2 = null;


        while (matcher.find()) {
            temp = matcher.start();
            tempStr = matcher.group();
            temp2 = matcher.end();
            nAccountNumbers++;
        }

        /*String numberRegex2 = "\\d";
        Pattern pattern2 = Pattern.compile(numberRegex2);
        Matcher matcher2 = pattern2.matcher(tempStr);*/

        String str2 = new String(tempStr);
        str2 = str2.replaceAll("\\s+\\d{4}\\s+", "*");

        /*while (matcher2.find()) {
            tempStr2 = matcher2.group();
        }

        String[] arrayAccount = new String[nAccountNumbers];*/

        return readLine;
    }

    /**
     * Метод должен считыввать файл sensitive_data.txt (из директории resources) и заменять плейсхолдер ${payment_amount} и ${balance} на заданные числа. Метод должен
     * содержать регулярное выражение для поиска плейсхолдеров
     *
     * @return обработанный текст
     */
    @Override
    public String replacePlaceholders(double paymentAmount, double balance) {
        return null;
    }
}
