# #1. Interface(API / ADT) vs Data Structure

## Interface

> - Specification
> - What data can store
> - What operations are supported & what they mean
> - Problems



## DataStructure

> - Representation
> - How to store data
> - Algorithms to support operations
> - Solutions

# #2. main interfaces

> set
>
> sequence

## 

## 2 main DataStructures approaches

> - arrays
> - Pointer based

 



## Static sequence interface

maintain a sequence of items X0, X1, X2 ... Xn-1 subject to these operations

- build(x): make new DS(DataStructure) for items in X
- len(): return n
- Iter_seq(): output X0, Xn ... Xn-1 in sequecne order(at least linear time)
- get_at():  return Xi (index i)
- set_at(): set Xi to X

### Solution(natural): static array



Key : word RAM model of computation

- memory = array of w-bit words
- "array" = Consecutive chunk of memory



