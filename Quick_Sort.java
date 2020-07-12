import java.util.*;

public class Quick_Sort {

	public static void main(String[] args) {
		List<Integer>list = new ArrayList<>();
		list.add(66);
		list.add(10);
		list.add(1);
		list.add(34);
		list.add(5);
		list.add(-10);
		//Quick2(list,0,list.size()-1);
		System.out.println(list);
		System.out.println(Quick(list));

	}
	
	public static List<Integer> Quick(List<Integer> list) {
		if (list.size()<=1) {
			return list;
		}
		int pivot = list.get(list.size()/2);
		List<Integer> left_list = new ArrayList<>();
		List<Integer> equal_list = new ArrayList<>();
		List<Integer> right_list = new ArrayList<>();
		for(int num: list) {
			if (num<pivot) {
				left_list.add(num);
			}
			else if (num>pivot) {
				right_list.add(num);
			}
			else {
				equal_list.add(num);
			}
		}
		List<Integer> ans = new ArrayList<>();
		ans.addAll(Quick(left_list));
		ans.addAll(equal_list);
		ans.addAll(Quick(right_list));
		return ans;
		//return Stream.of(Quick(left_list),equal_list,Quick(right_list)).flatMap(Collection::stream).collect(Collectors.toList());
	}
	
	public static void Quick2 (List<Integer> list, int l, int r) {
		int left = l;
		int right = r;
		int pivot = list.get((l+r)/2);
		while(left<=right) {
			while(list.get(left)<pivot) left++;
			while(list.get(right)>pivot) right--;
			if(left<=right) {
				int tmp = list.get(left);
				list.set(left,list.get(right));
				list.set(right, tmp);
				left++;
				right--;
			}
		}
		if (l<right) Quick2(list,l,right);
		if (r>left) Quick2(list,left,r);
	}

}
