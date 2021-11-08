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

        int array = 0;
        int arrayS = 0;
        BigInteger bigNumber = new BigInteger("2");
        BigInteger[] arrayProstChisel = new BigInteger[range + 1];

        while (arrayS <= range) {
            boolean flag = true;
            BigInteger t = new BigInteger("2");

            while ( t.multiply(t).compareTo(bigNumber)<=0 ) {
                if (bigNumber.remainder(t).compareTo(new BigInteger("0"))==0) {  //BigInteger.valueOf(0)
                    flag = false;
                    break;
                }
               t = t.add(new BigInteger("1"));
            }

            if (flag == true) {
                arrayProstChisel[array] = bigNumber;
                array++;
                arrayS++;
            }

            bigNumber = bigNumber.add(new BigInteger("1"));

        }

        return arrayProstChisel[range];
    }
}
