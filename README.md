# 编程题目练习总结





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

