package bai4;

public class MyLinkedList<E> {

    class Node {
        public Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }

    private int numNodes = 0;
    private Node head;

    public MyLinkedList(Object data) {
        head=new Node(data);
        numNodes++;
    }

    public void addFirst(E element) {
        Node temp = head;
        head = new Node(element);
        head.next = temp;
        numNodes++;
    }

    public void addLast(E element) {
        if (head==null){
            addFirst(element);
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(element);
        numNodes++;
    }

    public void add(int index,E element) {
        if (index > numNodes) {
            addLast(element);
            return;
        }
        if (numNodes == 0||index==0) {
            addFirst(element);
            return;
        }
        Node temp = head;
        Node holder;
        for (int i = 0; i < index - 1 && temp.next != null; i++) {
            temp=temp.next;
        }
        holder=temp.next;
        temp.next=new Node(element);
        temp.next.next=holder;
        numNodes++;
    }
    public E remove(int index){
        Node temp=head;
        Node holder=null;
        if (index==0){
            head=temp.next;
            numNodes--;
            return (E) temp.getData();
        }
        if (index>=numNodes){
            for (int i=0;i<numNodes-1;i++){
                temp=temp.next;
            }
            holder=temp.next;
            temp.next=null;
            numNodes--;
            return (E) holder.getData();
        }
        for (int i=0;i<numNodes;i++){
            if (i==index-1){
                holder=temp.next;
                temp.next=holder.next;
                numNodes--;
                return (E) holder.getData();
            }
            temp=temp.next;
        }
        return null;
    }
    public int size(){
        return numNodes;
    }
    public boolean contains(E element){
        Node temp=head;
        for (int i=0;i<numNodes;i++){
            if (temp.getData().equals(element)){
                return true;
            }
            temp=temp.next;
        }
        return false;
    }
    public int indexOf(E element){
        Node temp=head;
        for (int i=0;i<numNodes;i++){
            if (temp.getData().equals(element)){
                return i;
            }
            temp=temp.next;
        }
        return -1;
    }
    public E getFirst(){
        return (E) head.getData();
    }
    public E getLast(){
        Node temp=head;
        while (temp.next!=null){
            temp=temp.next;
        }
        return (E) temp.getData();
    }
    public E get(int index){
        if(index==0){
            getFirst();
        }
        if(index==numNodes-1){
            getLast();
        }
        Node temp=head;
        for (int i=0;i<numNodes;i++){
            if (i==index){
                return (E) temp.getData();
            }
            temp=temp.next;
        }
        return null;
    }
    public void clear(){
        numNodes=0;
    }
    public void offer(E element){
        if (head==null){
            head = new Node(element);
            numNodes++;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(element);
        numNodes++;
    }
    public E peek(){
        if (head==null){
            return null;
        }
        return (E) head.getData();
    }
}
