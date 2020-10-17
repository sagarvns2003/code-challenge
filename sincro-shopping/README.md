![GitHub last commit (branch)](https://img.shields.io/github/last-commit/sagarvns2003/code-challenge/main?style=for-the-badge)
![GitHub All Releases](https://img.shields.io/github/downloads/sagarvns2003/code-challenge/total?style=for-the-badge)


# Epic/Story Context
A big retail brand outlet, on the eve of Christmas, we want to offer attractive seasonal discounts to our customers to boost our retail sales.
# Story...
As a retail outlet’s salesman, I should be able to calculate the customer's shopping cart bill after considering applicable discount rates that are based on the purchase amount and customer type so that our retail outlet can maximize sales volume & value.
Discount Slabs for various purchase amounts for the regular and premium customers are as follows...

### Customer Type: Regular
| Purchase Amount Slab  |  Discount % |
|---|--:|
| $0 - $5,000  | Nil  |
| $5,000 - $10,000 | 10%  |
| $10,000 & above | 20%  |

### Customer Type: Premium
| Purchase Amount Slab  |  Discount % |
|---|--:|
| $0 - $4,000  | 10%  |
| $4,000 - $8,000 | 15%  |
| $8,000 - $12,000 | 20%  |
| $12,000 & above | 30%  |

```
Note:
Total discount would be the sum of discount calculated for each slab.
E.g. For purchase of $15,000 by a regular customer would entitle total discount $1500 which is sum of
discount $500 for 2nd slab [10% of $(10000-5000)] & $1000 discount for 3rd slab [20% of $(15000-10000)].
```

# Story Test-cases
### Customer Type (input): Regular
| Purchase Amount (input)  |  Bill Amount (output) |
|---:|--:|
| $5,000  | $5,000  |
| $10,000 | $9,500  |
| $15,000 | $13,500 |

### Customer Type (input): Premium
| Purchase Amount (input)  |  Bill Amount (output) |
|---:|--:|
| $4,000  | $3,600  |
| $8,000 | $7,000  |
| $12,000 | $10,200 |
| $20,000 | $15,800 |


# Solution...

#### Run this main junit class
```
/src/test/java/com/sincro/shop/service/ShoppingServiceTest.java
```











