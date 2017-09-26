package magicSquare;

import java.util.Scanner;

class Console {
    private Scanner scanner;
    Console(){
        scanner = new Scanner(System.in);
    }

    int registerLimit(){
        String enteredValue = null;
        while (isNotValidInt(enteredValue)){
            System.out.println("Enter a limit (an integer bigger than 8):");
            enteredValue = scanner.nextLine();
        }
        assert enteredValue != null;
        return Integer.parseInt(enteredValue);
    }

    private boolean isNotValidInt(String stringToCheck){
        int checkVariable;
        try{
            checkVariable = Integer.parseInt(stringToCheck);
        }catch(NumberFormatException e){
            return true;
        }
        return checkVariable <= 8;
    }

    void success(int[] numbers){
        System.out.println("The magic square is:");
        printCurrentSet(numbers);
    }

    void end(int limit){
        System.out.println("No more magic squares for a limit of " + limit);
    }

    private void printCurrentSet(int[] numbers){
        for(int i=0; i< numbers.length;i++){
            System.out.print(numbers[i]);
            if (i<numbers.length-1)
                System.out.print(", ");
            else
                System.out.println(".");
        }
    }
}
