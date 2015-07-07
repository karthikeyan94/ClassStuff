import java.util.*;
class MaxSubArray {
	
	String findCrossSubArray(int a[], int low, int mid, int high) {
		int leftsum = -2147483648, sum = 0;
		int leftindex = 0, rightindex = 0;
		for(int i=mid; i>=low; i--) {
			sum += a[i];
			if(sum > leftsum) {
				leftsum = sum;
				leftindex = i;
			}
		}
		int rightsum = -2147483648;
		sum = 0;
		for(int i=mid+1; i<=high; i++) {
			sum += a[i];
			if(sum > rightsum) {
				rightsum = sum;
				rightindex = i;
			}
		}
		return (new String(leftindex + " " + rightindex + " " + (rightsum+leftsum)));
	}
	
	String findMaxSubArray(int a[], int low, int high) {
		if(low == high)
			return (new String(low + " " + high + " " + a[low]));
		else {
			int mid = (low+high)/2;
			String left, right, cross;
			left = findMaxSubArray(a, low, mid);
			right = findMaxSubArray(a, mid+1, high);
			cross = findCrossSubArray(a, low, mid, high);
			Scanner s = new Scanner(left);
			int lleft[] = new int[3];
			int rright[] = new int[3];
			int ccross[] = new int[3];
			for(int i=0; i<3; i++)
				lleft[i] = s.nextInt();
			s = new Scanner(right);
			for(int i=0; i<3; i++)
				rright[i] = s.nextInt();
			s = new Scanner(cross);
			for(int i=0; i<3; i++)
				ccross[i] = s.nextInt();
			if(lleft[2]>=rright[2] && lleft[2]>=ccross[2])
				return (new String(lleft[0] + " " + lleft[1] + " " + lleft[2]));
			else if(rright[2]>=lleft[2] && rright[2]>=ccross[2])
				return (new String(rright[0] + " " + rright[1] + " " + rright[2]));
			else
				return (new String(ccross[0] + " " + ccross[1] + " " + ccross[2]));
		}
	}
	
	public static void main(String ar[]) {
		MaxSubArray max = new MaxSubArray();
		Scanner s = new Scanner(System.in);
		int n;
		System.out.println("Enter no of array elements");
		n = s.nextInt();
		if(n < 1) {
			System.out.println("Error in input size");
			System.exit(0);
		}
		int a[] = new int[n];
		System.out.println("Enter array elements");
		for(int i=0; i<n; i++)
			a[i] = s.nextInt();
		System.out.println("Maximum SubArray : " + max.findMaxSubArray(a, 0, n-1));
	}
}
