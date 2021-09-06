## Stripe 

Core product is effectively an API. Auxiliary product like dashboards but many companies basically sell access to an API. 

Making changes to API becomes extremely difficult after rollout because so many downstream customers rely on the API. 

When a new API is developer high level engineers review the design choices etc before actually implementing it.  

## API Design interview 

+ what are designing? 
+ what is the scale? 

For example design the twitter API or the stripe API? 

What part of twitter or what part of the stripe? Who is the consumer? Without this information you can't design the API. 

Then afterwards you jump into the meat of the interview. 

Not really drawing out diagrams and systems etc we will instead be talking about he outline of entities/resources are. 

Outline of various parameters and outputs of each API. 

Is there really a right answer to this?  Everything is kind of fair game if you are able to defend your decision. There really isn't a right or wrong answer. 

Final product of an API interview 

# API definition 

## Entity definitions 
### Charge: 
- id: uuid 
- customer_id: uuid 
- amount: integer 
- currency: string (or currency-code enum)  
- status: enum ["succeeded", "pending", "failed"]

### Customer: 
- id: uuid 

### Card 

## Endpoint definitions 
### Charges 
CreateCharge(charge: Charge) 
=> Charge 
GetCharge(id: uuid) 
=> Charge 
UpdateCharge(id: uuid, updatedCharge: Charge) 
=> Charge  
ListCharges(offset: integer, limit: integer)  
=> Charge[] 
CaptureCharge(id: uuid)  
=> Charge  

### Customers 
CreateCustomer() 
=> Customer 

3 exercises that you should: 

Go over API design interview questions on SystemDesign expert. 
Go online and look through your favorite companies API documentation.  Clear visibility on production code. 

