/**
At DoorDash, menus are updated daily even hourly to keep them up-to-date. Each menu can be regarded as a tree. 
When the merchant sends us the latest menu, can we calculate how many nodes has changed?
 
Assume each Node structure is as below:
We only do SOFT delete if an existing node in the new tree is null by marking the node inactive in our database. 
Assume there are no duplicate active nodes with the same key.
 
Example 1
Existing Menu in our system:
 
Existing tree
     a(1)
   /      \
  b(2)   c(3)
 /   \      \
d(4) e(5)  f(6)
( Legend - a(1) a is the key, 1 is the value)
 
New Menu sent by the Merchant:
 
New tree
a(1)
  \
  c(3)
    \
   f(66)
Expected Answer: 4 Explanation: Node b, Node d, Node e are automatically set to inactive. The value of Node f changed as well.
 
Example 2
Existing Menu in our system:
 
Existing tree
     a(1)
    /    \
   b(2)  c(3)
  /   \     \
d(4)  e(5)  g(7)
New Menu sent by the Merchant:
 
New tree
       a(1)
     /      \
    b(2)    h(3)
  /  |   \      \
e(5) d(4) f(6)  g(7)
Expected Answer: 5 Explanation: There are a total of 5 changed nodes. 
Node f is a newly-added node. c(3) and old g(7) are deactivated; h(8) and new g(7) are newly added nodes
 
 */
public class doordash {
    // Given two n-ary tree with <key, value> in each node idenity the differences between the two. 
    
}
