import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

public class First {
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
        ArrayList<String> arrayList = new ArrayList<String>();
        LinkedList<String> linkedList = new LinkedList<String>();

        // filling collections
        for (int i = 0; i < 1000000; i++) {
            arrayList.add(getRandomString(10));
            linkedList.add(getRandomString(10));
        }

        // insertion at the end (ArrayList)
        LocalDateTime start = LocalDateTime.now();

        arrayList.add("To the end");

        LocalDateTime end = LocalDateTime.now();
        long difference = ChronoUnit.MILLIS.between(start, end);

        System.out.println("Insert at the end [ArrayList] = " + difference + " ms");

        // insertion at the end (LinkedList)
        start = LocalDateTime.now();

        linkedList.add("To the end");

        end = LocalDateTime.now();
        difference = ChronoUnit.MILLIS.between(start, end);

        System.out.println("Insert at the end [LinkedList] = " + difference + " ms\n");

        // insertion at the beginning (ArrayList)
        start = LocalDateTime.now();

        arrayList.add(0, "To the beginning");

        end = LocalDateTime.now();
        difference = ChronoUnit.MILLIS.between(start, end);

        System.out.println("Insert at the beginning [ArrayList] = " + difference + " ms");

        // insertion at the beginning (LinkedList)
        start = LocalDateTime.now();

        linkedList.add(0, "To the beginning");

        end = LocalDateTime.now();
        difference = ChronoUnit.MILLIS.between(start, end);

        System.out.println("Insert at the beginning [LinkedList] = " + difference + " ms\n");

        // deleting random element by index (ArrayList)
        start = LocalDateTime.now();

        arrayList.remove(50);

        end = LocalDateTime.now();
        difference = ChronoUnit.MILLIS.between(start, end);

        System.out.println("Deleting random element by index [ArrayList] = " + difference + " ms");

        // deleting random element by index (LinkedList)
        start = LocalDateTime.now();

        linkedList.remove(50);

        end = LocalDateTime.now();
        difference = ChronoUnit.MILLIS.between(start, end);

        System.out.println("Deleting random element by index [LinkedList] = " + difference + " ms\n");

        // iteration
        start = LocalDateTime.now();

        for (String str : arrayList) {
            continue;
        }

        end = LocalDateTime.now();
        difference = ChronoUnit.MILLIS.between(start, end);

        System.out.println("Iteration [ArrayList] = " + difference + " ms");

        // iteration
        start = LocalDateTime.now();

        for (String str : linkedList) {
            continue;
        }

        end = LocalDateTime.now();
        difference = ChronoUnit.MILLIS.between(start, end);

        System.out.println("Iteration [LinkedList] = " + difference + " ms");
    }
}
