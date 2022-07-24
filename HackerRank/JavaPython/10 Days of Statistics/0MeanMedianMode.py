# Enter your code here. Read input from STDIN. Print output to STDOUT
import numpy as soln
from scipy import stats

size = int(input())
numbers = list(map(int, input().split()))
print(soln.mean(numbers))
print(soln.median(numbers))
print(int(stats.mode(numbers)[0]))