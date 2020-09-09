# LeetCode Microsoft explore
# Arrays and Strings
## 1. Two Sum
用Hashmap来做，遍历数组，需要查找的map中有没有target-val的key存在了，如果有的话就说明有那样一对pair去构成target，如果没有就存在map里面，key是val，value是index.  
时间复杂度：O(N)  
空间复杂负：O(N)  

## 2. Valid Palindrome
首先这题检查下base case，input为null或者空，然后两个指针，前指针从前往后，后指针从往前，移动时候只检查字母或者数字，每次移动一个指针直到遇到字母或者数字，再移动另一个指针，在java中有个built in的method: Character.isLetterOrDigit(char c)，移动时候注意指针的情况，前指针要小于后指针，然后检查前后指针对应的char是不是一致（注意ignore大小写）.不一样直接return false。走完整个string再return true  
时间复杂度：O(N)  
空间复杂度：O(1)

## 3. String to Integer
这题首先处理前空格，可以用trim()也可以用while loop，接下来因为由正负(正号可能有也可能没有)，所以在判断的时候要看第一个char是不是+或者-，是的话就移动一位index，不是的话就不要移动。用1或者-1去记录正负，最后结果跟sign相乘就可以。  
接下来用while loop去跑指针，注意每次遇到的char一定要是digit，不然就停止，返回累计值。这题的难点是怎么handle overflow。我们用一个sum去记录累计值，然后判断当前sum是不是已经大于Integer.MAX_VALUE / 10了，是的话下一次就超了，直接根据sign的情况返回MAX或者MIN。
如果当前sum == Integer.MAX_VALUE / 10,那么我们就要看下面那个char，是不是大于MAX的个位数了，如果大了也是返回MAX或者MIN，如果小于就继续累计。累计的时候注意要先把sum\*10+val。最后return的时候记得累计的sum\*sign  
时间复杂度：O(N)  
空间复杂度：O(1)

## 4. Reverse String
前后两个指针互换..  
时间复杂度：O(N)  
空间复杂度：O(1)

## 5. Reverse Words in a String
先前后两个指针移动去掉多余的space，然后用一个新的pointer等于后指针，从后往前扫描，遇到char就一直走，直到遇到空格或者等于前指针，然后把从pointer到后指针的substring加入到ans，把后指针移动到pointer，继续判断现在是不是空格，是的话继续移动后指针直到遇到char。  
时间复杂度：O(N)  
空间复杂度：O(1)

## 6. Reverse Words in a String II
非常巧妙的解法，先把整个array reverse一遍，这样就得到了reverse的array只是每个单词都反了，现在我们只要把每个单词再reverse就变回正确的顺序的  
时间复杂度：O(N)  
空间复杂度：O(1)

