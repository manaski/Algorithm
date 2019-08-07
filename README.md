# 编程题目练习总结

[TOC]



## 第一章. 数组和队列

### 1. 求滑动窗口中对应的最大值

采用双端队列，在滑动过程中保存最大值和候选最大值，当最大值已经超出窗口范围时，从队列头部出队，当新遍历的值比当前值大时，从队尾进行更新

这个方法还可以用在别的问题中，如求滑动窗口的最大值和最小值之差的最大值，用两个双端队列分别记录每个窗口的最大值和最小值

```java
public int[] getMax(int[] nums, int w){
    if(nums==null||w<1||nums.length<w){
        return null;
    }
    int index=0;   //记录结果集合中的下标
    int[] res=new int[nums.length-w+1];
    //双端队列，队列头部表示当前最大值
    //从尾部进入的元素有可能作为下一个头部元素，因此进行比较
    Deque<Integer> deque=new LinkedList<>();
    for(int i=0;i<nums.length;i++){
        while(!deque.isEmpty()&&nums[deque.peekLast()]<=nums[i]){
            deque.pollLast();
        }
        deque.addLast(i);
        //如果此时的头部元素已经过期，应该弹出去，由下一个候补元素做头元素
        if(deque.peekFirst()==i-w){
            deque.pollFirst();
        }
        //当遍历到出现窗口时进行结果记录
        if(i>=w-1){
            res[index++]=nums[deque.peekFirst()];
        }
    }
    return res;
}
```

### 2. 求01矩阵中1组成的矩形的最大值

这个问题是求直方图中最大矩形的变形，要先用一个二维矩阵记录每层的对应位置1的高度，然后对每一层进行矩形求解，得到最大值，时间复杂度和空间复杂度都是O(NxM)

```java
public static int getMaxArea(int[][] arr){
    int height=arr.length;
    int length=arr[0].length;
    int[][] lens=new int[height][length];//记录每行每个位置的1的高度
    for(int i=0;i<height;i++){
        for(int j=0;j<length;j++){
            int h=i;
            while(h>=0&&arr[h--][j]==1){
                lens[i][j]++;
            }
        }
    }
    int area=0;
    int maxA=0;
    Stack<Integer> stack=new Stack<>();
    for(int i=0;i<height;i++){
        for(int j=0;j<length;j++){
            if(stack.isEmpty()||lens[i][stack.peek()]<=lens[i][j]){
                stack.push(j);
            }else{
                while(!stack.isEmpty()&&lens[i][stack.peek()]>lens[i][j]){
                    int index=stack.pop();
                    if(stack.isEmpty()){
                        area=lens[i][index]*(j-0);   //如果栈空，表示一直可以计算到开头
                    }else{
                        area=lens[i][index]*(j-stack.peek());//用栈记录下标，维护递增高度
                    }
                    maxA=Math.max(maxA,area);
                }
                stack.push(j);//只有<=的才被压入
            }
        }
        while(!stack.isEmpty()){//栈中还有数据未计算
            int index=stack.pop();     //计算过的位置弹出去
            if(stack.isEmpty()){
                area=lens[i][index]*(length-0); 
            }else{
                area=lens[i][index]*(length-stack.peek());
            }
            maxA=Math.max(maxA,area);
        }
    }
    return maxA;
}
```

### 3. 大顶堆的生成

一般用数组的大顶堆生成是比较简单的，采用递归的方法来生成，采用下沉的方式不断插入新节点，可以实现时间复杂度O(n)，如果是上浮操作，复杂度为O(nlogn)

基于节点的大顶堆生成，需要借助一些外部存储空间记录每个节点之间的关系

方法是：在节点数组中，用哈希表记录每个节点左边和右边第一个大于自己的节点，这两个节点中值较小的选为父节点

```java
public static Node getMaxTree(int[] arr) {
   Node[] nArr = new Node[arr.length];
   for (int i = 0; i != arr.length; i++) {
      nArr[i] = new Node(arr[i]);
   }
   Stack<Node> stack = new Stack<Node>();
   HashMap<Node, Node> lBigMap = new HashMap<Node, Node>();
   HashMap<Node, Node> rBigMap = new HashMap<Node, Node>();
   for (int i = 0; i != nArr.length; i++) {
      Node curNode = nArr[i];
      while ((!stack.isEmpty()) && stack.peek().value < curNode.value) {
         popStackSetMap(stack, lBigMap);
      }
      stack.push(curNode);
   }
   while (!stack.isEmpty()) {
      popStackSetMap(stack, lBigMap);
   }
   for (int i = nArr.length - 1; i != -1; i--) {
      Node curNode = nArr[i];
      while ((!stack.isEmpty()) && stack.peek().value < curNode.value) {
         popStackSetMap(stack, rBigMap);
      }
      stack.push(curNode);
   }
   while (!stack.isEmpty()) {
      popStackSetMap(stack, rBigMap);
   }
   Node head = null;
   for (int i = 0; i != nArr.length; i++) {
      Node curNode = nArr[i];
      Node left = lBigMap.get(curNode);
      Node right = rBigMap.get(curNode);
      if (left == null && right == null) {
         head = curNode;
      } else if (left == null) {
         if (right.left == null) {
            right.left = curNode;
         } else {
            right.right = curNode;
         }
      } else if (right == null) {
         if (left.left == null) {
            left.left = curNode;
         } else {
            left.right = curNode;
         }
      } else {
         Node parent = left.value < right.value ? left : right;
         if (parent.left == null) {
            parent.left = curNode;
         } else {
            parent.right = curNode;
         }
      }
   }
   return head;
}

public static void popStackSetMap(Stack<Node> stack, HashMap<Node, Node> map) {
   Node popNode = stack.pop();
   if (stack.isEmpty()) {
      map.put(popNode, null);
   } else {
      map.put(popNode, stack.peek());//记录每个节点左边界和右边界
   }
}
```



## 第二章. 链表问题

### 1. 打印两个有序链表有序链表公共部分

这个比较简单，把相等的节点的值打印出来即可

```java
public class CommonPart {
    public void getCommonPart(Node node1,Node node2){
        if(node1==null||node2==null){
            return;
        }
        Node p1=node1;
        Node p2=node2;

        while(p1!=null&&p2!=null){
            if(p1.value>p2.value){
                p2=p2.next;
            }else if(p1.value<p2.value){
                p1=p1.next;
            }
            else {
                System.out.println(p1.value);      //相等则打印
                p1=p1.next;
                p2=p2.next;
            }
        }

    }
}
```

### 2. 删除倒数第K个节点

**方法1：** 长度为N的链表，删除倒数第K个节点，则需要得到倒数第K个节点前面那个节点即第N-K个节点，用一个计数器初始设为K，遍历一遍链表，每经过一个节点减一，则遍历完成是为K-N。所以再从头开始遍历，计数器加1，计数器变成0时，则找到了要删除节点前一个节点。

**方法2：** 用两个指针先后出发，中间间隔K步，找到要删除的节点

```java
//两次循环
public static Node removek(Node head,int k){
    Node cur=head;
    //K-N
    while(cur!=null){
        k--;
        cur=cur.next;
    }
    if(k==0){
        head=head.next;
    }
    //N-K
    if(k<0){
        cur=head;
        while(++k!=0){
            cur=cur.next;
        }
        cur.next=cur.next.next;
    }
    return head;
}
```

