import java.util.*;

class ActivitySelection {
	public static void main(String ar[]) throws Exception {
		Scanner s = new Scanner(System.in);
		System.out.print("Enter the no of activities : ");
		int n = s.nextInt();
		int start[] = new int[n];
		int finish[] = new int[n];
		int arr[] = new int[n];
		for(int i=0; i<n; i++) {
			System.out.print("Enter the starting time for activity " + (i+1) + " : ");
			start[i] = s.nextInt();
			System.out.print("Enter the finish time for activity " + (i+1) + " : ");
			finish[i] = s.nextInt();
		}
		arr[1] = 1;
		int i = 2;
		for(int k=1,j=2; j<n; j++)
			if(start[j] >= finish[k]) {
				arr[i++] = j+1;
				k = j;
			}
		System.out.println("\nThe Selected Activity");
		for(int j=1; j<i; j++)
			System.out.print(arr[j] + " ");
	}
}
