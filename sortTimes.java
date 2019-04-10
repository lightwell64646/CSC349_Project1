import java.util.Random;
import java.util.Arrays;

class SortTimes{
   public interface my_sort_interface{
      public void sort(int[] arr, int N);
   }

   public static long time_sort(my_sort_interface sort_func, int arr[], int N){
      long stime = System.nanoTime();
      sort_func.sort(arr, N);
      long etime = System.nanoTime();
      
      int last = arr[0];
      for (int i = 1; i < arr.length; i++){
         assert (arr[i] >= last);
         last = arr[i];
      }

      //System.out.printf("%d - ", N);
      //System.out.println((etime - stime) / 1000000);
      return ((etime - stime) / 1000000);
   }

   public static void main(String []args){
      Random rd = new Random();
      Sorts mysorts = new Sorts();

      my_sort_interface selectS = (arr, N) -> mysorts.selectionSort(arr, N);
      my_sort_interface mergeS = (arr, N) -> mysorts.mergeSort(arr, N);
      my_sort_interface quickS = (arr, N) -> mysorts.quickSort(arr, N);

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
            ss_time = time_sort(selectS, arr1, N);
            ms_time = time_sort(mergeS, arr2, N);
            qs_time = time_sort(quickS, arr3, N);
            System.out.printf("N = %d T_ss =  %d, T_ms = %d, T_qs = %d\n",  N, ss_time, ms_time, qs_time);
         }
         System.out.printf("\n");
      }
   }
}