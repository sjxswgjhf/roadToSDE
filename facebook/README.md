# LeetCode Microsoft explore

# Arrays and Strings
## 1. Longest Substring Without Repeating Characters
lt 3. 
Sliding window algorithm, map记录了遇到过的char跟先前的idx，然后还需要个临时变成取记录之前停止的位置，因为可能遇到c比先前停止的地方
小的情况，例如abcdba, a先前为0，prev是1,这时候计算的话是2~5，而不是0~5  
时间复杂度: O(N)  
空间复杂度: O(N)  

## 2. String to Integer(atoi)
lt 8.  
这题先用trim()处理空格，然后查看第一个char是不是符号，用个临时变量记录下，-的话就是-1，没有或者+的话就是1
然后while loop，检查是不是digit，不是的话就返回累计值，是的话继续往下累计，这里在累计前需要查看是不是overflow，
要看先前累积的sum是不是大于max/10，或sum = max / 10,那么当前digit是不是大于max的最后一位数，是的话根据sign来返回MIN或者MAX，
不是的话，继续累计，最后返回的时候继续乘上sign  
时间复杂度: O(N)  
空间复杂度: O(1)  

## 3. Roman to Integer
lt 13.  
for loop, 继续检查后一位是不是大于前一位，是的话就要做减法，idx+=2，不是的话就做单个的加法, idx++，hashmap做个table。
edge case就是最后一位的处理，只有遇到加法的时候才会碰到i==n-1，减法会自动跳过，所以加个if直接累计就好  
时间复杂度: O(N)  
空间复杂度: O(1)  

## 4. 3Sum
lt 15.  
2 Sum升级版，要处理dup triplets的情况，所以要先sort，然后看当前是不是跟前一位一样，一样的话就继续往后。然后传给2sum，
出发点为当前idx+1,然后检查3个数的sum是不是0，然后这里也要注意移动指针的时候要看是不是跟前面的一样，是的话继续移动，要避免dup


## 5. Remove Duplicate from Sorted Array
lt. 26  
双指针，如果当前idx跟前指针的数不一样的话，就把前指针移动到下一位，然后修改成当前idx的值，用个int记录修改了几次


## 6. Next Permutation
lt. 31    
这题真的是巧秒，首先如果一个数不能找到下一个permutation的话，那么肯定是从大到小排列，也就是说如果一个数不是从大到小排列的话，就能找到permutation
那么我们就要找到从后往前第一个decreasing的地方，然后跟后面just larger这个数的数互换，然后把从这个数之后的全部倒一遍，我们就能找到结果.  
例子: 123765 -> 125367, 从后往前找到了7->3的时候发生了decrease，然后我们在3后面找到一个只比他大的数，就是5，然后把3跟5交换，变成了125763，
再把763变成367就是下一格permutation 125367,这里的原理是，我们交换完3跟5之后，763还是最大的，没有下一个permutation，只有367从头开始，即要做763的reverse


## 7. Multiply Strings
lt. 43  
这题我用了乘法来做，一个digit乘另一个数，得到val然后根据position append0到后面，最后再合并所有的乘积数，速度较慢。  
但是这题可以用num1[i] * num2[j] will be placed at indices [i+j, i + j + 1]来做,res的长度是fixed即m+n,然后两重循环遍历所有乘积，再加上个位数的余数，然后根据对应的idx累计

## 8. Group Anagrams
lt. 49  
两种做法，一种是拿到一个str，变成char array再sort之后组合str，用hashmap记录了string对应的list，加到相应的list里面
第二种也是拿到一个str，然后记录count，再把count变成特殊的code string，用hashmap存到对应的list里

## 9. Add Binary
lt. 67
双指针从后往前，用个临时变量记录sum>=2，是的话带到下一次计算，不是的话就变成0，加完再看carry是不是1，是的话加到前面，注意指针跑完的情况


