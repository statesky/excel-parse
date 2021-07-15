package com.sina.算法.中等;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * leetcode 3.
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2020-10-28
 * @since excel-test 1.0.0
 */
public class 无重复字符的最长子串 {

    /**
     * 本人
     *
     * 执行用时 8ms     68.27%
     * 内存消耗 38.6MB  93.63%
     *
     * 引入了 removeIndex
     * @param s
     * @return
     */
    public int lengthOfLongestSubstring(String s) {
        if (s == null) {
            return 0;
        }
        int length = s.length();
        int max = 0;
        int removeIndex = 0;
        Map<Character, Integer> map = new HashMap<>(length);

        for (int i = 0; i < length; i++) {
            char c = s.charAt(i);
            if (!map.containsKey(c)) {
                map.put(c, i);
            } else {
                Integer index = map.get(c);
                int size = map.size();
                if (size > max) {
                    max = size;
                }
                while (removeIndex < index) {
                    char c1 = s.charAt(removeIndex);
                    Integer integer = map.get(c1);
                    if (integer == removeIndex) {
                        map.remove(c1);
                    }
                    removeIndex++;
                }
                map.put(c, i);
            }
        }

        if (map.size() > max) {
            max = map.size();
        }
        return max;
    }

    public int lengthOfLongestSubstringFromLeetCode(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    /**
     * 思路不对，错误
     *
     * @param s
     * @return
     */
    public int lengthOfLongestSubstringError(String s) {
        int length = s.length();

        int begin = 0;
        int end = 0;
        int max = 0;
        Set<Character> set = new HashSet<>();
        Map<String, String> map = new HashMap<>();
        while (end < length) {
            char c = s.charAt(end);
            if (!set.contains(c)) {
                set.add(c);
                end++;

            } else {
                if (end - begin > max) {
                    max = end - begin;
                }

                begin = end;
                set = new HashSet<>();
            }
        }

        if (end - begin > max) {
            max = end - begin;
        }
        return max;

    }

    public static void main(String[] args) {
        无重复字符的最长子串 s = new 无重复字符的最长子串();
        String q ="bpfbhmipx";
        int i = s.lengthOfLongestSubstring(q);
        System.out.println(i);
    }
}
