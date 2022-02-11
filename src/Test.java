import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test {

    //This file stores the testing code and the baseline sort (insertion)

    public static boolean Sorted(int Arr[]) {

        for (int i = 0; i < Arr.length - 1; i++) {
            if (Arr[i] > Arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static int[] Insertion(int Arr[]){

        for (int i = 1; i < Arr.length; i++){

            int Key = Arr[i];
            int j = i-1;

            while ((j >= 0) && (Arr[j] > Key)){

                Arr[j+1] = Arr[j];
                j--;

            }

            Arr[j+1] = Key;

        }

        return Arr;
    }



    public static int[] ReadFile(String FileName){

        String data = "";
        //Read file in
        try{
            Scanner fileReader = new Scanner(new File(FileName));
            while (fileReader.hasNextLine()) {
                data = data + fileReader.nextLine() + "&";
            }
            fileReader.close();
        }
        catch (FileNotFoundException e) {
            System.out.println("An error has occurred");
        }

        //Split string into array
        String[] arrOfStr = data.split("&");

        //Turn array of String into array of int
        int[] returnArr = new int[arrOfStr.length];

        for(int i = 0; i < arrOfStr.length; i++){
            if(arrOfStr[i] != ""){
                returnArr[i] = Integer.parseInt(arrOfStr[i]);
            }

        }

        return returnArr;

    }




}

