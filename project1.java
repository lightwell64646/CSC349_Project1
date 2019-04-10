import java.util.Random;
import java.util.Arrays;

class Sorts{   
   public static void selectionSort(int[] arr, int N){
      for (int i = 0; i < N; i++){
         int min = arr[i];
         int min_index = i;
         for (int j = i + 1; j < N; j++){
            if (min > arr[j]){
               min = arr[j];
               min_index = j;
            }
         }
         arr[min_index] = arr[i];
         arr[i] = min;
      }
   }
   public static void mergeSort(int[] arr, int N){
      mergeSort(arr, 0, N - 1);
   }
   private static void mergeSortedHalves(int[] arr, int first, int middle, int last){
      
      int temp[] = new int[last - first + 1];
      int index1 = first;
      int index2 = middle + 1;
      int index = 0;

      //pull smallest step
      while (index1 <= middle && index2 <= last){
         if (arr[index1] < arr[index2]){
            temp[index] = arr[index1];
            index1 += 1;
         }
         else{
            temp[index] = arr[index2];
            index2 += 1;
         }
         index += 1;
      }

      //copy remainder
      while (index1 != middle + 1){
         temp[index] = arr[index1];
         index += 1;
         index1 += 1;
      }
      while (index2 != last + 1){
         temp[index] = arr[index2];
         index += 1;
         index2 += 1;
      }

      //copy tmp step
      for (index = 0; index < last - first + 1; index++){
         arr[first + index] = temp[index];
      }
   }
   private static void mergeSort(int[] arr, int first, int last){
      if (first < last){
         int middle = (first + last) / 2;
         mergeSort(arr, first, middle);
         mergeSort(arr, middle + 1, last);
         mergeSortedHalves(arr, first, middle, last);
      }
   }

   public static void quickSort(int[] arr, int N){
      quickSort(arr, 0, N - 1); 
   }

   public static void swap(int[] arr, int i, int j){
      int buf = arr[i];
      arr[i] = arr[j];
      arr[j] = buf; 
   }

   private static void setPivotToEnd(int[] arr, int first, int last){
      int min, max, median;
      median = (first + last)/2;
      if (arr[first] > arr[median]){
         swap(arr,first, median);
      }

      if (arr[first] > arr[last]){
         swap(arr,first, last);
      }

      if (arr[median] < arr[last]){
         swap(arr,median, last);
      }

   }

   private static int splitList(int[] arr, int left, int right){
      int low_index = left;
      int high_index = right - 1;
      int pivot_value = arr[right];

      while (low_index <= high_index){
         while (arr[low_index] < pivot_value){
            low_index ++;
         }
         while (high_index >= low_index && arr[high_index] > pivot_value){
            high_index --;
         }
         if (low_index <= high_index){
            swap(arr,low_index, high_index);
            low_index += 1;
            high_index -= 1;
         }
      }

      swap(arr,low_index, right);

      return low_index;
   }

   private static void quickSort(int[] arr, int first, int last){
      if (first < last){
         setPivotToEnd(arr, first, last);
         int pivotIndex = splitList(arr, first, last);
         quickSort(arr, first, pivotIndex - 1);
         quickSort(arr, pivotIndex + 1, last);
      }
   }
}

class Sorts1{   
   public static int selectionSort(int[] arr, int N){
      int comparisons = 0;
      for (int i = 0; i < N; i++){
         int min = arr[i];
         int min_index = i;
         for (int j = i + 1; j < N; j++){
            comparisons += 1;
            if (min > arr[j]){
               min = arr[j];
               min_index = j;
            }
         }
         arr[min_index] = arr[i];
         arr[i] = min;
      }
      return comparisons;
   }
   public static void mergeSort(int[] arr, int N){
      mergeSort(arr, 0, N - 1);
   }
   private static void mergeSortedHalves(int[] arr, int first, int middle, int last){
      
      int temp[] = new int[last - first + 1];
      int index1 = first;
      int index2 = middle + 1;
      int index = 0;

      //pull smallest step
      while (index1 <= middle && index2 <= last){
         if (arr[index1] < arr[index2]){
            temp[index] = arr[index1];
            index1 += 1;
         }
         else{
            temp[index] = arr[index2];
            index2 += 1;
         }
         index += 1;
      }

      //copy remainder
      while (index1 != middle + 1){
         temp[index] = arr[index1];
         index += 1;
         index1 += 1;
      }
      while (index2 != last +1){
         temp[index] = arr[index2];
         index += 1;
         index2 += 1;
      }

      //copy tmp step
      for (index = 0; index < last - first + 1; index++){
         arr[first + index] = temp[index];
      }
   }
   private static void mergeSort(int[] arr, int first, int last){
      if (first < last){
         int middle = (first + last) / 2;
         mergeSort(arr, first, middle);
         mergeSort(arr, middle + 1, last);
         mergeSortedHalves(arr, first, middle, last);
      }
   }

   public static void quickSort(int[] arr, int N){
      quickSort(arr, 0, N - 1); 
   }

   public static void swap(int[] arr, int i, int j){
      int buf = arr[i];
      arr[i] = arr[j];
      arr[j] = buf; 
   }

   private static void setPivotToEnd(int[] arr, int first, int last){
      int min, max, median;
      median = (first + last)/2;
      if (arr[first] > arr[median]){
         swap(arr,first, median);
      }

      if (arr[first] > arr[last]){
         swap(arr,first, last);
      }

      if (arr[median] < arr[last]){
         swap(arr,median, last);
      }

   }

   private static int splitList(int[] arr, int left, int right){
      int low_index = left;
      int high_index = right - 1;
      int pivot_value = arr[right];

      while (low_index <= high_index){
         while (arr[low_index] < pivot_value){
            low_index ++;
         }
         while (high_index >= low_index && arr[high_index] > pivot_value){
            high_index --;
         }
         if (low_index <= high_index){
            swap(arr,low_index, high_index);
            low_index += 1;
            high_index -= 1;
         }
      }

      swap(arr,low_index, right);

      return low_index;
   }

   private static void quickSort(int[] arr, int first, int last){
      if (first < last){
         setPivotToEnd(arr, first, last);
         int pivotIndex = splitList(arr, first, last);
         quickSort(arr, first, pivotIndex - 1);
         quickSort(arr, pivotIndex + 1, last);
      }
   }
}

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
      my_sort_interface builtin = (arr, N) -> Arrays.sort(arr);


      /*System.out.println("Selection Sort");
      for (int N = 100; N < 200000; N*=2){
         time_sort(selectS, N, rd);
      }*/

      /*System.out.println("Merge Sort");
      for (int N = 100; N < 2000000; N*=2){
         time_sort(mergeS, N, rd);
      }

      System.out.println("Quick Sort");
      for (int N = 100; N < 2000000; N*=2){
         time_sort(quickS, N, rd);
      }

      System.out.println("built in Sort");
      for (int N = 100; N < 2000000; N*=2){
         time_sort(builtin, N, rd);
      }*/

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
            System.out.printf("N = %d T_ss =  %d, T_ms = %d, T_qs = %d, T_bi = %d\n",  N, ss_time, ms_time, qs_time, time_sort(builtin, arr4, N));
         }
         System.out.printf("\n");
      }
   }

}




