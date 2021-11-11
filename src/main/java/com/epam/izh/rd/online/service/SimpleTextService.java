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
        String[] strArr = text.split("\\s");
        char[] charArray = new char[strArr.length];
        String[] strArray = new String[strArr.length];



        for (int i = 0; i < strArr.length; i++) {

            //String[]  charArrayTemp = new String[strArr[i].length()];
            char[] charArrayTemp = new char[strArr[i].length()];


            for (int j = 0; j < strArr[i].length(); j++) {
                //нечетные нижний регистр
                //четные верхний регистр

                if (j/2 != 0) {
                    if (Character.isLowerCase(strArr[i].charAt(j)) == false) {
                        charArrayTemp[j] = Character.toLowerCase(strArr[i].charAt(j));
                    } else {
                        charArrayTemp[j] = strArr[i].charAt(j);
                    }
                } else {
                    if (Character.isUpperCase(strArr[i].charAt(j)) == false) {
                        charArrayTemp[j] = Character.toUpperCase(strArr[i].charAt(j));
                    } else {
                        charArrayTemp[j] = strArr[i].charAt(j);
                    }
                }




                //strArr[i].charAt(j);
                /*if (Character.isLowerCase(strArr[i].charAt(j)) == false) {
                }*/

                /*strArr[i].charAt(j);  //символ [j]
                        strArr[i]*/

            }
            strArray[i] = String.valueOf(charArrayTemp);
        }

        return null; //TODO
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
       return false; //TODO
    }
}
