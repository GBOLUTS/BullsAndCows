package com.company;

import java.util.ArrayList;

/**
 * Created by Nalika on 22.01.2017.
 */
public class AutoPlay {//Считает за сколько попыток алгоритм рассчитает данное число
    public int autoPlay(int realNumber) {
        Answers answer = new Answers();
        Operations pot = new Operations();
        Efficiency eff = new Efficiency();


        ArrayList<Integer> list = pot.findPotentialNumbers();


        int lastAttempt = eff.giveEfficientNumber(list);
        int numberOfAttempts = 1;

            while (true){
                String AutomaticAnswer = answer.findAnswer(realNumber,lastAttempt);
                if (AutomaticAnswer.equals("40")){//Если писать в while условие, то как я понимаю, первый раз считает проверит условие выхода из цикла, второй раз для проверки
                    break;
                }else {

                    pot.removeWrongNumbers(list, lastAttempt, AutomaticAnswer);
                    int nextAnswer = eff.giveEfficientNumber(list); //Выводит первое число из возможных. // TODO: 22.01.2017 Сделать чтобы выбирало из самых информативных.
                    lastAttempt = nextAnswer;
                    numberOfAttempts += 1;
                }
            }

        return numberOfAttempts;
    }
}
