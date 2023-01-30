# Design and implement a data structure for a Least Frequently Used (LFU) cache.

# Implement the LFUCache class:

# LFUCache(int capacity) Initializes the object with the capacity of the data structure.
# int get(int key) Gets the value of the key if the key exists in the cache. Otherwise, returns -1.
# void put(int key, int value) Update the value of the key if present, or inserts the key if not already present. When the cache reaches its capacity, it should invalidate and remove the least frequently used key before inserting a new item. For this problem, when there is a tie (i.e., two or more keys with the same frequency), the least recently used key would be invalidated.
# To determine the least frequently used key, a use counter is maintained for each key in the cache. The key with the smallest use counter is the least frequently used key.

# When a key is first inserted into the cache, its use counter is set to 1 (due to the put operation). The use counter for a key in the cache is incremented either a get or put operation is called on it.

# The functions get and put must each run in O(1) average time complexity.


# Example 1:

# Input
# ["LFUCache", "put", "put", "get", "put", "get", "get", "put", "get", "get", "get"]
# [[2], [1, 1], [2, 2], [1], [3, 3], [2], [3], [4, 4], [1], [3], [4]]
# Output
# [null, null, null, 1, null, -1, 3, null, -1, 3, 4]

# Explanation
# // cnt(x) = the use counter for key x
# // cache=[] will show the last used order for tiebreakers (leftmost element is  most recent)
# LFUCache lfu = new LFUCache(2);
# lfu.put(1, 1);   // cache=[1,_], cnt(1)=1
# lfu.put(2, 2);   // cache=[2,1], cnt(2)=1, cnt(1)=1
# lfu.get(1);      // return 1
#                  // cache=[1,2], cnt(2)=1, cnt(1)=2
# lfu.put(3, 3);   // 2 is the LFU key because cnt(2)=1 is the smallest, invalidate 2.
#                  // cache=[3,1], cnt(3)=1, cnt(1)=2
# lfu.get(2);      // return -1 (not found)
# lfu.get(3);      // return 3
#                  // cache=[3,1], cnt(3)=2, cnt(1)=2
# lfu.put(4, 4);   // Both 1 and 3 have the same cnt, but 1 is LRU, invalidate 1.
#                  // cache=[4,3], cnt(4)=1, cnt(3)=2
# lfu.get(1);      // return -1 (not found)
# lfu.get(3);      // return 3
#                  // cache=[3,4], cnt(4)=1, cnt(3)=3
# lfu.get(4);      // return 4
#                  // cache=[4,3], cnt(4)=2, cnt(3)=3


# Constraints:

# 0 <= capacity <= 104
# 0 <= key <= 105
# 0 <= value <= 109
# At most 2 * 105 calls will be made to get and put.

# Solution:
# Store (key,value) pairs in two hashmap. The first hashmap will map keys to their frequencies and the second hashmap will map frequencies to an ordered hashmap of (key,value) pairs. Ordered hashmap is important here because it will store the most recently used (key,value) pairs at the back. Also, we will keep track of the minimum frequency such that we can find and remove the least frequently used (key,value) pair in O(1).

# Get: Check if a key exists. If yes, increment its frequency in the keyToFreq hashmap and move it one frequency up in the freqToKey hashmap. Update the minimum frequency if it is necessary.

# Put: Check if a key exists.
# If yes, increment its frequency in the keyToFreq hashmap, move it one frequency up in the freqToKey hashmap, and update the value. Update the minimum frequency if it is neccessary.

# Else, add the key and set its frequency as 1 in the keyToFreq hashmap and add such (key,value) pair to its corresponding frequency in the freqToKey hashmap. If we exceed the capacity, using the minimum frequency and find the first (key,value) pairs at such frequency in the keyToFreq hashmap and remove it from both hashmap. Set the minimum frequency to 1.

# Complexity:
# Time: O(1)
# Space: O(capacity)

from collections import OrderedDict, defaultdict


class LFUCache:
    def __init__(self, capacity: int):

        # Initialize the capacity
        self.capacity = capacity

        # Initialize the hashmap to map freq -> ordered hashmap of (key,value) pairs.
        self.freqToKey = defaultdict(OrderedDict)

        # Initialize the hashmap to map key -> freq
        self.keyToFreq = defaultdict()

        # Initialize the minimum frequency to 1
        self.minFreq = 1

    def get(self, key: int) -> int:

        # If the key doesn't exist, return -1
        if key not in self.keyToFreq:
            return -1

        # Move (key,value) pair one frequency up
        self.freqToKey[self.keyToFreq[key] +
                       1][key] = self.freqToKey[self.keyToFreq[key]].pop(key)

        # If the minimum frequency is the same as the freq of the current key and there isn't any more (key,value) pair after moved such key 1 frequency up, increment the minimum frequency by 1
        if (
            self.minFreq == self.keyToFreq[key]
            and len(self.freqToKey[self.keyToFreq[key]]) == 0
        ):
            self.minFreq = self.keyToFreq[key] + 1

        # Increment the frequency of the current key in the keyToFreq hashmap by 1
        self.keyToFreq[key] += 1

        # Return the value
        return self.freqToKey[self.keyToFreq[key]][key]

    def put(self, key: int, value: int) -> None:

        # If the key exists,
        if key in self.keyToFreq:

            # Move (key,value) pair one frequency up and update its value
            self.freqToKey[self.keyToFreq[key]].pop(key)
            self.freqToKey[self.keyToFreq[key] + 1][key] = value

            # If the minimum frequency is the same as the freq of the current key and there isn't any more (key,value) pair after moved such key 1 frequency up, increment the minimum frequency by 1
            if (
                self.minFreq == self.keyToFreq[key]
                and len(self.freqToKey[self.keyToFreq[key]]) == 0
            ):
                self.minFreq = self.keyToFreq[key] + 1

            # Increment the frequency of the current key in the keyToFreq hashmap by 1
            self.keyToFreq[key] += 1

        # Elif the key doesn't exist,
        else:

            # Add it to the keyToFreq hashmap
            self.keyToFreq[key] = 1

            # Add the (key,value) pair to the freqToKey hashmap
            self.freqToKey[self.keyToFreq[key]][key] = value

            # Decrement the capacity by 1
            self.capacity -= 1

            # If we run out of capacity
            if self.capacity < 0:

                # Remove the first (key,value) pair at the minimum frequency from both hashmaps
                key, value = self.freqToKey[self.minFreq].popitem(last=False)
                self.keyToFreq.pop(key)

                # Increment the capacity
                self.capacity += 1

            # Set the minimum frequency to 1
            self.minFreq = 1


# Your LFUCache object will be instantiated and called as such:
# obj = LFUCache(capacity)
# param_1 = obj.get(key)
# obj.put(key,value)
