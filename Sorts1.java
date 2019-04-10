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
   public static int mergeSort(int[] arr, int N){
      return mergeSort(arr, 0, N - 1);
   }
   private static int mergeSortedHalves(int[] arr, int first, int middle, int last){
      
      int temp[] = new int[last - first + 1];
      int index1 = first;
      int index2 = middle + 1;
      int index = 0;
      int comparisons = 0;

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
      return comparisons
   }
   private static int mergeSort(int[] arr, int first, int last){
      int comparisons = 0;
      if (first < last){
         int middle = (first + last) / 2;
         comparisons += mergeSort(arr, first, middle);
         comparisons += mergeSort(arr, middle + 1, last);
         comparisons += mergeSortedHalves(arr, first, middle, last);
      }
      return comparisons;
   }

   public static int quickSort(int[] arr, int N){
      return quickSort(arr, 0, N - 1); 
   }

   public static int swap(int[] arr, int i, int j){
      int buf = arr[i];
      arr[i] = arr[j];
      arr[j] = buf; 
   }

   private static int setPivotToEnd(int[] arr, int first, int last){
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
      return 3;
   }

   private static int splitList(int[] arr, int left, int right, int *comparisons){
      int low_index = left;
      int high_index = right - 1;
      int pivot_value = arr[right];

      while (low_index <= high_index){
         *comparisons += 1;
         while (arr[low_index] < pivot_value){
            *comparisons += 1;
            low_index ++;
         }
         *comparisons += 1;
         while (high_index >= low_index && arr[high_index] > pivot_value){
            *comparisons += 1;
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

   private static int quickSort(int[] arr, int first, int last){
      int comparisons = 0;
      if (first < last){
         comparisons += setPivotToEnd(arr, first, last);
         int pivotIndex = splitList(arr, first, last, &comparisons);
         comparisons += quickSort(arr, first, pivotIndex - 1);
         comparisons += quickSort(arr, pivotIndex + 1, last);
      }
      return comparisons;
   }
}




