# Easy problems  

These are the typical problems you'll find in the easy section of leetcode.  
These are typically never asked unless you're interviewing for a more junior position. 

I started my studies from here since I was super rusty on solving coding interview questions. 

# *August 03, 2021* 

Solved :pencil:

+ `two-number-sum` - trick for these type of problems is doing a one pass traversal by utilizing the complement and a hash table
+ `validate-subsequence` - everything in the subsequence needs to be in the original array and in the same order. The caveat is the same order part that makes this actually easier. If it was in any order than a one pass approach wouldn't have worked and we'd need to use something like a HashMap. 
+ `sorted-squared-array` - anytime you see sorted array the solution is usually O(n). The trick is to use Math.abs() and check the beginning and the end before appending to output array at the end. Clever. Stuff like this is kind of difficult to think of quickly.  

Watched :eyes: 

Videos on `data structures`, `complexity analysis`, `memory`, and `big o notation`. Some random videos like "How to get into google on youtube". Interesting little tidbits I picked up 
+ Always start with clarifying questions 
+ Instead of commenting code think of how you can rename variables 
+ Instead of convoluted if statements maybe move that logic into a boolean variable 
+ Constantly communicate and summarize your implementation you've written thus far 
+ Quality is better than quantity 

Evaluation :trollface: 

Didn't get as much as I could done as I wanted. Still not writing the solutions as fast and elegantly enough. :cry: But I kind of like blogging my progress out. It makes it less dry and painful. :sleepy: 
Also did some research on smart contract auditing with mythx/manticore. On my business side I've made some major advancements as well. I had a Coinbase interview for tomorrow but moving it out by a lot. 

# *August 04, 2021* 

Solved :pencil:

+ `tournament-winner` - This one is pretty easy. I can solve it in 20 minutes. But sifting through nested ArrayList kind of makes me type erraneous code at times. It's also kind of nervewracking having someone watch you fumbling around trying to properly add the test case into a nested array. I noticed I'm fairly good at questions that involve utilizing a hashmap. Instead of traversing the HashMap after in another pass you can also try to use a variable that constantly points to the string. Although I think this makes it less readable... and you are also doing an additional lookup every time anyway. 

```java 
// Nifty way to traverse a hashmap for the largest value  in 1 line. 
Collections.max(yourHashMap.entrySet(), Map.Entry.comparingByValue()).getKey(); 
```
+ `non-constructible change` - this is actually really easy after you run through a couple examples on paper. It's kind of annoying that during the coding interviews you have to speak and type out all the examples. Something about writing it down on a notebook with a paper and pen is how I figure things out. Another interesting thing is the final result if every permutation of change could be made (1-lastCoin). Then the change you're missing is actually lastCoin + 1. Edge case I haven't thought of. grr. 
+ `find-closest-value-in-bst` - It feels like these type of questions it's easy after you view the code but it's hard to write since recursion is difficult to visualize. 

Watched :eyes:

+ Videos on Trees

Evaluation :trollface: 

# Random things I learned 
Difference between HashMap and HashSet 
HashSet is implementation of Set Interface which does not allow duplicate value. 
The main thing is, objects that are stored in HashSet must override equals() for check for equality and hashCode() methods for no duplicate value are stored in our set.

HashMap is an implementation of Map Interface, which map a key to value. Duplicate keys are not allowed in a map.
Basically Map Interface has two implementation classes HashMap and TreeMap the main difference is TreeMap maintains order of the objects but HashMap will not.
HashMap allows null values and null keys.

Both HashSet and HashMap are not synchronized.