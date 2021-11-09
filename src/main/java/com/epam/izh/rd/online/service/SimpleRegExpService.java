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

        String numberRegex = "(\\d{4}\\s+)(\\d{4}\\s+\\d{4})(\\s+\\d{4})";
        Pattern pattern = Pattern.compile(numberRegex);
        Matcher matcher = pattern.matcher(readLine);
        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            matcher.appendReplacement(result, "$1" + "**** ****" + "$3");
        }
        matcher.appendTail(result);

        return result.toString();
    }

    /**
     * Метод должен считыввать файл sensitive_data.txt (из директории resources) и заменять плейсхолдер ${payment_amount} и ${balance} на заданные числа. Метод должен
     * содержать регулярное выражение для поиска плейсхолдеров
     *
     * @return обработанный текст
     */
    @Override
    public String replacePlaceholders(double paymentAmount, double balance) {
        String str = null;
        try(FileReader reader = new FileReader("C:\\data\\java-data-handling-template\\src\\main\\resources\\sensitive_data.txt");
            BufferedReader bufferedReader = new BufferedReader(reader)) {
            str = bufferedReader.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int temp1 = 0;
        int temp2 = 0;
        String strTemp = null;
        String strTemp1 = null;
        String strTemp2 = null;
        String strTemp3 = null;
        String result = null;

        //String accountRegex = "\\d{4}\\s\\d{4}\\s\\d{4}\\s\\d{4}";
        String accountRegex = "(\\d{4}\\s)(\\d{4}\\s\\d{4})(\\s\\d{4})";
        String input = str;
        Pattern pattern = Pattern.compile(accountRegex);
        Matcher matcher = pattern.matcher(input);
        /*while (matcher.find()) {
            temp1 = matcher.start();
            strTemp = matcher.group();
            strTemp1 = matcher.group(1);
            strTemp2 = matcher.group(2);
            strTemp3 = matcher.group(3);
            temp2 = matcher.end();
        }*/

        while (matcher.find()) {
            strTemp = matcher.group();
            strTemp1 = matcher.group();
        }

        Pattern pattern1 = Pattern.compile("\\d4");
        matcher.usePattern(pattern1);

        result = strTemp1 + "**** ****" + strTemp3;

        return str;
    }
}
