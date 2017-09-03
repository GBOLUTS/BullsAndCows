package com.company;

/**
 * Created by Nalika on 21.01.2017.
 */
public class Answers {

    public String findAnswer(int truNumber, int ans) {
        int[] truNumberChars = divideByNumbers(truNumber);
        int[] ansChars = divideByNumbers(ans);
        int bulls = 0;
        int cows = 0;

        for (int i = 0; i < truNumberChars.length; i++) {//определяем количество быков
            if (truNumberChars[i] == ansChars[i]) {
                bulls += 1;
            }
        }


        for (int i = 0; i < ansChars.length ; i++) {

            for (int j = 0; j < truNumberChars.length; j++) {
                if ((ansChars[i] == truNumberChars[j]) && (i != j)) {
                    cows += 1;
                }

            }
        }
            String sbulls = String.valueOf(bulls);
            String scows = String.valueOf(cows);

            String result = sbulls + scows;
        return result; // Ответ пишет в виде String ab, количество быков и коров соответственно.


    }


        public int[] divideByNumbers ( int N)//метод создаёт на основе числа массив с его цифрами
        {
            int K = N;
            int chars = 1;
            while (K > 9) //определяем количество знаков
            {
                K = K / 10;
                chars += 1;
            }

            int[] numbers = new int[chars];

            for (int i = 0; i < chars; i++) {
                numbers[chars - i -1] = N -(N / 10 * 10);//Заполняется с конца, чтобы числа были в том же порядке
                N = N/10;
            }


            return numbers;
        }
    }
