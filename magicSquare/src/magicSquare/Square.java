package magicSquare;

public class Square {
    private int limit;
    private int[]numbers;

    Square(int limit){
        this.limit = limit;
        fillArray();
    }

    private void fillArray(){
        numbers = new int[9];
        for(int i=0;i<numbers.length;i++){
            numbers[i]=i+1;
        }
    }

    boolean isMagicSquare(){
        int sum;

        sum = numbers[0]+numbers[1]+numbers[2];

        if(sum!=(numbers[0]+numbers[1]+numbers[2])) return false;
        if(sum!=(numbers[3]+numbers[4]+numbers[5])) return false;
        if(sum!=(numbers[6]+numbers[7]+numbers[8])) return false;

        if(sum!=(numbers[0]+numbers[3]+numbers[6])) return false;
        if(sum!=(numbers[1]+numbers[4]+numbers[7])) return false;
        if(sum!=(numbers[2]+numbers[5]+numbers[8])) return false;

        if(sum!=(numbers[0]+numbers[4]+numbers[8])) return false;
        if(sum!=(numbers[6]+numbers[4]+numbers[2])) return false;

        return true;
    }

    public int[] getNumbers(){
        return numbers;
    }

    public int getLimit(){
        return limit;
    }

    public void iterate() {
        increment(numbers.length - 1);
    }
    private void increment(int digit){
        if(numbers[digit]<limit) {
            numbers[digit]++;
            if(isRepetition(digit))
                increment(digit);
        }else{
            numbers[digit]=1;
            increment(digit-1);
            if(isRepetition(digit))
                iterate();

        }
    }

    private boolean isRepetition(int numberToCheck){
        for(int i=0;i<numbers.length;i++){
            if(i!=numberToCheck && numbers[i]==numbers[numberToCheck])
                return true;
        }
        return false;
    }
    boolean hasMoreCombinations(){

        for(int i=0;i<numbers.length;i++){
            if (numbers[i]<limit-i)
                return true;
        }
        return false;
    }
}
