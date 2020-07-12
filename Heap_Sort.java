
public class Heap_Sort {
	public static void main(String[] args) {
		int[] arr = {16,4,10,14,7,9,3,2,8,1};
		int[] sortArr = HeapSort(arr);
		for (int i=0;i<sortArr.length;i++) {
			System.out.println(sortArr[i]);
		}
	}
	
	public static int[] HeapSort(int[] arr) {
		int n = arr.length;
		for (int i=n/2-1; i>=0;i--) {
			heapify(arr,i,n);
		}
		for (int i=n-1;i>0;i--) {
			int tmp = arr[0];
			arr[0] = arr[i];
			arr[i] = tmp;
			heapify(arr,0,i);
		}
		return arr;
	}
	
	public static void heapify(int[] arr, int index,int heapsize) {
		int largest = index;
		int left_ind = 2*index + 1;
		int right_ind = 2*index + 2;
		if (left_ind < heapsize && arr[left_ind]>arr[largest]) {
			largest = left_ind;
		}
		if (right_ind < heapsize && arr[right_ind]>arr[largest]) {
			largest = right_ind;
		}
		if (largest!=index) {
			int tmp = arr[largest];
			arr[largest] = arr[index];
			arr[index] = tmp;
			heapify(arr,largest,heapsize);
		}
	}

}
