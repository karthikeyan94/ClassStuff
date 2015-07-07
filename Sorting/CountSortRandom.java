import java.util.*;
class CountSortRandom {	
	void countSort(int a[], int b[], int h) {
		int c[] = new int[h+1], temp=0;
		for(int i=0; i<=c.length-1; i++)
			c[i] = 0;
		for(int i=1; i<=a.length-1; i++)
			c[a[i]] = c[a[i]] + 1;
		for(int i=1; i<=h; i++)
			c[i] = c[i] + c[i-1];		
		for(int j=a.length-1; j>=1; j--) {
			b[c[a[j]]] = a[j];
			c[a[j]] = c[a[j]] - 1;
		}
	}
	void display(int a[]) {
		for(int i=1; i<a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}
	public static void main(String arg[]) {
		CountSortRandom csort = new CountSortRandom();
		Random s = new Random();
		Scanner sc = new Scanner(System.in);
		System.out.println("No of array elements");
		int n = sc.nextInt();
		if(n < 1) {
			System.out.println("Error in input size");
			System.exit(0);
		}
		int a[] = new int[n+1];
		System.out.println("Enter max element:");
		int max = sc.nextInt();
		for(int i=1; i<=n; i++)
			a[i]=s.nextInt(max);
		System.out.println("Array elements before Count Sort");
		csort.display(a);
		int b[]=new int[n+1];
		csort.countSort(a,b,max);
		System.out.println("Array elements after Count Sort");
		csort.display(b);
	}
}
