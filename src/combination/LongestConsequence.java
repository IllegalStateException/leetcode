package combination;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LongestConsequence lc = new LongestConsequence();
		int[] nums = new int[]{1,2,1,0};
		System.out.println(lc.longestConsecutiveUsingSet(nums));
	}
	
	
	/**
	 * my solution. maybe result in memory overflow.
	 * @param nums
	 * @return
	 */
	public int longestConsecutive(int[] nums) {
		int length;
        if(nums == null || (length = nums.length) == 0)
        	return 0;
        int maxPostiveNum = -1;
        int minNegativeNum = 0;
        
        for(int i = 0;i < length;i++){
        	if(nums[i] >= 0){
        		if(nums[i] > maxPostiveNum)
        			maxPostiveNum = nums[i];
        	}
        	else{
        		if(nums[i] < minNegativeNum)
        			minNegativeNum = nums[i];
        	}
        }
        int[] pos = null;
        if(maxPostiveNum >= 0){
        	pos = new int[maxPostiveNum+1];
        }
        int[] neg = null;
        if(minNegativeNum < 0){
        	neg = new int[-minNegativeNum + 1];
        }
        int maxPosLength = 0;
        int maxNegLength = 0;
        for(int i = 0;i < length;i++){
        	if(nums[i] >= 0){
        		int exist = pos[nums[i]];
        		if(exist > 0)
        			continue;
        		else{
        			pos[nums[i]] = (nums[i] -1 < 0 ? 0 : pos[nums[i]-1]) + 1 +
        					(nums[i]+1 >= pos.length ? 0 : pos[nums[i]+1]);
        			if(pos[nums[i]] > maxPosLength)
        				maxPosLength = pos[nums[i]];
        			for(int j = nums[i]+1; j < pos.length && pos[j] != 0;j++){
        				pos[j] = pos[nums[i]];
        			}
        			for(int k = nums[i]-1;k >= 0 && pos[k] != 0;k--){
        				pos[k] = pos[nums[i]];
        			}
        		}
        	}
        	else{
        		int exist = neg[-nums[i]];
        		if(exist > 0)
        			continue;
        		else{
        			neg[-nums[i]] = (-nums[i] - 1 < 1 ? 0 : neg[-nums[i]-1]) + 1 +
        					(-nums[i] + 1 >= neg.length ?  0 : neg[-nums[i] + 1]);
        			if(neg[-nums[i]] > maxNegLength)
        				maxNegLength = neg[-nums[i]];
        			for(int j = -nums[i] + 1;j < neg.length && neg[j] != 0;j++)
        				neg[j] = neg[-nums[i]];
        			
        			for(int k = -nums[i] - 1;k >= 1 && neg[k] != 0;k--)
        				neg[k] = neg[-nums[i]];
        		}
        	}
        }
        int maxCross = (pos == null ? 0 : pos[0])  + (neg == null ? 0 : neg[1]);
        
        return Math.max(maxCross, Math.max(maxNegLength, maxPosLength));
    }
	
	public int longestConsecutiveUsingSet(int[] nums){
        if(nums == null || nums.length == 0)
        	return 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums)
        	set.add(num);
        
        int max = 0;
        
        for(int num : nums){
        	int count = 0;
        	
        	int value = num;
        	while(set.remove(value--))
        		count++;
        	
        	while(set.remove(++num))
        		count++;
        	
        	max = Math.max(max, count);
        	
        }
        
        return max;
	}
	
	public int longestConsecutiveUsingUF(int[] nums){
		if (nums == null || nums.length == 0)
			return 0;
		int res = 1;
		Map<Integer, Integer> map = new HashMap<>();
		int count = 0;
		for (int num : nums) {
			if (!map.containsKey(num))
				map.put(num, count++);
		}
		UnionFind uf = new UnionFind(count);
		for (int num : nums) {
			if (map.containsKey(num - 1))
				uf.union(map.get(num), map.get(num - 1));
			if (map.containsKey(num + 1))
				uf.union(map.get(num), map.get(num + 1));
			res = Math.max(res, uf.rank[uf.find(map.get(num))]);
		}
		return res;
	}

	private class UnionFind{
		int[] id;
		int[] rank;

		private UnionFind(int n) {
			id = new int[n];
			rank = new int[n];
			for (int i = 0; i < n; i++) {
				id[i] = i;
				rank[i] = 1;
			}
		}

		public int find(int i) {
			while(i != id[i]){ //根节点有 id[root] == root,且根节点处保存了组信息
				id[i] = id[id[i]]; //路径压缩
				i = id[i];
			}
			return i;
		}

		public void union(int i, int j) {
			int ii = find(i);
			int jj = find(j);
			if(ii == jj)
				return;
			if(rank[ii] > rank[jj]){
				id[jj] = ii;
				rank[ii] += rank[jj];
			} 
			else{
				id[ii] = jj;
				rank[jj] += rank[ii];
			}
		}
	}
}
