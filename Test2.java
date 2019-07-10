/*
有个小孩正在上楼梯，楼梯有n阶台阶，小孩一次可以上1阶、2阶、3阶。请实现一个方法，计算小孩有多少种上楼的方式。为了防止溢出，请将结果Mod 1000000007

给定一个正整数int n，请返回一个数，代表上楼的方式数。保证n小于等于100000。

测试样例1：
1
返回：1
测试样例2：
3
返回：4
测试样例3：
4
返回：7
*/
package written_test0710;

//上楼梯
public class Test2 {
    public static void main(String[] args) {
        GoUpstairs s = new GoUpstairs();
        int n = 159;
        System.out.println(s.countWays(n));
    }
}


class GoUpstairs {
    public int countWays(int n) {
        int a[] = { 1, 1, 2 };
        if (n < 3) {
            return a[n];
        }
        int i = 3;
        for (; i <= n; i++) {
            int b = 0;
            for (int j = 0; j < 3; j++) {
                b += a[(i + j) % 3];
                b %= 1000000007;
            }
            a[i % 3] = b;
        }
        return a[(i - 1) % 3];
    }
}