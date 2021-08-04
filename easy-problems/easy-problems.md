# Easy problems  

These are the typical problems you'll find in the easy section of leetcode.  
These are typically never asked unless you're interviewing for a more junior position. 

I started my studies from here since I was super rusty on solving coding interview questions. 

+ `two-number-sum` - trick for these type of problems is doing a one pass traversal by utilizing the complement and a hash table
+ `validate-subsequence` - everything in the subsequence needs to be in the original array and in the same order. The caveat is the same order part that makes this actually easier. If it was in any order than a one pass approach wouldn't have worked and we'd need to use something like a HashMap. 
+ 

# Random things I learned 
Difference between HashMap and HashSet 
HashSet is implementation of Set Interface which does not allow duplicate value. 
The main thing is, objects that are stored in HashSet must override equals() for check for equality and hashCode() methods for no duplicate value are stored in our set.

HashMap is an implementation of Map Interface, which map a key to value. Duplicate keys are not allowed in a map.
Basically Map Interface has two implementation classes HashMap and TreeMap the main difference is TreeMap maintains order of the objects but HashMap will not.
HashMap allows null values and null keys.

Both HashSet and HashMap are not synchronized.