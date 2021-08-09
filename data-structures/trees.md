# Trees 

A special type of graph, trees excel at storing data hierarchically and are commonly used as a means of testing your knowledge of recursion during coding interviews.

Interesting fact: unlike their botanical counterparts, these digital perennials sport but a single, unique root.

+ It has a root node 
+ Acyclic 
+ Not allowed to be disconnected 
+ Examples in real life: management chain, family trees

# Binary tree 

+ At most 2 child nodes 

## Complete Binary Tree 
A binary tree that's almost perfect; its interior nodes all have two child-nodes but it's leaf nodes don't necessarily all have the same depth. The last level are as far left as possible. 

## Full Binary Tree 
A binary tree whose nodes all have either two child-nodes or zero child-nodes. 

## Perfect Binary Tree 
A binary tree whose nodes all have two child-nodes. Leaves point to null*. 

## Balanced Binary Tree 

If it maintains a roughly logn traversal 

## Sidenote

If you forget all these little vocabulary things just ask the interviewer. 

## Binary search tree  

+ Special type of binary tree 

# Ternary tree

+ At most 3 child nodes 

# k-ary trees 

+ At most k child nodes 

# Tries 

+ Tree-like typically stores characters (special questions)

# Other 

Some trees have all children node point back to their parent node. 

## min heap, max heap 
Median type of questions 

## Red black tree 
Less likely to show up in a coding interview. Self balancing trees. I heard of something like this 10 year ago. lol 

# Space complexity 

O(nodes)

# Time complexity 

**O(nodes)** - Traversing through the whole tree 

**O(logn)** - if you pick one side every time you go down a level. You eliminate one side of the tree every time. 

Trees that are very skewed however still result in **O(n)**

# Popular problems 

+ is the tree a mirror of some other tree?  
+ running sum of branches 
+ is this tree a valid bst?  





