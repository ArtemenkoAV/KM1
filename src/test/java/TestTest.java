import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestTest {
    NewList<String> list = new NewList<>();
    NewList<Integer> list1 = new NewList<>();


    @Test
    public void addAndSizeTest() {
        list.add("Jack");
        list.add("Alex");
        list.add("Max");
        list.add("Anna");
        list.add("Klim");
        list.add("Michel");
        Assertions.assertEquals(6, list.size());
    }

    @Test
    public void addAllAndRemoveTest() {
        list.addAll(List.of("Jack","Alex","Max","Anna","Klim","Michel"));
        list.remove(3);
        list.remove("Michel");
        Assertions.assertEquals(4, list.size());
    }

    @Test
    public void addFirst() {
        list1.addAll(List.of(1,2,3,4,5,6));
        list1.addFirst(10);
        Assertions.assertEquals(10, list1.get(0));
    }

    @Test
    public void addLastAndContainsTest() {
        list.addAll(List.of("Jack","Alex","Max","Anna","Klim","Michel"));
        list.addFirst("Evgeniy");
        Assertions.assertTrue(list.contains("Evgeniy"));
    }

    @Test
    public void iteratorTest() {
        list1.addAll(List.of(0,1,2,3,4,5,6));
        int i = 0;
        Iterator<Integer> iter = list1.iterator();
        while (iter.hasNext()){
            int item = iter.next();
            Assertions.assertEquals(i, item);
            i++;
        }
    }

    @Test
    public void cleanTest() {
        list1.addAll(List.of(0,1,2,3,4,5,6));
        list1.clear();
        Assertions.assertEquals(0, list1.size());
        }


}