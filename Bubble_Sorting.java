
public class Bubble_Sorting {

	public static void main(String[] args) {
		int[] list = {7,4,5,1,3};
		System.out.println("Before Sort");
		for(int i=0;i<list.length;i++) {
			System.out.println(list[i]);
		}
		bubble(list);
		System.out.println("After sort");
		for(int i=0;i<list.length;i++) {
			System.out.println(list[i]);
		}
	}
	public static void bubble(int[] list) {
		int n = list.length;
		for(int i=n-1;i>0;i--) {
			for(int j=0;j<i;j++) {
				if(list[j]>list[j+1]) {
					int tmp = list[j];
					list[j] = list[j+1];
					list[j+1] = tmp;
				}
			}
		}
	}

}
