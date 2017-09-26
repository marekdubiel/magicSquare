package magicSquare;

public class Main {
    public static void main(String[] Args){
        Console console = new Console();
        Square square = new Square(console.registerLimit());
        FileHandler writer = new FileHandler(square.getLimit());

        while(square.hasMoreCombinations()) {
            square.iterate();
            if (square.checkCombination()) {
                console.success(square.getNumbers());
                writer.writeCombinantion(square.getNumbers());
            }
        }
        console.end(square.getLimit());
        writer.closeFile();
    }
}
