package com.sina.算法.简单;

/**
 * leetcode 925.
 * <p>
 * 你的朋友正在使用键盘输入他的名字 name。偶尔，在键入字符 c 时，按键可能会被长按，而字符可能被输入 1 次或多次。
 * <p>
 * 你将会检查键盘输入的字符 typed。如果它对应的可能是你的朋友的名字（其中一些字符可能被长按），那么就返回 True。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：name = "alex", typed = "aaleex"
 * 输出：true
 * 解释：'alex' 中的 'a' 和 'e' 被长按。
 * 示例 2：
 * <p>
 * 输入：name = "saeed", typed = "ssaaedd"
 * 输出：false
 * 解释：'e' 一定需要被键入两次，但在 typed 的输出中不是这样。
 * 示例 3：
 * <p>
 * 输入：name = "leelee", typed = "lleeelee"
 * 输出：true
 * 示例 4：
 * <p>
 * 输入：name = "laiden", typed = "laiden"
 * 输出：true
 * 解释：长按名字中的字符并不是必要的。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/long-pressed-name
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2020-10-21
 * @since excel-test 1.0.0
 */
class 长按输入 {

    /**
     * 本人
     *
     * 执行用时 1ms     86.91%
     * 内存消耗 36.6MB  71.78%
     *
     */
    public boolean isLongPressedName(String name, String typed) {
        int nameIndex = 0;
        int typeIndex = 0;
        while (typeIndex < typed.length() && nameIndex < name.length()) {
            if (typed.charAt(typeIndex) == name.charAt(nameIndex)) {
                typeIndex++;
                nameIndex++;
            } else if (nameIndex > 0 && typed.charAt(typeIndex) == name.charAt(nameIndex - 1)) {
                typeIndex++;
            } else {
                return false;
            }
        }
        if (nameIndex < name.length()) {
            return false;
        }
        if (typeIndex < typed.length()) {
            while (typeIndex < typed.length()) {
                if (typed.charAt(typeIndex) != name.charAt(name.length() - 1)) {
                    return false;
                }
                typeIndex++;
            }
        }
        return true;
    }

    /**
     * 来自leetcode
     * 思路是一样的，但明显优化了
     *
     * 执行用时 1mx     86.91%
     * 内存消耗 36.2MB  98.32%
     * @param name
     * @param typed
     * @return
     */
    public boolean isLongPressedNameForLeetCode(String name, String typed) {
        int i = 0, j = 0;
        while (j < typed.length()) {
            // 将在while 循环中的条件放在这里进行比较，并在结尾比较name是否遍历结束
            // 这样就不用像我一样判断了。做到了内存上面的优化
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j > 0 && typed.charAt(j) == typed.charAt(j - 1)) {
                j++;
            } else {
                return false;
            }
        }
        return i == name.length();
    }

    public static void main(String[] args) {
        长按输入 s = new 长按输入();
        String name = "dfuyalc";
        String typed = "fuuyallc";
        s.isLongPressedName(name, typed);
    }
}

//"dfuyalc"
//"fuuyallc"
