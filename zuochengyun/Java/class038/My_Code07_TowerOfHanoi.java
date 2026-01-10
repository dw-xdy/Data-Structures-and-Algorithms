package class038;

/**
 * @author 冯肖伟
 * @version 1.0
 */
public class My_Code07_TowerOfHanoi {
    public static void f(int i, String from, String to, String other) {
        if (i == 1) {
            System.out.println("将 1 圆盘从 " + from + " 移动到 " + to);
            return;
        }
        f(i - 1, from, other, to);
        System.out.println("将 " + i + " 圆盘从 " + from + " 移动到 " + to);
        f(i - 1, other, to, from);
    }

    public static void main(String[] args) {
        f(3, "左", "右", "中");
    }
}
