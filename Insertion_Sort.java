
public class Insertion_Sort {
	public static void main(String[] args) {
		int[] list = {8,5,6,2,4};
		System.out.println("Before Sort");
		for(int i=0;i<list.length;i++) {
			System.out.println("Index"+i+" is "+list[i]);
		}
		Insertion(list);
		System.out.println("After Sort");
		for(int i=0;i<list.length;i++) {
			System.out.println("Index"+i+" is "+list[i]);
		}
	}
	
	public static void Insertion(int[] list) {
		int i,j,key;
		int n = list.length;
		for(i=1; i<n;i++) {
			key = list[i];
			for (j=i-1;j>=0 &&list[j]>key;j--) {
				list[j+1] = list[j];
			}
			list[j+1]=key;
		}
	}
}
