// Given an array of strings words and an integer k, return the k most frequent strings.

// Return the answer sorted by the frequency from highest to lowest. Sort the words with the same frequency by their lexicographical order.


// Example 1:
// Input: words = ["i","love","leetcode","i","love","coding"], k = 2
// Output: ["i","love"]
// Explanation: "i" and "love" are the two most frequent words.
// Note that "i" comes before "love" due to a lower alphabetical order.

// Example 2:
// Input: words = ["the","day","is","sunny","the","the","the","sunny","is","is"], k = 4
// Output: ["the","is","sunny","day"]
// Explanation: "the", "is", "sunny" and "day" are the four most frequent words, with the number of occurrence being 4, 3, 2 and 1 respectively.

// Intuition
//   If we put all numbers into a max-heap, the top element of the heap must be the max value of all numbers in the heap. So instead of sorting all unique words, we only need to pop the word with the max frequency from a max heap k times.

// Algorithm
//   Count the frequency of each word like Approach 1.
  
//   Heapify: make the list of words as a max heap h by their frequencies, in which the top element has the max frequency and lexicographically in all words with the same frequency.

//   Pop the top element from the max heap h totally k times, and then the words you get are already in the correct order.

class Solution {
  class Word implements Comparable<Word> {
    private String word;
    private int count;

    public Word(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public int compareTo(Word other) {
        if(this.count == other.count) {
            return this.word.compareTo(other.word);
        }
        return other.count - this.count;
    }
  }


  //Max Heap
  public List<String> topKFrequent(String[] words, int k) {
    Map<String, Integer> map= new HashMap<>();
    for(String word : words) {
        map.put(word, map.getOrDefault(word, 0) + 1);
    }
    
    List<Word> candidates = new ArrayList<>();
    for(var entry : map.entrySet()) {
        candidates.add(new Word(entry.getKey(), entry.getValue()));
    }
    
    Queue<Word> queue = new PriorityQueue<>(candidates);
    List<String> res = new ArrayList<>();
    for(int i = 0; i < k; i++) {
        res.add(queue.poll().word);
    }
    return res;
  }
}

// Min Heap

// Approach 2 looks perfect when the given input is off-line, i.e., no new unique words will be added later. For those top-k elements problems that may have dynamically added elements, we often solve them by maintaining a min heap of size k to store the largest k elements so far. Every time we enumerate a new element, just compare it with the top of the min heap and check if it is one of the largest k elements.

// Algorithm
// It's almost the same idea with Approach 1 in solution to 347, except that:

//   We need to be careful with the order, considering not only the frequency but the word lexicographically.

//   The min heap doesn't guarantee the order. We need to sort the elements in the heap before returning them or just pop them one by one from the min-heap to our result in order.


class Solution {
    
  public List<String> topKFrequent(String[] words, int k) {
      Map<String, Integer> map = new HashMap<>();
      for(String word : words) {
          map.put(word, map.getOrDefault(word, 0) + 1);
      }
      
      PriorityQueue<String> queue = new PriorityQueue<>(
          (w1, w2) -> map.get(w1).equals(map.get(w2)) ? w2.compareTo(w1) : map.get(w1) - map.get(w2));
      
      for(String word : map.keySet()) {
          queue.offer(word);
          if(queue.size() > k) queue.poll();
      }
      
      List<String> res = new ArrayList<>();
      while(!queue.isEmpty()) {
          res.add(queue.poll());
      }
      Collections.reverse(res);
      return res;
  }
}

