package com.gangbin.leetcode题目;

import java.util.*;

/**
 * @author gangbin.li
 * @description: 拓扑排序分两步，首先构建图，然后对图进行拓扑排序，用到了队列和入度
 * 1、用一个map建立一个映射关系，表示起点和重点
 * 2、用一个入度数组，记录每个点的入度
 * 3、用队列，将入度为0的节点加入队列，然后将这些节点的出度删掉，将新的入度为0 的节点加入队列
 * 4、从队列中出队的顺序作为一个顺序
 * 5、如果最后的节点没有全部入队，说明有环存在
 * @date 2019/10/1
 */
public class 火星文字 {
    public String alienOrder(String[] words) {
        //1.构建图
//        Map<Character, Set<Character>> map = new HashMap<>();//图的关系主要是一个响亮映射关系，也就是先后关系
//        for (int i = 0; i < words.length - 1; i++) {
//            for (int j = 0; j < words[i].length() && j < words[i + 1].length(); j++) {
//                //如果字符相同，比较下一个
//                if (words[i].charAt(j) == words[i + 1].charAt(j)) continue;
//                //保存第一个不同的字符顺序
//                Set<Character> set = map.getOrDefault(words[i].charAt(j), new HashSet<>());
//                set.add(words[i + 1].charAt(j));
//                map.put(words[i].charAt(j), set);
//                break;//找到第一个不同的单词之后，就判断下面两个单词，当前单词不能再确定相对关系了
//            }
//        }
        Map<Character,Set<Character>> map=new HashMap<>();
        for(int i=0;i<words.length-1;i++){
            for(int j=0;j<words[i].length()&&j<words[j+1].length();j++){
                if(words[i].charAt(j)==words[i+1].charAt(j)){
                    continue;
                }
                Set<Character> set=map.getOrDefault(words[i].charAt(j),new HashSet<>());
                set.add(words[i+1].charAt(j));
                map.put(words[i].charAt(j),set);
                break;
            }
        }

        int[] degrees=new int[26];
        Arrays.fill(degrees,-1);
        int count=0;
       for(String s:words){
           for(Character c:s.toCharArray()){
               degrees[c-'a']=0;
           }
       }
        for(Character key:map.keySet()){
            for(Character c:map.get(key)){
                degrees[c-'a']++;
            }
        }
        LinkedList<Character> queue=new LinkedList<>();
        for(int i=0;i<26;i++){
            if(degrees[i]!=-1){
                count++;
            }
            if(degrees[i]==0){
                queue.offer((char)(i+'a'));
            }
        }
        StringBuilder sb=new StringBuilder();
        while(!queue.isEmpty()){
            char c=queue.poll();
            sb.append(c);
            if(map.containsKey(c)){
                Set<Character> set=map.get(c);
                for(Character c1:set){
                    degrees[c1-'a']--;
                    if(degrees[c1-'a']==0){
                        queue.offer(c1);
                    }
                }
            }
        }
        if(sb.length()!=count){
            return "";
        }
        return sb.toString();


//        //2.拓扑排序
//        //创建保存入度的数组
//        int[] degrees = new int[26];
//        Arrays.fill(degrees, -1);
//        //注意，不是26字母都在words中出现，所以出度分为两种情况：没有出现的字母出度为-1，出现了的字母的出度为非负数
//        for (String str : words) {
//            //将出现过的字符的出度设定为0
//            for (char c : str.toCharArray())
//                degrees[c - 'a'] = 0;
//        }
//        for (char key : map.keySet()) {
//            for (char val : map.get(key)) {
//                degrees[val - 'a']++;
//            }
//        }
//        //创建StringBuilder保存拓扑排序
//        StringBuilder sb = new StringBuilder();
//        //创建一个Queue保存入度为0的节点
//        Queue<Character> list = new LinkedList<>();
//
//        int count = 0;//计算图中节点数
//        for (int i = 0; i < 26; i++) {
//            if (degrees[i] != -1) count++;
//            if (degrees[i] == 0) {
//                list.add((char) ('a' + i));
//            }
//        }
//
//        while (!list.isEmpty()) {
//            Character cur = list.poll();
//            sb.append(cur);
//            //将邻接点出度-1
//            if (map.containsKey(cur)) {
//                Set<Character> set = map.get(cur);
//                for (Character c : set) {
//                    degrees[c - 'a']--;
//                    if (degrees[c - 'a'] == 0) list.add(c);
//                }
//            }
//        }
//
//        //判断是否有环
//        if (sb.length() != count) return "";
//        else return sb.toString();

    }

    public static void main(String[] args) {
    }
}
