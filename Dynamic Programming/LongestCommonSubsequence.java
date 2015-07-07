import java.util.*;
class LongestCommonSubsequence {
		
	void LCS_LENGTH(int x[],int y[], int c[][], int b[][]) {
		for(int i=0; i<=x.length; i++)
			c[i][0] = 0;
		for(int j=1; j<=y.length; j++)
			c[0][j] = 0;
		for(int i=1; i<=x.length; i++)
			for(int j=1; j<=y.length; j++) {
				if(x[i-1] == y[j-1]) {
					c[i][j] = c[i-1][j-1]+1;
					b[i][j] = 1; //diagonal
				}
				else if(c[i][j-1] >= c[i-1][j]) {
					c[i][j] = c[i][j-1];
					b[i][j] = 0; //left
				}
				else {
					c[i][j] = c[i-1][j];
					b[i][j] = 2; //top
				}
			}
	}
	
	void PRINT_LCS(int b[][], int x[], int i, int j) {
		if(i==0 || j==0)
			return;
		else if(b[i][j] == 1) {
			PRINT_LCS(b,x,i-1,j-1);
			System.out.print((char)(x[i-1]) + " ");
		}
		else if(b[i][j] == 2)
			PRINT_LCS(b,x,i-1,j);
		else
			PRINT_LCS(b,x,i,j-1);
	}
	
	public static void main(String ar[]) {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter 1st sequence as a String");
		String x1 = s.nextLine();
		System.out.println("Enter 2nd sequence as a String");
		String y1 = s.nextLine();
		int x[] = new int[x1.length()];
		int y[] = new int[y1.length()];
		for(int i=0; i<x1.length(); i++)
			x[i] = (int)(x1.charAt(i));
		for(int i=0; i<y1.length(); i++)
			y[i] = (int)(y1.charAt(i));
		int c[][] = new int[1+x.length][y.length+1];
		int b[][] = new int[1+x.length][y.length+1];
		LongestCommonSubsequence lc = new LongestCommonSubsequence();
		lc.LCS_LENGTH(x, y, c, b);
		System.out.println("\nValue table");
		for(int i=0; i<=x.length; i++) {
			for(int j=0; j<=y.length; j++)
				System.out.print(c[i][j] + " ");
			System.out.println();
		}
		System.out.println("\nArrow table");
		for(int i=0; i<=x.length; i++) {
			for(int j=0; j<=y.length; j++)
				System.out.print(b[i][j] + " ");
			System.out.println();
		}
		System.out.println("\nLongest Common Subsequence");
		lc.PRINT_LCS(b, x, x.length, y.length);
	}
}
