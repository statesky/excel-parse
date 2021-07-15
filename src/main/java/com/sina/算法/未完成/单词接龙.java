package com.sina.算法.未完成;

import java.util.*;

/**
 * leetcode 127.
 * <p>
 * 给定两个单词（beginWord 和 endWord）和一个字典，找到从 beginWord 到 endWord 的最短转换序列的长度。转换需遵循如下规则：
 * <p>
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 * <p>
 * 如果不存在这样的转换序列，返回 0。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * 输出: 5
 * <p>
 * 解释: 一个最短转换序列是 "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * 返回它的长度 5。
 * 示例 2:
 * <p>
 * 输入:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * 输出: 0
 * <p>
 * 解释: endWord "cog" 不在字典中，所以无法进行转换。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-ladder
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2020-11-05
 * @since excel-test 1.0.0
 */
public class 单词接龙 {

    Map<String, Integer> wordId = new HashMap<>();
    List<List<Integer>> edge = new ArrayList<>();
    int nodeNum = 0;

    /**
     * 来源于官方，本人不会，而这个我也看了很久，觉得自己low里low气的
     *
     * 执行用时 30ms        86.79%
     * 内存消耗 48.7MB      5.05%
     *
     * 内存消耗大师情有可原的，这过程中创建了长度为n的map，n+1和list，还有Queue，确实消耗很大
     *
     * 思路主要是先建立一个图，之后再用广度优先遍历遍历图，直至找到endWord或者遍历结束，找到则返回步数
     *
     */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // 将所有单词及其虚拟节点放入map数组，并且此时二维数组，已通过虚拟节点连接
        for (String word : wordList) {
            addEdge(word);
        }
        // 将起点放入
        addEdge(beginWord);
        // 若map中不包含endWord，表明到不了，直接返回0
        if (!wordId.containsKey(endWord)) {
            return 0;
        }
        // 记录该节点是否被访问，并记录是在第几层被访问
        int[] dis = new int[nodeNum];
        // 初始化，不是零，个人认为这样可区分第一步的步数，初始化成该系统中不可能存在的值，避免了混乱，这点非常值得学习
        Arrays.fill(dis, Integer.MAX_VALUE);
        // 拿到起点和终点
        int beginId = wordId.get(beginWord), endId = wordId.get(endWord);
        dis[beginId] = 0;

        // 将需遍历的放入此处，遍历后就拿出，避免了递归的使用
        Queue<Integer> que = new LinkedList<>();
        // 将起点放入，开始遍历
        que.offer(beginId);
        // 为空，表示遍历结束
        while (!que.isEmpty()) {
            // 开始访问
            int x = que.poll();
            // 到达终点，返回实际步数
            if (x == endId) {
                return dis[endId] / 2 + 1;
            }
            // 遍历该节点的下一个节点
            for (int it : edge.get(x)) {
                // 该下一个节点未被访问
                if (dis[it] == Integer.MAX_VALUE) {
                    // 未被访问，记录在第几步被访问，且标明已被访问
                    dis[it] = dis[x] + 1;
                    // 将该节点放入队列，等待遍历其邻接节点
                    que.offer(it);
                }
            }
        }
        // 表明遍历结束且未到达终点，返回0
        return 0;
    }

    /**
     * 将该节点，及其虚拟节点放入map集合
     *
     * @param word
     */
    public void addEdge(String word) {
        addWord(word);
        int id1 = wordId.get(word);
        char[] array = word.toCharArray();
        int length = array.length;
        for (int i = 0; i < length; ++i) {
            char tmp = array[i];
            array[i] = '*';
            String newWord = new String(array);
            addWord(newWord);
            // 获取该节点的 id
            int id2 = wordId.get(newWord);
            // 将该两个节点 相连，若已存在，则会有一条条脉络呈现
            edge.get(id1).add(id2);
            edge.get(id2).add(id1);
            array[i] = tmp;
        }
    }

    /**
     * 未改节点创建数组，用于记录该节点连接哪几个节点
     *
     * @param word
     */
    public void addWord(String word) {
        if (!wordId.containsKey(word)) {
            wordId.put(word, nodeNum++);
            edge.add(new ArrayList<>());
        }
    }

    public static void main(String[] args) {
        单词接龙 s = new 单词接龙();
        String a = "hit";
        String b = "cog";
        List<String> list = new ArrayList<>();
        list.add("hot");
        list.add("dot");
        list.add("dog");
        list.add("lot");
        list.add("log");
        list.add("cog");

        int i = s.ladderLength(a, b, list);
        System.out.println(i);
    }
}

//"hit"
//"cog"
//["hot","dot","dog","lot","log","cog"]
