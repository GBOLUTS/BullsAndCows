package com.company;

import java.util.ArrayList;

/**
 * Created by Nalika on 22.01.2017.
 */
public class Efficiency {
Operations pot = new Operations();
    Analitics analitic = new Analitics();

    public int countPotentialNumber(ArrayList arr, int number, String answer)//Рассчитывает сколько остаётся вариантов при соответствующем ответе на число
    {
        ArrayList<Integer> copyArr = new ArrayList<Integer>();
        for (int i = 0; i < arr.size(); i++) {//Заведение копии списка
            copyArr.add((Integer) arr.get(i));
        }

       pot.removeWrongNumbers(copyArr, number, answer);
        return copyArr.size();
    }

    public ArrayList<Integer> findTreeOfPotentialNumbers(ArrayList arr, int number) {//Создаёт для числа массив с количеством оставшихся на каждый вариант ответа
        ArrayList<String> listOfAnswers = analitic.createListOfAllVariables();
        ArrayList<Integer> treeOfPotentialNumbers = new ArrayList<Integer>();

        for (int i = 0; i < listOfAnswers.size(); i++) {
            int n = countPotentialNumber(arr, number, listOfAnswers.get(i));
            treeOfPotentialNumbers.add(n);
        }

        return treeOfPotentialNumbers;
    }

    public int findEfficiencyOfNumberMax(ArrayList arr, int number){//Рассчитывает эффективность числа, как количество оставшихся вариа
        int eff = analitic.findMax(arr);
        return eff;
    }

    public ArrayList<Integer> createListOfNumEff(ArrayList<Integer> arr){//Создаю массив эффективностей чисел массива.
        ArrayList<Integer> listOfEff = new ArrayList<Integer>();

        for (int i = 0; i <arr.size() ; i++) {
            int num = arr.get(i);
            int eff = findEfficiencyOfNumberMax(arr,num);//Узнаю эффективность числп
            listOfEff.add(eff);
        }

        return listOfEff;
    }

    public int giveEfficientNumber(ArrayList<Integer> arr){
        ArrayList<Integer> listOfEfficiencies = createListOfNumEff(arr);
        int mostEff = analitic.findMin(listOfEfficiencies);

        for (int i = 0; i < arr.size() ; i++) {
            if (listOfEfficiencies.get(i) == mostEff){
                return arr.get(i);
            }

        }
        return -1;//Не должно никогда выпасть.
    }
}
