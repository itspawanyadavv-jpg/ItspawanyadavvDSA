class TopVotedCandidate {

    private int[] times;
    private int[] leaders;

    public TopVotedCandidate(int[] persons, int[] times) {
        this.times = times;
        this.leaders = new int[persons.length];

        // Stores vote count of each candidate
        HashMap<Integer, Integer> voteCount = new HashMap<>();

        int leader = -1;
        int leaderVotes = 0;

        // Process each vote
        for (int i = 0; i < persons.length; i++) {
            int person = persons[i];

            // Increase vote count
            voteCount.put(person, voteCount.getOrDefault(person, 0) + 1);

            // Update leader
            // >= ensures that in case of a tie,
            // the most recent vote becomes the leader.
            if (voteCount.get(person) >= leaderVotes) {
                leader = person;
                leaderVotes = voteCount.get(person);
            }

            // Store the leader after this vote
            leaders[i] = leader;
        }
    }

    public int q(int t) {
        int left = 0;
        int right = times.length - 1;
        int ans = 0;

        // Binary search for the last index where times[index] <= t
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (times[mid] <= t) {
                ans = mid;
                left = mid + 1; // Look for a later valid time
            } else {
                right = mid - 1;
            }
        }

        return leaders[ans];
    }
}

/**
 * Your TopVotedCandidate object will be instantiated and called as such:
 * TopVotedCandidate obj = new TopVotedCandidate(persons, times);
 * int param_1 = obj.q(t);
 */