## 10. Minimum Window Substring
lt. 76
典型的sliding window，先用hashmap记录pattern每个char的要求数量，然后双指针走string，每遇到一个char，取减去对应map里面的count，
当一个count变成0的时候，说明有个char已经足够了，form++，当form==map的size说明整个pattern被覆盖了，然后跟当前res比较，再去移动左指针，
直到有个char不够覆盖了，如果循环直到右指针越界

## 11. Merge Sorted Array
lt. 88  
Two pointer，都从后面开始，哪个大放哪个再见小，最后注意p2的指针走没走完，没走完就再放到1里面

## 12. Valid Palindrome
lt. 125  
Two pointer一前一后，注意判断当前是不是digit或者letter

## 13. Read N Characters Give Read4
lt. 157  
这题要一次性读完，那就用两个变量去判断当前是不是达到eof或者size满了，然后把能放入buff的放进去

## 14. Read N Characters Give Read4 II
lt. 158  
跟上题的区别是这题每次只读一次，读到多少算多少，能放入buff就放入，满了就不放，那么我们就需要用global取记录先前到哪里了，size多少，buff也是global

## 15. One Edit Distance
lt. 161  
分情况讨论,先保证长度小的为第一变量，然后看两个str的长度差是不是小于等于1，然后for loop遍历找到一处不一样的地方，
如果长度一样，那么就说明是replace，看后面的substring是不是相等就好，如果不一样就说明是insert，那么看str1从i开始跟str2从i+1开始是不是相等，
如果for loop走完还没结果，那么说明str1从0~m跟str2的从0~m一样，那么就要看str1跟str2是不是长度一样还是差一位，如果是一样就是false，
差一位的话表明str2还有个char没读到，我们可以用insert into s来达到，那么就是true. 关键就是要注意完全一样也是false的情况，怎么处理


## 16. Product of Array Except Self
lt. 238  
这题用两组变量记录当前idx左边的乘积和右边的乘积，就能计算除了自己之后当前的乘积，优化的话我们可以用ans来记录变量记录左边的乘积，再用ans数组去从后往前乘右边的乘积


## 17. Integer To English Words
lt. 273  
这题先分情况，分成Less20，Tens，Thousands来做，然后从后往前做，每次取除1000的余数，丢到recursion里面，看余数是0~19,还是20~99,还是100到999，
分情况处理，先处理高位用%处理低位，百位的话手动添加Hundred进去，因为我们之前的划分没有hundred这个区间，需要手动主力，然后用个idx去记录下我们当前
处理的值的后缀情况，是空，还是thousand还是million还是billion

## 18. Move Zeros
lt. 283  
Two Pointer做，不是0的话就要l的指针值互换，直到r走完

## 19. Longest Substring with At Most K Distinct Characters
lt. 340  
Longest Substring with At Most K Distinct Characters
双指针+hashmap，sliding window，hashmap记录了当前遇到的char跟freq，同时更新最大的length当hashmap的size大于k的时候，我们开始移动左指针去去掉char，
直到有个char的freq变成0，hashmap移除这个char开始重新移动右指针.


## 20. Subarray Sum Equals K
lt. 560  
两种解法：一种是DP，一维数组记录了prefix sum，然后二维数组遍历从j~i能有多少种subarray的sum == k
第二种是按two sum 的思想，hashmap存了所有的sum的情况跟freq，然后看当前idx的时候，之前有没有一个sum-k的key存在，有的话就累计，
edge case是sum是0的时候为1,这个hashmap的思想就是prefix sum的思想. 按solution里面的说法是如果两个idx的sum是一样的，那么他们中间的
sum就是0，那么也就是说sum[i]-sum[j]=k的话，那么sum[i]~sum[j]就是k

## 21. Valid Palindrome II
lt. 680
Two pointer, 一个从后往前，一个从前往后，如果当前char不一样，那么就看去掉任意一个char的时候是不是palindrome，是的话就是，不然的话就不是.


# Linked Lists
## 22. Add Two Number
lt. 2  
用一个临时变量记录carryone，然后双指针同时移动，注意null的情况，最后记得查看carryone是不是，是的话就再加到尾部


