# Major pointers 

The prompt is usually "Design youtube". They ask very broad questions on purpose to kind of gauge if you are a good problem solver.    

## Step 1. Gather system requirements (10 min) 

Examples of clarifying questions 
1. What piece of functionality are we looking for support for?  
2. Then get even more granular on the functionality 
3. Scale of the design we are tackling. How many users? Global userbase? Sometimes it doesn't matter. Regionality, etc Sometimes the scale has to do with data not so much users. For example Google Drive. How much data can each user have? 
4. System characterstics: Latency, fault tolerance, downtime  

## Step 2. Planning 

After having enough information write up a plan for your design. Not anything fancy but many numbered steps etc.  

Helpful to interviewer and yourself as well. Interviewer can get you back on track if your plan isn't good or doesn't match their question. 

instagram: first start with storage solutions (user metadata, user profile), and then next (profile creation, editing), posting etc. Final part might be explore page on instagram  

ebay: buyer side, seller side. Split up both sides in subsystem etc. 

## Step 3. Estimation 

Estimate needs of the system 

- throughput, bandwidth, etc  

Can system needs be met? 

For example: system really values low latency 
cache data in API servers. How big is the data? What if it's one picture and how many users do you have? Do you have enough memory to store 1 picture space * users?

+ 1kB = 1000 bytes 
+ 1MB = 1000 kB 
+ 1GB = 1000 MB 
+ 1TB = 1000 GB 

Arbitary metadata space sizes is good to know. 

+ Metadata 1kb - 10kb. Netflix movie 1 character = 1 byte. 
+ Pictures (1080 x 1920) 2 MB. Compressed 1.5MB  
+ 20 minutes of HD video (3 GB) 

How much does a server have? Some industrial grade machines have 256 GB of RAM lol. 

Bandwidth/latency 

How long does it take for a regular HTTP request to make a round trip, not bound by bandwidth? 

+ network requests 150ms (cross country) 500ms global 
+ phone 1-3 mbps 
+ desktop 1gb/s 
+ datacenter 5 gb/s 

## Step 4. Communication 

+  Even more important to communicate during system design since you're not asked to code everything out. 
+ Every design decision explain your thought process. 
+ Why sql over nosql database?  

Many different routes you can take but make sure to explain the pros and cons. 

Frequently confirm "Is this acceptable? Does this seem fine?" 

## Step 5. Diagramming 

+ Draw shapes etc lol 

Annotate diagram 





