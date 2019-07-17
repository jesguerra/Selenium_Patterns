import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Utilidades {

    @Test
    public void test2() {

        List<String> list = new ArrayList<String>();
        list.add("tester1");
        list.add("tester2");
        list.add("tester3");
        list.add("tester4");
        String array[] = {"esguerra", "cortes", "johnathan", "alexander"};

        for (String elemento : array)
            System.out.println(elemento);

        for (String elemtos2 : list
        ) {
            System.out.println(elemtos2);

        }
    }
}
