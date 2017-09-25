package magicSquare;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileHandler {
    private BufferedWriter out;

    FileHandler(int limit){
        createFile(limit);
    }

    private void createFile(int limit){
        try{
            out = new BufferedWriter(new FileWriter("magicSquaresLimit"+limit+".txt"));
            out.write("3x3 magic squares made with integers from 1 to "+limit+":");
            out.newLine();
            out.newLine();
        }catch(IOException e){
            System.out.println("Exception during creating file");
        }
    }

    void writeCombinantion(int[] numbers) {
        try {
            out.write("Magic square: ");
            for (int i = 0; i < numbers.length; i++) {
                out.write(" "+numbers[i]);
                if (i < numbers.length - 1)
                    out.write(",");
                else
                    out.write(".");
            }
            out.newLine();
        } catch (IOException e) {
            System.out.println("Exception during writing file");
        }
    }

    void closeFile(){
        try {
            out.close();
        }catch(IOException e){
            System.out.println("Exception during closing file");
        }
    }
}
