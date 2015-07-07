import java.util.*;
class RodCutting {
	
	public static void main(String arg[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the length of the rod : ");
		int n = sc.nextInt();
		int p[] = new int[n+1];
		int r[] = new int[n+1];
		int s[] = new int[n+1];
		for(int i=1; i<=n; i++) {
			System.out.print("Enter the price for rod of length " + i + " : ");
			p[i] = sc.nextInt();
		}
		System.out.println("\nRod cut length  Maximum revenue");
		System.out.println("-------------------------------");
		for(int i=1; i<=n; i++)
			System.out.println(i + "\t\t" + memoizedCutRod(p, i, r, s));
	}
	
	static int memoizedCutRod(int p[], int n, int r[], int s[]) {
		int q, temp;
		if(r[n] > 0)
			return r[n];
		else if(n == 0) {
			r[0]=0;
			return r[0];
		}
		else {
			q = -1;
			for(int i=1; i<=n; i++) {
				temp = p[i] + memoizedCutRod(p, n-i, r, s);
				if(temp > q) {
					q = temp;
					s[n] = i;
				}
			}
			r[n] = q;
			return r[n];
		}
	}
}
