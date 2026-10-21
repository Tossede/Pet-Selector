  //Perfect Pet Selector
  //Author: Faith Agbazagan
  //Date: October 14redth 2026
import java.util.Scanner;

public class PerfectPetSelector {

    static final String LETTERS = "abcdefghijklmnopqrstuvwxyz";
    static final String VOWELS = "aeiou";

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Get all three inputs (each method keeps asking until valid)
        String color = askColor(input);
        String season = askSeason(input);
        String name = askName(input);

        // Figure out whether the name starts with a vowel or consonant
        // (askName guarantees the first character is a letter)
        String firstLetter = name.substring(0, 1).toLowerCase();
        boolean startsWithVowel = VOWELS.indexOf(firstLetter) >= 0;
        boolean startsWithConsonant = !startsWithVowel;

        // pet stays "" until a rule gives the person one
        String pet = "";

        // Rule 1: blue + fall = alligator
        if (color.equals("blue") && season.equals("fall")) {
            pet = "Alligator";
        }

        // Rule 2: blue + spring = ostrich
        if (color.equals("blue") && season.equals("spring")) {
            pet = "Ostrich";
        }

        // Rule 3: green + consonant name + winter = giraffe
        if (color.equals("green") && startsWithConsonant && season.equals("winter")) {
            pet = "Giraffe";
        }

        // Rule 4: green + any season except fall = dog (unless already a giraffe)
        if (color.equals("green") && !season.equals("fall") && !pet.equals("Giraffe")) {
            pet = "Dog";
        }

        // Rule 5: red = panda, but a vowel name gets a porcupine
        if (color.equals("red")) {
            if (startsWithVowel) {
                pet = "Porcupine";
            } else {
                pet = "Panda";
            }
        }

        // Rule 6: summer = pony (unless already a dog, panda or porcupine)
        if (season.equals("summer") && !pet.equals("Dog") && !pet.equals("Panda")
                && !pet.equals("Porcupine")) {
            pet = "Pony";
        }

        // Rule 7: consonant name + blue + season is not summer or fall = axolotl
        // (unless already an ostrich)
        if (startsWithConsonant && color.equals("blue") && !season.equals("summer")
                && !season.equals("fall") && !pet.equals("Ostrich")) {
            pet = "Axolotl";
        }

        // Rule 8: no rule matched, so the person gets a pet rock
        if (pet.equals("")) {
            pet = "Pet Rock";
        }

        System.out.println();
        System.out.println("Your perfect pet is: " + pet);
        input.close();
    }

    // Keeps asking until the user types red, blue or green
    public static String askColor(Scanner input) {
        while (true) {
            System.out.println("Enter your favorite color (Either red, blue or green):");
            String answer = readLine(input).trim().toLowerCase();

            if (answer.equals("red") || answer.equals("blue") || answer.equals("green")) {
                return answer;
            }
            System.out.println("Sorry, \"" + answer + "\" is not a valid color. Please try again.");
        }
    }

    // Keeps asking until the user types winter, spring, summer or fall
    public static String askSeason(Scanner input) {
        while (true) {
            System.out.println("Enter your favorite season (winter, spring, summer, fall):");
            String answer = readLine(input).trim().toLowerCase();

            if (answer.equals("winter") || answer.equals("spring")
                    || answer.equals("summer") || answer.equals("fall")) {
                return answer;
            }
            System.out.println("Sorry, \"" + answer + "\" is not a valid season. Please try again.");
        }
    }

    // Keeps asking until the name starts with a letter
    public static String askName(Scanner input) {
        while (true) {
            System.out.println("Enter your name:");
            String answer = readLine(input).trim();

            if (answer.length() > 0
                    && LETTERS.indexOf(answer.substring(0, 1).toLowerCase()) >= 0) {
                return answer;
            }
            System.out.println("Sorry, your name must start with a letter. Please try again.");
        }
    }

    // Reads one line safely. If the input stream ends unexpectedly
    // (e.g. Ctrl+D), exit politely instead of crashing.
    public static String readLine(Scanner input) {
        if (!input.hasNextLine()) {
            System.out.println("No more input available. Goodbye!");
            System.exit(0);
        }
        return input.nextLine();
    }
}