## 23. Merge Two Sorted List
lt. 21  
Two pointer, 那个小先放进去，再移动到一下，注意下null的情况

## 24. Copy List With Random Pointer
lt. 138  
用HashMap记录已经处理过的node，loop的时候如果node处理过了就返回，没有的话建新node，加到map里面，

## 25. Reorder List
lt. 143  
这题的难点是不能换值，而是要替换node，又不是doubly linked list，所以没法双指针指首尾，那么我们就要找到中间节点把整个list拆分成两个，
然后把尾部的list去reverse，这样我们就能得到后半部分的list是从尾开始的，然后再把head跟reverse的list一起处理

## 26. Validate Binary Search Tree
lt. 98  
因为是Binary Search Tree，所以root要大于左边，小于右边，我们需要一个recursion携带左右的值去traversal整个tree，同时更新左右boundary

## 27. Flatten Binary Tree to Linked List
lt. 114  
DFS，主要逻辑是如果右边接到最左边的后面，左边接到root的右边，root左边为空，衔接过程中我们需要直到leftMost，rightMost用于下一次衔接，
如果左most右most为空就返回root。

## 28. Binary Tree Maximum Path Sum
lt. 124  
Recursion，然后用一个global值记录当前的最大sum，当前root的sum是root.val+(0,右)+(0,左)，然后返回上一层的话要左右中取较大值+root的值给上一层

## 29. Clone Graph
lt. 133  
HashMap记录已经访问过的node，然后当前node的话建立新node，copy val，再for loop处理neighbor，也用clone method

## 30. Binary Tree Right Side View
lt. 199  
PostOrder traversal 携带一个level的变量，如果当前list的size小于等于level的话，就把当前node的值加进去，不然就不加

## 31. Number Of Islands
lt. 200  
DFS, 注意用个二维数组记录已经访问过的cell，也可以用union find来做，岛的数量为一开始有多少个1，然后看union了多少次，差值就是岛的数量


## 32. Lowest Common Ancestor of a Binary Tree
lt. 236  
Recursion, 如果root等于其中任何一个node 或者 null，直接返回，都是的话继续探索，先左后右，recursion的关系，左右都有会东西返回，
我们只用看left跟right的返回值，如果当前root的左右都有返回值，那说明左右各有一个target，放回当前root，如果左边为空，说明都在右边，
我们返回右边那个node，如果右边为空，我们返回左边那个node

## 33. Binary Tree Paths
lt. 257  
Recursion做法，我们需要三个变量，node，list，跟当前路径情况，当我们遇到leaf node的时候我们把值append到path加入list返回，如果当前node
左不为空，那么我们继续recursion它的左子树，path加上->跟val，再看右子树，不为空，我们同样recursion右子树，path加上->跟val.  
Iterative做法：用BFS的思想来做，我们要用两个queue来分别记录path跟node就可以了。 如果是DFS的话，我们要用来个stack来做。

## 34. Alien Dictionary
lt. 269  
难题，这题要用topological sort来做，先要建立graph，我们要直到每个char的degree是多少，首先loop所有的单词，每个char都设置count为0，
然后两两word来处理，这里要注意word1是不是把word2include了，是的话就是invalid，不是的话，找两个str从哪开始char不一样，
前者指向后者表示前者大于后者，graph里面就是directed edge，我们把后者加入前者的list里面，后者的count要++，说明income degree增加了，
最后我们用queue来实现拓扑排序，先把0 degree的char加入到queue里，依次pop加入到res，pop的时候处理它的相邻char，减少他们的incoming degree，
直到queue为空。最后要注意是不是有环在图像里，也就是说我们的最后res的长度是小于所有char的数量，那么我们也是invalid

## 35. Shortest Distance from All Buildings
lt. 317  
这题比较特别，如果单纯的从每个0出发做bfs去找1并做统计的话会TLE，所以我们从1出发做BFS，对每个0我们累计走的步数跟有几个1到达，
这样我们最后loop一下所有的0，看0能遇到了所有的1，然后是最小的sum就可以了

