import java.util.Scanner;

public class NumberGame{
    public static int getANumber(int min , int max){
        return (int)(Math.random()*((max-min)+1)) + min ;
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int num = 0 ;
        int chances = 6 ;
        int score = 0;
        Boolean play_again = true ;
        System.out.print("enter your name : ");
        String name = sc.nextLine();
        System.out.println("\nHello " + name);
        System.out.println("Welcome to this number guessing game...");
        System.out.println("Here you have " + chances + " chances to win this game.");
        System.out.println();
        System.out.println("So , lets start");
        
        while(play_again){
            int randnum = getANumber(1,100) ; 
            Boolean guess = false ;
            for(int i = 1 ; i<= chances ; i++){
                System.out.println("Chance " + i +" .Guess the number between 1 to 100 : ");
                num = sc.nextInt();
                if(randnum==num){
                    guess = true ;
                    score += 1 ;
                    System.out.println("....You won it ....");
                    break;
                }else if(randnum<num){
                    System.out.println("Too High");
                }else if(randnum>num){
                    System.out.println("Too Low");
                }
            }
            if(guess==false){
                System.out.println("....You Lost it.... Correct number is " + randnum);
            }
            System.out.println("Want to Play again ,(yes/no) :");
            String value = sc.next();
            play_again = value.equalsIgnoreCase("yes");
        }
        System.out.println("Total score " + score);
        System.out.println();
        System.out.println("....................Bye Bye.................");
        
        sc.close();
    }    
}