```java
public static Node deleteK(Node head,int k){
    if(head==null||k<=0){
        return head;
    }
    k=k+1;
    Node help=new Node(-1);
    Node fast=help;
    Node slow=help;
    help.next=head;
    //最后是在null处停下，所以k要多加一个
    while(fast!=null){
        fast=fast.next;
        k--;
        if(k<0){
          slow=slow.next;
        }
    }

   if(k==0){
        help.next=head.next;
    }else if(k<0){
        slow.next=slow.next.next;
    }
    return help.next;
}
```

### 3. 翻转单向链表的方法

```java
public static Node reverse(Node head){
    if(head==null||head.next==null){
        return head;
    }
    //三个指针完成链表的翻转
    Node pre=null;
    Node cur=head;
    Node next=null;
    while(cur!=null){
        next=cur.next;
        cur.next=pre;
        pre=cur;
        cur=next;
    }
    return pre;
}
```

### 4. 翻转链表的指定的一部分

```java
//对上面的程序，稍微改进，添加一个tail节点作为结尾判断，而不是null
public static Node reverse(Node head,Node tail){
    if(head==null||head.next==null){
        return head;
    }
    //三个指针完成链表的翻转
    Node pre=null;
    Node cur=head;
    Node next=cur.next;
    while(cur!=tail){
        cur.next=pre;
        pre=cur;
        cur=next;
        if(next!=null){
            next=next.next;
        }
    }
    return pre;
}
```

```java
public static Node reversPart(Node head,int from, int to){
    if(head==null||from>=to){
        return head;
    }
    int index=1;
    Node p=head;
    Node pre=new Node(-1);
    Node pHead=pre;
    pre.next=head;
    Node tail=null;
    while(p!=null){
        if(index==from-1){
            pre=p;       //记录翻转部分的前一个节点
        }
        if(index==to){
           tail=p.next;  //记录翻转部分的后一个节点
           break;
        }
        p=p.next;
        index++;
    }
    if(p==null){
        return head;     //如果长度不满足，则直接返回
    }
    Node header=pre.next;
    Node r=reverse(header, tail);//翻转链表
    pre.next=r;
    header.next=tail;
    return pHead.next;
}
```

### 5. 环形单向链表的约瑟夫问题

这个问题，主要是要找到新旧坐标之间的递推关系，简化问题复杂度。

直接按照游戏规则进行还原，时间复杂度是o(NxM)，用递推关系则能简化为o(N).

如果没有删除，则编号之间对应的关系为
$$
B=(A-1)\%i+1\\
old=(new+s-1)\%i+1
$$
从而有
$$
old=(new+m-1)\%i+1
$$
从而可以通过递归方法实现

```java
public static Node getSurvivor(Node head,int m){
    int len=1;
    Node last=head;
    while(last.next!=head){
        len++;
        last=last.next;
    }
    int index=getSurvive(len,m);//获得幸存者，也就是最后一次要kill的人
    while(--index>0){
        head=head.next;
    }
    head.next=head;
    return head;
}
public static int getSurvive(int n,int m){
    if(n==1){
        return 1;
    }
    return (getSurvive(n-1,m)+m-1)%n+1;         //递推方法
}
```

### 6. 判断一个链表是否为回文结构

**方法1：** 用栈记录链表的每个节点，然后遍历链表，看栈中逆序记录是否和链表顺序记录对应

**方法2：** 不用额外的空间，采用快慢指针找到链表的中间节点，然后将右边链表翻转，然后遍历判断头尾对应位置的节点是否相等，最后恢复结构

```java
public static boolean isPalindrom(Node head){
    if(head==null||head.next==null){
        return true;
    }
    Node left=head;
    Node right=head;
    while(right.next!=null&&right.next.next!=null){   //找到中间节点
        left=left.next;
        right=right.next.next;
    }
    //用三个指针翻转链表
    Node cur=left.next;  
    left.next=null;
    Node pre=null;
    Node forward=null;
    while(cur!=null){
        forward=cur.next;
        cur.next=pre;
        pre=cur;
        cur=forward;
    }
    forward=pre;//记录节点
    Node h=head;
    boolean isP=true;
    while(pre!=null&&h!=null){
        if(pre.value!=h.value){
            isP=false;
            break;
        }
        pre=pre.next;
        h=h.next;
    }
    //恢复链表
    cur=forward;
    pre=null;
    forward=null;
    while(cur!=null){
        forward=cur.next;
        cur.next=pre;
        pre=cur;
        cur=forward;
    }
    left.next=pre;
    return isP==true;
}
```

### 7. 将单向链表划分成左边小，中间相等，右边大的形式

用三个分链表来记录属于不同分区的节点，同时还能保存原来的相对顺序，最后再合并起来就可以

```java
public static Node listPartition(Node head,int k){
    Node less=new Node(-1);
    Node great=new Node(-1);
    Node equal=new Node(-1);
    Node l=less;
    Node g=great;
    Node e=equal;
    while(head!=null){
        if(head.value>k){
            g.next=head;
            g=g.next;
        }else if(head.value<k){
            l.next=head;
            l=l.next;
        }else {
            e.next=head;
            e=e.next;
        }
        head=head.next;
    }
    l.next=null;
    e.next=null;
    g.next=null;
    //注意顺序，从后往前连接
    e.next=great.next;
    l.next=equal.next;
    return less.next;
}
```

### 8. 复制含有随机指针的链表

**方法1：** 采用哈希表记录对应的节点和关系

**方法2：** 用合并拆分的方法保存相对关系

```java
public static Noder copyList(Noder head){
     Map<Noder,Noder> map=new HashMap<>();
     Noder p=head;
     while(p!=null){
        map.put(p,new Noder(p.value));
        p=p.next;
     }
     p=head;
     while(p!=null){
         Noder node=map.get(p);
         if(p.next!=null)
         node.next=map.get(p.next);//创建关系
         if(p.rand!=null)
         node.rand=map.get(p.rand);
     }
     return map.get(head);
}
public static Noder copyList2(Noder head){
    if(head==null){
        return null;
    }
    Noder p=head;
    while(p!=null){
        Noder node=new Noder(p.value);//生成新节点插入到原节点后面
        node.next=p.next;
        p.next=node;
        p=node.next;
    }
    p=head;
    while(p!=null){
        if(p.rand!=null){
            p.next.rand=p.rand.next;//随机指针关系
        }
        p=p.next.next;
    }
    //拆分链表
    p=head;
    Noder nHead=p.next;
    Noder q=p.next;
    while(p!=null){
        p.next=q.next;
        p=p.next;
        if(p!=null){
            q.next=p.next;
            q=q.next;
        }
    }
    return nHead;
}
```

### 9. 两个链表生成相加链表

**方法1：**  用栈记录两个链表，然后从末尾开始对应位相加

**方法2：**  把对应数字生成出来，相加后再生成对应链表，可能会溢出

**方法3：**  借用逆序的方法，把两个链表先逆序，然后对应位相加，时间复杂度O(N)，空间复杂度O(1)

