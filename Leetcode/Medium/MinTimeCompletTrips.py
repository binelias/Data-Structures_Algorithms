# You are given an array time where time[i] denotes the time taken by the ith bus to complete one trip.

# Each bus can make multiple trips successively; that is, the next trip can start immediately after completing the current trip. Also, each bus operates independently; that is, the trips of one bus do not influence the trips of any other bus.

# You are also given an integer totalTrips, which denotes the number of trips all buses should make in total. Return the minimum time required for all buses to complete at least totalTrips trips.


# Example 1:

# Input: time = [1,2,3], totalTrips = 5
# Output: 3
# Explanation:
# - At time t = 1, the number of trips completed by each bus are [1,0,0].
#   The total number of trips completed is 1 + 0 + 0 = 1.
# - At time t = 2, the number of trips completed by each bus are [2,1,0].
#   The total number of trips completed is 2 + 1 + 0 = 3.
# - At time t = 3, the number of trips completed by each bus are [3,1,1].
#   The total number of trips completed is 3 + 1 + 1 = 5.
# So the minimum time needed for all buses to complete at least 5 trips is 3.
# Example 2:

# Input: time = [2], totalTrips = 1
# Output: 2
# Explanation:
# There is only one bus, and it will complete its first trip at t = 2.
# So the minimum time needed to complete 1 trip is 2.


# Constraints:

# 1 <= time.length <= 105
# 1 <= time[i], totalTrips <= 107

class Solution:
    def minimumTime(self, time: List[int], totalTrips: int) -> int:
        # Initialize the search range for minimum completion time
        l = 1
        r = min(time) * totalTrips

        # Binary search for minimum completion time
        while l < r:
            # Calculate the midpoint of the search range
            m = (l + r) // 2
            # Count the number of tasks that can be completed within m time
            if sum(m // t for t in time) >= totalTrips:
                # If enough tasks can be completed within m time, search for smaller time
                r = m
            else:
                # If not enough tasks can be completed within m time, search for larger time
                l = m + 1

        # Return the minimum completion time
        return l