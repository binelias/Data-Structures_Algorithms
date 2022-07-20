def arraySign(self, nums: List[int]) -> int:
  negative = 0
  for num in nums:
    if num < 0:
      negative+=1
    elif num == 0:
      return 0
  if negative&1 == 0:
      return 1
  else:
      return -1