```java
public static Node getSum(Node node1,Node node2){
    Node p1=ReverseList.reverse(node1);
    Node p2=ReverseList.reverse(node2);
    Node tail1=p1,tail2=p2;
    Node head=new Node(-1);
    Node h=head;
    int carry=0;
    int quot=0;
    while(p1!=null||p2!=null){
        if(p1!=null&&p2!=null){
            quot=(p1.value+p2.value+carry)%10;
            carry=(p1.value+p2.value+carry)/10;
            p1=p1.next;
            p2=p2.next;
        }else if(p1!=null){
            quot=(p1.value+carry)%10;
            carry=(p1.value+carry)/10;
            p1=p1.next;
        }else {
            quot=(p2.value+carry)%10;
            carry=(p2.value+carry)/10;
            p2=p2.next;
        }
        head.next=new Node(quot);
        head=head.next;

    }
    if(carry>0){
        head.next=new Node(carry);
        head=head.next;
    }
    Node res=ReverseList.reverse(h.next);
    return res;
}
```

### 10. 两个链表相交的各种问题

两个链表可能相交也可能不想交，整个过程分为

- 判断是否有环，并得到进入环的节点。采用快慢指针的方法

- 如果没有环，那么怎么判断相交。如果相交，那么存在公共的后半部分，因此，先让两个环后面部分长度相同，然后一起移动，判断是否有相同节点，没有则不想交

- 如果有环，分为两种情况

  * 如果入环的节点相同，说明相交点在环外

  * 如果入环节点不同，判断是否同一个环，如果是同一个环，则相交，返回任意一个入环节点都可

```java
//判断是否是带有环的链表，并返回第一个入环的节点
public static Node getLoopNode(Node head){
    if(head==null||head.next==null||head.next.next==null){
        return null;
    }
    Node slow=head.next;
    Node fast=head.next.next;
    while(slow!=fast){
        if(fast.next==null||fast.next.next==null){
            return null;
        }
        slow=slow.next;
        fast=fast.next.next;
    }
    fast=head;
    while(fast!=slow){
        slow=slow.next;
        fast=fast.next;
    }
    return slow;
}
```

```java
//先遍历一遍，获得两个长度，然后长的先走一段，然后同步走，如果中间有相同节点退出，如果走到尾退出
public static Node getCross(Node node1,Node node2,Node end){
    int len1=0,len2=0;
    Node p1=node1;
    Node p2=node2;
    while(p1!=end){
        len1++;
        p1=p1.next;
    }
    while(p2!=end){
        len2++;
        p2=p2.next;
    }
    int len=0;
    p1=node1;
    p2=node2;
    if(len1>len2){
        len=len1-len2;
        while(len-->0){
            p1=p1.next;
        }
    }else if(len1<len2){
        len=len2-len1;
        while(len-->0){
            p2=p2.next;
        }
    }
    while(p1!=end&&p2!=end&&p1!=p2){
        p1=p1.next;
        p2=p2.next;
    }
    return p1;
}
```

```java
public static Node getCrossNode(Node node1,Node node2){
    //先判断带有环，并且返回入环的点
    Node loop1=LoopList.getLoopNode(node1);
    Node loop2=LoopList.getLoopNode(node2);
   //如果都不含有环
    if(loop1==null){
        return CrossLists.getCross(node1,node2,null);
    }
    //如果含有环
    if(loop1==loop2){
        return CrossLists.getCross(node1,node2,loop1);
    }else{
        //判断是否相交
        Node p=loop1.next;
        while(p!=loop1){
            if(p==loop2){
                return loop2;
            }
            p=p.next;
        }
        return null;
    }
}
```

### 11. 每K个节点逆序

**方法1：** 用栈结构，每记录到K个节点，就逆序K个

**方法2：** 直接调整，类似翻转链表的方法

```java
public static Node reversek(Node head,int k){
    if(head==null){
        return null;
    }
    Stack<Node> stack=new Stack<>();
    int count=0;
    Node pre=null;     //记录每次翻转后的最后一个节点
    Node oldHead=head;//记录总的头部
    while(head!=null){
        stack.push(head);
        head=head.next;
        count++;
        if(count%k==0){
            Node p=stack.pop();
            Node newHead=p;     //翻转段的头部
            while(!stack.isEmpty()){
               p.next=stack.pop();
               p=p.next;
            }
            p.next=null;
          if(pre!=null){
              pre.next=newHead;
              pre=p;
          }else{
              oldHead=newHead;
              pre=p;
          }
        }
    }
    //没有翻转的部分接到后面
    if(stack.size()>0){
        while(stack.size()>1){
            stack.pop();
        }
        pre.next=stack.pop();
    }
    return oldHead;
}
```

```java
public static Node reverseK2(Node head,int k){
    if(head==null){
        return null;
    }
    Node end=null;      //记录结束位置
    Node h=head;
    Node start=head;    //记录逆序开始位置
    Node newHead=null;     
    int count=0;
    while(h!=null){
        count++;
        h=h.next;
        if(count%k==0){
            int n=0;
            Node pre=null;
            Node cur=start;
            Node next=cur.next;
            while(n<k){
                cur.next=pre;
                pre=cur;
                cur=next;
                if(next!=null){
                    next=next.next;
                }
                n++;
            }
            if(end==null){
                end=start;
                newHead=pre;//更新head
            }else{
                end.next=pre;
                end=start;
            }
            start=cur;
        }
    }
     if(start!=null){
            end.next=start;
        }
    return newHead;
}
```

### 12. 将搜索二叉树转为双向链表

可以采用递归的方法，关键是返回值需要返回头尾两个节点，所以为了简便，将尾节点指向头结点，只返回尾节点

```java
public TreeNode changeTree(TreeNode node){
    if(node==null){
        return null;
    }
    if(node.left==null&&node.right==null){
        node.right=node;
        return node;
    }
    TreeNode leftNode=changeTree(node.left);
    TreeNode rightNode=changeTree(node.right);
    if(leftNode!=null&&rightNode!=null){
        node.right=rightNode.right;
        rightNode.right.left=node;
        rightNode.right=leftNode.right;
        node.left=leftNode;
        leftNode.right=node;
        return rightNode;
    }else if(leftNode!=null){
        node.right=leftNode.right;
        leftNode.right=node;
        node.left=leftNode;
        return node;
    }else{
        node.right=rightNode.right;
        rightNode.right=node;
        node.left=rightNode;
        return rightNode;
    }
}
```

### 13. 删除重复节点

注意一个问题：相当于连接不重复的各个节点，所以连接时要把各个节点原来的指针清除，同样的，在翻转部分链表时，pre记录的上次最后一个链表的指针需要清零

```java
public static Node deleteRep(Node head){
    if(head==null){
        return head;
    }
    Set<Integer> set=new HashSet<>();
    set.add(head.value);
    Node h=head.next;
    Node pre=head;
    pre.next=null;
    while(h!=null){
        if(set.contains(h.value)){
            int v=h.value;
            while(h!=null&&h.value==v){
                h=h.next;
            }
        }else{
            set.add(h.value);
            pre.next=h;
            pre=h;
            h=h.next;
            pre.next=null;    //为了避免原来的链表的影响，把next指针消除
        }
    }
    return head;
}
```

## 第三章 二叉树

### 1. 二叉树的前序中序后序遍历方法，递归非递归和Morris方法

#### 递归遍历

很简单，时间复杂度为O(N)，空间复杂度为递归深度O(N)

