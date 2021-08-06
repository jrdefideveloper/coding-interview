# Recursion 

Most things can be done with a for or while loop but recursion typically makes things look more elegant. Recursion is a divide-and-conquer approach to solving problems.

+ Sub-problems are easier to solve than the original problem
+ Solutions to sub-problems are combined to solve the original problem

Other examples of *divide-and-conquer* include quicksort, heapsort, searching tree/graph

# Classic examples 

+ Factorial 
+ Tree traversal 
+ Fibonacci 
+ Reversing a string 
+ Quicksort 

# Think like a programmer 

Don't try to think of it in terms of a system stack instead think like this: 

1. Write an iterative function to solve the problem 
2. Write a "dispatcher" function 
+ Dispatcher function solves problem for some "minimal" data set. In this case, when size parameter == 0 Dispatcher calls iterative function to handle non-minimal cases.  Dispatcher gives smaller data sets. 
3. In dispatcher, replace call to iterative function with call to dispatcher 

# Space complexity 

Whenever you use recursion keep in mind that you have to use O(n) extra space for the call stack. 
Some compilers may be able to optimize the call stack through tail recursion but you can't always assume so.  



