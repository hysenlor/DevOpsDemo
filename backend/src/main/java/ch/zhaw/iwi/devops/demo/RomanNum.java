package ch.zhaw.iwi.devops.demo;

public class RomanNum {
    public String convert(int number) {
        if (number == 1) {
            return "I";
        } else if (number == 2) {
            return "II";
        } else if (number == 3) {
            return "III";
        }
        return "";
    }

}
