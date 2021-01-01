package facebook;

import java.util.ArrayList;
import java.util.List;

public class EnglishPhraseOfNumbers {
    //543 = five hundred and forty three
    //5430 = five thousand four hundred and thirty
    //54330 = fifty four thousand three hundred and thirty
    //543308 = five hundred forty three thousand three hundred and eight.

    //unit, tens, hundred, thousand, ten thousand, hundred thousand

    String[] zeroToTwenty = {"Zero", "One", "Two", "Three", "Four", "Five", };
    public class NumberUnits{
        private int number;

        public NumberUnits(int number){
            this.number = number;
        }

        public void convertToUnits(){
            List<Integer> units = new ArrayList<>();
            int temp = number;
            while(temp > 0) {
                units.add(temp % 10);
                temp = temp / 10;
            }
            //lets assuem the max. size is 6 digit
            if(units.size() == 6){
                convertToHundredThousand(units);
            } else  if(units.size() == 5){
                convertToTenThousand(units);//5 4 3 3 0 8
            }
        }
    }



    private void convertToHundredThousand(List<Number> units) {
          units.get(5);
    }


    public static void main(String[] args) {
        System.out.println("540 % 10 " +  540 % 10);
        System.out.println("540 / 10 " +  540 / 10);
        System.out.println("5 / 10 " +  5 / 10);
    }




}
