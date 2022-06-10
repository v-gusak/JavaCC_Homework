import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ListWrapper<T> {
    private List<T> list;

    public ListWrapper() {
        this.list = null;
    }

    public ListWrapper(List<T> list) {
        this.list = list;
    }

    public void addOtherCollection(Collection<? extends T> otherCollection) {
        for (T item : otherCollection) {
            list.add(item);
        }
    }

    public int removeElementsByCollection(Collection<? extends T> collection) {
        Objects.requireNonNull(collection);
        int count = 0;

        for (Iterator<?> i = list.iterator(); i.hasNext(); ) {
            if (collection.contains(i.next())) {
                i.remove();
                count++;
            }
        }

        return count;
    }

    public int countDuplicates(Collection<? extends T> collection) {
        Objects.requireNonNull(collection);
        int count = 0;

        for (Iterator<?> i = list.iterator(); i.hasNext(); ) {
            if (collection.contains(i.next())) {
                count++;
            }
        }

        return count;
    }

    public List<T> getList() {
        return this.list;
    }

    public T getElement(int index) {
        return this.list.get(index);
    }

    public String beautyString() {
        StringBuffer sb = new StringBuffer("[");

        for (T item : list) {
            sb.append("\"" + item + "\", ");
        }

        sb.delete(sb.length() - 1, sb.length());

        return sb.toString();
    }

    public static <E> ListWrapper<E> fromElements(E... elements) {
        ListWrapper<E> listWrapper = new ListWrapper<>();

        listWrapper.addOtherCollection(List.of(elements));

        return listWrapper;
    }
}
