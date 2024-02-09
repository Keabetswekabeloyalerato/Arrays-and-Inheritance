import java.util.Scanner;

public class CowsAndBulls{
 public final static int NUM_DIGITS= 4;
 public final static int MAX_VALUE= 9876;
 public final static int MIN_VALUE= 1234;
    public final static int MAX_GUESSES= 10;

    private int secretNumber;
    private int guessesRemaining;
    private NumberPicker numberPicker;
    private boolean gameOver;

  public CowsAndBulls(int seed){
        this.numberPicker= new NumberPicker(seed, 1, 9);
        this.secretNumber= generateSecretNumber();
        this.guessesRemaining= MAX_GUESSES;
        this.gameOver= false;
    }
    
 public int guessesRemaining(){
  return guessesRemaining;
    }

 public Result guess(int guessNumber) {
  if (guessesRemaining== 0 || gameOver) {
    return new Result(0,0);
        }

   guessesRemaining--;
   if (guessNumber== secretNumber) {
     gameOver=true;
     return new Result(0,4);
        }

   String secretStr= Integer.toString(secretNumber);
        String guessStr= Integer.toString(guessNumber);

        int cows= 0;
        int bulls= 0;

        for (int i= 0; i < NUM_DIGITS; i++) {
            char secretChar= secretStr.charAt(i);
            char guessChar= guessStr.charAt(i);

            if (secretChar== guessChar) {
                bulls++;
            } else if (secretStr.contains(Character.toString(guessChar))) {
                cows++;
            }
        }

        return new Result(cows, bulls);
    }

  public int giveUp() {
    gameOver = true;
    guessesRemaining= 0;
    return secretNumber;
       }

 public boolean gameOver() {
  return gameOver;
    }

  private int generateSecretNumber() {
    int number= 0;
    boolean[] usedDigits = new boolean[10];
    
     for (int i = 0; i < NUM_DIGITS; i++) {
            int digit;
            do {
                digit = numberPicker.nextInt();
            } while (usedDigits[digit]);

            usedDigits[digit] = true;
            number = number * 10 + digit;
        }
        return number;
    }
    
  public static void main(String[] args){
     Scanner input= new Scanner(System.in);
     System.out.println("Your challenge is to guess a secret " + CowsAndBulls.NUM_DIGITS + " digit number.");

        System.out.println("Enter randomisation seed value:") ;
        int seed= input.nextInt() ;
        CowsAndBulls cowsAndBulls= new CowsAndBulls(seed) ;

        while (!cowsAndBulls.gameOver()){
            String command= input.next();
            if (command.equals("guessesRemaining()")) {
                System.out.println(cowsAndBulls.guessesRemaining());
          } else if (command.equals("guess()")) {
                int guess= input.nextInt() ;
                Result answer= cowsAndBulls.guess(guess);
                System.out.println(answer.cows() + " cows and " + answer.bulls() + " bulls");
           } else if (command.equals("giveUp()")) {
                int secretNumber= cowsAndBulls.giveUp() ;
                System.out.println(secretNumber);
             } else if (command.equals("gameOver()")) {
                System.out.println(cowsAndBulls.gameOver());
            } else {
                System.out.println("Invalid command: " + command);
          }
        }

        input.close();
  }
}
