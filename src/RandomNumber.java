import java.util.concurrent.ThreadLocalRandom;

public class RandomNumber {
    public RandomNumber() {
        int Num = ThreadLocalRandom.current().nextInt(1,1000);
        System.out.println(Num);
    }
}
