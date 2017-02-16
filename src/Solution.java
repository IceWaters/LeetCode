import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        int[] nums = {-477,-476,-471,-462,-440,-400,-398,-394,-394,-393,-389,-386,-350,-346,-338,-315,-273,-249,-182,-172,-166,-161,-149,-116,-112,-109,-100,-73,-33,-26,-22,-11,6,8,13,19,56,78,101,102,111,140,155,158,181,205,211,225,232,242,254,265,281,308,310,320,320,364,366,381,385,387,443,496,496};
        solution.fourSum(nums, 1236);		
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();     
        if(nums.length < 4)
    		return list;
    	Arrays.sort(nums);//将数组排序
    	if(target > (nums[nums.length - 1] + nums[nums.length - 2] + nums[nums.length - 3] + nums[nums.length - 4])
    		|| target < (nums[0] + nums[1] + nums[2] + nums[3]))
    		return list;
    	Vector<Integer> vector = new Vector<>();
    	for(int i : nums)
    		vector.add(i);
        for(int i = 0; i < nums.length - 3; i++){
        	vector.remove(0);
        	if(i > 0 && nums[i] == nums[i - 1]){
        		continue;
        	}
        	list.addAll(threeSum(vector, target - nums[i], nums[i]));
        }
    	return list;
    }
    
    public List<List<Integer>> threeSum(Vector<Integer> nums, int target, int first) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        if(nums.size() < 3)
			return list;
        
        for(int i = 0; i < nums.size() - 2; i++){
        	if(i == 0 || nums.get(i) > nums.get(i - 1)){
        		int start = i + 1;
        		int end = nums.size() - 1;
        		while(start < end){
	        		if(nums.get(i) + nums.get(start) + nums.get(end) == target){
	        			ArrayList<Integer> threeNum = new ArrayList<>();
	        			threeNum.add(first);
	        			threeNum.add(nums.get(i));
	        			threeNum.add(nums.get(start));
	        			threeNum.add(nums.get(end));
	        			list.add(threeNum);
	        			start++;
	        			end--;
	        			while((int)nums.get(start) == (int)nums.get(start - 1) && start < end)
	        				start++;
	        			while((int)nums.get(end) == (int)nums.get(end + 1) && start < end)
	        				end--;
	        		}else if(nums.get(i) + nums.get(start) + nums.get(end) > target)
	        			end--;
	        		else {
						start++;
					}
        		}
        	}
        }
        
        return list;
    }
}