## 7. Valid Parentheses
直接用stack来做，遇到 ( { [ 这三个char的时候push到stack，遇到 ] } ） 这三个char的时候pop，然后检查是不是一对pair，注意pop的时候stack不能为空，最后return的时候stack也要是空的  
时间复杂度：O(N)  
空间复杂度：O(1)

## 8. Longest Palindromic Substring
两种解法：
1. 从一个char往两边extend，找到最长的可能，这里要从odd跟even分别extend然后取较长的那个，然后跟最后的结果再比较。  
时间复杂度：O(N^2)  
空间复杂度：O(1)

1. DP，一个二维数组记录了从j到i是不是palindrome，那么当我们判断i+1的时候，只要看j-1是不是等于i+1跟j~i是不是palindrome就行了。  
时间复杂度：O(N^2)  
空间复杂度：O(N^2)

3. Manacher's Algorithm. 马拉车算法，传闻狗家面试这题的时候需要你写的是这个算法。

## 9. Group Anagrams
这题两种解法
1. 用hashmap来做，key是sort后的string，value就是list，先把一个string变成char array，然后sort，再变成string，再加入hashmap。  
时间复杂度：O(NKlogK)  
空间复杂度：O(NK)

2. 用int[26]来做，即count freq，count完后用得到的freq组成一个特别的string，然后用hashmap来做  
时间复杂度：O(NK)  
空间复杂度：O(NK)
 
## 10. Trapping Rain Water
这题的思路是怎么算当前idx能存多少水，一个idx能存多少水取决于它左右boundary的高度，取低的那个。  
那么我们双指针遍历，同时记录左右挡板的高度，当左边低的时候，我们计算左pointer的积水再移动pointer，即ans + LBarHeight-height[left++],同时更新左挡板的height，反之右边也是如此操作  
时间复杂度：O(N)  
空间复杂度：O(1)

## 11. Set Matrix Zeroes
这题有个重要的idea就是如果当前row/col里面有一个0那么整个就要变成0，又因为要用m+n的space，所以要用两个set去记录cell为0的row跟col，第二次双重循环的时候如果当前row或者col有在set里面就改成0。即如果当前row或者col里面有一个0，cell就变成0.  
这题还有个O(1)space的解法。没太理解。
时间复杂度：O(N)  
空间复杂度：O(1)

## 12. Rotate Image
图形旋转，个人感觉这类题一般是变化两次，这题首先是上下兑换，第一行跟最后一行，第二行跟倒数第二行，然后再对角换,i=j不换，(i,j)跟(j,i)换  
也可以先对角换再左右换  
时间复杂度：O(N^2)  
空间复杂度：O(1)

## 13. Spiral Matrix
个人感觉这题蛮难的，要思路清晰，这题需要顺时针螺旋输出res，所以首先要有个设置方向，先左再下再右再上，只有当遇到边界或者已经处理过的cell时候我们才要变向，所以需要一个二维数组去记录遇没遇到.  
时间复杂度：O(N^2)  
空间复杂度：O(N^2)

# Linked Lists
## 14. Reverse Linked List
两个node一个cur从头开始，一个next，先记录cur.next再把cur.next指向next,再把next更新成cur，再把cur移动到记录的node。  
时间复杂度：O(N)  
空间复杂度：O(1)

## 15. Linked List Cycle 
用快慢指针来做，快的每次走两个，慢的走一个，如果快的先变成null了就说明没有cycle，如果快慢指针相等了就说明有cycle，即慢指针被套圈了.  
这题有个延伸题即找那个cycle的entry point。lt142。两种做法:  
1. 简单的是set去记录遇到的node，遇到重复的就return了，那个就是入口.
1. 双指针先找到两个指针的交叉点，再双指针一个从head一个从交汇点，遇到了就是entry point.
时间复杂度：O(N)  
空间复杂度：O(1)

## 16. Add Two Number
这题用一个int即记录carryone，然后就是移动两个指针，值相加+carryone，大于等于10就carryone是1不然就是0，然后注意两个指针中有一个可能会边为null，那么就是val=0，最后结束了看下carryone是不是1，是1再建个node加进去(899+120=1019这类的).  
时间复杂度：O(N)  
空间复杂度：O(1)

## 17. Add Two Number II
这题现在是高位再前低位再后，那么我们reverse之后就是变成上一题了，算完再reverse一下就好。  
FollowUp说不让reverse，那么我们就要用stack来做了，先进后出，全部push到两个stack，然后再pop就好了，注意empty的时候
时间复杂度：O(N)  
空间复杂度：Reverse O(1), Stack O(N)

## 18. Merge Two Sorted Lists
两指针，比较值，只移动小的那个，直到其中一个为空，然后把另一个剩下的接在后面。Recursion或者Iteration都行。  
时间复杂度：O(M + N)  
空间复杂度：Recursion: O(M+N) / Iteration: O(1)

## 19. Merge K Sorted List
两种解法：
1. PriorityQueue，里面放每个list的head，然后循环pq,每次pop 最小的list head，拿到值加入linkedlist，然后把head.next 不为空，塞回pq.  
1. Divide and Conquer, merge sort的思路，拆分input list先，然后再两两merge起来。注意start跟end idx不能越界。  
PQ时间复杂度：O(NlogK)  
PQ空间复杂度：Recursion: O(N) for a new linkedlist, O(k) for PQ  
D&C时间复杂度：O(Nlogk)  
D&C空间复杂度：O(1)不考虑recursion那块消耗的stack

## 20. Intersection of Two Linked Lists
两种解法：
1. HashSet,先把a的node存到set，然后loop b的node，遇到存过的就是intersection point
2. Two pointer，面试肯定是需要写这个的，因为set太简单了。这个解法需要知道两个linkedlist的长度，因为intersection之后长度肯定一样了，计算完长度后就loop，每次移动长的那个，往后移一个，长度-1，如果长度一样了，那么可能是intersection也可能不是，所以要有个判断，是的话就return了，不是的话就同时往后移动，长度-1  
时间复杂度：O(N+M)  
空间复杂度：O(1) / set O(M)/O(N) 看存哪个

## 21. Copy List with Random Pointer
这题用一个hashmap取记录访问过的node，因为这个的random可能指向同一个node，先从head开始，建立一个对应的新node，然后再把next跟random的node也复制过来，如果这里的next跟random已经在hashmap里面了。那么直接返回建立好的node，如果没有就新建node，移动head指针到下一个，新建的node也移动到下一个。  
时间复杂度：O(N)  
空间复杂度：O(N)

# Trees and Graphs
## 22. Validate Binary Search Tree
这题recursion解法，需要记录lower&upper boundary，对于left child来说要(min，root.val)，right child来说要(root.val, max)，如果越界就是false了
时间复杂度：O(N)  
空间复杂度：O(N)

## 23. Binary Tree Inorder Traversal
Recursion，先左再加值再右，Iteration，Stack，先push所有left的node，然后pop出来加值再把node指向右边
时间复杂度：O(N)  
空间复杂度：O(N)

## 24. Binary Tree Level Order Traversal
Recursion: 需要个level来跟踪到哪层了，来获得对应的list
Iteration: 需要Queue来储存每层的node，然后一个level去取对应的level list
时间复杂度：O(N)  
空间复杂度：O(N)

## 25. Binary Tree Zigzag Level Order Traversal
跟24题一样，只是需要多一个0，1的值取判断当前是从前还是从后插入到list
时间复杂度：O(N)  
空间复杂度：O(N)

## 26. Populating Next Right Pointers in Each Node
这题因为是perfect tree，所以当左子树为空那么右子树也为空，所以当左子树的时候把左子树的next指到右子树，然后如果root.next不为空，那么右子树的next就是root.next的的左子树。
时间复杂度：O(N)  
空间复杂度：O(N)

## 27. Populating Next Right Pointers in Each Node II
Level Order Traversal:  
逐层遍历，每个node.next就是queue的peek，注意这里要根据size判断下是不是到每层的最后了，因为我们一直在往queue里面加node，所以不判断的话可能把next指向了下一层的第一个node  
Recursion:  
两个global node: prev, leftmost  
prev: 表示的是下一层的当前的node在哪，我们需要在处理children的时候就是用prev来链接他们，从左到右的
leftmost：表示的是每层的最左边的node
过程：首先把leftmost设置成root，开始遍历leftmost，cur指向当前层的leftmost，开始用cur遍历当前层，遍历开始的之前，我们首先要把leftmost变成null，prev也要设成null，为下一层做准备，当左右子树不为空时候，我们要先看leftmost是不是为null，是的话表示这个child是下一层的leftmost，设置好，不是的话就把prev.next指向这个child，即把child加到下一层的list里面，最后移动prev指针到当前child上，为后一个child做准备  
比起直观的逐层遍历，这个更提现水平  
时间复杂度：O(N)  
空间复杂度：O(1)

## 28. Lowest Common Ancestor of a Binary Search Tree
利用BST的性质，如果当前root的值大于p，q的值，那么向左，反之root的值小于p，q的值，那么向右  
时间复杂度：O(N)  
空间复杂度：O(1)

## 29. Lowest Common Ancestor of a Binary Tree
利用BFS取找p跟q在左还是右subtree，如果在左边就继续recursion左边，再右边就recursion右边，在两边就return root  
时间复杂度：O(N^2)  
空间复杂度：O(N)

简化些：直接recursion，如果当前root是null或者root == p 或者 root == q了那么直接return root。然后看左子树的recursion跟右子树的返回值，如果左子树的为空那就是在右子树，如果右子树的为空那么就是左子树  
时间复杂度：O(N)  
空间复杂度：O(N)

## 30. Construct Binary Tree from Preorder and Inorder Traversal
用recursion来做，但是首先用个hashmap记录每个值对应的idx，因为对应idx的左边就是左子树，右边就是右子树，然后用个preorder的idx去走整个preorder的array，rootval就是preorder[preidx],然后根据val拿到从hashmap中拿到inorder对应的idx，然后左子树就是left~idx，右子树就是idx+1~right  
时间复杂度：O(N)  
空间复杂度：O(N)

## 31. Number of Islands
DFS,用个二维数组取记录visited，然后遍历数组，每次遇到没有访问过的1的时候就做一次四个方向的DFS，找到当前的岛屿，累计res  
时间复杂度：O(N^2)  
空间复杂度：O(N^2)

## 32. Clone Graph
用个hashmap记录已经访问过的node，然后每个新的node都是先建node跟neighbor list，然后加到hashmap里面，然后遍历老的neighbors加到新的list里面，这里要注意，老的加到新的也要用到clone  
时间复杂度：O(N)
空间复杂度：O(N)

# Backtracking
## 33. Letter Combinations of a Phone number
用hashmap来建立phone number对应的chars，然后backtracking method要两个变量，一个是当前的str，一个是digits的str，开始的时候当前str是空，digits是input  
recursion的时候终止情况就是digits为空，把当前str加到ans里面，不为空的时候，我们就继续拿出第一个char，然后hashmap里找到对应的string，遍历string，把组合的新的str跟剩下的digits传进去  
时间复杂度：取决于input，O(3^N\*4^M)
空间复杂度：O(3^N\*4^M)

## 34. Word Search II
1. 普通解法就是backtracking，用二维数组去记录访问过的char避免重复计算，当找到了就break loop，不然可能有重复的虽然用到的不一样，这题不要这些重复的。典型的backtracking。  
这个解法速度比较慢，但是还是pass了
1. Backtracking with Trie. 先用words去构建trie tree，然后再去看board里面能dfs到几个trie tree的word。感觉有点奇怪的解法


## 35. Wildcard Matching
难题，把backtracking解法，用两个pointer分别对应s跟p，然后stmp用来记录先前spointer遇到star的位置，startIdx用来记录*开始cover的位置。  
1. p的char是个?或者p跟s的char一样，同时移动p跟s的pointer
1. 如果p是*，那么我们用startIdx去记录这个*的位置,这个位置是我们可能会用到的backtracking的位置，然后移动p到下一位，同时用stmp记录s指针的位置
1. 如果没有match的情况，先看startIdx有没有记录过，没有就是false了，有的话我们backtrack，把ppointer变回start+1，然后移动stmp到下一位，把spointer指到stmp的地方，这里表示one more char in s are covered by the start
1. 最后s走完了看p还剩不剩下，剩下的话要全部是*才行

## 36. Regular Expression Matching
#还没做

# Sorting and Searching
## 37. Remove Duplicates from Sorted Array
两个指针，一个快一个慢，快指针每次移动一格，慢指针只有当快指针跟它值不一样的时候才会先替换再移动。  
时间复杂度：O(N)  
空间复杂度：O(1)

## 38. Merge Sorted Array
三个指针，p1 = m - 1，p2 = n - 1，p = m + n - 1,循环p1跟p2，如果p1的小那么p2的数值放到p的位置，p2--，反之p1--，最后看下p2是不是全部走完了，如果没有的话，就把剩下的值从前往后放入nums1  
时间复杂度：O(N+M)    
空间复杂度：O(1)

## 39. Sort Colors
三个指针，一个前start一个后end一个cur用来遍历，当cur遇到0的时候，把cur跟front的值替换，然后移动front跟cur，如果遇到2就把end跟cur替换，然后end跟cur移动，如果遇到1就只移动cur,循环终结为cur <= end  
时间复杂度: O(N)  
空间复杂度: O(1)

## 40. Find Minimum in Rotated Sorted Array
做binary search，如果mid比start大，那么start = mid + 1,不然就是end = mid  
时间复杂度: O(logN)  
空间复杂度: O(1)

## 41. Find Minimum in Rotated Sorted Array
做binary search，如果mid比end大，那么start = mid + 1，如果mid 比 end小，那么end = mid，如果一样就end--,因为有dup的情况，所以要考虑  
时间复杂度: Average: O(logN) Worst: O(N)  
空间复杂度: O(1)

## 42. Search In Rotated Sorted Array
Binary Search，如果mid>=start,那么如果target小于mid并大于start，那么end = mid - 1，反之start = mid + 1。 如果mid < start,如果mid < target并且end >= mid, 那么start = mid + 1,不然end = mid - 1.  如果while loop结束了没return就是没找到返回-1。  
时间复杂度：O(N)  
空间复杂度：O(1)

## 43. Search a 2d Matrix  
做binary search，把target跟mid做比较，如果target小于mid，那么end = mid - 1，如果target大于mid又小于mid那行的最后一个val，那么就在这里面找，不然就是start = mid + 1。while结束还没return就false。  
时间复杂度：O(N*logM)  
空间复杂度：O(1)

## 44. Search a 2d Matrix II
做binary search，但是跟上题不同，我们是在当前row去做binary search，而不是对第一个column做binary search，如果target小于当前row的end，大于start，那么我们就在这行里面做bs去找target，找到返回，找不到就继续下一行.最后都没找到就false。  
时间复杂度：O(M*logN)  
空间复杂度：O(1)

## 45. Median of Two Sorted Array
这题还没做，但是大致是用多个数字记录当前两个array分别用了多少个element，通过移动使用的element来找到median

# Dynamic Programming
## 46. Best Time To But and Sell Stock
用一个数组存当前之前的最小价格，然后跟今天比较计算收益，同时更新ans跟当前的最小价格。  
时间复杂度：O(N)  
空间复杂度：O(N)


## 47. Maximum Subarray
用一个数组存当前之前的最大的sum。如果sum大于0，就跟当前的相加，不然就取自己，更新数组跟ans，继续往后。  
可以降到O(1)space
时间复杂度：O(N)  
空间复杂度：O(N)


## 48. Longest Increasing Subsequence
用一个数组存到当前为止的最大subsequence length，对于i+1来说，他要往前找所以比他小的数，看最大的能构成的len是多少。  
时间复杂度：O(N^2)  
空间复杂度：O(N)

# Design
## 49. Serialize and Deserialize BST
## 50. Serialize and Deserialize BST
这题用postorder跟stack做，也可以用preorder跟queue来做，用特殊符号来隔开每个node跟表示null

## 51. Implement Trie
Trie Tree核心是每个node有个children array，然后数量是26对应char，有个boolean value表示当前结尾是不是一个word

## 52. LRU Cache
用double linkedlist来做，每次做了get都要去做remove跟movenodetohead的操作，每次做了put都要去检查是不是存在了key是的话，更新val，然后做remove跟movetohead的操作，不存在的话就放进去然后movetohead，size超了的话再把tail删掉。  
remove要注意当前node的前面是不是null，不是的话就把prev.next = cur.next,是的话head就是node.next,然后再看cur.next是不是null，不是的话就next.prev = cur.prev,是的话就是tail=cur.prev  
movetoHead先把node.next设成head，然后prev=null,然后看head是不是null，不是的话 head.prev = node,然后head = node,然后再看tail是不是null，是的话就是tail = node

# Others
## 53. Single Number
用Xor来做，两个相同的number做xor会变成0，然后最后只剩下单个的  
时间复杂度：O(N)  
空间复杂度：O(1)

## 54. Roman to Integer
这题用hashmap当dictionary，然后每次都看下后面的char，是不是比前面的大，是的话就是两个一起处理做减法，不是的话就是单个处理，累计到sum里面  
时间复杂度：O(N)  
空间复杂度：O(N)

## 55. Excel Sheet Column Number
一个char一个char处理，char - 'A' + 1是当前val，然后之前的sum*26+curVal
时间复杂度：O(N)  
空间复杂度：O(1)

## 56. Find the celebrity
两种解法
1. 用数组记录当前这个人被多少认识跟认识多少人，做完整个loop再找那个celebrity.  
时间复杂度：O(N^2)  
空间复杂度：O(N)

2. 用Stack来做，把所有人都push到stack里面， 然后每次pop两个人直到最后stack只剩下一个，如果p1认识p2,就把p2push回stack，如果p1不认识p2，就把p1push回stack。潜在的celebrity是要不认识任何人，别人都认识他的。 最后stack剩下的那个人，检查下，是不是所有人都认识这个人，这个人不认识任何一个人.  
时间复杂度：O(N)  
空间复杂度：O(N)


## 57. Integer to English Words
这题从后往前，我们需要个idx去跟踪我们现在处理的是个位，千位，还是...，每次处理3位数，如果当前数小于20就去20里面找，如果是20~99，十位数就去tens找，再处理个位数，然后是百位的，就先append hundred再处理两位数

## 58. The Skyline Problem
swap line algorithm...扫描线算法...


