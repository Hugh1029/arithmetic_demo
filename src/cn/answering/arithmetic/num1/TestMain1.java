package cn.answering.arithmetic.num1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author zhangjp
 * @date 2020-04-20 23:44
 * @qq 34948062
 * @github: https://github.com/Hugh1029
 * @web: https://answering.cn
 * @description
 *
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释： 因为无重复字符串的最长字段是"abc"，所以长度是3
 * 理解： 这个题的意思是子串里没有重复的字符串，比如abca,这里面a和a重复了，不算；
 *
 */
public class TestMain1 {

    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        String str = "abcabcdebb";
        int maxLen = childStrLength(str);
        System.out.println("长度为:" + maxLen);
        int maxlen2 = lengthOfLongestSubstring(str);
        System.out.println("长度2为:" + maxlen2);
    }

    /**
     * 自己实现
     * 通过Set来实现
     * 从第一个字符挨个往后数，如果Set中不包含，则加入，有了，则计算出这个字符串的长度
     * 然后进行比较
     * @param str
     * @return
     */
    public static int childStrLength(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int maxLen = 0;
        char[] chars = str.toCharArray();
        Set<Character> set = new HashSet<>();
        for (int i = 0; i < chars.length; i ++) {
            for (int j = i; j < chars.length; j ++) {
                if (set.contains(chars[j])) {
                    maxLen = Math.max(maxLen, set.size());
                    set.clear();
                }else {
                    set.add(chars[j]);
                }
            }
        }
        return maxLen;
    }

    /**
     * 参考答案
     * 1. 用Map记录字符所在位置,当遇到重复字符时,移动start指针
     * 2. 替换Map中下标，计算子字符串
     *
     * 参考答案的巧妙之处:
     * 1. 利用map.put()，如果key已经存在，那么返回的会是被被替代的值；否则返回null;
     * 2. 通过map.put()，如果map中的key已经存在，那么说明前面的字符串长度已经计算出来了，如果是最大，已经存入到res中了
     * 这时候因为遇到重复的字符了，所以start要向后移动一个位置，这里虽然是用了Math.max()巧就巧在假如遇到的重复字符是前面的子字符的最后一个
     * 如果字符是abccbabb
     * 那么到遇到c和前面的字符重复的时候，bcc,cc就没必要再计算了，肯定是比之前的短的
     * 这样就较少了时间效率
     * 总的来说，参考答案的时间效率比我自己写的高明多了
     *
     * @param str
     * @return
     */
    public static int lengthOfLongestSubstring(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        HashMap<Character, Integer> temp = new HashMap<>();
        char[] chars = str.toCharArray();

        int res = 0, start = 0;
        for (int i = 0; i < chars.length; i ++) {
            if (temp.containsKey(chars[i])) {
                start = Math.max(temp.put(chars[i], i) + 1, start);
                // start ++;
            }
            temp.put(chars[i], i);
            res = Math.max(res, i - start + 1);
        }
        return res;
    }
}
