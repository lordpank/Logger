import java.util.ArrayList;
import java.util.List;

public class Filter {
    protected int trashHold;

    public Filter(int trashHold) {
        this.trashHold = trashHold;
    }

    public List<Integer> filterOut(List<Integer> source) {
        Logger logger = Logger.getInstance();
        List<Integer> result = new ArrayList<>();

        logger.log("Запуск фильтрации");

        for (int i = 0; i < source.size(); i++) {
            if (source.get(i) < trashHold) {
                logger.log("Значения \"" + source.get(i) + "\" не проходит");
            } else {
                logger.log("Значения \"" + source.get(i) + "\" проходит");
                result.add(source.get(i));
            }
        }

        logger.log("Прошло фильтр " + result.size() + " элемента из " + source.size());

        return result;
    }
}
