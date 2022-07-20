// Priority Queues, as the name suggests, are queues where the elements have different priorities
// And it does not always follow the FIFO rule.
// They can be implemented in a number of ways, out of which heap is the most commonly used one.
//In Python, it is available using “heapq” module. The property of this data structure in Python is that each time the smallest of heap element is popped(min heap).
//Whenever elements are pushed or popped, heap structure in maintained. The heap[0] element  returns the smallest element each time.
//Operations we can perform on heap using heapq module are:
//heapify(iterable) : This function converts the iterable into a heap. i.e. in heap order.
//heappush(heap, ele) : This function inserts an element into heap. The order is adjusted, so as heap structure is maintained.
//heappop(heap) : This function removes and returns the smallest element from heap. Again, he order is adjusted, so as heap structure is maintained.
//heappushpop(heap, ele) : This function combines the functioning of both push and pop operations in one statement, increasing efficiency. Heap order is maintained after this operation.
//eapreplace(heap, ele) : This function also inserts and pops element in one statement, but in this, minimum element is first popped, then the new element is pushed.
//heapreplace() returns the smallest value originally in heap regardless of the pushed element as opposed to heappushpop().


