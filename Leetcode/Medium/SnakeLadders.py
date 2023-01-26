# You are given an n x n integer matrix board where the cells are labeled from 1 to n2 in a Boustrophedon style starting from the bottom left of the board (i.e. board[n - 1][0]) and alternating direction each row.

# You start on square 1 of the board. In each move, starting from square curr, do the following:

# Choose a destination square next with a label in the range [curr + 1, min(curr + 6, n2)].
# This choice simulates the result of a standard 6-sided die roll: i.e., there are always at most 6 destinations, regardless of the size of the board.
# If next has a snake or ladder, you must move to the destination of that snake or ladder. Otherwise, you move to next.
# The game ends when you reach the square n2.
# A board square on row r and column c has a snake or ladder if board[r][c] != -1. The destination of that snake or ladder is board[r][c]. Squares 1 and n2 do not have a snake or ladder.

# Note that you only take a snake or ladder at most once per move. If the destination to a snake or ladder is the start of another snake or ladder, you do not follow the subsequent snake or ladder.

# For example, suppose the board is [[-1,4],[-1,3]], and on the first move, your destination square is 2. You follow the ladder to square 3, but do not follow the subsequent ladder to 4.
# Return the least number of moves required to reach the square n2. If it is not possible to reach the square, return -1.


# Example 1:


# Input: board = [[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,-1,-1,-1,-1,-1],[-1,35,-1,-1,13,-1],[-1,-1,-1,-1,-1,-1],[-1,15,-1,-1,-1,-1]]
# Output: 4
# Explanation:
# In the beginning, you start at square 1 (at row 5, column 0).
# You decide to move to square 2 and must take the ladder to square 15.
# You then decide to move to square 17 and must take the snake to square 13.
# You then decide to move to square 14 and must take the ladder to square 35.
# You then decide to move to square 36, ending the game.
# This is the lowest possible number of moves to reach the last square, so return 4.
# Example 2:

# Input: board = [[-1,-1],[-1,3]]
# Output: 1


# Constraints:

# n == board.length == board[i].length
# 2 <= n <= 20
# grid[i][j] is either -1 or in the range [1, n2].
# The squares labeled 1 and n2 do not have any ladders or snakes.

# Breadth-first search
# Intuition
# Breadth-first search is an algorithm for finding the shortest path in unweighted graphs (directed or undirected).

# This algorithm uses a queue. If this data structure is new to you, we encourage you to visit the queue and stack explore card. The explore card will help you understand the data structure and practice using it before proceeding.

# The queue data structure has two primary operations:

# enqueue: add an element to the end of the queue.
# dequeue: remove the first element in the queue.
# C++, Java, Python and other programming languages have built-in queue implementations.

# The breadth-first search operates as follows. It maintains a queue of vertices (nodes). It starts with only the starting vertex (cell 1 in this problem). Then it processes the vertices one by one in the queue. Let's say we are processing some vertex. There are (possibly zero) outgoing edges from this vertex. If these edges lead to unvisited vertices, push these vertices to the queue. The algorithm terminates when it has visited all vertices.

# Algorithm
# Find the cell (row,column)(\text{row}, \text{column})(row,column) associated with each label from 111 to n2n^2n
# 2. Start from the bottom left cell and traverse the board alternately left to right and right to left. One can do this by maintaining the order of columns and reversing it after each row.

# Maintain a queue of cells and an array to store distances to all cells from the first one. By distance to the cell, we mean the least number of moves required to reach it. The distance from the first cell to itself is 000. Mark all other cells as initially unreachable from the first one (we denote the distance to such cells with −1-1−1). Push the first cell to the queue.

# While the queue is not empty:

# Pop a cell from the queue. Let's say its label is curr\text{curr}curr. For each square next\text{next}next with a label in the range curr+1\text{curr} + 1curr+1 to min⁡(curr+6,n2)\min(\text{curr} + 6, n^2)min(curr+6,n
# 2) (as described by the problem), if next\text{next}next has a snake or a ladder, set destination\text{destination}destination to the destination of that snake or ladder. Otherwise, set destination\text{destination}destination to next\text{next}next.

# If dist[destination]\text{dist[destination]}dist[destination] is −1-1−1 (i.e. the destination\text{destination}destination has not been visited yet) set dist[destination]\text{dist[destination]}dist[destination] to dist[curr]+1\text{dist[curr]} + 1dist[curr]+1 (the number of moves to get to the current cell, plus one more move to get to destination\text{destination}destination) and push destination\text{destination}destination on to the queue.

# Return the distance to cell n2n^2n
# 2
#  . If it is unreachable, the result will be −1-1−1.

from collections import deque


class Solution:
    def snakesAndLadders(self, board: List[List[int]]) -> int:
        n = len(board)
        cells = [None] * (n**2 + 1)
        label = 1
        columns = list(range(0, n))
        for row in range(n - 1, -1, -1):
            for column in columns:
                cells[label] = (row, column)
                label += 1
            columns.reverse()
        dist = [-1] * (n * n + 1)
        q = deque([1])
        dist[1] = 0
        while q:
            curr = q.popleft()
            for next in range(curr + 1, min(curr + 6, n**2) + 1):
                row, column = cells[next]
                destination = (board[row][column] if board[row][column] != -1
                               else next)
                if dist[destination] == -1:
                    dist[destination] = dist[curr] + 1
                    q.append(destination)
        return dist[n * n]
