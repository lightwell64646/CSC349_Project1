/*
******HEADER****** 
Authors: Nathan Pestes (npestes)
         Kiana Dyson   (kdyson)
Project #: 1
Date: 4-12-2019
Class: CSC349
*/

class Sorts1{   
   public static long selectionSort(int[] arr, int N){
     long comparisons = 0;
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
   public static long mergeSort(int[] arr, int N){
      return mergeSort(arr, 0, N - 1);
   }
   private static long mergeSortedHalves(int[] arr, int first, int middle, int last){
      
      int temp[] = new int[last - first + 1];
      int index1 = first;
      int index2 = middle + 1;
      int index = 0;
      long comparisons = 0;

      //pull smallest step
      while (index1 <= middle && index2 <= last){
         comparisons += 1;
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
      return comparisons;
   }
   private static long mergeSort(int[] arr, int first, int last){
      long comparisons = 0;
      if (first < last){
         int middle = (first + last) / 2;
         comparisons += mergeSort(arr, first, middle);
         comparisons += mergeSort(arr, middle + 1, last);
         comparisons += mergeSortedHalves(arr, first, middle, last);
      }
      return comparisons;
   }

   private static long qs_comparisons;
   public static long quickSort(int[] arr, int N){
      qs_comparisons = 0;
      quickSort(arr, 0, N - 1);
      return qs_comparisons;
   }

   private static void swap(int[] arr, int i, int j){
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
      qs_comparisons += 3;
   }

   private static int splitList(int[] arr, int left, int right){
      int low_index = left;
      int high_index = right - 1;
      int pivot_value = arr[right];

      while (low_index <= high_index){
         qs_comparisons += 1;
         while (arr[low_index] < pivot_value){
            qs_comparisons += 1;
            low_index ++;
         }
         qs_comparisons += 1;
         while (high_index >= low_index && arr[high_index] > pivot_value){
            qs_comparisons += 1;
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




