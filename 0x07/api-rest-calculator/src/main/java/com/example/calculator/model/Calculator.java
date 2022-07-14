package com.example.calculator.model;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Calculator {

    public Calculator() {
    }

    public Double sum(Double number1, Double number2) {
        Double soma = number1 + number2;

        if(number1 == null || number1.equals("") || number2 == null || number2.equals("")){
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }
        return soma;
        // validação -> throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
    }

    public Double sub(Double number1, Double number2) {
        Double subtra=number1-number2;
        if(number1 == null || number1.equals("") || number2 == null || number2.equals("")){
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        }
        return subtra;
        // validação -> throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
    }

    public Double divide (Double number1, Double number2)  {

        Double div = number1/number2;

        if(number1 == null || number1.equals("") || number2 == null || number2.equals("")){
            throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        } else if (number1 == 0 || number2 == 0) {
            throw new ArithmeticException("Divisão por zero não é permitido.");
        }
        return div;
        // validação -> throw new NullPointerException("Número 1 e número 2 são obrigatórios.");
        // validação -> throw new ArithmeticException("Divisão por zero não é permitido.");
    }

    public Integer factorial(Integer factorial) {
        
        if(factorial == null || factorial.equals("")){
            throw new NullPointerException("Número é obrigatório.");
        } else if (factorial == 0) {
            return 1;
        }
        return (factorial*factorial(factorial-1));
        // validação -> throw new NullPointerException("Número é obrigatório.");
    }

    // Exemplos:
    // Integer = 1 -> Binary = 1
    // Integer = 5 -> Binary = 101
    // Integer = 20 -> Binary = 10100
    public static Integer integerToBinary(Integer integer) {
        return Integer.parseInt(Integer.toBinaryString(integer));
    }

    // Exemplos:
    // Integer = 1 -> Hexadecimal = "1"
    // Integer = 5 -> Hexadecimal = "37"
    // Integer = 170 -> Binary = "AA"
    public String integerToHexadecimal(Integer integer) {
        return Integer.toHexString(integer);
    }

    // Exemplos
    // Date 1 = LocalDate.of(2020, 3, 15);
    // Date 2 = LocalDate.of(2020, 3, 29)
    // Total de dias = 14
    public int calculeDayBetweenDate(LocalDate date1, LocalDate date2) {
        return (int) ChronoUnit.DAYS.between(date1, date2);
    }

}
