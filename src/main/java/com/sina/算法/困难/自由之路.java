package com.sina.算法.困难;

import java.util.*;

/**
 * leetcode 514.
 * <p>
 * 视频游戏“辐射4”中，任务“通向自由”要求玩家到达名为“Freedom Trail Ring”的金属表盘，并使用表盘拼写特定关键词才能开门。
 * <p>
 * 给定一个字符串 ring，表示刻在外环上的编码；给定另一个字符串 key，表示需要拼写的关键词。您需要算出能够拼写关键词中所有字符的最少步数。
 * <p>
 * 最初，ring 的第一个字符与12:00方向对齐。您需要顺时针或逆时针旋转 ring 以使 key 的一个字符在 12:00 方向对齐，然后按下中心按钮，以此逐个拼写完 key 中的所有字符。
 * <p>
 * 旋转 ring 拼出 key 字符 key[i] 的阶段中：
 * <p>
 * 您可以将 ring 顺时针或逆时针旋转一个位置，计为1步。旋转的最终目的是将字符串 ring 的一个字符与 12:00 方向对齐，并且这个字符必须等于字符 key[i] 。
 * 如果字符 key[i] 已经对齐到12:00方向，您需要按下中心按钮进行拼写，这也将算作 1 步。按完之后，您可以开始拼写 key 的下一个字符（下一阶段）, 直至完成所有拼写。
 * <p>
 * 示例
 * 输出: 4
 * 解释:
 * 对于 key 的第一个字符 'g'，已经在正确的位置, 我们只需要1步来拼写这个字符。
 * 对于 key 的第二个字符 'd'，我们需要逆时针旋转 ring "godding" 2步使它变成 "ddinggo"。
 * 当然, 我们还需要1步进行拼写。
 * 因此最终的输出是 4。
 * <p>
 * 提示：
 * <p>
 * ring 和 key 的字符串长度取值范围均为 1 至 100；
 * 两个字符串中都只有小写字符，并且均可能存在重复字符；
 * 字符串 key 一定可以由字符串 ring 旋转拼出
 *
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/freedom-trail
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2020-11-11
 * @since excel-test 1.0.0
 */
public class 自由之路 {

    /**
     * 本人   此方法是可以的，但有一种情况未被考虑在内，即到两边的距离相等，下一个第二个更近等情况
     * 故此方法不行，需补充优化
     *
     * @param ring
     * @param key
     * @return
     */
    public int findRotateSteps(String ring, String key) {
        Map<Character, List<Integer>> map = new HashMap<>();

        int length = ring.length();
        int keyLength = key.length();

        int sum = 0;
        int index = 0;
        int tmp = 0;
        for (int i = 0; i < length; i++) {
            char a = ring.charAt(i);
            if (map.containsKey(a)) {
                List<Integer> list = map.get(a);
                list.add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);

                List<Integer> put = map.put(a, list);
            }
        }

        for (int i = 0; i < keyLength; ++i) {
            char c = key.charAt(i);
            List<Integer> list = map.get(c);

            int min = 1000;
            for (Integer x : list) {
                if (x > index) {
                    int d = x - index > index + length - x ? index + length - x : x - index;
                    if (d < min) {
                        tmp = x;
                        min = d;
                    }
                } else if (x < index) {
                    int d = index - x > x + length - index ? x + length - index : index - x;
                    if (d < min) {
                        tmp = x;
                        min = d;
                    }
                } else {
                    tmp = x;
                    min = 0;
                    break;
                }
            }
            index = tmp;
            sum = sum + min + 1;
        }

        return sum;
    }

    /**
     * 来自官方
     *
     * 执行用时 16ms    42.47%
     * 内存消耗 39.1MB  66.42%
     */
    public int findRotateSteps1(String ring, String key) {
        int n = ring.length(), m = key.length();
        List<Integer>[] pos = new List[26];
        // 给26个字母分别创建list以便于等下的保存
        for (int i = 0; i < 26; ++i) {
            pos[i] = new ArrayList<Integer>();
        }
        // 将 ring 中字母下标存入对应数组，字母已对应，此方法类似于我用的map
        for (int i = 0; i < n; ++i) {
            pos[ring.charAt(i) - 'a'].add(i);
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; ++i) {
            Arrays.fill(dp[i], 0x3f3f3f);
        }
        for (int i : pos[key.charAt(0) - 'a']) {
            dp[0][i] = Math.min(i, n - i) + 1;
        }
        for (int i = 1; i < m; ++i) {
            for (int j : pos[key.charAt(i) - 'a']) {
                for (int k : pos[key.charAt(i - 1) - 'a']) {
                    // 算出到该点走需几步，并且加一
                    dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + Math.min(Math.abs(j - k), n - Math.abs(j - k)) + 1);
                }
            }
        }
        return Arrays.stream(dp[m - 1]).min().getAsInt();
    }

    public static void main(String[] args) {
        自由之路 s = new 自由之路();
        String a = "edcba";
        String b = "abcde";
        int rotateSteps = s.findRotateSteps1(a, b);
        System.out.println(rotateSteps);
    }
}

// "edcba"
//"abcde"
