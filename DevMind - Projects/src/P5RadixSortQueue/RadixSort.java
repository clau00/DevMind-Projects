package P5RadixSortQueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class RadixSort {

	private Queue<String>[] digitQueues = new ArrayDeque[10];
	private int max;
	
	public RadixSort() {
		for(int i=0; i<10; i++) {
			digitQueues[i] = new ArrayDeque();
		}
	}
	
	public void radixSort(String str) {
		for(double i=1; i<=max; i++) {
			//System.out.println("\t Pasul: " + (int)i);
			for(String el : str.split("\\s")) {
				int n = Integer.parseInt(el);
				//System.out.println(n);
				double digit = (n%Math.pow(10, i))/Math.pow(10, (i-1));
				int d = (int)digit;
				//System.out.println("\t" +d);
				digitQueues[d].add(el);
			}
			String rez = "";
			for(int j=0;j<10;j++) {
				while(!digitQueues[j].isEmpty()) {
					rez += digitQueues[j].poll() + " ";
				}
			}
			str = rez;
			System.out.println(rez);
		}
	}
	
	public static void main(String[] args) {
		int[] n = {1000, 4, 25, 319, 88, 51, 3430, 8471, 701, 1, 2989, 657, 713};
		RadixSort r = new RadixSort();
		String str = r.addZeros(n);
		r.radixSort(str);
	}
	
	private String addZeros(int[] n) {
		max = 0;
		for(int i=0; i<n.length; i++) {
			int digitsNo = getDigitsNo(n[i]);
			if(digitsNo > max) {
				max = digitsNo;
			}
		}
		StringBuilder sb = new StringBuilder();
		
		for(int i=0; i<n.length; i++) {
			int noOfZeros = max - getDigitsNo(n[i]);
			for(int j=0; j<noOfZeros; j++) {
				sb.append(0);
			}
			sb.append(n[i] + " ");
		}
		
		return sb.toString();
	}
	
	private int getDigitsNo(int n) {
		int counter = 0;
		while(n != 0) {
			counter++;
			n /= 10;
		}
		return counter;
	}
}
