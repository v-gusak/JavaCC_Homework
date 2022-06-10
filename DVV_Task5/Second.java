import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class Second {
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
        LinkedList<String> linkedList = new LinkedList<String>();
        HashSet<String> hashSet = new HashSet<String>();

        String str = "";

        // filling collections
        for (int i = 0; i < 1000000; i++) {
            if (i == 950000) {
                str = getRandomString(10);

                linkedList.add(str);
                hashSet.add(str);
            } else {
                linkedList.add(getRandomString(10));
                hashSet.add(getRandomString(10));
            }
        }

        // search an element in LinkedList
        LocalDateTime start = LocalDateTime.now();

        linkedList.contains(linkedList.get(950000));

        LocalDateTime end = LocalDateTime.now();
        long difference = ChronoUnit.MILLIS.between(start, end);

        System.out.println("Search an element in LinkedList = " + difference + " ms");

        // search an element in HashSet
        start = LocalDateTime.now();

        hashSet.contains(linkedList.get(950000));

        end = LocalDateTime.now();
        difference = ChronoUnit.MILLIS.between(start, end);

        System.out.println("Search an element in HashSet = " + difference + " ms");
    }
}
