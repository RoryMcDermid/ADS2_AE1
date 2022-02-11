import java.util.Random;

public class TimeSortingAlgorithms {

    public static void main(String[ ] args){


        //Change between: int10,int50,int100 and int1000. Above this causes a stackoverflow error I have not yet been able to solve
        String FileName = "./Test_Data/int1000.txt";

        int[] InputArray = Test.ReadFile(FileName);


        int[] InsertionArray = Test.ReadFile(FileName);

        //Used to test A and D with duplicates, initialising A_Array (line 40) and D_Array (line 70) further down must be removed if these lines are activated
        /*
        int[] A_Array = new int[1000];
        int[] D_Array = new int[1000];



        Random randNum = new Random();
        for (int i = 0; i < A_Array.length; i++) {
            int temp = randNum.nextInt(0, 10);
            A_Array[i] = temp;
            D_Array[i] = temp;
        }
        //*/


        long INS_startTime = System.nanoTime();
        Test.Insertion(InsertionArray);
        long INS_endTime   = System.nanoTime();
        long INS_totalTime = INS_endTime - INS_startTime;
        System.out.println("Execution time for Insertion Sort is : " + INS_totalTime + " nanoseconds");



        int[] A_Array = Test.ReadFile(FileName);

        //This line has to be here as otherwise Sort1 goes from EXE time of 6000~ to 350000
        QuickSorts.ArrayPrint(A_Array);

        long Sort1_startTime = System.nanoTime();
        QuickSorts.Sort1(A_Array, 0, A_Array.length-1);
        long Sort1_endTime   = System.nanoTime();
        long Sort1_totalTime = Sort1_endTime - Sort1_startTime;
        System.out.println("Execution time for Sort 1A is : " + Sort1_totalTime + " nanoseconds");


        int[] B_Array = Test.ReadFile(FileName);

        long Sort2_startTime = System.nanoTime();
        QuickSorts.Sort2(B_Array, 0, B_Array.length-1, 5000);
        long Sort2_endTime   = System.nanoTime();
        long Sort2_totalTime = Sort2_endTime - Sort2_startTime;
        System.out.println("Execution time for Sort 1B is : " + Sort2_totalTime + " nanoseconds");


        int[] C_Array = Test.ReadFile(FileName);

        long Sort3_startTime = System.nanoTime();
        QuickSorts.Sort3(C_Array, 0, C_Array.length-1);
        long Sort3_endTime   = System.nanoTime();
        long Sort3_totalTime = Sort3_endTime - Sort3_startTime;
        System.out.println("Execution time for Sort 1C is : " + Sort3_totalTime + " nanoseconds");


        int[] D_Array = Test.ReadFile(FileName);

        long Sort4_startTime = System.nanoTime();
        QuickSorts.Sort4(D_Array, 0, D_Array.length-1);
        long Sort4_endTime   = System.nanoTime();
        long Sort4_totalTime = Sort4_endTime - Sort4_startTime;
        System.out.println("Execution time for Sort 1D is : " + Sort4_totalTime + " nanoseconds");

    }

}
