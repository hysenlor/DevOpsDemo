package ch.zhaw.iwi.devops.demo;

class RomanNum {

    // Arrays zur Speicherung der Basis-Ziffern und subtraktiven Notationen
    private static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static final String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    String convert(int number) {
        StringBuilder result = new StringBuilder();  
        
        // Schleife über alle Werte und Symbole
        for (int i = 0; i < values.length; i++) {
            // Solange die aktuelle Zahl größer oder gleich dem aktuellen Wert ist
            while (number >= values[i]) {
                result.append(symbols[i]); 
                number -= values[i]; 
            }
        }

        return result.toString();  // Gib die resultierende römische Ziffer als String zurück
    }
}