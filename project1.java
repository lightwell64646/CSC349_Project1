import java.util.Random;

class project1{   
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
      while (index1 < middle && index2 < last){
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
      while (index1 != middle){
         temp[index] = arr[index1];
         index += 1;
         index1 += 1;
      }
      while (index2 != last){
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
         //normal
         int middle = (first + last) / 2;
         mergeSort(arr, first, middle);
         mergeSort(arr, middle + 1, last);
         mergeSortedHalves(arr, first, middle, last);
      }
      else{
         //basecase
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
         swap(arr,first, median);      }

      if (arr[first] > arr[last]){
         swap(arr,first, last);      }

      if (arr[median] < arr[last]){
         swap(arr,median, last);      }

   }

   private static int splitList(int[] arr, int left, int right){
      int low_index = left;
      int pivot_value = arr[right];
      for (int i = left; i < right; i++){
         if (arr[i] < pivot_value){
            swap(arr,low_index, i);
            low_index += 1;
         }
      }

      swap(arr,low_index, right);
      /*
      buf = arr[low_index];
      arr[low_index] = arr[right];
      arr[right] = buf;
      */

      return low_index;
   }

   private static void quickSort(int[] arr, int first, int last){
      if (first < last){
         setPivotToEnd(arr, first, last);
         int pivotIndex = splitList(arr, first, last);
         quickSort(arr, first, pivotIndex);
         quickSort(arr, pivotIndex + 1, last);
      }
   }

   public interface my_sort_interface{
      public void sort(int[] arr, int N);
   }

   public static void time_sort(my_sort_interface sort_func, int N, Random rd){
      int[] arr = new int[N];
      for (int i = 0; i < arr.length; i++){
         arr[i] = rd.nextInt() % 10000;
      }

      long stime = System.nanoTime();
      sort_func.sort(arr, N);
      long etime = System.nanoTime();
      
      int last = arr[0];
      for (int i = 1; i < arr.length; i++){
         assert (arr[i] >= last);
         last = arr[i];
      }

      System.out.printf("%d - ", N);
      System.out.println((etime - stime) / 1000000);

   }

   public static void main(String []args){
      Random rd = new Random();
      my_sort_interface selectS = (arr, N) -> selectionSort(arr, N);
      my_sort_interface mergeS = (arr, N) -> mergeSort(arr, N);
      my_sort_interface quickS = (arr, N) -> quickSort(arr, N);

      for (int N = 100; N < 200000; N*=2){
         time_sort(selectS, N, rd);
      }
      for (int N = 100; N < 200000; N*=2){
         time_sort(mergeS, N, rd);
      }
      for (int N = 100; N < 200000; N*=2){
         time_sort(quickS, N, rd);
      }


   }

}




