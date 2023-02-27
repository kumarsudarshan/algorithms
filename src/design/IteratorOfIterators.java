package design;

import java.util.Iterator;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

/*
Design Iterator of iterators :
where we have list of iterators is sorted order,
and we need to insert in sorted manner in one Iterator
 */
public class IteratorOfIterators<T extends Comparable> implements Iterator<T> {

    public static void main(String... args) {
        // Using Integer - since integer is comparable
//        Iterator<Integer> a = Arrays.asList(1, 2, 3, 14).iterator();
//        Iterator<Integer> b = Arrays.asList(10, 11, 12).iterator();
//        Iterator<Integer> c = Arrays.asList(97, 98, 99).iterator();
//
//        Iterator<Integer> ii = new IteratorOfIterators<Integer>(Arrays.asList(a, b, c));
//
//        while (ii.hasNext())
//            System.out.println(ii.next());

        Iterator<Student> a = Arrays.asList(new Student(1, "Kumar"), new Student(2, "Sudarshan")).iterator();
        Iterator<Student> b = Arrays.asList(new Student(5, "Akash"), new Student(89, "Nishant")).iterator();
        Iterator<Student> c = Arrays.asList(new Student(3, "Atul"), new Student(45, "Pyne")).iterator();
        Iterator<Student> ii = new IteratorOfIterators<Student>(Arrays.asList(a, b, c));

        while (ii.hasNext())
            System.out.println(ii.next());

    }

    private PriorityQueue<T> minHeap;

    public IteratorOfIterators(List<Iterator<T>> iterators) {
        minHeap = new PriorityQueue<>((a, b) -> a.compareTo(b));
        for (Iterator<T> itr : iterators) {
            while (itr.hasNext()) {
                minHeap.add(itr.next());
            }
        }
    }

    public boolean hasNext() {
        return minHeap.size() > 0;
    }

    public T next() {
        return minHeap.poll();
    }
}


class Student implements Comparable {
    int rollNo;
    String name;

    public Student(int rollNo, String name) {
        this.rollNo = rollNo;
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        return this.name.compareTo(((Student) o).name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", name='" + name + '\'' +
                '}';
    }
}
