package ch.zhaw.iwi.devops.demo;

public class RomanNum {
    public String convert(int number) {
        StringBuilder result = new StringBuilder();
        
        if (number == 10){
            result.append("X");
        } else if (number == 5){
            result.append("V");
        } else if (number == 4){
            result.append("IV");
        } else {
            for (int i = 1; i <= number; i++) {
                result.append("I");
            }
        }

        return result.toString();

    }

}
