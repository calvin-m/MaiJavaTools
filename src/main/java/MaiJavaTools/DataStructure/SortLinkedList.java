package MaiJavaTools.DataStructure;


public class SortLinkedList {
    private class Node{
        int value;
        Node next;
        public Node (int value){
            this.value = value;
        }
    }

    private Node head = new Node(0); // dummy node; value doesn't matter

    /*
    add element to the last position of the linked list
     */
    public void add(int value){
        Node newNode = new Node(value);
        Node node = this.head;
        while(null != node.next){
            node = node.next;
        }
        node.next = newNode;
    }

    /*
    remove the last element of the linked list
     */
    public void remove(){
        Node node = this.head;
        Node prevNode = null;
        while(null != node.next){
            prevNode = node;
            node = node.next;
        }

        if(null != prevNode){
            prevNode.next = null;
        }
    }



    public String toString(){
        StringBuilder sb = new StringBuilder();
        Node node = this.head;
        String separator = " -> ";
        while (null != node.next){
            node = node.next;
            sb.append(node.value).append(separator);
        }
        //start - inclusive
        //end - exclusive
        sb.delete(sb.length() - separator.length(), sb.length());

        return sb.toString();
    }

    public void sort(){
        int size = 0;
        Node node = this.head;
        while (null != node.next){
            node = node.next;
            size++;
        }

        if(size > 1){
            node = this.head.next; //reset
            this.head.next = sort(node, size);
        }
    }

    private Node sort(Node node, int size){
        if(size == 1){
            return new Node(node.value);
        }

        int mid = size/2;
        Node left=node, right=node;
        for(int i=0; i < mid; i++){
            right = right.next;
        }

        Node sortedLeft = sort(left, mid);
        Node sortedRight = sort(right, size-mid);
        return merge(sortedLeft, sortedRight);

    }

    private Node merge(Node left, Node right){
        Node newHead = new Node(0);
        Node cur = newHead;
        while(null != left && null != right){
            if(left.value < right.value){
                cur = copyNode(left, cur);
                left = left.next;
            }
            else{
                cur = copyNode(right, cur);
                right = right.next;
            }
        }

        while(null != left){
            cur = copyNode(left, cur);
            left = left.next;
        }

        while(null != right){
            cur = copyNode(right, cur);
            right = right.next;
        }
        return newHead.next;
    }

    private Node copyNode(Node node, Node parent){
        Node newNode = new Node(node.value);
        parent.next = newNode;
        return newNode;
    }
}
