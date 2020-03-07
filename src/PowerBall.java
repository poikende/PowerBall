import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class PowerBall {
    public static ArrayList<Integer> list1 = new ArrayList<>();
    public static ArrayList<Integer> list2 = new ArrayList<>();
    public static ArrayList<Integer> list3 = new ArrayList<>();
    public static ArrayList<Integer> list4 = new ArrayList<>();

    public static void main(String[] args) {
        getRandomFirst(1, 69, 5);
        getRandomSecond(1, 26, 1);
        getRandomFirst1(1, 69, 5);
        getRandomSecond2(1, 26, 1);
        /*System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
        System.out.println(list4);*/
        compareAndGetResult();
    }

    public static void getRandomFirst(int sampleRangeStart, int sampleRangeEnd, int amount) {
        for (int i = sampleRangeStart; i <= sampleRangeEnd; i++) {
            list1.add(i);
        }
        int[] a = new int[sampleRangeEnd];
        for (int count = 0; count < a.length - amount; count++) {
            a[count] = list1.remove((int) (Math.random() * list1.size()));
        }
    }

    public static void getRandomSecond(int sampleRangeStart, int sampleRangeFinish, int amount) {
        for (int i = 0; i < amount; i++) {
            //Если нужно несколько, то Не выдаст уникальные числа. Поменять.
            list2.add(ThreadLocalRandom.current().nextInt(sampleRangeStart, sampleRangeFinish + 1));
        }
    }

    public static void getRandomFirst1(int sampleRangeStart, int sampleRangeEnd, int amount) {
        for (int i = sampleRangeStart; i <= sampleRangeEnd; i++) {
            list3.add(i);
        }
        int[] a = new int[sampleRangeEnd];
        for (int count = 0; count < a.length - amount; count++) {
            a[count] = list3.remove((int) (Math.random() * list3.size()));
        }
    }

    public static void getRandomSecond2(int sampleRangeStart, int sampleRangeFinish, int amount) {
        for (int i = 0; i < amount; i++) {
            //Если нужно несколько, то Не выдаст уникальные числа. Поменять.
            list4.add(ThreadLocalRandom.current().nextInt(sampleRangeStart, sampleRangeFinish + 1));
        }
    }

    public static void compareAndGetResult() {
        list1.retainAll(list3);
        list2.retainAll(list4);
        if (list1.size() == 5 && list2.size() == 1) {
            System.out.println("All 6 - Jackpot");
        } else if (list1.size() == 5 && list2.size() == 0) {
            System.out.println("5-0 = 1 million $$$");
        } else if (list1.size() == 4 && list2.size() == 1) {
            System.out.println("4-1 = 50 000 $$$");
        } else if (list1.size() == 4 && list2.size() == 0) {
            System.out.println("4-0 = 100 $$$");
        } else if (list1.size() == 3 && list2.size() == 1) {
            System.out.println("3-1 = 100 $$$");
        } else if (list1.size() == 3 && list2.size() == 0) {
            System.out.println("3-0 = 7 $$$");
        } else if (list1.size() == 2 && list2.size() == 1) {
            System.out.println("2-1 = 7 $$$");
        } else if (list1.size() == 1 && list2.size() == 1) {
            System.out.println("1-1 = 4 $$$");
        } else if (list1.size() == 0 && list2.size() == 1) {
            System.out.println("0-1 = 4 $$$");
        } else
            System.out.println("No luck");
    }
}

