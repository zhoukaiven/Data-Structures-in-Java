@author Kaiven Zhou (kz2182)

A singly linked list which stores unique values and their counts, and allows the list to be reversed and sorted.
Values can be inserted and deleted from the list. All the values in the list can be printed, as well as the elements
that appear most in the list.

I've written 3 classes:
- MyCountingLinkedLists
- Node
- MYLLException

MyCountingLinkedLists is the singly linked list, which contains the first node in the list, and the number of ip's in the list.

The insert method increases the count of node with value x, or prepends a new node with value x. If the list is empty, the first
node is created with the value given. If the node is not empty, the list is traversed: if the node with the value x is found, then
that node's count is incremented; if no node is found then a node is created with the value x and prepended. My insert method is
O(n) because the list is traversed once, and comparisons/increments are O(1).

The delete method decreases the count of node with value x, or throws an exception. If a node's count is reduced to zero, the node 
is removed from the list. If the list is not empty, the list is traversed: if the node with value x is found, that node's count is
decremented, and, if the node now has count = zero then the node is removed. Else, the node is not found and a MYLLException is 
thrown. The method is O(n) because the list is traversed once, and comparisons/decrements/node reassignments are O(1).

The find method returns the index of the node with value x, or -1 if the node is not found. An integer index, starting at zero,
is created. The list is traversed, if the node with value x is found, then the index is returned. Otherwise, we move to the next
node, and index is incremented. If no node is found in the list, then -1 is returned. The method is O(n) because the list is
traversed once, and comparisons are O(1).

The reverse method reverses the list. Basically in a loop we store the previous node and check if the current node has a next. 
If it does, we the store the next, set the current node's next to the previous node, and then set the current node to the stored
next node. At the end of the loop, the last node (which is now the first), does not have a next, so we must manually set the 
next. This method is O(n) run time because the list is traversed once, and node next/prev assignments are O(1). Since I'm 
using a singly linked list, I need 2 extra Node variables in order to reverse the list. However, this means that all my nodes 
do not contain their own Node pointing to the previous so I am saving space overall.

The sort method sorts the list into descending order using a bubble sort. While the list is unsorted, we traverse through the 
list, checking the current node's value with the next node's value. If the next node's value is greater than the currents, we
switch the contents of the two nodes, and the sort is marked as not sorted. The node will be sorted if we traverse through it 
once without changing any nodes. The method is O(n^2), since in the worst case scenario the sorting is done n times (like when
the smallest value is at the very end).

The print method can take an integer value (the method has been overloaded). If the integer is supplied, the top n nodes of the
list is printed (the list is assumed to have been sorted). If the integer value is not supplied, the entire lise is printed. 
The method is O(n) not taking into account the previous sort, since the list is traversed once.

Node is a node class that has data, a count, and the next node.

MYLLException is an exception class that extends RuntimeException. Thrown when the user tries to delete a value that is not
in the list

HWTest tests the class. 