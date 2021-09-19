# Medium level problems 

I noticed top tech companies typically ask medium level questions and follow up with more medium level problems that are related to the first problem. 

In a 50 minute interview it's typicallly structured like 

1. 5 minute pleasantries - "Hi, my name is" 
2. 40 minutes of coding 
    + 5 minutes to break it down conceptually, ask questions, go through examples
    + 20 minutes to code the first original problem 
    + 10 answering and/or coding follow up questions 
    + 5 summarazing your answer and going through your code. cleaning things up. "productionizing"? 
3. 5 minutes of additional question asking "work culture, side projects, tech stack, challenges, etc" 

Algoexperts has 55 medium level questions. Leetcode has an additional couple hundred to sift through. :cry: 

# *August 06, 2021* 

Solved :pencil:  

+ `bst-construction` - searching, insertion, deletion. Deletion edge cases are difficult. If I were to have to do this in 15 minutes I'd get really pressured. Psyduck. 
+ `validate-bst` - This is easier when every key is unique. Slight nuances depending on exact interview question when there should be <= >= for each node value in the true compared to the left and right subtrees. Iterative approach doesn't work as well when theres a equal to greater than case. Recursive code is so short and simple yet so hard to put together. 
+ `balanced-brackets` - This one is kind of fun. I consider an *easy* level rather than a medium. Have to be care of the case of `([`. The stack must be empty at the end of the string iteration to be considered a balanced string.  

Evaluation :trollface: 

Got to be careful of setting up the recursion functions well. I noticed I'm much better at iteration versus recursion. But I need to think of the fact that the first function call is basically at the bottom of the period and you have to keep adding to the call stack until we reach the top of the pyramid. Then we hand down the result to lower levels of the pyramid. In most cases reaching the bottom of the pyramid yet again is how the solution is derived. 


# *August 12, 2021*

Solved :pencil: 

+ Nada

Evaluation :trollface: 

Body condition kind of sucks again today. I don't know why I keep waking up much earlier than I have to and not being able to fall back asleep. 

# *August 13, 2021*

Solved :pencil: 

+ `three-number-sum` - I got this one conceptually but started to get confused during implementation. 
+ `smallest-difference` - I couldn't figure this one out. 
+ `move-element-to-end` - not so bad as long as realize the pointers need to be set at start and end. I was trying to fast/slow pointer approach which is just, i, i+1; This doesn't work out so much.  

Evaluation :trollface: 

Much better day today! 

# *August 14, 2021*  

+ `monotonic-array` - This one is pretty easy actually. 
+ `spiral-traverse` - This is really great practice for me since I'm surprisingly bad at 2 for loop logic. It's so easy to see visually but tracking all these pointers makes me so sleepy. I'm almost fell asleep 10 times doing this, omg. 
+ `longest-peak` - This problem is kind of confusing 

Evaluation :trollface: 

Got really distracted by Community Eevee Day in Pogo. Also I think I slept 5 hours last night which has rendered me basically braindead. 


# *August 15, 2021* 

1.  `longest peak` - The next day it still doesn't make sense to me. :( Going to move on for now. 
2. `array of products` - Can't use division when it's the obvious thing to do hmm. Utilizing extra space with a left and right array. And then optimizing further was the solution. O(n^2) solution takes 2 seconds but figuring out 1 pass solution took me quite a while. 
3.  `first duplicate value` -  Optimal space complexity is interesting.... because you utilize negative numbers since you know the number must be between `[1..n]` using a negative number to use the array to double as a hashMap. The solution with HashMap is easier to understand. 

Evaluation :trollface: 

My back burns from constantly sitting down in wrong posture. Also my roommates keep playing TikTok at maxmimum volume so it's hard to focus. Going to invest in better noise cancelling headphones 

# *August 16, 2021* 

Day off. 

# *August 17, 2021* 

1. `merge overlapping variables` -  Very difficult for me. Will review again later
2. `BST Traversal` - Easy one actually 

# *August 18, 2021* 

Focused on working on my businesses. 

# *August 19, 2021*
1. `Min Height BST` -  Easy when you follow the solution but hard to put the code together. Still very weak at recursion + trees. 
2. `Find Kth Largest Value In BST` - This one is actually kind of easy. 

Reconstruct BST` - This one is really difficult 
# *August 25, 2021* 

Darn I did no studying for 5 consecutive days. This is why they say building momentum is so important. 

1. `Invert Binary Tree` - pretty easy after you see the solution for yourself, sadly difficult to put together on the spot. 
2. `Binary Tree Diameter` - Difficult 

# *August 26, 2021* 

1. `Find successor` - Not too bad if you just do an in order traversal and use extra space. Other solution is kind of funky knowing when to get left most child node or right most parent node. 
2. `Height Balanced Tree` - This is kind of similar to Binary Tree diameter actually.  
 
 # *August 27, 2021* 

 1. `Max subset of non adjacent numbers`  - This problem is quite interesting 
 2. `Number of ways to make change` - Another dp interesting question. The denoms needs to be the outer loop and amounts in inner loop. 
 3. `Min number of coins to make change` - Very similar to the last problem 

 # *August 28, 2021* 

 1. `Levenshtein Distance` - Another difficult DP program. The pattern is really difficult to come up with on the spot. Idk who is able to do this without coming across the problem before. I'm going to skip the space optimization because it looks too crazy. 
 2. `Number of ways to traverse a graph` - Recursion, DP, or Permutation trick. This problem is very difficult for me as well. It's hard to put the DP formula together. 
 3. `Kadane's algorithm` - O(n) time  not so bad. 

 (Also reviewed some prior problems. Find closest BST tree node etc. I need to be doing more reviews frequently.)

 I wonder who finds these types of problems enjoyable... 

 # *August 30, 2021* 
