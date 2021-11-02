package com.epam.izh.rd.online.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

public class SimpleBigNumbersService implements BigNumbersService {

    /**
     * Метод делит первое число на второе с заданной точностью
     * Например 1/3 с точностью 2 = 0.33
     * @param range точность
     * @return результат
     */
    @Override
    public BigDecimal getPrecisionNumber(int a, int b, int range) {
        return new BigDecimal(a).divide(new BigDecimal(b), range, RoundingMode.HALF_UP);
    }

    /**
     * Метод находит простое число по номеру
     *
     * @param range номер числа, считая с числа 2
     * @return простое число
     */
    @Override
    public BigInteger getPrimaryNumber(int range) {
        if (range == 0 || range == 1) {
            return null;
        }
        int n = 2;
        int[] arrayProstChisel = new int[range];
        int[] arrayTemp = new int[1];
        int array = 0;
        int p = 0;
        //int t = 2;
        int c = 2;
        int arrayS = 0;
        int number = 2;
        //boolean flag = true;

        while (arrayS < range) {
            boolean flag = true;
            int t = 2;

            while (t * t <= number) {
                if (number % t == 0) {
                    flag = false;
                    break;
                }
                t++;
            }

            if (flag == true) {
                arrayProstChisel[array] = number;
                arrayS++;
            }
        }







/*
        for (int i=0; i<range; i++) {

            while (n * n <= c) {
                if (c % t == 0) {
                    continue;
                }
                n++;
                t++;
            }

            arrayProstChisel[p] = c;
            c++;  //Число увеличивается вне цикла
            p++;


        }
*/
        //while (n)

        /*for (int i=0; i<1000; i++) {
            if (n % 2 != 0) {
                arrayTemp[p] = n;
            }
            n++;
        }*/



        return null;
    }
}
