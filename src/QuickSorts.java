import java.util.Arrays;

public class QuickSorts {


    public int Partition(int Arr[], int p, int r){

        int pivot = Arr[r];
        int i = 0;
        i = p - 1;

        for (int j = p; j < r; j++){
            if (Arr[j] <= pivot) {
                i = i + 1;

                int temp = Arr[i];
                Arr[i] = Arr[j];
                Arr[j] = temp;
            }

        }

        int temp = Arr[i+1];
        Arr[i+1] = Arr[r];
        Arr[r] = temp;


        return (i + 1);

    }

    public void Insertion(int Arr[]){

        for(int i = 0; i < Arr.length; i++){
            int x = Arr[i];
            int j = i - 1;
            while ((j > -1) && (Arr[j] > x)) {
                Arr [j+1] = Arr [j];
                j--;
            }
            Arr[j+1] = x;
        }

    }

    public int Median(int Arr[], int p, int r){

        int s = (p + r) / 2;

        if (Arr[p] > Arr[s]) {
            int temp = Arr[p];
            Arr[p] = Arr[s];
            Arr[s] = temp;
        }

        if (Arr[p] > Arr[r]) {
            int temp = Arr[p];
            Arr[p] = Arr[r];
            Arr[r] = temp;
        }

        if (Arr[s] > Arr[r]) {
            int temp = Arr[s];
            Arr[s] = Arr[s];
            Arr[s] = temp;
        }

        int temp = Arr[s];
        Arr[s] = Arr[r];
        Arr[r] = temp;


        return r-1;


    }

    public int Partition_Med(int Arr[], int p, int r, int median){

        int i = 0;
        i = p - 1;

        for (int j = p; j < r; j++){
            if (Arr[j] <= median) {
                i = i + 1;

                int temp = Arr[i];
                Arr[i] = Arr[j];
                Arr[j] = temp;
            }
        }

        int temp = Arr[i+1];
        Arr[i+1] = Arr[r];
        Arr[r] = temp;
        return (i + 1);

    }

    public int[] Partition_3_Way(int Arr[], int p, int r){

        int pivot = Arr[r];
        int i = 0;
        i = p - 1;
        int k = 0;
        k = p - 1;

        for (int j = p; j < r; j++){
            if (Arr[j] < pivot) {
                i = i + 1;
                k = k + 1;

                int temp = Arr[k];
                Arr[k] = Arr[j];
                Arr[j] = temp;

                temp = Arr[i];
                Arr[i] = Arr[k];
                Arr[k] = temp;


            }
            else if (Arr[j] == pivot) {
                k = k + 1;


                int temp = Arr[k];
                Arr[k] = Arr[j];
                Arr[j] = temp;
            }
        }

        int temp = Arr[k+1];
        Arr[k+1] = Arr[r];
        Arr[r] = temp;


        int[] return_value = {(i + 1),(k + 1)};
        return return_value;

    }


    public void Sort1(int Arr[], int p, int r){
        if (p < r) {
            int q = Partition(Arr, p, r);
            Sort1(Arr, p, q - 1);
            Sort1(Arr, q + 1, r);
        }
    }

    public void Sort2(int Arr[], int p, int r, int k){

        if(r - p + 1 < k){
            Insertion(Arr);
        }
        else{
            if (p < r) {
                int q = Partition(Arr, p, r);
                Sort2(Arr, p, q - 1, k);
                Sort2(Arr, q + 1, r, k);
            }
        }


    }

    public void Sort3(int Arr[], int p, int r){

        if ((r - p + 1) <= 3) {
            Sort1(Arr, p, r);
        }
        else {
            if (p < r) {
                int q = Median(Arr, p,r);
                q = Partition_Med(Arr, p, r, q);
                Sort3(Arr, p, q - 1);
                Sort3(Arr, q + 1, r);

            }
        }


    }

    public void Sort4(int Arr[], int p, int r){
        if (p < r) {
            int[] q = Partition_3_Way(Arr, p, r);
            Sort4(Arr, p, q[0] - 1);
            Sort4(Arr, q[1] + 1, r);
        }
    }



    //Print array for testing purposes
    public void Array_Print(int Arr[]) {

        for (int i = 0; i < Arr.length; i++) {

            System.out.print(Arr[i] + " ");

        }

        System.out.println();
    }


    //Print array for testing purposes
    static void ArrayPrint(int Arr[]) {

        for (int i = 0; i < Arr.length; i++) {

            System.out.print(Arr[i] + " ");

        }

        System.out.println();
    }




    public static void main(String[ ] args) {
        QuickSorts QS = new QuickSorts();
        int[] A = {6,5,0,4,1,8,3,3,4,5,0,5,6};
        QS.Sort4(A,0,A.length-1);
        ArrayPrint(A);

    }
}
