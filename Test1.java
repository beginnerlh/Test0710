/*

大家应该都会玩“锤子剪刀布”的游戏：

现给出两人的交锋记录，请统计双方的胜、平、负次数，并且给出双方分别出什么手势的胜算最大。

输入描述:
输入第1行给出正整数N（<=105），即双方交锋的次数。随后N行，每行给出一次交锋的信息，
即甲、乙双方同时给出的的手势。C代表“锤子”、J代表“剪刀”、B代表“布”，第1个字母代表
甲方，第2个代表乙方，中间有1个空格。


输出描述:
输出第1、2行分别给出甲、乙的胜、平、负次数，数字间以1个空格分隔。第3行给出两个字母，
分别代表甲、乙获胜次数最多的手势，中间有1个空格。如果解不唯一，则输出按字母序最小的解。

示例1
输入
10
C J
J B
C B
B B
B C
C C
C B
J B
B C
J J
输出
5 3 2
2 3 5
B B
*/
package written_test0710;

import java.util.Scanner;
//锤子剪刀布
public class Test1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] num = new int[3];// num[0]:甲胜 num[1]:平局 num[2]:乙胜
        char[] b = { 'B', 'C', 'J' };
        int[][] bt = new int[3][2];// bt[i][0]:甲BCJ胜的次数 乙同理
        //char[] w = new char[2];
        for (int i = 0; i < n; i++) {
            char t1 = in.next().charAt(0);
            char t2 = in.next().charAt(0);
            int te1 = -10, te2 = -10;
            for (int j = 0; j < b.length; j++) {
                if (t1 == b[j])
                    te1 = j;
                if (t2 == b[j])
                    te2 = j;
            }
            switch (te1 - te2) {
                case -1:// 甲胜
                case 2:
                    num[0]++;  bt[te1][0]++;  break;

                case 1:// 乙胜
                case -2:

                    num[2]++;  bt[te2][1]++;  break;
                default:// 平局
                    num[1]++; break;
            }
        }
        System.out.printf("%d %d %d\n", num[0], num[1], num[2]);
        System.out.printf("%d %d %d\n", num[2], num[1], num[0]);
        for (int j = 0; j < 2; j++) {
            int max = bt[0][j];
            int ww = 0;
            for (int i = 1; i < 3; i++) {
                if (bt[i][j] > max) {
                    max = bt[i][j];
                    ww = i;
                }
            }
            System.out.print(b[ww]);
            if (j != 1)
                System.out.print(" ");
        }
    }
}
