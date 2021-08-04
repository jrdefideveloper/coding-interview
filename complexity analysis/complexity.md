# Complexity Analysis 
Most coding problems have multiple solutions however some solutions are better than the others! The metric you use to decide which solution is better is the following

1. Time complexity 
2. Space complexity 

Both of them together are referred to as space time complexity. 

`Time complexity` is the measure of how fast an algorithm runs 

`Space complexity` is how much space the algorithm uses 

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

`ArrayList<Integer> numbers = new ArrayList<>();` 

`f1(x) = 1 + a[0];` O(1)

`f2(x) = sum(a);` O(N)

`f3(x) = pair(a); ` O(N^2)



