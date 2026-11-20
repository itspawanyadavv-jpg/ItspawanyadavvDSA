import java.util.*;

class Solution {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // Step 1: Create adjacency list.
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        // Step 2: Calculate indegree.
        int[] indegree = new int[numCourses];

        for (int[] prerequisite : prerequisites) {

            int course = prerequisite[0];
            int required = prerequisite[1];

            graph.get(required).add(course);

            indegree[course]++;
        }

        // Step 3: Add zero-indegree courses to queue.
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {

            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        // Step 4: Store the topological ordering.
        int[] order = new int[numCourses];

        int index = 0;

        // Step 5: Perform BFS.
        while (!queue.isEmpty()) {

            int currentCourse = queue.poll();

            // Store the completed course.
            order[index++] = currentCourse;

            // Process dependent courses.
            for (int neighbor : graph.get(currentCourse)) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Step 6: Detect cycle.
        if (index != numCourses) {
            return new int[0];
        }

        return order;
    }
}