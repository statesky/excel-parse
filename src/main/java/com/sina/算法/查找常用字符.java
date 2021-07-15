package com.sina.算法;

import java.util.*;

/**
 * leetcode 1002.
 * <p>
 * 给定仅有小写字母组成的字符串数组 A，返回列表中的每个字符串中都显示的全部字符（包括重复字符）组成的列表。例如，如果一个字符在每个字符串中出现 3 次，但不是 4 次，则需要在最终答案中包含该字符 3 次。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 示例 1：
 * <p>
 * 输入：["bella","label","roller"]
 * 输出：["e","l","l"]
 * 示例 2：
 * <p>
 * 输入：["cool","lock","cook"]
 * 输出：["c","o"]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/find-common-characters
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author zhangbin
 * @version 1.0, 2020-10-14
 * @since excel-test 1.0.0
 */
public class 查找常用字符 {

    public static List<String> commonChars(String[] A) {
        int length = A.length;
        int minLength = A[0].length();
        int index = 0;
        for (int i = 1; i < length; i++) {
            if (minLength > A[i].length()) {
                minLength = A[i].length();
                index = i;
            }
        }
        String s = A[index];
        char[] chars = s.toCharArray();
        Map<Character, Integer> map = new HashMap<>(minLength);
        for (char c : chars) {
            if (map.containsKey(c)) {
                Integer count = map.get(c) + 1;
                map.put(c, count);
            } else {
                map.put(c, 1);
            }
        }
        for (String s1 : A) {
            Map<Character, Integer> mapNew = new HashMap<>(minLength);
            char[] charList = s1.toCharArray();
            for (char c : charList) {
                if (map.containsKey(c)) {
                    if (mapNew.containsKey(c)) {
                        Integer countNew = mapNew.get(c) + 1;
                        mapNew.put(c, countNew);
                    } else {
                        mapNew.put(c, 1);
                    }
                    int count = map.get(c) - 1;
                    if (count == 0) {
                        map.remove(c);
                    } else {
                        map.put(c, count);
                    }
                }
            }
            map = new HashMap<>(mapNew);
        }

        Set<Map.Entry<Character, Integer>> entries = map.entrySet();
        List<String> list = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : entries) {
            Character key = entry.getKey();
            for (int i = 0; i < entry.getValue(); i++) {
                list.add(String.valueOf(key));
            }
        }

        return list;
    }

    /**
     * leetcode官方，比本人的更加简洁且更加好
     * 此方法专为该题设计，小写的26个字母对应 ascil码是连在一起的，所以可以采用 ch - "a" 和 ch + "a" 的方式转换，这是精髓
     *
     * @param A
     * @return
     */
    public static List<String> commonCharsFromLeetCode(String[] A) {
        int[] minfreq = new int[26];
        Arrays.fill(minfreq, Integer.MAX_VALUE);
        for (String word: A) {
            int[] freq = new int[26];
            int length = word.length();
            for (int i = 0; i < length; ++i) {
                char ch = word.charAt(i);
                int i1 = ch - 'a';
                ++freq[i1];
            }
            for (int i = 0; i < 26; ++i) {
                minfreq[i] = Math.min(minfreq[i], freq[i]);
            }
        }

        List<String> ans = new ArrayList<String>();
        for (int i = 0; i < 26; ++i) {
            for (int j = 0; j < minfreq[i]; ++j) {
                ans.add(String.valueOf((char) (i + 'a')));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] a = {"bella", "label", "roller"};
        List<String> list = commonCharsFromLeetCode(a);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
