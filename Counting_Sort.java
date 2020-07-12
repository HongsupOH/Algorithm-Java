import java.util.*;

public class Counting_Sort {

	public static void main(String[] args) {
		int[] list = {53, 46, 60, 87, 70, 74, 99, 68, 96, 90};
		countingSort(list,0,100);
		for(int num: list) {
			System.out.println(num);
		}

	}
	
	public static void countingSort(int[] list, int min, int max) {
		int nbins = max - min + 1;
		int[] bins = new int[nbins];
		for(int num:list) {
			bins[num-min]+=1;
		}
		int index = 0;
		for (int i=0;i<nbins;i++) {
			for (int j=0;j<bins[i];j++) {
				list[index] = i+min;
				index+=1;
			}
		}
	}

}
