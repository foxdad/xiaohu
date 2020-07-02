import java.util.Random;

/**
 * ClassName: RandomTest
 * Description:
 * date: 2020/6/10 14:35
 *
 * @author 刘腾
 * @since JDK 1.8
 */
public class RandomTest {
    public static void main(String[] args) {
        Random random = new Random();
        int num = 1000;
        for (int i = 0 ; i<1000;i++) {
            int res = random.nextInt(8999) + num;
            System.out.println(res);
        }

    }
}
