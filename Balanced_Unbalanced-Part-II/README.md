RESULTS FROM 5 TRIALS:

1.
* TreeMap: 115.211 ms
* Unbalanced Tree Map: 127.393 ms

2.
* TreeMap: 119.500 ms
* Unbalanced Tree Map: 120.870 ms

3.
* TreeMap: 124.477 ms
* Unbalanced Tree Map: 133.426 ms

4.
* TreeMap: 120.653 ms
* Unbalanced Tree Map: 132.789 ms

5.
* TreeMap: 121.443 ms
* Unbalanced Tree Map: 127.212 ms

In the 5 trials ran, the Java implementation of TreeMap ran significantly faster on 4 out of the 5 trials.
The reason behind this is because the Unbalanced Tree Map uses a standard BST implementation where as the Java TreeMap uses the red-black tree implementation.
Because Java uses a red-black tree for it's implementation, at average and at worst, the search, insert and delete operations are all O(log(N)).
The Unbalanced Tree Map uses a standard binary search tree implementation with no self balancing, therefore best case scenarios will be O(log(N)) but 
worst case scenarios (where the BST turns into a linked list) will turn operations into an O(N) runtime.