```java
 //递归方法实现
    public void preOrderRecur(TreeNode root){
        if(root==null){
            return;
        }
        System.out.println(root.val);
        preOrderRecur(root.left);
        preOrderRecur(root.right);
    }
    public void inOrderRecur(TreeNode root){
        if(root==null){
            return;
        }
        inOrderRecur(root.left);
        System.out.println(root.val);
        inOrderRecur(root.right);
    }
    public void postOrderRecur(TreeNode root){
        if(root==null){
            return;
        }
        postOrderRecur(root.left);
        postOrderRecur(root.right);
        System.out.println(root.val);
    }
```

#### 非递归遍历

借助栈来保存节点信息，时间复杂度O(N)，空间复杂度O(N)，为栈空间所占用空间

- 先序遍历，用栈将每个节点的子节点按照右左的顺序压入，这样访问时总是从左往右弹出
- 中序遍历，用栈先将左边界的节点全压进去，当节点访问完之后进入右子节点

```java
//前序遍历
public void preOrderUnRecur(TreeNode root){
    if(root==null){
        return;
    }
    Stack<TreeNode> stack=new Stack<>();
    stack.push(root);
    while(!stack.isEmpty()){
        TreeNode node=stack.pop();
        System.out.println(node.val);
        if(node.right!=null){
            stack.push(node.right);//先压入右节点
        }
        if(node.left!=null){
            stack.push(node.left);
        }
    }
}
//中序遍历
public void inOrderUnRecur(TreeNode root){
    if(root==null){
        return;
    }
    Stack<TreeNode> stack=new Stack<>();
    while(stack!=null||root!=null){
        if(root!=null){
            stack.push(root);
            root=root.left;
        }else{
            root=stack.pop();
            System.out.println(root.val);
            root=root.right;
        }
    }
}
```

后序遍历稍微复杂一些，有两种实现方式

```java
//后序遍历
//方法1是用一个栈实现中右左的遍历，用另一个栈保存起来，再逆序输出
public void postOrderUnRecur1(TreeNode root){
    if(root==null){
        return;
    }
    Stack<TreeNode> stack=new Stack<>();
    Stack<TreeNode> stack1=new Stack<>();
    stack.push(root);
    while(!stack.isEmpty()){
        TreeNode node=stack.pop();
        stack1.push(node);
        if(node.left!=null){
            stack.push(node.left);
        }
        if(node.right!=null){
            stack.push(node.right);
        }
    }
    while(!stack1.isEmpty()){
        System.out.println(stack1.pop().val);
    }
}
//方法2 每次记录栈顶元素和上次访问元素
public void postOrderUnRecur2(TreeNode root){
    if(root==null){
        return;
    }
    Stack<TreeNode> stack=new Stack<>();
    stack.push(root);
    TreeNode c=null;   //记录栈顶元素，表示下一个要访问的对象
    while(!stack.isEmpty()){
        c=stack.peek();
        if(c.left!=null&&root!=c.left&&root!=c.right){  //如果左右子树都没访问过
            stack.push(c.left);
        }else if(c.right!=null&&root!=c.right){//如果左子树访问过，右子树没访问过
            stack.push(c.right);
        }else{
            System.out.println(stack.pop().val);  //如果子树都访问过了
            root=c;    //root表示上一次弹出并访问过的元素
        }
    }
}
```

#### Morris方法

通过调整当前节点左子树的最右节点的右指针，指向当前节点，从而获得从下往上的一个途径，便于在树形结构中遍历。

前序和中序的过程是类似的，只是打印的时机不同

前序是在第一次进入cur节点左子树进行指针调整的时候，在$cur=cur.left$之前打印cur的值，即首先访问了根节点，以后$cur=cur.left$也会首先打印cur节点

中序是在cur节点左子树全都调整完之后，根据$cur=cur.left$，此时cur实际上是最左边的节点，在$cur=cur.right$之前，会回到根节点，从根节点恢复左边指针后，会进入根节点的右节点，整个顺序是左根右

后序是在恢复指针的时候，此时是最后一次在cur节点停留，倒序打印以cur.left为头的右边界链，相当于斜着从左往右斜着打印所有节点，所以正好利用左子树最右节点这个位置。

```java
   //不需要借助栈结构完成中序遍历
    //时间复杂度O(N) 空间复杂度O(1)
public void morrisIn(TreeNode root){
        if(root==null){
            return ;
        }
         TreeNode cur1=root;
         TreeNode cur2=null;
         while(cur1!=null){
             cur2=cur1.left;    //进入左子树
             if(cur2!=null){
                 while(cur2.right!=null&&cur2.right!=cur1){
                     cur2=cur2.right;   //找到左子树最右边节点
                 }
                 if(cur2.right==null){//最右节点右指针为空
                     cur2.right=cur1;   //让右指针指向cur1
                     cur1=cur1.left;    //处理完cur1子树后，再往下到cur1的左子树重复上面过程
                     continue;
                 }else{                //如果不空闲，这次访问是利用了新指针回到了上层，恢复
                     cur2.right=null;
                 }
             }
             System.out.println(cur1.val);   //访问中间节点
             cur1=cur1.right;   //访问右节点，回到上层节点
         }
}
```

```java
//不需要借助栈结构完成先序遍历
public void morrisPre(TreeNode root){
    if(root==null){
        return ;
    }
    TreeNode cur1=root;
    TreeNode cur2=null;
    while(cur1!=null){
        cur2=cur1.left;    //进入左子树
        if(cur2!=null){
            while(cur2.right!=null&&cur2.right!=cur1){
                cur2=cur2.right;   //找到左子树最右边节点
            }
            if(cur2.right==null){//最右节点右指针为空
                cur2.right=cur1;   //让右指针指向cur1
                System.out.println(cur1.val);   //访问中间节点
                cur1=cur1.left;    //处理完cur1子树后，再往下到cur1的左子树重复上面过程
                continue;
            }else{                //如果不空闲，这次访问是利用了新指针回到了上层，恢复
                cur2.right=null;
            }
        }
        cur1=cur1.right;   //访问右节点，回到上层节点
    }
}
```

```java
public void postOrderUnRecur(TreeNode root){
    if(root==null){
        return ;
    }
    TreeNode cur1=root;
    TreeNode cur2=null;
    while(cur1!=null){
        cur2=cur1.left;
        if(cur2!=null){
            while(cur2.right!=null&&cur2.right!=cur1){
                cur2=cur2.right;
            }
            if(cur2.right==null){
                cur2.right=cur1;
                cur1=cur1.left;
                continue;
            }else{
                cur2.right=null;
                printEdge(cur1.left);//打印时机是指针调整的时候
            }
        }
        cur1=cur1.right;
    }
    printEdge(root);//最后还要再打印整棵树的右边界
}
//倒序打印右边界节点，使结果是左右中
public void printEdge(TreeNode node){
    TreeNode node1=reverseTree(node);
    TreeNode p=node1;
    while(p!=null){
        System.out.println(p.val);
        p=p.right;
    }
    reverseTree(node1);
}
//翻转链表
public TreeNode reverseTree(TreeNode node){
    TreeNode cur=node;
    TreeNode pre=null;
    TreeNode next=null;
    while(cur!=null){
        next=cur.right;
        cur.right=pre;
        pre=cur;
        cur=next;
    }
    return pre;
}
```

### 2. 打印二叉树边界节点

标准一

