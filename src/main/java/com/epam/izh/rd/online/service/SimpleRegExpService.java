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
        String readLine = null;
        try (FileReader reader = new FileReader("C:\\data\\java-data-handling-template\\src\\main\\resources\\sensitive_data.txt");
             BufferedReader bufferedReader = new BufferedReader(reader)) {
            readLine = bufferedReader.readLine();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String placeholdersRegex = "\\$\\{payment_amount\\}";
        Pattern pattern = Pattern.compile(placeholdersRegex);
        Matcher matcher = pattern.matcher(readLine);
        StringBuffer result = new StringBuffer();

        while (matcher.find()) {
            matcher.appendReplacement(result, "2");
        }

        matcher.appendTail(result);

        return result.toString();
    }
}
