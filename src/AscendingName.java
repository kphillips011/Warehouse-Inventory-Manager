import java.util.Comparator;
import java.util.Map;

public class AscendingName implements Comparator<Map.Entry<Integer, Product>> {
    public int compare(final Map.Entry<Integer, Product> l, final Map.Entry<Integer, Product> r) {
        return l.getValue().getName().compareTo(r.getValue().getName());
    }
}