1. 头节点为边界节点。

2. 叶节点为边界节点。

3. 如果节点在其所在的层中是最左或最右的，那么也是边界节点。

标准二

1. 头节点为边界节点。

2. 叶节点为边界节点。

3. 树左边界延伸下去的路径为边界节点。

4. 树右边界延伸下去的路径为边界节点。

对于一

采用额外的存储空间来记录每一层的最左边和最右边的节点，相当于先序遍历时记录层数和当前层的左右节点数，由于先序遍历是根左右，所以每层最右边的节点在遍历过程中不断更新，再用先序遍历找到叶子节点。

对于二

先找到第一个左节点和右节点都不为空的节点，之前的节点都打印。

对左节点打印左延伸和叶子结点，对右节点，打印叶子节点和右延伸。需要一个标志变量来保证某个节点不被打印时，以其为头结点的子树都不会被打印，除非是叶子节点

```java
//先序遍历，正序打印
public static void printLeftEdge(Node h, boolean print) {
   if (h == null) {
      return;
   }
   if (print || (h.left == null && h.right == null)) {  //打印叶子节点或者边界节点
      System.out.print(h.value + " ");
   }
   printLeftEdge(h.left, print);
   printLeftEdge(h.right, print && h.left == null ? true : false);//非边界节点会置为false
}
//后序遍历，能形成一种倒序打印的效果
public static void printRightEdge(Node h, boolean print) {
   if (h == null) {
      return;
   }
   printRightEdge(h.left, print && h.right == null ? true : false);
   printRightEdge(h.right, print);
   if (print || (h.left == null && h.right == null)) {
      System.out.print(h.value + " ");
   }
}
```

 ==很多算法基于对二叉树的各种顺序的遍历，在遍历过程中进行一些操作，选择合适的时机进行一些输出。== 

### 3. 直观打印二叉树

把二叉树放倒打印，控制空格间距，并用一些符号来表示头结点关系，先打印右子树，再打印左子树，间隔与高度相关

```java
public void printTree(TreeNode root){
    printT(root,0,"H",17);
}
public void printT(TreeNode node, int height, String h,int len){
    if(node==null){
        return;
    }
    printT(node.right,height+1,"v",len);
    String val=h+node.val+h;
    int valLen=val.length();
    int sLen=(len-valLen)/2;
    int tlen=len-valLen-sLen;
    val=getSpace(sLen)+val+getSpace(tlen);
    System.out.println(getSpace(height*len)+val);
    printT(node.left,height+1,"^",len);
}
public String getSpace(int len){
    StringBuilder sb=new StringBuilder();
    while(len-->0){
        sb.append(" ");
    }
    return sb.toString();
}
```

###  4. 二叉树的序列化和反序列化

- 先序遍历的方法实现序列化和反序列化

序列化过程比较好做，反序列化时，按照中左右顺序来做，可以用一个结构把所有的字符串保存起来，左右之间自然地以#分割，所以可以用递归方法实现。

```java
public String serialize(TreeNode node){
    if(node==null){
        return "#";
    }
    String s=node.val+"!";
    s=s+serialize(node.left);
    s=s+serialize(node.right);
    return s;
}
public TreeNode deSerialize(String s){
    String[] ss=s.split("!");
    Queue<String> queue=new LinkedList<>();//用一个结构存起来
    for(int i=0;i<ss.length;i++){
        queue.offer(ss[i]);
    }
    TreeNode node=deSerial(queue);
    return node;
}
public TreeNode deSerial(Queue<String> queue){
    String s=queue.poll();
    if(s=="#"){
        return null;
    }
    TreeNode head=new TreeNode(Integer.valueOf(s));
    head.left=deSerial(queue);
    head.right=deSerial(queue);
    return head;
}
```

- 用层次遍历实现序列化和反序列化

层次遍历用到队列，保存上一层的数据。

```java
public String serialize1(TreeNode node){
    if(node==null){
        return "";
    }
    Queue<TreeNode> queue=new LinkedList<>();
    queue.offer(node);
    StringBuilder sb=new StringBuilder();
    sb.append(node.val+"!");
    while(!queue.isEmpty()){
        TreeNode h=queue.poll();
        if(h.left!=null){
            queue.offer(h.left);
            sb.append(h.left.val+"!");
        }else{
            sb.equals("#!");
        }
        if(h.right!=null){
            queue.offer(h.right);
            sb.append(h.right.val+"!");
        }else{
            sb.equals("#!");
        }
    }
    return sb.toString();
}
public TreeNode deSerialize1(String s){
    if(s==null||s.equals("")){
        return null;
    }
    String[] ss=s.split("!");
    Queue<TreeNode> queue=new LinkedList<>();
    TreeNode head=new TreeNode(Integer.valueOf(ss[0]));
    queue.offer(head);
    int index=1;
    while(!queue.isEmpty()){
        TreeNode node=queue.poll();
        if(!ss[index++].equals("#")){
            TreeNode node1=new TreeNode(Integer.valueOf(ss[index-1]));
            node.left=node1;
            queue.offer(node1);

        }
        if(!ss[index++].equals("#")){
            TreeNode node1=new TreeNode(Integer.valueOf(ss[index-1]));
            node.right=node1;
            queue.offer(node1);
        }
    }
    return head;
}
```

### 5. 累加和为指定值的最长路径

方法和求未排序数组中累加和为指定值的最长子数组的方法相同，这里用递归的前序遍历方法更合适，所以并不是递归不好。需要记录层数的时候，递归很有用。

```java
public int getMaxLengt(TreeNode node, int k){
    if(node==null){
        return 0;
    }
    Map<Integer,Integer> map=new HashMap<>();
    map.put(0,0);//这个初始设置很重要
    int len=0;
    int sum=0;
    int level=0;
    int res=preOrder(node,level+1,k,sum,len,map);
    return res;
}

public int preOrder(TreeNode node,int level,int k, int sum,int len,Map<Integer,Integer> map){
    if(node==null){
        return len;
    }
    int val=node.val;
    sum+=val;
    if(map.containsKey(sum-k)){
        int lev=map.get(sum-k);
        len= Math.max(len,level-lev);
    }
    if(!map.containsKey(sum)){
        map.put(sum,level);
    }
    int left=preOrder(node.left,level+1,k,sum,len,map);  //递归方法
    int right=preOrder(node.right,level+1,k,sum,len,map);
    return Math.max(left,right);
}
```

### 6. 求最大搜索二叉树结构

以节点node为头的树中，最大的搜索二叉子树只可能来自以下两种情况。

第一种：如果来自node左子树上的最大搜索二叉子树是以node.left为头的；来自node右子树上的最大搜索二叉子树是以node.right为头的；node左子树上的最大搜索二叉子树的最大值小于node.value；node右子树上的最大搜索二叉子树的最小值大于node.value，那么以节点node为头的整棵树都是搜索二叉树。

第二种：如果不满足第一种情况，说明以节点node为头的树整体不能连成搜索二叉树。这种情况下，以node为头的树上的最大搜索二叉子树是来自node的左子树上的最大搜索二叉子树和来自node的右子树上的最大搜索二叉子树之间，节点数较多的那个。

