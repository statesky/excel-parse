package com.sina.算法.中等;

/**
 * leetcode 395.
 * <p>
 * 给你一个字符串 s 和一个整数 k ，请你找出 s 中的最长子串， 要求该子串中的每一字符出现次数都不少于 k 。返回这一子串的长度。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "aaabb", k = 3
 * 输出：3
 * 解释：最长子串为 "aaa" ，其中 'a' 重复了 3 次。
 * 示例 2：
 * <p>
 * 输入：s = "ababbc", k = 2
 * 输出：5
 * 解释：最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 104
 * s 仅由小写英文字母组成
 * 1 <= k <= 105
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-substring-with-at-least-k-repeating-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2021-02-27
 * @since excel-test 1.0.0
 */
public class 至少有K个重复字符的最长子串 {

    /**
     * 此方法来自官方，本人是实在没想出来，此方法利用分治算法
     * <p>
     * 找出小于k的字母，按即包含这些的都不行，再在这些分段中继续重复此操作找出，
     * <p>
     * 执行用时 1ms     78.52%
     * 内存消耗 36.2MB  90.68%
     *
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring(String s, int k) {
        int n = s.length();
        return dfs(s, 0, n - 1, k);
    }

    private int dfs(String s, int l, int r, int k) {
        int[] cnt = new int[26];
        for (int i = l; i <= r; i++) {
            cnt[s.charAt(i) - 'a']++;
        }

        // 初始化为0，方便下方比较
        char split = 0;
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0 && cnt[i] < k) {
                split = (char) (i + 'a');
                break;
            }
        }
        // 表明该分段无小于k的字符，符合要求，返回该段长度
        if (split == 0) {
            return r - l + 1;
        }

        // 此处就赋值，因为l是开头，此处赋值
        int i = l;
        int ret = 0;
        // 此为该段的末尾，表明大于末尾则返回，以保证遍历完成字符串
        while (i <= r) {
            // 找到开头第一个
            while (i <= r && s.charAt(i) == split) {
                i++;
            }
            // 表明该段无开头，直接返回，找下一段
            if (i > r) {
                break;
            }
            int start = i;
            // 找出结尾，此过程中i不断++，所以在下次循环中i已经是这次处理后的结尾，继续遍历下一次的部分，
            // 然后找出整段最长的一段，不断向上返回，最终找出最大的一段
            while (i <= r && s.charAt(i) != split) {
                i++;
            }

            // 对该段进行查找，找出该段符合要求长度
            int length = dfs(s, start, i - 1, k);
            // 去最长，返回
            ret = Math.max(ret, length);
        }
        return ret;
    }

    /**
     * 来自官方
     * <p>
     * 第二种方法：滑动窗口
     * <p>
     * 我们枚举最长子串中的字符种类数目，它最小为 11，最大为 |\Sigma|∣Σ∣（字符集的大小，本题中为 2626）。
     * <p>
     * 对于给定的字符种类数量 tt，我们维护滑动窗口的左右边界 l,rl,r、滑动窗口内部每个字符出现的次数 \textit{cnt}cnt，以及滑动窗口内的字符种类数目 \textit{total}total。当 \textit{total} > ttotal>t 时，我们不断地右移左边界 ll，并对应地更新 \textit{cnt}cnt 以及 \textit{total}total，直到 \textit{total} \le ttotal≤t 为止。这样，对于任何一个右边界 rr，我们都能找到最小的 ll（记为 l_{min}l
     * min
     * ​
     * ），使得 s[l_{min}...r]s[l
     * min
     * ​
     * ...r] 之间的字符种类数目不多于 tt。
     * <p>
     * 对于任何一组 l_{min}, rl
     * min
     * ​
     * ,r 而言，如果 s[l_{min}...r]s[l
     * min
     * ​
     * ...r] 之间存在某个出现次数小于 kk （且不为 00，下文不再特殊说明）的字符，我们可以断定：对于任何 l' \in (l_{min}, r)l
     * ′
     * ∈(l
     * min
     * ​
     * ,r) 而言，s[l'...r]s[l
     * ′
     * ...r] 依然不可能是满足题意的子串，因为：
     * <p>
     * 要么该字符的出现次数降为 00，此时子串内虽然少了一个出现次数小于 kk 的字符，但字符种类数目也随之小于 tt 了；
     * 要么该字符的出现次数降为非 00 整数，此时该字符的出现次数依然小于 kk。
     * 根据上面的结论，我们发现：当限定字符种类数目为 tt 时，满足题意的最长子串，就一定出自某个 s[l_{min}...r]s[l
     * min
     * ​
     * ...r]。因此，在滑动窗口的维护过程中，就可以直接得到最长子串的大小。
     * <p>
     * 此外还剩下一个细节：如何判断某个子串内的字符是否都出现了至少 kk 次？我们当然可以每次遍历 \textit{cnt}cnt 数组，但是这会带来 O(|\Sigma|)O(∣Σ∣) 的额外开销。
     * <p>
     * 我们可以维护一个计数器 \textit{less}less，代表当前出现次数小于 kk 的字符的数量。注意到：每次移动滑动窗口的边界时，只会让某个字符的出现次数加一或者减一。对于移动右边界 ll 的情况而言：
     * <p>
     * 当某个字符的出现次数从 00 增加到 11 时，将 \textit{less}less 加一；
     * <p>
     * 当某个字符的出现次数从 k-1k−1 增加到 kk 时，将 \textit{less}less 减一。
     * <p>
     * 对于移动左边界的情形，讨论是类似的。
     * <p>
     *
     * 极度复杂
     *
     * 执行用时 9ms     21.28%
     * 内存消耗 36.4MB  79.68%
     *
     * @param s
     * @param k
     * @return
     */
    public int longestSubstring1(String s, int k) {
        int ret = 0;
        int n = s.length();
        for (int t = 1; t <= 26; t++) {
            int l = 0, r = 0;
            int[] cnt = new int[26];
            int tot = 0;
            int less = 0;
            while (r < n) {
                cnt[s.charAt(r) - 'a']++;
                if (cnt[s.charAt(r) - 'a'] == 1) {
                    tot++;
                    less++;
                }
                if (cnt[s.charAt(r) - 'a'] == k) {
                    less--;
                }

                while (tot > t) {
                    cnt[s.charAt(l) - 'a']--;
                    if (cnt[s.charAt(l) - 'a'] == k - 1) {
                        less++;
                    }
                    if (cnt[s.charAt(l) - 'a'] == 0) {
                        tot--;
                        less--;
                    }
                    l++;
                }
                if (less == 0) {
                    ret = Math.max(ret, r - l + 1);
                }
                r++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        至少有K个重复字符的最长子串 a = new 至少有K个重复字符的最长子串();
        String s = "aaabb";
        int i = a.longestSubstring1(s, 2);
        System.out.println(i);
    }

}
