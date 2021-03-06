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

Didn't do as much as I wanted. Distracted by my sister's new puppy. 
Made a visual board of all the things I want out of life. I like looking at it. I think after 3 pomodoro cycles I should take a 30 minute break and then immediately get back into studying after that. Taking an extended break makes my mind to use to chilling.  

# *August 05, 2021* 

Solved :pencil:  

+ `fibonacci` - Be careful with how the first number is defined. Some people define it slightly different. For instance n=1 may be 0 or 1 depending on the asker. It can be done with rudimentary DP or recursion. 
+ `first-non-repeating-character` - pretty easy one. I like Hashmaps. 
+ `is-palindrome` - super easy. I like one pass problems. interesting to go through different types of solutions though. I still have problems with putting together the recursive version of the solution. 
```java 
    // This is just somehow really weird to me. 
    return (start >= end) true ? (str.charAt(start) == str.charAt(end) && isPalindrome(str, start - 1));  
```
+ `remove-duplicates-from-linked-list` - These problems are fairly easy. Just got to be kind of careful about the next being null etc. Have to go through the examples a couple time and go through the pseudocode logic a couple times before saying I'm done with it 
+ `binary-search` - This is also really easy. But you just have to make sure that the right and left exclude mid itself or you'll run into issues when the result is in the last or first index. 
```java 
    right = mid - 1; 
    left = mid + 1
``` 

Watched :eyes: 

+ Videos on recursion setup 

Evaluation :trollface: 

Problems today were more straightforward to me than previous days. I need to watch more videos on recursion. When the set up is complicated I start to get really confused. 

# *August 06, 2021* 

Solved :pencil:  

+ Nada 

Watched :eyes: 

+ Nada 

Evaluation :trollface: 

Driving to San Francisco today. Kind of hectic and hard to study on the car. Random thought I had today about Pokemon Go, every trade only has a 2% of producing a lucky Pokemon so what kind of algorithm do they have running on some sort of UserTradeSession class? It also needs to take into consideration that a Pokemon from 2016 produces a guaranteed trade but either user can only have 10 Pokemon be guaranteed luckies. Business logic must just be a bunch of if statements. Some other edge cases I'm not taking into consideration as well for instance, best friends can also produce guaranteed luckies. 

```java 
// Pokemon constructor would possibly look like this 
class UserPokemon { 

    int cp, quickMove, chargeMove, level = 0;  

    public UserPokemon(int id, PokeType type, boolean isLucky, boolean isShiny) { 

    }

    // More overloaded constructors here. 
}
``` 

# *August 9, 2021* 

Solved :pencil:  

+ `branch-sums` This is actually fairly easy. I'm getting better at setting up recursive tree functions. Sometimes you almost have to just take a leap of faith that it'll work out. 
+ `node-depths` - I fumbled on putting together the recursive and iterative solution for this. I was trying to do a level order traversal with only a nodeDepth variable but I realized the nodeDepth wouldn't be able to properly track the depth as you traverse the tree. Utilizing an extra level variable is what I was missing. 
```java 
 public static int nodeDepthsIterativeSolution(BinaryTree root) { 
        Queue<Level> queue = new LinkedList<Level>(); 

        queue.add(new Level(root, 0));   // first add root node with a level of 1
        int totalDepth = 0; 

        while (!queue.isEmpty()) { 
            Level currentLevel = queue.remove();  
            BinaryTree currentNode = currentLevel.root; 
            int currentDepth = currentLevel.depth; 
            if (currentLevel.root == null) continue; 
            System.out.println("We are currently on node " + currentLevel.root.value + " level " + currentDepth); 
            totalDepth += currentDepth; 
            queue.add(new Level(currentNode.left, currentDepth + 1)); 
            queue.add(new Level(currentNode.right, currentDepth + 1));   
        }
           
        return totalDepth;  // the root doesn't count. 
    }
}
``` 
+ Kind of cool that nodeDepths solution can be solved with both a queue and a stack. I made a terrible mistake of referencing a currentNode temp variable instead of the recent node from the queue. Easy to make bad mistakes like that. 

Watched :eyes: 

+ Nada 

Evaluation :trollface:  

+ Honestly a bit dissapointed in my lack of progress today. Although my body condition is kind of terrible since I haven't slept more than 5-6 hours in the past 3 days. Still having a bit of difficulty putting slightly convoluted recursive functions together. I need to sleep more so that I can use the full extent of my brain. 

# *August 10, 2021*

There are 12 easy problems left in AlgoExpert. I want to just complete these in 1 day tmr. It's also spotlight hour for East Shellos in Pogo. Hmm. Decisions. Hope to solve all though. 

