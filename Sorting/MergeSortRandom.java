import java.util.*;
class MergeSortRandom {	
	int count = 1;	
	void mergeSort(int a[],int p,int r) {
		int q;
		if(p<r) {
			q=(p+r)/2;
			mergeSort(a,p,q);
			mergeSort(a,q+1,r);
			merge(a,p,q,r);
		}
	}	
	void merge(int a[],int p,int q,int r) {
		int i,j,k;
		int t[]=new int[100000];
		i=p;
		j=q+1;
		k=p;
		while(i<=q&&j<=r) {
			if(a[i]<a[j]) {
				t[k]=a[i];
				i=i+1;
			}
			else {
				t[k]=a[j];
				j=j+1;
			}
			k=k+1;
			count++;
		}
		if(i>q) {
			while(j<=r) {
				t[k]=a[j];
				j=j+1;
				k=k+1;
				count++;
			}
		}
		else {
			while(i<=q) {
				t[k]=a[i];
				i=i+1;
				k=k+1;
				count++;
			}
		}
		for(k=p;k<=r;k++)
			a[k]=t[k];
	}	
	void display(int a[]) {
		for(int i=0; i<a.length; i++)
			System.out.print(a[i] + " ");
		System.out.println();
	}	
	public static void main(String ar[]) {
		Scanner s = new Scanner(System.in);
		Random r = new Random();
		System.out.println("Enter the no of array elements");
		int n = s.nextInt();
		if(n < 1) {
			System.out.println("Error in input size");
			System.exit(0);
		}
		int a[] = new int[n];
		for(int i=0; i<n; i++)
			a[i] = r.nextInt();
		MergeSortRandom msort = new MergeSortRandom();
		System.out.println("Array Elements before MergeSort");
		msort.display(a);
		msort.mergeSort(a,0,n-1);
		System.out.println("Array Elements after MergeSort");
		msort.display(a);
		System.out.println("No of comparisons made " + msort.count);
	}
}