## 36. Diameter of Binary Tree
lt. 543  
这题跟path sum一样，向左+1，向右+1，跟max比较的时候是左+右，但是返回上一层就是左右取最大值+1

## 37. Accounts Merge
lt. 721  
这题name不是unique的，所以要用email来做，用两个hashmap，一个是email对应的名字，还有个就是当前email相关联的emails，要注意这里的graph是无向图
即在给当前email加adj的时候，也要把当前email加到adj的email的list，之后我们对每个email做dfs，把所有相关联的加入到一个list里面，
为了避免重复计算，要有个hashet记录所有已经访问过的email
Union Find也可以做

## 38. Convert Binary Search Tree to Sorted Doubly Linked List
lt. 426  
这题简单版就是inorder遍历之后一个个处理，但是好像不符合题意。
所以要用recursion来做,需要个global的prev来做，先建个dummy，然后把prev指向dummy，这个是我们的head keeper，
接下来做inorder，null的时候return，先左，左边结束的时候是返回到1，这时候我们prev是dummy，cur是1，把prev跟cur设置成dll，
然后prev设置成cur，prev就成了1，接下来的cur变成了2，彼此处理直到结束，这时prev是5，dummy.right是1，首尾要相连，我们把这两个相连，完成。


## 39. Is Graph Bipartite?
lt. 785  
特殊题，确定一个graph是不是bipartite要用coloring的方法来做，我们要个一维数组记录所有已经color过的node，然后loop所有node，从0~n-1，
如果当前node没有被color过，我们就color它，然后放入stack里面，做DFS，把相邻的node color成相反的颜色，并放入stack继续color这个node的相邻，
如果遇到一个color过的，而且这个color过的颜色跟当前的一样的话就是false了

## 40. Binary Tree Vertical Order Traversal
lt. 314
这题需要vertical的情况，那我们肯定要直到leftMost跟rightMost的值，这样我们就能直到要有多少list，
并且如果我们直到当前每个node对应的具体position的话(left/right)那么我们就能通过shift来计算vertical的位置，因为vertical的leftMost是0，
我们可以建个新的node，里面有两个值一个position来表示当前位置，一个val来表示val，我们先做preorder traversal，把所有node遍历一遍，并把
新建的node放入一个list，同时更新leftMost跟rightMost，然后我们就可以建res list，再遍历list去一个个加入到对应位置的list里面

## 41. Letter Combinations of a Phone Number
lt. 17  
先用hashmap创建我们的phone number对应的字母表，然后我们做recursion，需要三个值，一个是res list，第二个是当前str，最后一个是当前digits的str，
如果当前digits为空了表明我们已经处理完了就把cur str加入res，不然的话我们就继续拿下一个char，加到当前str里面，做下一层recursion，记得更新digits

## 42. Permutations
lt. 46  
Backtracking, 从idx=0开始，用boolean数组表示访问过没，如果当前num已经被访问过了就继续往后走，直到list size跟num一样。

## 43. Permutations II
lt. 47  
Backtracking, 从idx=0开始，如果当前list包含了这个num就继续往后走，直到list size跟num一样。这里要处理dup的问题，我们需要先排序，然后用
一维数组处理visited的情况，避免重复，在接下来我们需要判断当前num是不是跟前面一样，并且前面的没被使用过，那说明以这个num开头的情况已经处理过了，
直接continue，如果一样但是前面的使用过了，说明可以加进去，因为对这个num来说，我们是在第一轮的permutation种