Solved :pencil: 

+ `depth-first-search` - Awesome review. DFS code is really simple. Hard to put together a graph test case during the interview 
+ `minimum-waiting-time` - Easy to do. Made a little mistake on the totalWait in my solution. Separate solution without using any extra space is a neat math hack. 
+ `class-photos` - When you have an if logic its better to put it within the for loop instead of putting it out side and using two for loops. This question is quite easy as well. 
+ `tandem-bicycle` - I was pretty good at this one. Made a mistake here and there. I wish I could do one pass coding and it just works as soon as you press 'Run code'. Lol. 
+ `product-sum` - Had a bit of difficulty putting the recursion together... I tried to put sum as a third paramater but that was unnecessary. I'm embarassingly slow at simple math as well. I need to download some sort of fast math mind games app.. lol
+ `find-three-largest-numbers` - Practice running through code before clicking Run. Mentally find mistakes quickly. 

Watched :eyes: 

Evaluation :trollface: 

Sometimes it feels like I type slower than I can think. And I type a lot of errors when I try to type quickly. I almost need to do some accurate typing practice so I can write an elegant solution with test cases in the alloted time. 

I need to do more problems that have recursive solutions. Leetcode should have some sort of recursion tag hopefully. I need to download some sort of math mindgames iPhone app.  

Did 6 easy questions and then went to do family stuff. Wasn't able to finish all the easy questions. 

# *August 11, 2021*

Solved :pencil: 

+ `bubble-sort` - Forgot all about this, lol. 
+ `insertion-sort` - Pretty easy sort as well. 
+ `selection-sort` - Reviewing more not so performant sorting methods. I feel like  I really only need to know quickSort and mergeSort. Possibly Radix. 
+ `caesar-cipher-encryptor` - This is kind of easy if you have the Ascii table in front of you. The tricky testcase is when the shift is > 26. 
+ `run-length-encoding` - Very easy conceptually but struggled putting together the solution that passes all test cases... sigh. But I guess this is what practice is for. I was attempting to use a slow and fast pointer but just keeping track of the prevChar and the currentChar was easy. Knowing how to put the proper if statement together to start the appending of the string gets tricky. 

Watched :eyes: 

Nothing extra 

Evaluation :trollface: 

Sorting day finally. Still need to be better at putting solutions together without errors. Going to practice summarizing the solution every so often out loud. 

# *August 12, 2021*

Solved :pencil: 

+ `generate-document` - I love these type of problems. lol. 

Evaluation :trollface: 

Doing the last easy problem. Then moved onto medium problems. See mediums problems directory. 

# *September 23, 2021* 

+ `leetcode: logger rate limiter` - Wow it's so easy I wish someone could ask me something like this during an interview 
+ `leetcode: employee importance` - nice refresher on bfs/dfs 

# *September 24, 2021* 

interviews 

# *September 25, 2021* 

+ `Find Nodes Distance K` - 

# Random things I went over  

## StringBuilder
Some knickknacks that are important to remember concerning strings 

Quickly reverse a string. O(n) time complexity when utilizing StringBuilder. But if you are use regular string concatenation it's O(n^2) so be careful. 
```java 
StringBuilder sb = new StringBuilder(); 
sb.reverse(); 
```

Deleting a last character from a StringBuilder quickly 
```java 
sb.deleteCharAt(sb.length() - 1); // Delete last character 
sb.deleteCharAt(sb.length() - 2); // Delete second to last character. 

```

## Stack 
Can implement this with an ArrayList<Type>(); 

Remember to remove at the last index e.g `stack.remove(stack.size() - 1);` Code looks a tad funky. 
## Hashmap 
Difference between HashMap and HashSet 
HashSet is implementation of Set Interface which does not allow duplicate value. 
The main thing is, objects that are stored in HashSet must override equals() for check for equality and hashCode() methods for no duplicate value are stored in our set.

HashMap is an implementation of Map Interface, which map a key to value. Duplicate keys are not allowed in a map.
Basically Map Interface has two implementation classes HashMap and TreeMap the main difference is TreeMap maintains order of the objects but HashMap will not.
HashMap allows null values and null keys.

Both HashSet and HashMap are not synchronized.

## Reverse an array 

Java doesn't have convenient Array.sort method for reverse order, unlike with ArrayList<Integer> you can just use `Collections.reverseOrder` as the second parameter.  

```java 
   public static void reverseArrayOrder(int[] array) { 
        int start = 0; 
        int end = array.length - 1;  

        while (start < end) { 
            int temp = array[start]; 
            array[start] = array[end]; 
            array[end] = temp; 
            start++;  // be careful about putting this 
            end--; 
        }
    }
``` 