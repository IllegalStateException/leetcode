package combination;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * here are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
 * which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, return the ordering of courses you 
 * should take to finish all courses.
 * 
 * There may be multiple correct orders, you just need to return one of them. If it is impossible to finish 
 * all courses, return an empty array.
 * 
 * For example:
 * 
 * 2, [[1,0]]
 * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct 
 * course order is [0,1]
 * 
 * 4, [[1,0],[2,0],[3,1],[3,2]]
 * There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 
 * 1 and 2 should be taken 
 * after you finished course 0. So one correct course order is [0,1,2,3]. Another correct ordering is[0,2,1,3].
 * @author zwb
 *
 */
public class CourseSchedule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] order = findOrder(4,new int[][]{{1,0},{2,0},{3,1},{3,2}});
		for(int i : order)
			System.out.println(i);
	}
	
	public static int[] findOrder(int numCourses, int[][] prerequisites) {
        if(numCourses < 1)
        	return null;
        
		int[] courseOrder = new int[numCourses];
		
		Map<Integer,Integer> indegreeMap = new HashMap<>();
		Map<Integer,List<Integer>> adjacentsMap = new HashMap<>();
		Deque<Integer> queue = new ArrayDeque<>();
		
		for(int[] prerequisity : prerequisites){
			int indegree = indegreeMap.get(prerequisity[0]) == null ? 0 : indegreeMap.get(prerequisity[0]);
			List<Integer> adjacents = adjacentsMap.get(prerequisity[1]);
			
			if(adjacents == null){
				adjacents = new LinkedList<>();
			}
			
			adjacents.add(prerequisity[0]);
			adjacentsMap.put(prerequisity[1], adjacents);
			indegreeMap.put(prerequisity[0], indegree + 1);
		}
		
		for(int i = 0;i < numCourses;i++){
			if(indegreeMap.get(i) == null)
				queue.offer(i);
		}
		
		int index = 0;
		int currentCourse;
		while(!queue.isEmpty()){
			currentCourse = queue.poll();
			courseOrder[index++] = currentCourse;
			
			List<Integer> adjacents = adjacentsMap.get(currentCourse);
			if(adjacents == null)
				continue;
			for(int adjacentCourse : adjacents){
				int indegree = indegreeMap.get(adjacentCourse);
				indegreeMap.put(adjacentCourse, indegree - 1);
				
				if(indegree == 1)
					queue.offer(adjacentCourse);
			}
			
		}
		if(index != numCourses)
			return new int[0];
		return courseOrder;
    }

}
