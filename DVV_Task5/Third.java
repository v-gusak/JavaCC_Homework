import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.TreeSet;

public class Third {
    public static String getRandomString(int length){
        String str = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < length; i++){
            int number = random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        HashSet<String> hashSet = new HashSet<String>();
        TreeSet<String> treeSet = new TreeSet<String>();

        String str = "";

        // filling collections
        for (int i = 0; i < 1000000; i++) {
            if (i == 500000) {
                str = getRandomString(10);

                hashSet.add(str);
                treeSet.add(str);
            } else {
                hashSet.add(getRandomString(10));
                treeSet.add(getRandomString(10));
            }
        }

        // search an element in HashSet
        LocalDateTime start = LocalDateTime.now();

        hashSet.contains(str);

        LocalDateTime end = LocalDateTime.now();
        long difference = ChronoUnit.MILLIS.between(start, end);

        System.out.println("Search an element in HashSet = " + difference + " ms");

        // search an element in Treeset
        start = LocalDateTime.now();

        treeSet.contains(str);

        end = LocalDateTime.now();
        difference = ChronoUnit.MILLIS.between(start, end);

        System.out.println("Search an element in TreeSet = " + difference + " ms");
    }
}
