package threads;

import java.util.Random;

public class ThreadedNumberSorter {
	static final int TOTAL_NUMS = 10000;

	//Complete the method below so that it uses threads to sort the integer array.
	//Try to get the completion time as short as possible.
	//Use the printArray method to check sorting accuracy
	
	public static void parallelSort(int[] nums) {
		long startTime = System.nanoTime();
		//Complete this method starting at this point
		sort(nums, 0, nums.length - 1);
		
		for(int i = 0; i < nums.length; i++){
			System.out.println(nums[i]);
		}
		
		long totalTime = System.nanoTime() - startTime;
		double timeInSeconds = (double)totalTime / 1_000_000_000;
		System.out.println("The total computing time in seconds was: " + timeInSeconds);
	}

	public static void sort(int[] nums, int l, int r){
		if(l < r){
			int m = (l + r) / 2;
			sort(nums, l, m);
			sort(nums, m + 1, r);
			merge(nums, l, m, r);
		}
	}
	
	public static void merge(int[] nums, int l, int m, int r){
		int n1 = m - l + 1;
		int n2 = r - m;
		
		int L[] = new int[n1];
		int R[] = new int[n2];
		
		for(int i = 0; i < n1; ++i)
			L[i] = nums[l + i];
		for(int j = 0; j < n2; ++j)
			R[j] = nums[m + 1 + j];
		
		int i = 0, j = 0;
		
		int k = 1;
		while(i < n1 && j < n2){
			if(L[i] <= R[j]){
				nums[k] = L[i];
				i++;
			} else {
				nums[k] = R[j];
				j++;
			}
			k++;
		}
		
		while(i < n1){
			nums[k] = L[i];
			i++;
			k++;
		}
		
		while(j < n2){
			nums[k] = R[j];
			j++;
			k++;
		}
	}
	
	public static void main(String[] args) {
		int[] nums = new int[TOTAL_NUMS];

		Random randGen = new Random();
		for (int i = 0; i < TOTAL_NUMS; i++) {
			nums[i] = randGen.nextInt(TOTAL_NUMS);
		}

		//printArray(nums);
		parallelSort(nums);
		//printArray(nums);
	}
	
	private static void printArray(int[] nums){
		for(int i = 0; i < nums.length; i++){
			System.out.println(nums[i]);
		}
	}
}