```java
public TreeNode getMaxTree(TreeNode node){
    if(node==null){
        return null;
    }
    int[] record=new int[3];//记录全局变量，包括两个子树的最大值最小值，子树节点数
    return postOrder(node,record);
}
public TreeNode postOrder(TreeNode node, int[] record){
    if(node==null){
        record[0]=0;
        record[1]= Integer.MAX_VALUE;
        record[2]=Integer.MIN_VALUE;
        return null;
    }
    TreeNode lBST=postOrder(node.left,record);//左子树判断
    int lsize=record[0];
    int lmin=record[1];
    int lmax=record[2];
    TreeNode rBST=postOrder(node.right,record);//右子树判断
    int rsize=record[0];
    int rmin=record[1];
    int rmax=record[2];
    record[1]= Math.min(lmin,node.val); //若满足搜索树结构，这个是正确的，不满足时，这个更新并不会发挥作用
    record[2]= Math.max(node.val,rmax);
    //当前节点可以作为搜索树节点的条件
    if(lBST==node.left&&rBST==node.right&&node.val>lmax&&node.val<rmin){
        record[0]=lsize+rsize+1;
        return node;
    }
    //根据节点数来判断
    record[0]=Math.max(lsize,rsize);
    return lsize>rsize?lBST:rBST;
}
```

### 7. 最大的搜索二叉树结构

**方法1：** 时间复杂度O(N^2)，对每个节点都查找一下，以该节点为头结点所能得到的最大搜索二叉树结构。对每个节点，通过递归子节点，根据搜索树的规则进行查找，从头部开始递归找如果最后能够找到子节点，则该节点可以加入到搜索树的结构中，然后继续查找这个节点的子节点是否能找到。这个过程中，头部节点不变，最后返回节点个数。由于每个节点都要找一遍其子孙节点，所以是N^2.

```java
public static int bstTopoSize1(Node head) {
   if (head == null) {
      return 0;
   }
   int max = maxTopo(head, head);
   max = Math.max(bstTopoSize1(head.left), max);
   max = Math.max(bstTopoSize1(head.right), max);
   return max;
}

public static int maxTopo(Node h, Node n) {
   if (h != null && n != null && isBSTNode(h, n, n.value)) {
      return maxTopo(h, n.left) + maxTopo(h, n.right) + 1;//如果当前节点满足，则查找子节点
   }
   return 0;
}
//以h为头结点，查找n节点，如果能够按照搜索树规则找到，说明满足条件
public static boolean isBSTNode(Node h, Node n, int value) {
   if (h == null) {
      return false;
   }
   if (h == n) {
      return true;
   }
   return isBSTNode(h.value > value ? h.left : h.right, n, value);
}
```

**方法2：** 时间复杂度O(N)，最差O(NlogN)

通过每个节点记录贡献度，从而可以快速得到某个头结点的贡献度，然后按照搜索树的规则进行判断，去掉不满足的节点，调整贡献度，最终得到的就是结果。

```java
//记录结构
public static class Record {
   public int l;
   public int r;

   public Record(int left, int right) {
      this.l = left;
      this.r = right;
   }
}
public static int bstTopoSize2(Node head) {
   Map<Node, Record> map = new HashMap<Node, Record>();//map
   return posOrder(head, map);
}
//后序遍历，先得到左右，然后得到头节点的贡献值
//由于是递归的，假设当前节点的左右是已经处理过的子树
public static int posOrder(Node h, Map<Node, Record> map) {
   if (h == null) {
      return 0;
   }
   int ls = posOrder(h.left, map);
   int rs = posOrder(h.right, map);
   modifyMap(h.left, h.value, map, true);//需要修正的左右节点的记录
   modifyMap(h.right, h.value, map, false);
   Record lr = map.get(h.left);//没有记录，可能是没有遍历过或者因为不满足条件被删除了
   Record rr = map.get(h.right);
   int lbst = lr == null ? 0 : lr.l + lr.r + 1;
   int rbst = rr == null ? 0 : rr.l + rr.r + 1;  //得到本节点的记录值
   map.put(h, new Record(lbst, rbst));//添加记录
   return Math.max(lbst + rbst + 1, Math.max(ls, rs));//返回最大值，算本节点，不算本节点
}
public static int modifyMap(Node n, int v, Map<Node, Record> m, boolean s) {
   if (n == null || (!m.containsKey(n))) {
      return 0;
   }
   Record r = m.get(n);
   if ((s && n.value > v) || ((!s) && n.value < v)) {
      m.remove(n);      //从map中去掉，则子树都被去掉
      return r.l + r.r + 1;//如果当前节点不满足左小右大的规则，则所有记录都要去掉
   } else {
      int minus = modifyMap(s ? n.right : n.left, v, m, s);//左子树遍历右边界，右子树遍历左边界
      if (s) {
         r.r = r.r - minus;//更新节点的记录值，如果minus不为0则向上层递归不断进行更新
      } else {
         r.l = r.l - minus;
      }
      m.put(n, r);//更新
      return minus;
   }
}
```

### 8. 按层打印和Z字形打印二叉树

按层打印就是按层遍历的方法，用一个变量记录每一层的宽度控制换行。

按z字形打印，需要在不同的层进行不同的顺序操作，用双端队列可以从头部和尾部进行操作，从而实现这个过程。

```java
public static void printBylevel(TreeNode node){
    if(node==null){
        return;
    }
    Queue<TreeNode> queue=new LinkedList<>();
    queue.offer(node);
    int sum=1;
    int level=1;
    System.out.print("level"+level+": ");
    while(!queue.isEmpty()){
        TreeNode p=queue.poll();
        System.out.print(p.val+" ");
        sum--;
        if(p.left!=null){
            queue.offer(p.left);
        }
        if(p.right!=null){
            queue.offer(p.right);
        }
        if(sum==0){
            sum=queue.size();
            if(sum>0){      //控制换行的操作
                System.out.println();
                level++;
                System.out.print("level"+level+": ");
            }
        }
    }
}

public static void printZ(TreeNode node){
    if(node==null){
        return;
    }
    int level=1;
    int sum=1;
    LinkedList<TreeNode> list=new LinkedList<>();//双端队列
    list.push(node);
    System.out.print("level"+level+": ");
    while(!list.isEmpty()){
       if(level%2==1){
         TreeNode p=list.pollLast();
           System.out.print(p.val+" ");
         if(p.left!=null){
             list.offerFirst(p.left);
         }
           if(p.right!=null){
               list.offerFirst(p.right);
           }
       }else{//上面和下面的过程是相反的
           TreeNode p=list.pollFirst();
           System.out.print(p.val+" ");
           if(p.right!=null){
               list.offerLast(p.right);
           }
           if(p.left!=null){
               list.offerLast(p.left);
           }
       }
       sum--;
        if(sum==0){
            sum=list.size();
            if(sum>0){
                System.out.println();
                level++;
                System.out.print("level"+level+": ");
            }
        }
    }
}
```

###  9. 搜索二叉树查找交换了的两个节点

由于搜索二叉树是有序的，通过==中序遍历==可以得到一个有序的序列，如果交换了两个值，则序列不再有序，找到出现降序的位置，第一次降序较大的值和第二次降序较小的值是两个交换的节点。如果只有一次降序则降序位置的两个值互相交换。很多问题结合二叉树的遍历和搜索二叉树的特点可以得到一些解法，要多思考。

