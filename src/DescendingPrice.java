import java.util.Comparator;
import java.util.Map;

public class DescendingPrice implements Comparator<Map.Entry<Integer, Product>> {
        public int compare(final Map.Entry<Integer,Product> l, final Map.Entry<Integer,Product> r) {

            if (l.getValue().getPrice() > r.getValue().getPrice()) return -1;
            else if (l.getValue().getPrice() < r.getValue().getPrice()) return +1;
            else return l.getKey().compareTo(r.getKey());
        }
}
