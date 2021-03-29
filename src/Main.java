public class Main {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();


        for (int i = 0; i <  4; i++) {
            linkedList.addFirst(i);
        }

        System.out.println(linkedList.removeLast());
        System.out.println(linkedList.removeLast());
        System.out.println(linkedList.removeLast());
        System.out.println(linkedList.removeLast());

        System.out.println();

    }
}
