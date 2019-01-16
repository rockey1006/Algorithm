import java.util.Arrays;//
public class MergeSort {
	
		// 归并排序，递归实现
		public int[] sortMergeRecursion(int[] nums) {
		  sortMergeRecursionHelper(nums, 0, nums.length - 1);
		  return nums;
		}
		public void sortMergeRecursionHelper(int[] nums,int left, int right) {
		  if(left == right) return;  // 当待排序的序列长度为1时，递归开始回溯，进行merge
		  int middle = left + (right - left) / 2;
		  sortMergeRecursionHelper(nums, left, middle);
		  sortMergeRecursionHelper(nums, middle + 1, right);
		  mergeArr(nums, left, middle, right);
		}
		public void mergeArr(int[] nums, int left, int middle, int right) {
		  int[] tem = new int[right - left + 1];
		  int i = left, j = middle + 1, k = 0;
		  while(i <= middle && j <= right) {
		    tem[k++] = nums[i] < nums[j]? nums[i++] : nums[j++];
		  }
		  while(i <= middle) {
		    tem[k++] = nums[i++];
		  }
		  while(j <= right) {
		    tem[k++] = nums[j++];
		  }
		  // 将辅助数组数据写入原数组
		  int index = 0;
		  while(left <= right) {
		    nums[left++] = tem[index++];
		  }
		}
		// 归并排序，非递归实现(迭代)
		  public void sortMergeIteration(int[] nums) {
		    int len = 1;  // 初始排序数组的长度
		    while(len < nums.length) {
		      for(int i = 0; i < nums.length; i += len * 2) {
		        sortMergeIterationHelper(nums, i, len);
		      }
		      len *= 2;  // 每次将排序数组的长度*2
		    }
		  }
		  /**
		   * 辅助函数
		   * @param nums  原数组
		   * @param start 从start位置开始
		   * @param len  本次合并的数组长度
		   */
		  public void sortMergeIterationHelper(int[] nums, int start, int len) {
		    int[] tem = new int[len * 2];
		    int i = start;
		    int j = start + len;
		    int k = 0;
		    while(i < start + len && (j < start + len + len && j < nums.length)) {
		      tem[k++] = nums[i] < nums[j]? nums[i++] : nums[j++];
		    }
		    while(i < start + len && i < nums.length) {  // 注意：这里i也可能超出长度
		      tem[k++] = nums[i++];
		    }
		    while(j < start + len + len && j < nums.length) {
		      tem[k++] = nums[j++];
		    }
		    int right = start + len + len;
		    int index = 0;
		    while(start < nums.length && start < right) {
		      nums[start++] = tem[index++];
		    }
		  }
	
		
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] b = new int[] {5,2,7,4,6,9,1,3,8};
		MergeSort a= new MergeSort();
		System.out.println(Arrays.toString(a.sortMergeRecursion(b)));

	}
}


