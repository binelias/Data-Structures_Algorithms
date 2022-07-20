//Trie is an efficient information reTrieval data structure.
//It is mostly used for searching through strings to see if certain desired words are present or not
//Doing this task using a list, or a balanced BST, costs O(nm) and O(mlog N) respectively, where m is the length of the string being searched
//But using tries, it can be done in O(m) time.
//Tries are like trees, with each node having multiple branches, generally equal to the number of letters in the alphabet.
//Each node represents a single letter. Each node also consists of an end_of_word variable which tells us whether it marks the end of a word or not
