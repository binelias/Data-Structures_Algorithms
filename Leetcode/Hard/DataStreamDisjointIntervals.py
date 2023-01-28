# Given a data stream input of non-negative integers a1, a2, ..., an, summarize the numbers seen so far as a list of disjoint intervals.

# Implement the SummaryRanges class:

# SummaryRanges() Initializes the object with an empty stream.
# void addNum(int value) Adds the integer value to the stream.
# int[][] getIntervals() Returns a summary of the integers in the stream currently as a list of disjoint intervals [starti, endi]. The answer should be sorted by starti.

# Example 1:

# Input
# ["SummaryRanges", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals", "addNum", "getIntervals"]
# [[], [1], [], [3], [], [7], [], [2], [], [6], []]
# Output
# [null, null, [[1, 1]], null, [[1, 1], [3, 3]], null, [[1, 1], [3, 3], [7, 7]], null, [[1, 3], [7, 7]], null, [[1, 3], [6, 7]]]

# Explanation
# SummaryRanges summaryRanges = new SummaryRanges();
# summaryRanges.addNum(1);      // arr = [1]
# summaryRanges.getIntervals(); // return [[1, 1]]
# summaryRanges.addNum(3);      // arr = [1, 3]
# summaryRanges.getIntervals(); // return [[1, 1], [3, 3]]
# summaryRanges.addNum(7);      // arr = [1, 3, 7]
# summaryRanges.getIntervals(); // return [[1, 1], [3, 3], [7, 7]]
# summaryRanges.addNum(2);      // arr = [1, 2, 3, 7]
# summaryRanges.getIntervals(); // return [[1, 3], [7, 7]]
# summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
# summaryRanges.getIntervals(); // return [[1, 3], [6, 7]]

# Constraints:

# 0 <= value <= 104
# At most 3 * 104 calls will be made to addNum and getIntervals.

class SummaryRanges:

    def __init__(self):
        self.intervals = []

    def addNum(self, value: int) -> None:
        # O(log(N))
        i = bisect.bisect_left(self.intervals, value)
        if i == len(self.intervals) or self.intervals[i] != value:
            if i % 2 == 0:
                if i > 0 and i < len(self.intervals) and self.intervals[i - 1] == value - 1 and self.intervals[i] == value + 1:
                    # O(N)
                    self.intervals = self.intervals[:i -
                                                    1] + self.intervals[i + 1:]
                elif i > 0 and self.intervals[i - 1] == value - 1:
                    # O(1)
                    self.intervals[i - 1] = value
                elif i < len(self.intervals) and self.intervals[i] == value + 1:
                    # O(1)
                    self.intervals[i] = value
                else:
                    # O(N) + O(N.log(N))
                    self.intervals += [value, value]
                    self.intervals.sort()

    def getIntervals(self) -> List[List[int]]:
        # O(N)
        intervals = [[self.intervals[i], self.intervals[i + 1]]
                     for i in range(0, len(self.intervals), 2)]
        return intervals


# Your SummaryRanges object will be instantiated and called as such:
# obj = SummaryRanges()
# obj.addNum(value)
# param_2 = obj.getIntervals()
