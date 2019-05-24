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

**方法1：**长度为N的链表，删除倒数第K个节点，则需要得到倒数第K个节点前面那个节点即第N-K个节点，用一个计数器初始设为K，遍历一遍链表，每经过一个节点减一，则遍历完成是为K-N。所以再从头开始遍历，计数器加1，计数器变成0时，则找到了要删除节点前一个节点。

**方法2：**用两个指针先后出发，中间间隔K步，找到要删除的节点

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

直接按照游戏规则进行还原，时间复杂度是o(N*M)，用递推关系则能简化为o(N).

