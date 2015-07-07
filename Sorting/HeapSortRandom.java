import java.util.*;
class HeapSortRandom {	
	int count = 0;
	void heapSort(int a[], int heapSize) {
		buildMaxHeap(a, heapSize);
		for(int i=a.length-1; i>=2; i--) {
			int temp = a[i];
			a[i] = a[1];
			a[1] = temp;
			heapSize = heapSize-1;
			maxHeapify(a, 1, heapSize);
		}
	}	
	void maxHeapify(int a[], int i, int heapSize) {
		int l = 2*i;
		int r = 2*i+1;
		int largest;
		if(l<=heapSize && a[l]>a[i])
			largest = l;
		else
			largest = i;
		count++;
		if(r<=heapSize && a[r]>a[largest]) {
			largest = r;
			count++;
		}
		if(largest != i) {
			int temp = a[largest];
			a[largest] = a[i];
			a[i] = temp;
			count++;
			maxHeapify(a, largest, heapSize);
		}
	}	
	void buildMaxHeap(int a[], int heapSize) {
		heapSize = a.length-1;
		for(int i=(a.length-1)/2; i>=1; i--)
			maxHeapify(a, i, heapSize);
	}	
	void display(int a[]) {
		for(int i=1; i<a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}	
	public static void main(String ar[]) {
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		System.out.println("Enter no of array elements");
		int n = s.nextInt();
		if(n < 1) {
			System.out.println("Error in input size");
			System.exit(0);
		}
		int a[] = new int[n+1];
		System.out.println("Enter array elements");
		for(int i=1; i<=n; i++)
			a[i] = r.nextInt(1000000000);
		HeapSortRandom hsort = new HeapSortRandom();
		System.out.println("Before Heap Sort");
		hsort.display(a);
		hsort.heapSort(a, n);
		System.out.println("After Heap Sort");
		hsort.display(a);
		System.out.println("No of comparisons " + hsort.count);
	}
}
