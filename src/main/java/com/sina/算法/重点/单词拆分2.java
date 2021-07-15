package com.sina.算法.重点;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * leetcode 140.
 * <p>
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * <p>
 * 说明：
 * <p>
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * <p>
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * 示例 2：
 * <p>
 * 输入:
 * s = "pineapplepenapple"
 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
 * 输出:
 * [
 *   "pine apple pen apple",
 *   "pineapple pen apple",
 *   "pine applepen apple"
 * ]
 * 解释: 注意你可以重复使用字典中的单词。
 * 示例 3：
 * <p>
 * 输入:
 * s = "catsandog"
 * wordDict = ["cats", "dog", "sand", "and", "cat"]
 * 输出:
 * []
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/word-break-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2020-11-10
 * @since excel-test 1.0.0
 */
public class 单词拆分2 {

    private int length;
    String s;

    public List<String> wordBreak(String s, List<String> wordDict) {
        s = s;
        length = s.length();
        Set<String> set = new HashSet<>(wordDict);

        List<String> list = new ArrayList<>();

        dfs(list, set, 0);

        return list;
    }

    private void dfs(List<String> list, Set<String> set, int i) {
        if (i >= length) {
            return;
        }

        for (int a = i + 1; a < length; a++) {
            String substring = s.substring(i, a);
            if (set.contains(substring)) {

            }
        }
    }
}
