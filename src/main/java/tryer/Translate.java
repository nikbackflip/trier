package tryer;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

class Translate {
    String original;
    String translation;

    public Translate(String original) throws FileNotFoundException {
        this.original = original;
        this.translation = translation;
        ArrayList al = new ArrayList();
        Path p1 = Paths.get("C:\\Users\\Daria_Nikolaichenko\\IdeaProjects\\trier\\src\\main\\resources\\dict.txt");
        Scanner sc = new Scanner(p1.toFile()).useDelimiter("\\s*-\\s*");

        while (sc.hasNext()) {
            String word = (sc.next());
            String translation = translate(word);
            al.add(word);
            al.add(translation);
            System.out.println("Print Arraylist using for loop");
            for(int i=0; i < al.size(); i++){
                System.out.println( al.get(i));
            }
        }
    }

    private String translate(String word) {
        return "translated_" + word;
    }

    public static void main(String args[]) throws FileNotFoundException {
        Translate gcd = new Translate("envolope");
    }
}