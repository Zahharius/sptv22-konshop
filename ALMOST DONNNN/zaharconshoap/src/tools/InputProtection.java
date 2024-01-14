package tools;

import java.util.Scanner;


public class InputProtection {
    
    public static int intInput(int beginRange, int endRange){
        Scanner scanner = new Scanner(System.in);
        int number = -1;
        do{
            try {
                number = scanner.nextInt();
                scanner.nextLine();
            } catch (Exception e) {
                scanner.nextLine();
                System.out.print("Цифру а не букву: ");
                continue;
            }
            if(number >= beginRange && number <= endRange){
                return number;
            }else{
                System.out.printf("леее выбери цифру от до (%d .. %d): ",beginRange, endRange);
                continue;
            }
        }while(true);
        
    }
}