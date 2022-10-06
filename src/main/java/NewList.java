import java.util.*;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;

public class NewList<E> implements List<E> {

    private Node first;
    private Node last;
    private int capacity;
    private int max =5;
    private int size;


    private static class Node {
        Object[] data;
        Node next;
        Node prev;

        public Node(Node prev, Object[] data, Node next) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }


    public NewList() {
        last = new Node(null, new Object[5], null);
        first = last;
    }
    public void addFirst(E e){
        if(max >=5){
            max = 0;
            Node node = new Node(null, new Object[5], first);
            first.prev = node;
            first = node;
        }
        first.data[4- max] = e;
        max++;
        size++;
    }

    public void addLast(E e){
        if(capacity<5){
            last.data[capacity] = e;
            capacity++;
        }
        else{
            Node nextNode = new Node(last, new Object[5], null);
            last.next = nextNode;
            nextNode.data[0] = e;
            last = nextNode;
            capacity = 1;
        }
        size++;
    }


    @Override
    public boolean add(E e) {
        addLast(e);
        return true;
    }

    @Override
    public Object[] toArray() {
        Object[] result = new Object[size];
        for (int i=0; i<size; i++){
            result[i] = get(i);
        }
        return result;
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        Object[] arr = c.toArray();
        for (Object o: arr)
            addLast((E) o);

        return true;
    }
    @Override
    public E get(int index) {
        Node node = first;
        for (int i = 0; i < (index + 5 - max)/5; i++) {
            node = node.next;
        }
        return (E) node.data[(index + 5 - max) % 5];

    }

    @Override
    public E remove(int index) {
        Node node = first;
        Object removedObject = get(index);

        if (index > size) {
            return null;
        } else {
            for (int i = 0; i < (index + 5 - max)/5; i ++) {
                node = node.next;
            }
            Object[] array = toArray();
            last = node;
            node.next = null;
            size = index;
            capacity = (index + 5 - max)%5;

            for (int i = index+1; i < array.length; i++) {
                addLast((E) array[i]);
            }
        }
        return (E) removedObject;
    }


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean remove(Object o) {
        int index = 0;
        for(int i=0; i < size; i++) {
            if (get(i).equals(o)) {
                index = i;
                break;
            }
            else index = -1;
        }
        if (index == -1) {
            return false;
        } else {
            remove(index);
            return true;
        }
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for(int i=0; i < size; i++) {
            if (get(i).equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> iterator = new Iterator<E>() {
            int nextIndex;

            @Override
            public boolean hasNext() {
                return nextIndex<size;
            }

            @Override
            public E next() {
                E e = get(nextIndex);
                nextIndex++;
                return e;
            }
        };

        return iterator;
    }

    @Override
    public void clear() {
        first =new Node(null, new Object[] {},null);
        capacity=0;
        max =5;
        size=0;
    }
    @Override
    public boolean removeAll(Collection<?> c) {
        Object[] arr = c.toArray();
        for (Object o: arr)
            remove(o);
        return true;
    }

    @Override
    public void forEach(Consumer<? super E> action) {
        List.super.forEach(action);
    }



    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public <T> T[] toArray(IntFunction<T[]> generator) {
        return List.super.toArray(generator);
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends E> c) {

        return false;
    }

    @Override
    public boolean removeIf(Predicate<? super E> filter) {
        return List.super.removeIf(filter);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void replaceAll(UnaryOperator<E> operator) {
        List.super.replaceAll(operator);
    }

    @Override
    public void sort(Comparator<? super E> c) {
        List.super.sort(c);
    }

    @Override
    public E set(int index, E element) {
        return null;
    }

    @Override
    public void add(int index, E element) {

    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

    @Override
    public Spliterator<E> spliterator() {
        return List.super.spliterator();
    }

    @Override
    public Stream<E> stream() {
        return List.super.stream();
    }

    @Override
    public Stream<E> parallelStream() {
        return List.super.parallelStream();
    }
}
