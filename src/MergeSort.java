public class MergeSort {
	public static void mergeSort(int[] a, int n) {
		if (n < 2) {
			return;
		}
		int mid = n / 2;
		int[] l = new int[mid];
		int[] r = new int[n - mid];

		for (int i = 0; i < mid; i++) {
			l[i] = a[i];
		}
		for (int i = mid; i < n; i++) {
			r[i - mid] = a[i];
		}
		mergeSort(l, mid);
		mergeSort(r, n - mid);

		merge(a, l, r, mid, n - mid);
	}


	public static void merge(int[] a, int[] l, int[] r, int left, int right) {
		int i = 0, j = 0, k = 0;
		while (i < left && j < right) {
			if (l[i] <= r[j]) {
				a[k++] = l[i++];
			}
			else {
				a[k++] = r[j++];
			}
		}
		while (i < left) {
			a[k++] = l[i++];
		}
		while (j < right) {
			a[k++] = r[j++];
		}
	}

//    static void merge(int[] array, int left, int mid, int right) {
//        // calculating lengths
//        int lengthLeft = mid - left + 1;
//        int lengthRight = right - mid;
//
//        // creating temporary subarrays
//        int leftArray[] = new int [lengthLeft];
//        int rightArray[] = new int [lengthRight];
//
//        // copying our sorted subarrays into temporaries
//        for (int i = 0; i < lengthLeft; i++)
//            leftArray[i] = array[left+i];
//        for (int i = 0; i < lengthRight; i++)
//            rightArray[i] = array[mid+i+1];
//
//        // iterators containing current index of temp subarrays
//        int leftIndex = 0;
//        int rightIndex = 0;
//
//        // copying from leftArray and rightArray back into array
//        for (int i = left; i < right + 1; i++) {
//            // if there are still uncopied elements in R and L, copy minimum of the two
//            if (leftIndex < lengthLeft && rightIndex < lengthRight) {
//                if (leftArray[leftIndex] < rightArray[rightIndex]) {
//                    array[i] = leftArray[leftIndex];
//                    leftIndex++;
//                }
//                else {
//                    array[i] = rightArray[rightIndex];
//                    rightIndex++;
//                }
//            }
//            // if all the elements have been copied from rightArray, copy the rest of leftArray
//            else if (leftIndex < lengthLeft) {
//                array[i] = leftArray[leftIndex];
//                leftIndex++;
//            }
//            // if all the elements have been copied from leftArray, copy the rest of rightArray
//            else if (rightIndex < lengthRight) {
//                array[i] = rightArray[rightIndex];
//                rightIndex++;
//            }
//        }
//    }
}
