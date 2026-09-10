class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        if(start == goal){
            return 0;
        }

        boolean[] vis = new boolean[1001];
        // BFS 

        Queue<Integer> q = new LinkedList<>();

        q.offer(start);

        vis[start] = true;
        int op = 0;

        while(!q.isEmpty()){

            int size = q.size();
            op++;

            for(int i = 0; i < size ; i++){

                int curr = q.poll();

                for(int num : nums){
                    int[] nV = {
                        curr + num , curr - num, curr ^ num
                    };

                    for(int next : nV){

                        if(next == goal){
                            return op;
                        }

                        if(next >=0 && next <= 1000 && !vis[next]){
                            vis[next] = true;
                            q.offer(next);
                        }
                    }
                }
            }
        }
        
      return -1 ;       
    }
}