## 44. Remove Invalid Parentheses
lt. 301  
难题  
1. 首先我们不知道有删除多少的左右括号，所以先要遍历看我们要删除多少左右括号，loop整个str，用两个变量去记录要删除的左右括号。遇到左括号的时候
l++，遇到有括号有两种情况，一种是跟左括号合并，l--，如果没有左括号，我们就要删除这个右括号，r++
2. dfs  
2.1 终止条件比较清晰，l跟r都为0的时候，并且是个valid的，这里注意letter要ignore  
2.2 主体，我们for loop从头开始，如果遇到letter或者当前char跟前一个相等的情况,例如：((), 删除第一个跟第二个删除是一样的效果，
所以当i=start的时候，我们不做处理，因为是首位，但是当后面的时候，我们就要看跟前面的是不是一样了.
所以一样的话就continue，然后把这个idx的char删掉之后重新构建str，如果当前的char是左括号，那么我们就dfs的时候l-1，如果是右括号，就r-1
3. 建个function去检查当前str是不是有效的result.

## 45. Subsets
lt. 78  
这题要求所有的subsets，看个example[1,2,3], 我们先从1开始加入，可以构成[1],那再加入2，我们现在有[],[1],可以形成,[2],[1,2],得到[],[1],
[2],[1,2],再加入3，我们可以得到[3],[1,3],[2,3],[1,2,3],最后整个list里有[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3],通过这个我们可以直到
双重循环，第一重为nums，第二重为已求得的subset

## 46. Strobogrammatic Number II
lt. 247  
这题backtracking，我们先分析下，首先0，1，8是可以直接加入的，然后6跟9是相互对应的，那么我们要实现n长度的strobogrammatic，我们应分成2段，
front跟back，一个从前往后加，一个往前塞，我们需要两个变量去记录前后指针的值，如果前后指针overlap的时候，我们就把结果加入list，当前后指针
相等的时候，这表示我们现在只能加一个char进去了，那么只有0,1,8三种，分别加入之后加到res，如果l<r，我们可以有五种情况，前后都加1或8，0的话
要避开l是0的情况，不能有0打头的integer，接下来是6跟9，如果前面加6后面就加9，如果前面加9，后面就加6.

# Sorting and Searching
## 47. Divide Two Integers
lt. 29
这题的corner case非常的坑，需要考虑divisor是0的时候返回MAX，如果dividend是MIN的时候，要特殊处理，有overflow的情况，如果divisor是+，
那么返回MIN，反之返回MAX。接下来好吧两个input cast成long，因为后面处理可能会超界，在接下来，我们计算divisor要位移多少次，能超过当前的dividend，
如果超过了，我们的res就累计1<<(shift-1)，然后把dividend减去divisor<<(shift-1),继续看接下来的余数要多少次，直到dividend小于divisor,最后返回的时候注意下正负。

## 48. Search in Rotated Sorted Array
lt. 33  
Binary Search, 因为是rotated sorted array，核心是要找道哪一段是sorted的，我们把l跟mid比较，如果mid大，那说明l~mid是sorted，反正右边是sorted，
我们再看target是在哪个区间，如果l~mid是sorted，并且target在这段里面，r=mid，反之l=mid+1,如果mid~r是sorted，target在mid~r里面，l=mid+1，反之r=mid.

## 49. Find First and Last Position of Element in Sorted Array
lt. 34  
这题我们可以设计一个binary search，找到首个>=target的数字，然后再找首个>=target+1的数字，这样我们就知道了target的first跟last了，first就是
首个>=的，尾部就是>=target + 1的idx - 1，然后有个地方要注意的是pos要先设置位n，因为可能要找的target是最大的num，而我们找back的时候用的是target+1，
也就是超过了array了，即第n个idx，那么就是尾巴也就是N-1,最后看left是不是小于等于right，既有效的,如果没有的话，left会大于right

## 50. Pow(x,n)
lt. 50  
Recursion来做，如果我们知道x^n，那么我们怎么求x^2n,我们直接x^n * x^n,利用这个idea，我们先求得x^(n/2),那么我们就能得到x^n，当然注意n的奇偶，
n为odd的话，我们要额外乘个x，如果偶的话不需要，要记得处理n<0情况，如果小于0，我们把x变成x=1/x,n=-n就可以了。

## 51. Merger Intervals
lt. 56  
两个pointer，先sort整个intervals，然后慢指针不动，快指针往后移动，如果当前的end大于快指针的start的话，继续往后，但是要记得维护end的max情况，
可能有slow的end还大于fast的end，每当发现fast的interval不能merge的时候，就把begin跟end构建int[]加入到list里面，更新慢指针

## 52. Find Peak Element
lt. 162  
二分法，如果当前mid比mid+1大的话，更新r=mid，不然就是l，最后返回l或r

## 53. Find Bad Version
lt. 278  
Binary search,当前是好的version 的话更新l，当前是bad的话更新r

## 54. Intersection of Two Arrays
lt. 349  
Hashset记录第一个nums的所有num的情况，然后loop第二个nums，有存在的就加到res

## 55. Intersection of Two Arrays
lt. 350  
HashMap记录第一个array的所有num跟freq，loop第二个num，每遇到存在的并且freq>0的就加入res，减去hashmap中的freq

# Dynamic Programming
## 56. Longest Palindromic Substring
lt. 5  
1. DP: 二维数组记录i~j是不是palin，当到i-1，j+1的时候，如果char相等，就看dp[i][j]，注意i-j<=2的时候就是true了，更新max
2. Expand: 尝试每个idx的expand，两种case，odd跟even

## 57. Longest Valid Parentheses
lt. 32  
()()(), ((())),()(())  
1. DP: 一维数组记录了对应idx的累计长度，如果当前char是)的话  
1.1 前一个是)的话，那么就是dp[i-2]+2  
1.2 如果不是(的话，那么我们就看i-dp[i-1]-1这个idx的char是什么，是(的话，就能构成有效的组合，dp[i]=dp[i-1]+2
1.3 但是1.2还有一种情况没包含就是()(()),所以我们要看i-dp[i]是不是没越界,是的话，我们就可以累计

## 58. Decode Ways
lt. 91  
case: 123 1 2 3 | 12 3 | 1 23
case: 1224 1 2 2 4 | 12 2 4 | 1 22 4 | 12 24
DP: 分情况讨论。如果当前char不能跟前一个合并的话，组合数等于前一个，如果合并的话，还能来及i-2的情况
1. 如果前一个char不是0的话，dp[i]=dp[i-1]至少，
2. 不是的话，那么substr从i-1~i是10~26的话，那么dp[i] += dp[i-2]
注意base case，如果0个char的时候就是0，但是1个char的时候要取决于这个char是0还是别的，是0的话就0，不是的话就是1

## 59. Best Time to Buy and Sell Stock
lt. 121  
DP: 记录当前最小prices是多少，滚动更新，也可以用个临时变量记录

## 60. Word Break
lt. 139  
DP: 用一个一维数组去记录，如果当前j~i的substr在wordDict中，那么只要0~j是true，0~i就是true，所以一个双重loop，外层是i，内层是j

## 61. Range Sum Query 2D - Immutable
lt. 304  
用colsums/rowsums来做的话query time是O(m)或O(n)  
这题可以实现Query O(1),先计算SumRange(i,j) = Sum(i)(j-1)+Sum(i-1)(j)+matrix(i)(j)-Sum(i-1)(j-1),这样我们就知道了sumrange，
计算的时候，我们就看从row1~row2,col1~col2, dp[row2+1][col2+1]-dp[row1][col2+1]-dp[row2+1][col1]+dp[row1][col1],注意要有padding

## 62. Continuous Subarray Sum
lt. 523
1. 用prefixsum来做的话，先计算prefixsum，然后双重循环，计算所有的subarray的sum，然后跟k检查，注意第二重循环的出发点要从start+1开始，因为要至少2  
 
1. 数学题，余数的概念，如果两个数被同一个数相除，余数相同，那么他们的差可以被整除, ex: a = ik+1，b=jk+1, a%k=1,b%k=1,那么(a-b)=(i-j)k % k = (i-j)
这样的话，我们就可以用个hashmap去记录了，key为余数，value为之前的idx，如果当前sum被k整除直接return true，不然的话把sum变成余数，检查余数是不是存在，
如果存在，检查下先前余数产生的idx跟当前idx是不是差为2，是的话就是true，如果不存在同样的余数，就记录sum,比较讨厌的edge case是0,要现在map中加入0，但是value要
-1，这样才能处理单个num是0但是后面没有的情况

# Design
## 63. LRU Cache
lt. 146  
DLL来做，主要要做的实现的是remove跟setHead两个method，remove的时候，看node的prev有没有，再看node的next有没有，有的话node.next.prev指向node.prev,没有的话表明是tail，那么tail要变成node.prev
setHead的时候先把head接到node的后面，再看head是不是null，不是的话，再把head的prev指向node，最后head变成node，
再看tail是不是null，是的话就设置tail=node。 再实现get的时候要remove，然后sethead，而put的时候分两种，一种是有
这个key，我们直接改val，然后remove再sethead，第二种是没有，先加到map里面，再sethead，然后去过超过capacity了就去掉tail

## 65. Binary Search Tree Iterator
lt. 173  
直接Queue来做要n的space，题目要h的space，我们利用inorder的思路，来用stack做，每次都把leftmost的那条放到stack，就可以

## 66. Add and Search Word - Data structure design
lt. 211  
Trie Tree implementation. Trie Tree有个root，然后每个节点有26个child对应a~z,还有个boolean值，对应存不存在以当前节点结尾的word

## 67. Serialize and Deserialize Binary Tree
lt. 297  
Preorder traversal来做的serialize的话，deserialize就要用queue。 Inorder的话用Stack来deserialize

## 68. Expression Add Operators
lt. 282  
Backtracking, 终止条件，当当前pos走完了整个input，并且sum=target，我们就加到res里面。对于每个char，我们都要尝试，所以需要个for loop，并且
idx是根据上一层的idx的下一位开始，那么我们就需要个position参数来tracking走到哪个idx了，loop里面，首先我们要看以当前pos开头以为pos+i结尾是不是
一个有效的int，那么leading char不可以是0，是0就break，即i!=pos的时候，s.char(pos)=0就break，然后我们用substring来计算值，要用long type，
因为最大是10位数，可能超过int的范围，接下来我们要考虑三个operator的情况，str首先首字母pos=0只有一种情况就是+，别的pos的话，我们可以用三种，
首先+，-很好处理直接apply，但是*法的话，我们如果只直到当前sum的话其实没法处理的，因为我们要先去掉前面累计的值，之前累计值再乘当前的值，
我们需要一个long的prev参数去tracking之前的值，当我们主要做乘法的时候，我们先把sum-prev再+prev*cur就好,即1+2*3,之前是1+2=3,prev=2,
我们现在要实习1+2*3，那么就是3-2=1+2*3。

## 69. Find All Anagrams in a String
lt. 438  
Sliding Window, 两个一维数组，一个记录pattern需要的各个count的数量，一个滚动更新当前数组的char的数量，每loop一次，去检查两个数组是不是一样，
是的话就是anagram，不是的话就往后走，当idx大于等于pattern长度的时候，我们需要前去之前char的count，即i-pattern.length()那个地方的idx

## 70. Permutation in String
lt. 567  
跟Anagrams一样，sliding window来做，查看同样长度下的pattern是不是一样的count，是的话就是，不然的话就不是

## 71. Verifying an Alien Dictionary
lt. 953  
两两比较，two pointer，找到首个char不一样的地方，然后去dictionary看index的大小。

## 72. Interval List Intersections
lt.  986
看A跟B有没有intersection的话，我们就看四个数值，Astart，Aend，Bstart，Bend，分四种情况
1. Aend < Bstart, A B没有交集，A往后移动
2. Astart > Bend， A B没有交集，B往后移动，
3. 有交集，那么首先是要取较大的start，然后看end哪个小   
3.1 如果Aend小，那么Aend加到internsection然后把intersection加到list之后A往后移动  
3.2 反之，把bend加到intersection然后把intersection加到list之后B往后移动