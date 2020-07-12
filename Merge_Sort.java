
import java.util.*;

public class Merge_Sort {
	public static void main (String[] args) {
		List<Integer>list = new ArrayList<>();
		list.add(97);
		list.add(29);
		list.add(42);
		list.add(80);
		list.add(43);
		list.add(80);
		list.add(49);
		list.add(59);
		list.add(61);
		list.add(63);
		System.out.println("Before Sort");
		System.out.println(list);
		System.out.println("After Sort");
		System.out.println(MergeSort(list));
		
	}
	
	public static List<Integer> MergeSort (List<Integer> list) {
		if (list.size()<=1) {return list;}
		int mid = list.size()/2;
		//Divide-Part
		List<Integer> left = MergeSort(list.subList(0, mid));
		List<Integer> right = MergeSort(list.subList(mid, list.size()));
		//Conquer
		int i = 0;
		int j = 0;
		int k = 0;
		while(i<left.size() && j<right.size()) {
			if(left.get(i)<right.get(i)) {
				list.set(k, left.get(i));
				i+=1;
			}
			else {
				list.set(k, right.get(j));
				j+=1;
			}
			k+=1;
		}
		//if right element remains
		if (i==left.size()-1) {
			while(j<right.size()) {
				list.set(k,right.get(j));
				j+=1;
				k+=1;
			}
		}
		//if left element remains
		else if (j==right.size()-1) {
			while (i<left.size()) {
				list.set(k, left.get(i));
				i+=1;
				k+=1;
			}
		}
		return list;
	}
}
