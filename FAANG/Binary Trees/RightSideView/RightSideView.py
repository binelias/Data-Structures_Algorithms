class Solution(object):
# BFS	
	def rightSideView(self, root):
			result = []
			queue = [root]

			while queue:
					count = 0
					curr = None
					q_len = len(queue)
					for _ in range(q_len):
							curr = queue.pop(0)
							if curr.left:
									queue.append(curr.left)
							if curr.right:
									queue.append(curr.right)
					result.append(curr.val)
			return result

# DFS
	def rightSideView(self, root):
		def dfs(node, level, levels, result):
			if level not in levels:
				result.append(node.val)
				levels.add(level)
			if node.right is not None:
				dfs(node.right, level + 1, levels, result)
			if node.left is not None:
				dfs(node.left, level + 1, levels, result)
		levels = set()
		result = []
		dfs(root, 1, levels, result)
		return result
