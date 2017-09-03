package com.company;


import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Created by Nalika on 22.01.2017.
 */
public class Play {
    public static void play() throws IOException {
        Answers answer = new Answers();
        Operations oper = new Operations();
        Efficiency eff = new Efficiency();
        Analitics analitics = new Analitics();


        ArrayList<Integer> list = oper.findPotentialNumbers();
        LinkedHashMap<Integer,String> numbersAndAnswers = new LinkedHashMap<>();//Будут храниться числа и ответы на них. Данная структура выбрана,
        //чтобы значения сорханялись в порядке добавления.

        System.out.println("Задумайте число");
        System.out.println("На каждое число ответьте 2х значным числом, где первая цифра - количество быков");
        System.out.println("А вторая, количество коров");
        int lastAttempt = eff.giveEfficientNumber(list);
        System.out.println(lastAttempt);
        int numberOfAttempts = 1;
        ArrayList<String> normalAnswers = analitics.createListOfAllVariables();


            while (true){
                String userAnswer = analitics.userRightAnswer();// Пока пользователь не введёт в правильном формате, будет у него спрашивать число
                numbersAndAnswers.put(lastAttempt,userAnswer);
                if (userAnswer.equals("40")){//Если писать в while условие, то как я понимаю, первый раз считает проверит условие выхода из цикла, второй раз для проверки
                    break;
                }else {
                    
                    oper.removeWrongNumbers(list, lastAttempt, userAnswer);//На основании последнего числа удаляет из списка возможных чисел все невозможные варианты
                    
                    if (list.size() == 0){//После ответа польз. не осталось возможных чисел, нужно перепроверить все варианты.
                        
                        list = oper.findPotentialNumbers();
                        //пересоздаём список потенциальных чисел, будем заново проверять.
                        oper.checkUserAnswers(list,numbersAndAnswers);
                    }
                        int nextAnswer = eff.giveEfficientNumber(list); //Выводит первое число из возможных. // TODO: 22.01.2017 Сделать чтобы выбирало из самых информативных.
                        lastAttempt = nextAnswer;
                        System.out.println(nextAnswer);
                        numberOfAttempts += 1;
                    
                    
                }
            }
        //Далее выводится когда закончилась игра
        System.out.println("Число было отгадано за " + numberOfAttempts + " шагов");
    }
}
