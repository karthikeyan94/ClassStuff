import java.util.*;
class QuickSortRandom {	
	int count = 0;
	int partition(int a[], int p, int r) {
		int x,i,j;
		x = a[r];
		i = p-1;
		int t;
		for(j=p; j<=r-1; j++) {
			if(a[j] <= x) {
				count++;
				i = i+1;
				t = a[i];
				a[i] = a[j];
				a[j] = t;
			}
		}
		t=a[i+1];
		a[i+1]=a[r];
		a[r]=t;
		return i+1;
	}
	void quickSort(int a[], int p, int r) {
		int q;
		if(p < r) {
			q = partition(a, p, r);
			quickSort(a, p, q-1);
			quickSort(a, q+1, r);
		}
	}
	void display(int a[]) {
		for(int i=0; i<a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}	
	public static void main(String ar[]) {
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		int n;
		System.out.println("Enter no of array elements");
		n = s.nextInt();
		if(n < 1) {
			System.out.println("Error in input size");
			System.exit(0);
		}
		int a[] = new int[n];
		for(int i=0; i<n; i++)
			a[i] = r.nextInt(1000000000);
		QuickSortRandom qsort = new QuickSortRandom();
		System.out.println("Array values before Quick Sort");
		qsort.display(a);
		qsort.quickSort(a, 0, n-1);
		System.out.println("Array values after Quick Sort");
		qsort.display(a);
		System.out.println("No of comparisons " + qsort.count);
	}
}
