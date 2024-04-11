import java.io.IOException;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> list1 = new CustomList<>();
        list1.add(3);
        list1.add(9);
        list1.add(6);

        List<Integer> list2 = list1.stream()
                .filter((item) -> item > 5)
                .collect(Collectors.toList());

        for(Integer i : list2) {
            System.out.println(i);
        }

        Integer x = 4;
        Double y = 4.5;

        Class xClass = x.getClass();
        Class yClass = y.getClass();

        if(xClass.equals(yClass)) {

        }
    }
}
