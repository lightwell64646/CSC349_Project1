import java.util.Random;
import java.util.Arrays;

class SortCounts{
   public interface my_sort_interface{
      public void sort(int[] arr, int N);
   }

   public static void main(String []args){
      Random rd = new Random();
      Sorts1 mysorts = new Sorts1();

      for (int N = 5000; N <= 160000; N *= 2){
         long qs_time = 0;
         long ms_time = 0;
         long ss_time = 0;
         for (int i = 0; i < 5; i++){
            int[] arr1 = new int[N];
            int[] arr2 = new int[N];
            int[] arr3 = new int[N];
            int[] arr4 = new int[N];

            for (int j = 0; j < N; j++){
               arr1[j] = rd.nextInt();
               arr2[j] = arr1[j];
               arr3[j] = arr1[j];
               arr4[j] = arr1[j];
            }
            ss_time = mysorts.selectionSort(arr1, N);
            ms_time = mysorts.mergeSort(arr2, N);
            qs_time = mysorts.quickSort(arr3, N);
            System.out.printf("N = %d C_ss =  %d, C_ms = %d, C_qs = %d\n",  N, ss_time, ms_time, qs_time);
         }
         System.out.printf("\n");
      }
   }
}
