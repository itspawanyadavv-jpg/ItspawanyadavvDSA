class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer ,Integer> fM = new HashMap<>();

        for(int num : nums){
            fM.put(num , fM.getOrDefault(num , 0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a ,b) -> fM.get(a) - fM.get(b));

        for(int num : fM.keySet()){
            minHeap.offer(num);

            if(minHeap.size() > k){
                minHeap.poll();
            }
        }

        int[] result = new int[k];
        for(int i = 0; i < k; i++){
            result[i] = minHeap.poll();
        }

        return result;




        
    }
}