import java.util.Comparator;
import java.util.List;

// based on https://stackoverflow.com/questions/35761864/java-sort-list-of-lists
class ListComparator<T extends Comparable<T>> implements Comparator<List<T>> {
    @Override
    public int compare(List<T> list1, List<T> list2) {
        for (int i = 0; i < Math.min(list1.size(), list2.size()); i++) {
            int c = list1.get(i).compareTo(list2.get(i));
            if (c != 0) {
                return c;
            }
        }
        return Integer.compare(list1.size(), list2.size());
    }
}