1. `Single cycle check` - Made a mistake with using currentIdx to track number of elements visited. Be careful. 
2. `Breadth-first Search` -  This is basically just level order sort. These kind of questions pop up a lot. 

# *August 31, 2021* 
1. `River sizes` - I have issues with these types of problems. 
2. `Youngest common ancestor` - Kind of easy kind of hard at the same time. Remember to write helper functions and don't repeat yourself. 
3. `Lowest common manager` - very difficult to implement and visualize (hard) problem

# *September 01, 2021* 

Focused on business and interviews. Started Ethereum dApp Programming course. Regenerative art NFTs can be created completely from CSS. The presentation is hidden in the gene bits. 

# *September 02, 2021* 

1. `Remove Islands` - Should have had more faith in myself. My solution was right the first time. This problem is nearly identical to River Sizes. 
2. `Cycle in a graph` - 

Reviewed Lowest Common Manager and River Sizes again 

# *September 03, 2021* 

1. `Cycles in a graph` - Convuluted implementation 
2. `Minimum passes of matrix` - How is this not a hard problem xD 
3. `Task Assignment` - I got the solution myself! Finally! 
4. `Valid Starting City` - Greedy algorithm 
5. `Min Heap Construction` -  Min heap, we meet again 

# *September 04, 2021* 

1. `Min Heap Construction` - Pretty easy to understand. Although I highly doubt anyone would straight up ask an interviewee to write a minHeap class from scratch. This is so academic that only someonone that recently took a Computer Science 101 class would remember. 
2. `Linked List Construction` - 

Focused more on system design tips and questions. 

# *September 05, 2021* 

1. `Linked List Construction` - Not bad. Great review. 

# *September 09, 2021* 

1. `Remove Kth Node From End` - Not bad

# *September 10, 2021* 
Focused on OpenZeppelin documentation and solidity contract writing.
# *September 11, 2021*  
1. `Sum of linked lists` - Not bad as well. 
2. `Permutations` - 

# *September 13, 2021* 
1. `Permutations` 
```
helper(arr, perm, perms): 
// if we run out of numbers then we picked all the numbers already


```

# *September 14, 2021* 
1. `Permutations` - This question is so weird and annoying. O(n * n!) complexity 
2. `Power set` -


# *September 15, 2021* 
1. `Power set` -  Not bad
2. `Phone Number Mneumonics` - Not bad
3. `Staircase Traversal` - I feel like I've seen this before. I am very weak at DP, I shall practice more of these type of problems. 


# *September 16, 2021* 

1. `Search in sorted matrix` - I'm much better at dealing with matrix related problems now. 
2. `Three number sort` - Not too bad. I think searching problems are much easier for me than recursion and random permutation type problems that a re little bit more math veering. 
3. `Min max stack construction` - Not bad 
4. `Sunset Views` - Not bad 
5. `Sort Stack` - This one makes my brain hurt. My weakness is still recursion because you need to think the opposite way and it hurts my head to do so. 
6. `Next Greater Element` - Headache 

# *September 17, 2021* 

1. `Leetcode: Letter Combinations of a Phone Number` - Reviewing this problem again... still kind of suck because it's hard to put together recursive calls for me that are overly complicated. 
2. `Leetcode: Bus routes` - Very difficult  
3. `Next Greater Element` - This is just a really strange problem to me. You can travel through an array in a circular fashion twice by multiplying array.length * 2 and then using modulus to get the proper index. 

# *September 18, 2021* 

1. `Longest Palindromic Substring` - Naive solution -> Get all substrings and then find the longest Palindrome. However this is O(n^3) where n is the length of the string. Optimal solution was O(n^2) I was able to figure it out myself but setting the indexes against odd and even it really error prone. 
2. `Group Anagrams` - 



# Random thoughts 

## Tools to dominate certain questions 

When working with arrays think about whether or not starting at the end or the middle of the list helps you instead only thinking about index 0. 

Think in terms of what utilizing a negative number can do you for you when the input is gauranteed to be a certain subset that is positive** This is how you can remember data without utilizing a hashmap. 

For `recursive` problems often think about how a final result is the result of the addition of the previous 2 results or possibly all of the previous results. 

## Ternary Operator. 
`booleanExpression ? expression1 : expression2` - Somehow I sometimes get the ? and : position confused... lol.  

## Adding numbers to ArrayList<Integer> quickly 
```java
ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList( 2, 1, 2, 2, 2, 3, 4, 2 ));
```
**Arrays.asList()** 

## Setting numbers in an ArrayList 
```java 
array.set(index, element); // Index first, element second. You can't set with .get() 
``` 

## Arrays sort with directions 

```java
Arrays.sort(sortedIntervals, (a, b) -> Integer.compare(a[0], b[0]));  
```

## Random math 

Remember when you are adding digits together the old school way column by column 

`carry = (sum of column) / 10` 

`actual column result value = (sum of column) % 10`  

Kind of sad how I forgot these basics and get confused every now and then... lol

