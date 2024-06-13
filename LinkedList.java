package dataStruture;

public class LinkedList {

    private Node head;

    private Node tail;

    private int length;



    class Node {

        String data;

        Node next;


        Node(String data) {
            this.data = data;
        }

    }

    public LinkedList(String data){
        length = 1;
        Node newNode = new Node(data);
        head = newNode;
        tail = newNode;
    }

    public void getHead() {
        if (this.head == null) {
            System.out.println("Lista vazia");
        } else {
            System.out.println("Head: " + head.data);
        }

    }

    public void getTail() {
        if (this.tail == null) {
            System.out.println("Lista vazia");
        } else {
            System.out.println("Head: " + tail.data);
        }

    }

    public void getLength() {
        System.out.println("Length: " + this.length);

    }


    public void makeEmpty(){
        head = null;
        tail = null;
        length = 0;
    }


        // print da lista
    public void print() {
        System.out.println("########################");
        Node temp = this.head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
        System.out.println("########################");
    }

        //append para colocar um valor em uma posição especifia da lista
    public void append(String data) {
        Node newNode = new Node (data);
        if (length == 0 ){
            head = newNode;
            tail = newNode;
        }else {
            tail.next = newNode;
            tail = newNode;
        }
        length ++;
    }

    public Node removeLast() {
        if (length == 0) return null;
        Node pre = head;
        Node temp = null;

        while(pre.next != tail) {
            pre = pre.next;
        }

        temp = tail;
        tail = pre;
        tail.next = null;

        length --;
        if (length == 0) {
            head = null;
            tail = null;
        }

        return temp;

    }


    // colocar um valor no inicio da lista

    public void prepend (String data) {
        Node newNode = new Node(data);
        if (length == 0) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length ++;
    }

        //remover o primeiro elemento
    public Node removeFirst() {
        if (length == 0) return null;
        Node temp = head;
        head = head.next;
        temp.next = null;
        length --;
        if (length == 0) {
          head = null;
          tail = null;
        }
        return temp;
    }

    // ler de uma posição especifica, começa do 0
    public Node get(int index) {
        if (index < 0 || index >= length) return null;
        Node temp = head;
        for(int i = 0; i<index; i++) {
            temp = temp.next;
        }
        return temp;
    }

    public boolean insert (int index, String data) {
        if (index < 0 || index > length) return false;
        if (index == 0) {
            prepend(data);
            return true;
        }
        if (index == length) {
            append(data);
            return true;
        }
        Node newNode = new Node (data);
        Node temp = get(index - 1);
        newNode.next = temp.next;
        temp.next = newNode;
        length++;
        return true;
    }

    public boolean set(int index, String data) {
        Node temp = get(index);
        if (temp != null) {
            temp.data = data;
            return true;
        }
        return false;
    }

    // remove de uma posição espeifica
    public Node remove(int index) {
        if (index < 0 || index >= length) return null;
        if (index == 0) return removeFirst();
        if (index == length -1) return removeLast();

        Node prev = get(index - 1);
        Node temp = prev.next;

        prev.next = temp.next;
        temp.next = null;
        length--;

        return temp;
    }



    public static void main(String[] args) {
        LinkedList list = new LinkedList("elemento 1");
        list.append("elemento 2");
        list.append("elemento 3");
        list.prepend("elemento 0");

        list.remove(2);
        list.print();

//        list.insert(3, "elemento 2.5");

//        System.out.println(list.get(2).data);

//        System.out.println(list.removeFirst().data);
//        list.print();
//
//        list.set(1, "elemento 0.5");
//        list.print();

//        list.getHead();
//        list.getTail();
//        list.getLength();
//        list.print();
    }




}
