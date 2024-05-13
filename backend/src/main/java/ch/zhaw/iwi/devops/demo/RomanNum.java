package ch.zhaw.iwi.devops.demo;

public class RomanNum {
    public String convert(int number) {
        StringBuilder result = new StringBuilder();

        if (number == 4){
            result.append("IV"); // Direktes Anhängen von "IV" bei 4
        } else {
            for (int i = 1; i <= number; i++) {
                result.append("I");
            }
        }

        return result.toString();

    }

}
