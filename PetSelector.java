// Date: 10/29/2026
// A pet selector that assigns you a pet according to your inputed favorite color and season
import java.util.Scanner;

public class PetSelector {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // ask information
        System.out.println("What is your name:");
        String name = input.nextLine();

        System.out.println("Enter you favorite color(red, blue or green):");
        String color = input.nextLine().toLowerCase();

        System.out.println("Enter your favorite season(winter,spring,summer,fall):");
        String season = input.nextLine().toLowerCase();


        // make sure user followed instructions
        if (!season.equals("winter") && !season.equals("spring") && !season.equals("summer") && !season.equals("fall")) {
            System.out.println("Invalid season entered. Follow the instructions loser.");
        } 
        else if (name.length() == 0 || "abcdefghijklmnopqrstuvwxyz".indexOf(name.substring(0, 1).toLowerCase()) < 0) {
            System.out.println("A name starts with a letter dude. Do better :( ");
        } 
        else if (!color.equals("red") && !color.equals("blue") && !color.equals("green")) {
            System.out.println("Colors can't be anything other than red, blue or green. Try again with a valid input.");
        } 
        
        else {
            // check vowels or consonants
            String firstLetter = name.substring(0, 1).toLowerCase();
            String pet = "Pet Rock";
            // figure out the right pet using the rules
            if (color.equals("red")) {
                if ("aeiou".indexOf(firstLetter) >= 0) {
                    pet = "Porcupine";
                } else {
                    pet = "Panda";
                }
            }
            else if (color.equals("blue") && season.equals("spring")) {
                pet = "Ostrich";
            }
            else if (color.equals("blue") && season.equals("fall")) {
                pet = "Alligator";
            }
            else if (color.equals("green") && !season.equals("fall")) {
                pet = "Dog";
            }
            else if (season.equals("summer")) {
                pet = "Pony";
            }
            else if (color.equals("green") && "aeiou".indexOf(firstLetter) == -1 && season.equals("winter")) {
                pet = "Giraffe";
            }
            else if ("aeiou".indexOf(firstLetter) == -1 && color.equals("blue") && !season.equals("summer") && !season.equals("fall")) {
                pet = "Axolotl";
            }
            else {
                pet = "Pet Rock";
            }

            System.out.println("Your perfect pet is: " + pet);
        }
    } 
}