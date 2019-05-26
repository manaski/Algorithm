# 编程题目练习总结



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
    preOrderRecur(root.left);
    System.out.println(root.val);
    preOrderRecur(root.right);
}
public void postOrderRecur(TreeNode root){
    if(root==null){
        return;
    }
    preOrderRecur(root.left);
    preOrderRecur(root.right);
    System.out.println(root.val);
}
```

#### 非递归遍历

借助栈来保存节点信息，时间复杂度O(N)，空间复杂度O(N)，为栈空间所占用空间

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