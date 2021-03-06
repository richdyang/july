package chapter1.section6.problems;

import org.junit.Test;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 例如输入字符串abc，则输出由字符a、b、c 所能排列出来的所有字符串
 * abc、acb、bac、bca、cab 和 cba。
 */
public class P1_AllPermutation {

    public void calcAllPermutation(char[] chars) {
        char[] xchars = new char[chars.length+1]; // 0 index ignored
        System.arraycopy(chars, 0, xchars, 1, chars.length);
        int length = xchars.length;
        int base = length;

        int min = 0;
        for(int i = 1; i < length; ++i) {
            min = i + min * base;
        }

        int max = 0;
        for(int i = length-1; i > 0; --i) {
            max = i + max * base;
        }

        for(int num = min; num <= max; ++num) {
            int remaining = 0;
            boolean illegal = false;

            int num1 = num;
            int[] bitset = new int[length];
            StringBuilder sb = new StringBuilder();
            while(num1 > 0) {
                remaining = num1 % base;

                if(remaining == 0 || remaining > length || bitset[remaining] == 1) {
                    illegal = true;
                    break;
                }
                sb.insert(0, xchars[remaining] + "\t");
                bitset[remaining] = 1;
                num1 /= base;
            }
            if(illegal) continue;
            System.out.print(sb.toString());
            System.out.println(num);
        }
    }

    @Test
    public void test() {
        char[] chars = {'a', 'b', 'c', 'd', 'e'};
        calcAllPermutation(chars);
    }
}
