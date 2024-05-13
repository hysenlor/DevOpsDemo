package ch.zhaw.iwi.devops.demo;

public class RomanNum {
    public String convert(int number) {
        StringBuilder result = new StringBuilder();
        while (number >= 1 && number <= 3) {
            result.append("I");
            number -= 1;
        }
        return result.toString();
    }

}
