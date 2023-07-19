import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        LinkedContainer<String> stringLinked = new LinkedContainer<>();
        stringLinked.addLast("abc");
        stringLinked.addLast("def");
        stringLinked.addFirst("tuy");
        System.out.println(stringLinked.size());
        System.out.println(stringLinked.getElementByIndex(0));
        System.out.println("=====");
        stringLinked.addFirst("jdkjkr");
        stringLinked.addFirst("jnj");
        stringLinked.addFirst("yger");
        for (String s: stringLinked){
            System.out.println(s);
        }
        System.out.println("==========");
        Iterator iterator = stringLinked.descendingIterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
