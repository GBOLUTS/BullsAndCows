package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Nalika on 21.01.2017.
 */
public class Operations {
    Answers answer = new Answers();
    Analitics analitics = new Analitics();


    public boolean isRightNumber(int i){
        int[] numbers = answer.divideByNumbers(i); //разделил на символы

        for (int j = 0; j <numbers.length - 1 ; j++) {//нет смысла проверять последний символ

            for (int k = j + 1; k <numbers.length ; k++) {
                if (numbers[j] == numbers[k]){
                    return false;
                }

            }
        }


        return true;
    }



    public ArrayList<Integer> findPotentialNumbers(){
        ArrayList<Integer> potentialNumbers = new ArrayList();

        for (int i = 1234; i < 10000 ; i++) {
            if (isRightNumber(i)){
                potentialNumbers.add(i);
            }

        }

        return potentialNumbers;
    }

    public void removeWrongNumbers (ArrayList arr, int number, String ans)
    {
        Iterator<Integer> iter = arr.iterator();//Через Итератор, так как при удалении уменьшается число элементов
        while (iter.hasNext()){
           int  num =(int) iter.next();
           // int num = Integer.parseInt(nu);

            String res = answer.findAnswer(num,number);
                 if (!ans.equals(res)){
                iter.remove();
                 }
            }
    }

    public  void checkUserAnswers (ArrayList<Integer> list,  LinkedHashMap<Integer,String> numbersAndAnswers) throws IOException//Перепроверяет все ответы пользователя, если не осталоссь возможных чисел.
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            for (Map.Entry<Integer, String> entry : numbersAndAnswers.entrySet()) {
                Integer vNumber = entry.getKey();
                String vAnswer = entry.getValue();
                System.out.println("По числу " + vNumber + " правильный ответ будет " + vAnswer + "?");
                System.out.println("Если верный ответ, нажмите Y, неверный, любую другую клавишу");


                    String answers = reader.readLine();

                if ((!answers.equals("Y")))//Если пользователь указал что ошибся
                {
                    System.out.println("А какой верный ответ?");
                    entry.setValue(analitics.userRightAnswer());//перезаписывает верным значением.
                }
            }
            MassRemoveWrongNumber(list, numbersAndAnswers); //Теперь на основании полученных ответов заново определяем список доступных значений
            if (list.size() > 0){break;}//Если после ответов пользоввателя остались возможные числа, то выходим из проверки.
            else{System.out.println("Вы ошиблись, перепроверим");}
        }
    }


    public void MassRemoveWrongNumber(ArrayList arr,LinkedHashMap<Integer,String> numbersAndAnswers)//определяет возможные числа на основе всех ответов пользователя

    {
        for (Map.Entry<Integer,String> entry : numbersAndAnswers.entrySet()) {//По очереди удаляем по всем ответам пользователя
            Integer vNumber = entry.getKey();
            String vAnswer = entry.getValue();
            removeWrongNumbers(arr,vNumber,vAnswer);
        }
    }
}
