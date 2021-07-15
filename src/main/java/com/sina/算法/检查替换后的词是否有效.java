package com.sina.算法;

/**
 * leetcode 1003.
 * <p>
 * 给定有效字符串 "abc"。
 * <p>
 * 对于任何有效的字符串 V，我们可以将 V 分成两个部分 X 和 Y，使得 X + Y（X 与 Y 连接）等于 V。（X 或 Y 可以为空。）那么，X + "abc" + Y 也同样是有效的。
 * <p>
 * 例如，如果 S = "abc"，则有效字符串的示例是："abc"，"aabcbc"，"abcabc"，"abcabcababcc"。无效字符串的示例是："abccba"，"ab"，"cababc"，"bac"。
 * <p>
 * 如果给定字符串 S 有效，则返回 true；否则，返回 false。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-word-is-valid-after-substitutions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 示例 1：
 * <p>
 * 输入："aabcbc"
 * 输出：true
 * 解释：
 * 从有效字符串 "abc" 开始。
 * 然后我们可以在 "a" 和 "bc" 之间插入另一个 "abc"，产生 "a" + "abc" + "bc"，即 "aabcbc"。
 * 示例 2：
 * <p>
 * 输入："abcabcababcc"
 * 输出：true
 * 解释：
 * "abcabcabc" 是有效的，它可以视作在原串后连续插入 "abc"。
 * 然后我们可以在最后一个字母之前插入 "abc"，产生 "abcabcab" + "abc" + "c"，即 "abcabcababcc"。
 * 示例 3：
 * <p>
 * 输入："abccba"
 * 输出：false
 * 示例 4：
 * <p>
 * 输入："cababc"
 * 输出：false
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-if-word-is-valid-after-substitutions
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2020-10-14
 * @since excel-test 1.0.0
 */
public class 检查替换后的词是否有效 {

    public boolean isValid(String s) {
        while (s.contains("abc")) {
            s = s.replace("abc", "");
        }
        return s.length() == 0;
    }
}
