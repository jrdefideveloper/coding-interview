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
+ 

Evaluation :trollface: 

Much better day today! 

# Random thoughts 
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