交换两个节点，需要获得两个节点各自的父节点和左右子节点，然后交换两个节点的环境。但是因为两个节点可能存在头结点，可能是相邻的关系，可能不相邻，所以要划分很多种情况来讨论。

- 两个节点有一个头结点，谁是头结点？
- 两个节点相邻，谁是谁的头结点？
- 两个节点不相邻，两个节点分别是左还是右边节点

考虑不同的情况，进行指针交换时才能不出错。

```java
public static Node[] getTwoErrNodes(Node head) {
   Node[] errs = new Node[2];
   if (head == null) {
      return errs;
   }
   Stack<Node> stack = new Stack<Node>();
   Node pre = null;  //记录前一个节点
   while (!stack.isEmpty() || head != null) {//中序遍历过程
      if (head != null) {
         stack.push(head);
         head = head.left;
      } else {
         head = stack.pop();
         if (pre != null && pre.value > head.value) {//如果出现递减变化
            errs[0] = errs[0] == null ? pre : errs[0];
            errs[1] = head;
         }
         pre = head;
         head = head.right;
      }
   }
   return errs;
}
```

```java
public static Node[] getTwoErrParents(Node head, Node e1, Node e2) {
   Node[] parents = new Node[2];
   if (head == null) {
      return parents;
   }
   Stack<Node> stack = new Stack<Node>();
   while (!stack.isEmpty() || head != null) {
      if (head != null) {
         stack.push(head);
         head = head.left;
      } else {
         head = stack.pop();
         if (head.left == e1 || head.right == e1) {
            parents[0] = head;    //获得父节点
         }
         if (head.left == e2 || head.right == e2) {
            parents[1] = head;
         }
         head = head.right;
      }
   }
   return parents;
}

public static Node recoverTree(Node head) {
   Node[] errs = getTwoErrNodes(head);
   Node[] parents = getTwoErrParents(head, errs[0], errs[1]);
   Node e1 = errs[0];
   Node e1P = parents[0];
   Node e1L = e1.left;
   Node e1R = e1.right;
   Node e2 = errs[1];
   Node e2P = parents[1];
   Node e2L = e2.left;
   Node e2R = e2.right;
   if (e1 == head) {
      if (e1 == e2P) { // 情况2
         e1.left = e2L;
         e1.right = e2R;
         e2.right = e1;
         e2.left = e1L;
      } else if (e2P.left == e2) { // 情况3
         e2P.left = e1;
         e2.left = e1L;
         e2.right = e1R;
         e1.left = e2L;
         e1.right = e2R;
      } else { // 情况4
         e2P.right = e1;
         e2.left = e1L;
         e2.right = e1R;
         e1.left = e2L;
         e1.right = e2R;
      }
      head = e2;
   } else if (e2 == head) {
      if (e2 == e1P) { // 情况5
         e2.left = e1L;
         e2.right = e1R;
         e1.left = e2;
         e1.right = e2R;
      } else if (e1P.left == e1) { // 情况6
         e1P.left = e2;
         e1.left = e2L;
         e1.right = e2R;
         e2.left = e1L;
         e2.right = e1R;
      } else { // 情况7
         e1P.right = e2;
         e1.left = e2L;
         e1.right = e2R;
         e2.left = e1L;
         e2.right = e1R;
      }
      head = e1;
   } else {
      if (e1 == e2P) {
         if (e1P.left == e1) { // 情况8
            e1P.left = e2;
            e1.left = e2L;
            e1.right = e2R;
            e2.left = e1L;
            e2.right = e1;
         } else { // 情况9
            e1P.right = e2;
            e1.left = e2L;
            e1.right = e2R;
            e2.left = e1L;
            e2.right = e1;
         }
      } else if (e2 == e1P) {
         if (e2P.left == e2) { // 情况10
            e2P.left = e1;
            e2.left = e1L;
            e2.right = e1R;
            e1.left = e2;
            e1.right = e2R;
         } else { // 情况11
            e2P.right = e1;
            e2.left = e1L;
            e2.right = e1R;
            e1.left = e2;
            e1.right = e2R;
         }
      } else {
         if (e1P.left == e1) {
            if (e2P.left == e2) { // 情况12
               e1.left = e2L;
               e1.right = e2R;
               e2.left = e1L;
               e2.right = e1R;
               e1P.left = e2;
               e2P.left = e1;
            } else { // 情况13
               e1.left = e2L;
               e1.right = e2R;
               e2.left = e1L;
               e2.right = e1R;
               e1P.left = e2;
               e2P.right = e1;
            }
         } else {
            if (e2P.left == e2) { // 情况14
               e1.left = e2L;
               e1.right = e2R;
               e2.left = e1L;
               e2.right = e1R;
               e1P.right = e2;
               e2P.left = e1;
            } else { // 情况1
               e1.left = e2L;
               e1.right = e2R;
               e2.left = e1L;
               e2.right = e1R;
               e1P.right = e2;
               e2P.right = e1;
            }
         }
      }
   }
   return head;
}
```

### 10. 判断二叉树是否是排序二叉树

主要解决方法：

考虑把这些问题都转化为可以通过二叉树遍历而获得的一些性质来判断。

对于排序二叉树 , 由于其有序的性质，可以采用中序遍历的方式，判断遍历过程中的数字是否是递增的。所以这里的主要难点是如何进行中序遍历，如何减少遍历的时间空间复杂度。

对于完全二叉树（CBT）,可以通过按层次遍历的方法来对树结构的完整性进行验证。也可以通过递归方法来解决。

```java
public boolean isBST(TreeNode node){
        if(node==null){
            return false;
        }
        int pre=Integer.MAX_VALUE;
        Stack<TreeNode> stack=new Stack<>();//借助于栈结构来进行遍历,空间复杂度高
        stack.push(node);

        while(!stack.isEmpty()||node!=null){
            if(node!=null){
                stack.push(node);
                node=node.left;
            }else{
                node=stack.pop();
                if(pre!=Integer.MAX_VALUE&&node.val<pre){
                    return false;
                }
                pre=node.val;
            }
        }
        return true;
    }
```

基于moris遍历方法

```java
//不借助栈实现中序遍历
    public boolean isBst(TreeNode node){
        if(node==null){
            return false;
        }
        TreeNode cur1=node;
        TreeNode cur2=null;
        int pre=Integer.MAX_VALUE;
        while(cur1!=null){
            cur2=cur1.left;
            if(cur2!=null){
                while(cur2.right!=null&&cur2.right!=cur1){
                    cur2=cur2.right;
                }
                if(cur2.right==null){
                    cur2.right=cur1;
                    cur1=cur1.left;
                    continue;
                }else{
                    cur2.right=null;
                }
            }
            if(pre!=Integer.MAX_VALUE&&pre>cur1.val){
                return false;
            }
                pre=cur1.val;
                cur1=cur1.right;
       
        return true;
    }
```

### 11. 判断完全二叉树

采用递归方式的关键在于设计全局变量，保存结果，一旦发现结果不满足要求就返回，不再进行后面的遍历。

用层次遍历，主要是区分是否到达叶子层，如果是叶子层，那么后面的节点都不能有子节点。层次遍历更加直观一些。

