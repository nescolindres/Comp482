import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class StableMarriage {
    static int num;
    static int stable = 0;
    static int count = 0;

    static void checkStable(int womenPrefernce[][], int manPreference[][], int pairs[][]) {

        while (stable < num) {
        // checks to see if w prefers m over her current engagement
        for (int i = 0; i < pairs.length; i++) {
            // if (prefer[women][i] == man1)
            // return true;

            // if(prefer[women][i] == man)
            // return false;
            int currMan = pairs[i][0];
            int currWomen = pairs[i][1];
           // System.out.println("Man " + currMan + " is paired with " + currWomen);
            for (int prevman = 0; prevman < womenPrefernce[i].length; prevman++) {
                if (womenPrefernce[currWomen - 1][prevman] == currMan) {
                    break;
                }
                int potentialMan = womenPrefernce[currWomen - 1][prevman];
                int pmCurrWomen = pairs[potentialMan - 1][1];
            //    System.out.println(" potential man is " + potentialMan);
            //    System.out.println("Potential man " + potentialMan + " is paired with " + pmCurrWomen);
                for(int prevWomen = 0; prevWomen < manPreference[i].length; prevWomen++) {
                    if(manPreference[potentialMan - 1][prevWomen] == pmCurrWomen) {
                        stable++;
                        System.out.println("Stable");
                        break;
                    }
                    if(manPreference[potentialMan - 1][prevWomen] == currWomen) {
                        System.out.println("unstable");
                        int temp = pairs[i][1];
                        pairs[i][1] = pairs[potentialMan - 1][1];
                        pairs[potentialMan - 1][1] = temp;
                        stable = 0;
                        print2D(pairs);
                      }
                    }
             }
         }
        }
    }

    public static void swap(int[][] pairs, int currWomen, int currMan, int pmCurrWomen, int potentialMan) {

    }

    public static void main(String[] args) {

        File myFile = new File("input.txt");
        Scanner myScanner = null;
        try {
            myScanner = new Scanner(myFile);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        num = myScanner.nextInt();
        int[][] menPreferences = new int[num][num];
        int[][] womensPreferences = new int[num][num];
        int[][] pairs = new int[num][2];

        // System.out.println(num);

        for (int rows = 0; rows < menPreferences.length; rows++) {
            for (int columns = 0; columns < menPreferences[rows].length; columns++) {
                menPreferences[rows][columns] = myScanner.nextInt();
            }
        }

        // filling 2d with womens preference
        for (int rows = 0; rows < womensPreferences.length; rows++) {
            for (int columns = 0; columns < womensPreferences[rows].length; columns++) {
                womensPreferences[rows][columns] = myScanner.nextInt();
            }
        }

        // filling 2d array with pairs
        for (int rows = 0; rows < pairs.length; rows++) {
            for (int columns = 0; columns < pairs[rows].length; columns++) {
                pairs[rows][columns] = myScanner.nextInt();
            }
        }

        // print2D(menPreferences);
        // print2D(womensPreferences);
        // print2D(pairs);
        // System.out.println("------------");
       // print2D(pairs);
        checkStable(womensPreferences, menPreferences, pairs);
            
        System.out.println("-------------");
       // System.out.println(count);
       // print2D(pairs);
    }

    public static void print2D(int mat[][]) {
        for (int[] row : mat)
            System.out.println(Arrays.toString(row));
    }

}
