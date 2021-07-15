package com.sina.算法.简单;

import java.util.Stack;

/**
 * leetcode 844.
 * <p>
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * <p>
 * 注意：如果对空文本输入退格字符，文本继续为空。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * 示例 2：
 * <p>
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * 示例 3：
 * <p>
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * 示例 4：
 * <p>
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 * <p>
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/backspace-string-compare
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2020-10-19
 * @since excel-test 1.0.0
 */
public class 比较含退格的字符串 {

    /**
     * 本人
     *
     * 方法简单，但不是我想要的
     *
     * 执行用时 1ms     96.52%
     * 内存消耗 36.6ms  97.70%
     */
    public boolean backspaceCompare(String S, String T) {
        if (S == null && T == null) {
            return true;
        } else if (S == null || T == null) {
            return false;
        }
        char[] a = S.toCharArray();
        char[] b = T.toCharArray();

        Stack<Character> aStack = toStack(a);
        Stack<Character> bStack = toStack(b);

        int size = aStack.size();
        if (size == bStack.size()) {
            while (size > 0) {
                if (aStack.pop() != bStack.pop()) {
                    return false;
                }
                size--;
            }

            return true;
        }
        return false;
    }

    private Stack<Character> toStack(char[] a) {
        Stack<Character> stack = new Stack<>();
        for (char c : a) {
            if ('#' == c) {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }

        return stack;
    }

    /**
     * 来自leetcode官网
     * 最精华的就是从后往前遍历的思想，我开始想的是从前往后，发现很复杂，就放弃了，采用了上方法
     *
     * 执行用时 1ms     96.52%
     * 内存消耗 36.4ms  99.42%
     *
     * 尽管看起来差不多，但其实比上一种要好，而且更值得学习
     *
     */
    public boolean backspaceCompareFromLeetCode(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int skipS = 0, skipT = 0;

        while (i >= 0 || j >= 0) {
            // 此循环会去除 "#" 的影响
            while (i >= 0) {
                if (S.charAt(i) == '#') {
                    skipS++;
                    i--;
                } else if (skipS > 0) {
                    skipS--;
                    i--;
                } else {
                    break;
                }
            }
            // 此循环会去除 "#" 的影响
            while (j >= 0) {
                if (T.charAt(j) == '#') {
                    skipT++;
                    j--;
                } else if (skipT > 0) {
                    skipT--;
                    j--;
                } else {
                    break;
                }
            }
            if (i >= 0 && j >= 0) {
                if (S.charAt(i) != T.charAt(j)) {
                    return false;
                }
            } else {
                // 有一个未小于零，表明有一个未遍历结束，返回false，若都遍历结束，则返回true
                if (i >= 0 || j >= 0) {
                    return false;
                }
            }
            i--;
            j--;
        }
        return true;
    }

    public static void main(String[] args) {
        比较含退格的字符串 s = new 比较含退格的字符串();
        String a = "y#fo##f";

        String b = "y#f#o##f";

        //boolean flag = s.backspaceCompare(a, b);
        boolean flags = s.backspaceCompareFromLeetCode(a, b);
        System.out.println(flags);

    }
}

//"y#fo##f"
//"y#f#o##f"