```java
/**
     * 递归方式实现
     * @param node
     * @return boolean
     */
    public boolean isCBT(TreeNode node){
        if(node==null){
            return false;
        }
        boolean[] res=new boolean[1];
        res[0]=true;
        getHeight(node,0,res);
        return res[0];
    }
    public int getHeight(TreeNode node, int level, boolean[] res){
        if(node==null){
            return level;
        }
        if(node.left==null&&node.right==null){
            return level+1;
        }
        if(node.left!=null&&node.right!=null){
            int Hleft=getHeight(node.left,level+1,res);
            if(!res[0]){
                return level;
            }
            int Hright=getHeight(node.right,level+1,res);
            if(!res[0]){
                return level;
            }
            if(Hleft!=Hright){
                res[0]=false;
                return level;
            }
            return Hleft;
        }
        res[0]=false;
        return level;
    }
```

用层次遍历

```java
/**
     * 用层次遍历的方法来实现
     * @param node
     * @return
     */
    public boolean isCbt(TreeNode node){
        if(node==null){
            return false;
        }
        Queue<TreeNode> queue=new LinkedList<>();
        queue.offer(node);
        boolean leaf=false;
        while(!queue.isEmpty()){
            TreeNode cur=queue.poll();
            if(leaf&&(cur.left!=null||cur.right!=null)
               ||cur.left==null&&cur.right!=null
               ||cur.right==null&&cur.left!=null){
                return false;
            }
            if(cur.left!=null){
                queue.offer(cur.left);
            }
            if(cur.right!=null){
                queue.offer(cur.right);
            }
            if(cur.left==null&&cur.right==null){
                leaf=true;
            }
        }
        return true;
    }
```

### 12. 判断是否是平衡二叉树

同样的是将问题转化为中序遍历的问题，先遍历左子树，若左子树不是平衡的，后面的不要再遍历。若左右子树都是平衡的，通过比较两边的高度来判断根节点是否平衡。

```java
 public boolean isBalance(TreeNode head){
        boolean[] res=new boolean[1];
        res[0]=true;
        getHeight(head,1,res);
        return res[0];
    }
    public int getHeight(TreeNode head, int level,boolean[] res){
        if(head==null){
            return level;
        }
        int leftLevel=getHeight(head.left,level+1,res);
        if(!res[0])
        {
            return level;
        }
        int rightLevel=getHeight(head.right,level+1,res);
        if(!res[0])
        {
            return level;
        }
        if(Math.abs(leftLevel-rightLevel)>1){
            res[0]=false;
        }
        return Math.max(leftLevel,rightLevel);
    }
```

### 13. 判断一个整形数组是否是排序树的后续遍历结果

这里用了`Arrays.copyOfRange`，也可以直接用数组下标表示范围开始和结束。按照定义来判断就行了。

根据一个后续遍历数组来恢复二叉树的过程，可以变成一个前序遍历的过程。

```java
public static boolean isPostArray(int[] arr){
        if(arr==null||arr.length==0){
            return true;
        }
        int len=arr.length;
        int posLeft=0;
        while(posLeft<len&&arr[posLeft]<arr[len-1]){
            posLeft++;
        }
        int posRight=posLeft;
        while(posRight<len&&arr[posRight]>arr[len-1]){
            posRight++;
        }
        if(posRight!=len-1){
            return false;
        }
        return isPostArray(Arrays.copyOfRange(arr,0,posLeft))
            &&isPostArray(Arrays.copyOfRange(arr,posLeft,posRight));
    }
    public static boolean isPost(int[] arr){
        if(arr==null||arr.length==0){
            return false;
        }
         return isPostArray(arr);
    }
```

### 14. 利用前序后序中序数组还原二叉树

前序中序，中序后序都比较好还原，前序后序并不能确定一个唯一二叉树，只能在二叉树节点只存在0个或2个子节点时才能还原二叉树。

```java
public TreeNode preInToTree(int[] preOrder,int[] inOrder){
        if(preOrder==null||preOrder.length==0){
            return null;
        }
        if(preOrder.length==1){
            return new TreeNode(preOrder[0]);
        }
        int head=preOrder[0];
        int index=0;
        int len=inOrder.length;
        while(index<len&&inOrder[index]!=head){
            index++;
        }

        TreeNode node=new TreeNode(head);
        node.left=preInToTree(Arrays.copyOfRange(preOrder,1,index+1),
                                    Arrays.copyOfRange(inOrder,0,index));
        node.right=preInToTree(Arrays.copyOfRange(preOrder,index+1,len),
                Arrays.copyOfRange(inOrder,index+1,len));
        return node;
    }
```

```java
 /**
     * 先序遍历和中序遍历可以获得二叉树
     * 可以用下标，也可以用数组复制
     * @param postOrder
     * @param inOrder
     * @return
     */
    public TreeNode postInToTree(int[] postOrder,int[] inOrder){
        if(postOrder==null||postOrder.length==0){
            return null;
        }
        if(postOrder.length==1){
            return new TreeNode(postOrder[0]);
        }
        int len=inOrder.length;
        int head=postOrder[len-1];
        int index=0;
        while(index<len&&inOrder[index]!=head){
            index++;
        }

        TreeNode node=new TreeNode(head);
        node.left=preInToTree(Arrays.copyOfRange(postOrder,0,index),
                Arrays.copyOfRange(inOrder,0,index));
        node.right=preInToTree(Arrays.copyOfRange(postOrder,index,len-1),
                Arrays.copyOfRange(inOrder,index+1,len));
       return node;
    }
```

```java

    /**
     * 不是任意两个数组都可以获得唯一二叉树，只有当二叉树节点有零个或两个子节点时才可以获得
     * @param pre
     * @param post
     * @return
     */
    public TreeNode prePostToTree(int[] pre,int[] post){
        if(pre==null||pre.length==0){
            return null;
        }
        if(pre.length==1){
            return new TreeNode(pre[0]);
        }

        int len=pre.length;
        int head=pre[0];
        int index=0;
        while(index<len&&post[index]!=pre[1]){
            index++;
        }
        TreeNode node=new TreeNode(head);
        node.left=prePostToTree(Arrays.copyOfRange(pre,1,index+2),
                Arrays.copyOfRange(post,0,index+1));
        node.right=prePostToTree(Arrays.copyOfRange(pre,index+2,len),
                Arrays.copyOfRange(post,index+1,len-1));
        return node;
    }
```



## 第八章 数组

### 求未排序数组中累加和为指定值的最长子数组

通过用map记录前面遍历过的值累加和出现的位置，在后面的判断中利用。其他问题也可以转为求指定和的问题。

第一个补充问题，求正数和负数个数相等的子数组，先把数组arr中的正数全部变成1，负数全部变成-1，0不变，然后求累加和为0的最长子数组长度即可。

第二个补充问题，求0和1个数相同的子数组，先把数组arr中的0全部变成-1，1不变，然后求累加和为0的最长子数组长度即可。

```java
public static int getLongSub(int[] arr,int k){
    if(arr==null||arr.length==0){
        return 0;
    }
    Map<Integer,Integer> map=new HashMap<>();
    map.put(0,0);//这一步不要忘了，是初始位置边界条件
    int sum=0;
    int len=0;
    for(int i=0;i<arr.length;i++){
        sum+=arr[i];
        if(map.containsKey(sum-k)){
            int index=map.get(sum-k);
            len=Math.max(i+1-index,len);
        }
        if(!map.containsKey(sum)){
            map.put(sum,i+1);
        }
    }
    return len;
}
```