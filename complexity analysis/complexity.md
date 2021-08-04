# Complexity Analysis 
Most coding problems have multiple solutions however some solutions are better than the others! The metric you use to decide which solution is better is the following

1. Time complexity 
2. Space complexity 

Both of them together are referred to as space time complexity. 

`Time complexity` is the measure of how fast an algorithm runs 

`Space complexity` is how much space the algorithm uses 

It will be helpful to explain to interviewer the time versus space tradeoffs. 

# Memory 
`foobar = 1` This is stored somewhere. 

Pretend you have a bounded memory canvas with 20 memory slots. Under the hood the program is storing the number 1 into the memory canvas. 

Your computer will always try to store data in free memory.  

Memory is made up of bits. 8 bits = a byte. 

**0000 0001** is 1 
**0000 0010** is 2 

+ Byte = 2^8 potential data values 
+ 16 bits 
+ 32 bits = int 
+ 64 bits = long 

Endianess - ordering of bytes 
Most significant byte is on the left  

Typically dealing with fixed-width integers.

You can store the memory address as the value of a different memory slot. **Pointers** point to a different memory slot. 

# ASCII Character mapping  
Assign letters to a number. 

# Big O Notation 
It doesn't make sense to describe algorithm runtime with exact time because the input changes the time to run drastically.

This is where big o notation comes in. 

For example 

```java
ArrayList<Integer> a = new ArrayList<>();

f1(x) = 1 + a[0]; // O(1) this is an elementary operation 

// Even when you have a bunch of elementary options it's still considered constant time. 

f2(x) = sum(a); // O(n)

f3(x) = pair(a);  // O(n^2) time complexity going crazy as input grows bigger. 

// When f(n) and n -> infinity you'd simplify things like O(N^2 + N + 1) to just O(N^2)

// This is called asymtotic(sp?) analysis
```

Asymptotic analysis (from fastest to slowest)
+ constant time O(1) 
+ linear time O(N)
+ logarithmic O(logn)
+ O(nlogn)
+ big ones O(N^2), O(N^3), O(N^4)
+ O(2^n)
+ O(N!)

You can also explain it in average case versus worst case. 

But Big O Notation implicitly represents **worst case scenario**.  

# Examples
Traversing through an array O(N)
Traversing left of an array then right to left O(2n). 

function that took in 2 arrays. If you summed the two arrays together then you'd get 

`O(N + M)` 
If there are two variables then you'll want to keep the two variables. 




