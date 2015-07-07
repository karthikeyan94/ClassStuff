/*
 RadixSort.java :  Sorts 32-bit integers with O(n*k) runtime performance.
                   Where k is the max number of digits of the numbers being
                   sorted.
                   (i.e. k=10 digits for 32-bit integers.)
 
 Copyright (C) 2013 Yeison Rodriguez ( github.com/yeison )
 
 This program is free software; you can redistribute it and/or
 modify it under the terms of the GNU General Public License
 as published by the Free Software Foundation; either version 2
 of the License, or (at your option) any later version.
 
 This program is distributed in the hope that it will be useful,
 but WITHOUT ANY WARRANTY; without even the implied warranty of
 MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 GNU General Public License for more details.
 
 You should have received a copy of the GNU General Public License
 along with this program; if not, write to the Free Software
 Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
 
import java.util.Random;
 
public class RadixSort {
 
    // Main function to test performance sorting 1 million integers.
    // Results in about 220 ms on a 2.3 Ghz Core i5 processor w/4GB 1333 Mhz RAM
    public static void main(String[] args){
        final int SIZE = 1000000;
 
        Random r = new Random();
        int[] test = new int[SIZE];
 
        for (int i = 0; i < SIZE; i++){
            test[i] = r.nextInt(Integer.MAX_VALUE);
        }
 
        long start = System.currentTimeMillis();
        test = sort(test);
        long end = System.currentTimeMillis();
 
        for (Integer i : test){
            System.out.println(i);
        }
 
        System.out.println(end-start);
    }
 
    // Sort the numbers beginning with least-significant digit
    public static int[] sort(int[] input){
 
        // Largest place for a 32-bit int is the 1 billion's place
        for(int place=1; place <= 1000000000; place *= 10){
            // Use counting sort at each digit's place
            input = countingSort(input, place);
        }
 
        return input;
    }
 
    private static int[] countingSort(int[] input, int place){
        int[] out = new int[input.length];
 
        int[] count = new int[10];
 
        for(int i=0; i < input.length; i++){
            int digit = getDigit(input[i], place);
            count[digit] += 1;
        }
 
        for(int i=1; i < count.length; i++){
            count[i] += count[i-1];
        }
 
        for(int i = input.length-1; i >= 0; i--){
            int digit = getDigit(input[i], place);
 
            out[count[digit]-1] = input[i];
            count[digit]--;
        }
 
        return out;
 
    }
 
    private static int getDigit(int value, int digitPlace){
        return ((value/digitPlace ) % 10);
    }
 
}
