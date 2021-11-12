package com.epam.izh.rd.online.service;

public class SimpleTextService implements TextService {

    /**
     * Реализовать функционал удаления строки из другой строки.
     *
     * Например для базовой строки "Hello, hello, hello, how low?" и строки для удаления ", he"
     * метод вернет "Hellollollo, how low?"
     *
     * @param base - базовая строка с текстом
     * @param remove - строка которую необходимо удалить
     */
    @Override
    public String removeString(String base, String remove) {
        return base.replaceAll(remove, ""); //TODO
    }

    /**
     * Реализовать функционал проверки на то, что строка заканчивается знаком вопроса.
     *
     * Например для строки "Hello, hello, hello, how low?" метод вернет true
     * Например для строки "Hello, hello, hello!" метод вернет false
     */
    @Override
    public boolean isQuestionString(String text) {
        return text.endsWith("?"); //TODO
    }

    /**
     * Реализовать функционал соединения переданных строк.
     *
     * Например для параметров {"Smells", " ", "Like", " ", "Teen", " ", "Spirit"}
     * метод вернет "Smells Like Teen Spirit"
     */
    @Override
    public String concatenate(String... elements) {
        StringBuffer result = new StringBuffer();

        for (int i = 0; i < elements.length; i++) {
            result.append(elements[i]);
        }

        return result.toString(); //TODO
    }

    /**
     * Реализовать функционал изменения регистра в вид лесенки.
     * Возвращаемый текст должен начинаться с прописного регистра.
     *
     * Например для строки "Load Up On Guns And Bring Your Friends"
     * метод вернет "lOaD Up oN GuNs aNd bRiNg yOuR FrIeNdS".
     */
    @Override
    public String toJumpCase(String text) {
        StringBuffer resultStringBuffer = new StringBuffer();

        for (int k = 0; k < text.length(); k++) {
            char temp = 0;
            temp = text.charAt(k);

            if (Character.toString(temp) == "\\s") {
                resultStringBuffer.append(temp);
                continue;
            }

            if (k == 0) {
                if (Character.isLowerCase(temp) == true) {
                    resultStringBuffer.append(temp);
                } else {
                    resultStringBuffer.append(Character.toLowerCase(temp));
                }
                continue;
            }

            if (k % 2 != 0) {
                if (Character.isUpperCase(temp) == true) {
                    resultStringBuffer.append(temp);
                } else {
                    resultStringBuffer.append(Character.toUpperCase(temp));
                }
            } else {
                if (Character.isLowerCase(temp) == true) {
                    resultStringBuffer.append(temp);
                } else {
                    resultStringBuffer.append(Character.toLowerCase(temp));
                }
            }
        }

        return resultStringBuffer.toString(); //TODO
    }

    /**
     * Метод определяет, является ли строка палиндромом.
     *
     * Палиндром - строка, которая одинаково читается слева направо и справа налево.
     *
     * Например для строки "а роза упала на лапу Азора" вернется true, а для "я не палиндром" false
     */
    @Override
    public boolean isPalindrome(String string) {
        boolean result = false;

        if (string.length() == 0 || string == "\\s+") {
            return false;
        }

        StringBuffer resultStrBuffer = new StringBuffer();
        String withoutSpaces = string.replaceAll("\\s+", "");
        String allLowerCase = withoutSpaces.toLowerCase();
        resultStrBuffer.append(allLowerCase);
        resultStrBuffer.reverse();
        result = allLowerCase.contentEquals(resultStrBuffer);

       return result; //TODO
    }
}
