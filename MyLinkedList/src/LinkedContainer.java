import java.util.Iterator;

public class LinkedContainer<E> implements Linked<E>, Iterable<E>, DescendingIterator<E> {
    private Node<E> fstNode;
    private Node<E> lstNode;
    private int size = 0;

    public LinkedContainer() {
            lstNode = new Node<>(null, null, fstNode);
            fstNode = new Node<>(null, lstNode, null);
        }

    @Override
    public void addLast(E e) {
        Node<E> prev = lstNode;
        prev.setCurrentElement(e);
        lstNode = new Node<E>(null,null,prev);
        prev.setNextElement(lstNode);
        size++;
    }

    @Override
    public void addFirst(E e) {
        Node<E> next = fstNode;
        next.setCurrentElement(e);
        fstNode = new Node<>(null,next, null);
        next.setPrewElement(fstNode);
        size++;
     }

    @Override
    public int size() {
        return size;
    }

    @Override
    public E getElementByIndex(int counter) {
        Node<E> target = fstNode.getNextElement();
        for (int i = 0; i < counter; i++) {
            target = getNextElement(target);
        }
        return target.getCurrentElement();
    }

    private Node<E> getNextElement(Node<E> current){
        return current.getNextElement();
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int counter = 0;
            @Override
            public boolean hasNext() {
                return counter<size;
            }

            @Override
            public E next() {
                return getElementByIndex(counter++);
            }
        };
    }

    @Override
    public Iterator<E> descendingIterator() {
        return new Iterator<E>() {
            int counter = size-1;
            @Override
            public boolean hasNext() {
                return counter>=0;
            }

            @Override
            public E next() {
                return getElementByIndex(counter--);
            }
        };
    }

    private class Node<E>{
            private E currentElement;
            private Node<E> nextElement;
            private Node<E> prewElement;

            public Node(E currentElement,Node<E> nextElement, Node<E> prewElement) {
                this.currentElement = currentElement;
                this.nextElement = nextElement;
                this.prewElement = prewElement;
            }

            public E getCurrentElement() {
                return currentElement;
            }

            public void setCurrentElement(E currentElement) {
                this.currentElement = currentElement;
            }

            public Node<E> getNextElement() {
                return nextElement;
            }

            public void setNextElement(Node<E> nextElement) {
                this.nextElement = nextElement;
            }

            public Node<E> getPrewElement() {
                return prewElement;
            }

            public void setPrewElement(Node<E> prewElement) {
                this.prewElement = prewElement;
            }
        }
    }




