public class Exercise1 {

    public static void main(String[] args){

        Exercise1 exercise1 = new Exercise1();
        double[]squaredArray = exercise1.calculateSquare(new double[]{2,3,4,5}, 3);
        exercise1.printArray(squaredArray);

        double sumOfArrayElements = exercise1.getSum(squaredArray);
        System.out.println(sumOfArrayElements);

        double sumOfEverySecondElement = exercise1.getSumOfEverySecondElement(squaredArray);
        System.out.println(sumOfEverySecondElement);

        double meanOfArrayElements = exercise1.getMean(squaredArray);
        System.out.println(meanOfArrayElements);

        int[] createdArray = exercise1.getArray(5);
        for (int i=0; i<createdArray.length; i++){
            System.out.println(createdArray[i]);
        }
        exercise1.printArray(new double[]{5,6,7});

        double[]arrayOfFibonacci = exercise1.getArrayOfFibonacci(10);
        exercise1.printArray(arrayOfFibonacci);
    }

    private double[] calculateSquare(double[] input, int power) {
        double[] squared = new double[input.length];
        for(int i=0; i<input.length;i++ ){
            squared[i] = Math.pow(input[i], power);
        }
        return squared;
    }
    private double getSum(double[] input){
        double sum=0;
        for (int i =0; i<input.length; i++){
            sum += input[i];
        }
        return sum;
    }
    private double getMean(double[] input){
        double mean = (this.getSum(input)/input.length);
        return mean;
    }
    private int[] getArray(int number){
        int[] newArray = new int[number];
        for (int i = 0; i < number; i++){
            newArray[i] = i;
        }
        return newArray;
    }
    private void printArray(double[] input){
        System.out.print("array: ");
        for(int i=0; i<input.length; i++){
            if (i == input.length-1){
            System.out.println(input[i]);
            }
            else {
                System.out.print(input[i]+ ", ");
            }
        }
    }
    private double getSumOfEverySecondElement(double[] input){
        double sum=0;
        for (int i =0; i<input.length; i+=2){
            sum += input[i];
        }
        return sum;
    }
    private double[] getArrayOfFibonacci(int number){
        double[] newArray = new double[number];
        for (int i = 0; i < number; i++){
            if (i==0 || i==1){
            newArray[i] = i;
            }
            else {
                newArray[i] = newArray[i-1]+newArray[i-2];
            }
        }
        return newArray;
    }
}
