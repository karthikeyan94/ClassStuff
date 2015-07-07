import java.util.*;
class InsertionSortRandom {
	int count = 1;
	
	void display(int a[]) {
		for(int i=0; i<a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}
	
	void insertSort(int b[]) {
		for(int i=1; i<b.length; i++) {
			int key = b[i];
			int j = i-1;			
			while(j>=0 && b[j]>key) {
				b[j+1]=b[j];
				j--;
				count++;
			}
			b[j+1]=key;	
		}			
	}
	
	public static void main(String ar[])throws Exception {		
		InsertionSortRandom isort=new InsertionSortRandom();
		Random s = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.println("No of array elements");
		int n = sc.nextInt();
		if(n < 1) {
			System.out.println("Error in input size");
			System.exit(0);
		}
		int a[] = new int[n];
		for(int i=0; i<n; i++)
			a[i] = s.nextInt(1000000000);
		System.out.println("Array elements before Insertion Sort");
		isort.display(a);
		if(n > 1)
			isort.insertSort(a);
		System.out.println("Array elements after Insertion Sort");
		isort.display(a);
		System.out.println("No of comparisons " + isort.count);
	}
	
}
