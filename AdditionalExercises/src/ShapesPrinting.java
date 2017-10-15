public class ShapesPrinting {
    public static void main(String[] args){
        printSquare(4);
        System.out.println();
        printFirstHalfUpToDown(4);
        System.out.println();
        printFirstHalfDownToUp(4);
        System.out.println();
        printSecondHalfUpToDown(4);
        System.out.println();
        printChristmasTree(4);
    }

     public static void printSquare(int number){
        for (int i=0; i<number; i++) {
            printX(number);
        }
     }
     public static void printFirstHalfUpToDown(int number){
         for (int i=0; i<number ;i++) {
            printX(i+1);
         }
     }
     public static void printFirstHalfDownToUp(int number){
         for (int i=number; i>0 ;i--) {
             printX(i);
         }
     }

     public static void printSecondHalfUpToDown(int number){
         for (int i=number; i>0; i--){
             int bs= i-1;
             printBlankSpace(bs);
             printX(number-bs);
         }
     }

     public static void printX(int number){
         for (int i=0; i<number; i++) {
             System.out.print("X");
         }
         System.out.println();
     }

     public static void printBlankSpace(int number){
         for (int i=0; i<number; i++) {
             System.out.print(" ");
         }
     }
     public static void printTree(int number){
         for (int i=0; i<number; i++) {
             for (int j = 0; j < number; j++) {
                 printX(j + 1);
             }
         }
     }
     public static void printChristmasTree(int number){
         for (int i=1; i<number; i++){
             printFirstHalfUpToDown(i+1);
         }
     }
}
