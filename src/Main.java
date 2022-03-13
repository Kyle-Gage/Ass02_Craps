import java.util.Random;
import java.util.Scanner;

public class Main
{

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Random rnd = new Random();
        int die1 = rnd.nextInt(6) + 1;
        int die2 = rnd.nextInt(6) + 1;
        int crapsRoll = 0;
        int thePoint = 0;
        boolean rerolling = false;
        boolean playAgain = false;

        do {
            die1 = rnd.nextInt(6) + 1;
            die2 = rnd.nextInt(6) + 1;
            crapsRoll = die1 + die2;


            System.out.println("You rolled a " + crapsRoll + "! Die 1 was " + die1 + ", and die 2 was " + die2 + ".");

            switch (crapsRoll)
            {
                case 2:
                case 3:
                case 12:
                    System.out.println("You rolled a " + crapsRoll + ". Which means you crapped out!");
                    break;

                case 7:
                case 11:
                    System.out.println("Your rolled a " + crapsRoll + ". Which means you win with a natural!");
                    break;

                default:
                    thePoint = crapsRoll;
                    System.out.println("Your rolled a " + crapsRoll + ". The point is now " + thePoint + ".");

                    do
                    {
                        System.out.print("Rolling again...");
                        die1 = rnd.nextInt(6) + 1;
                        die2 = rnd.nextInt(6) + 1;
                        crapsRoll = die1 + die2;


                        if (crapsRoll == 7) {
                            System.out.println("Your rolled a " + crapsRoll + ". You lose!");
                            rerolling = false;
                        } else if (crapsRoll == thePoint) {
                            System.out.println("You rolled a " + crapsRoll + ". You win!");
                            rerolling = false;
                        } else {
                            System.out.println("You rolled a " + crapsRoll + ", Try again for point!");
                            rerolling = true;
                        }
                    } while (rerolling);
            }
            playAgain = SafeInput.getYNConfirm(in, "Would you like to play again? [Y/N]: ");
        }while(playAgain);
    }
}
