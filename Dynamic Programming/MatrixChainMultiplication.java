import java.util.*;

class MatrixChainMultiplication {
	public static void main(String ar[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number of matrices : ");
		int arsize = sc.nextInt();
		int m[][] = new int[arsize+1][arsize+1];
		int s[][] = new int[arsize+1][arsize+1];
		int p[] = new int[arsize+1];
		System.out.print("Enter the dimensions : ");
		for(int i=0; i<=arsize; i++)
			p[i] = sc.nextInt();
		MatrixChainMultiplication mcm = new MatrixChainMultiplication();
		System.out.println("Total no of scalar multiplication : " + mcm.memoizedMatrixChain(p, m, s));
		System.out.print("The Optimum way of multiplication is : ");
		mcm.printParan(s, 1, arsize);
	}

	void printParan(int s[][], int i, int j) {
		if(i == j)
			System.out.print("A" + i + " ");
		else {
			System.out.print("(");
			printParan(s, i, s[i][j]);
			printParan(s, s[i][j]+1, j);
			System.out.print(")");
		}
	}
	
	int memoizedMatrixChain(int p[], int m[][], int s[][]) {
		int n = p.length - 1;
		for(int i=1; i<=n; i++)
			for(int j=i; j<=n; j++)
				m[i][j] = 32687;
		return lookupChain(p, m, 1, n, s);
	}
	
	int lookupChain(int p[], int m[][], int i, int j, int s[][]) {
		int q;
		if(m[i][j] < 32687)
			return m[i][j];
		else if(i == j) {
			m[i][j] = 0;
			return m[i][j];
		}
		else {
			for(int k=i; k<j; k++) {
				q = lookupChain(p, m, i, k, s) + lookupChain(p, m, k+1, j, s) + (p[i-1] * p[k] * p[j]);
				if(m[i][j] > q) {
					m[i][j]=q;
					s[i][j]=k;
				}
			}
		}
		return m[i][j];
	}
}
