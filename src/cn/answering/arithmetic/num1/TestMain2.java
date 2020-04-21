package cn.answering.arithmetic.num1;

/**
 * @author zhangjp
 * @date 2020-04-21 08:52
 * @qq 34948062
 * @github: https://github.com/Hugh1029
 * @web: https://answering.cn
 * @description
 *
 * 编写一个函数来查找字符串数组中最长的公共前缀
 *
 * 如果不存在公共前缀，返回空字符串""
 * 示例:
 * 输入: ["flower", "flow", "flight"]
 * 输出: "fl"
 *
 */
public class TestMain2 {

    public static void main(String[] args) {
        String[] strings = new String[] {"flower", "flow", "flight"};
        String s = getPrefix(strings);
        System.out.println("公共前缀:" + s);
    }

    /**
     * 自己实现方式
     * 1. 先找到字符串数组中最短的那个字符，因为最长前缀也就是这个字符串
     * 2. 将这个字符串拆为数组
     * 3. 循环这个数组，每次拼上一个字符去和每个字符串比较,如果不是这个字符串开头，那就意味着结束了
     *
     * 这里用了startWith函数，如果不用这个函数的话
     * 那应该拿这个数组的每个字符去和其他的字符串的对应位置的字符去比较，可以用二维数组去表示这个string的数组
     *
     * @param strs
     * @return
     */
    public static String getPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 先获取字符串长度最短的那个字符
        String temp = strs[0];
        for (String str : strs) {
            if (str.length() < temp.length()) {
                temp = str;
            }
        }

        char[] strArr = temp.toCharArray();
        StringBuilder builder = new StringBuilder();
        for (char cha : strArr) {
            builder.append(cha);
            for (String s : strs) {
                if (!s.startsWith(builder.toString())) {
                    return builder.deleteCharAt(builder.length() - 1).toString();
                }
            }
        }
        return temp;
    }

}

