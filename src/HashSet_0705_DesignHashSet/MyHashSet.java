package HashSet_0705_DesignHashSet;

public class MyHashSet {
    Node head;

    public MyHashSet() {
        head = null;
    }

    public Node lookForTail(Node head){
        Node temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }
        return temp;

    }
    public Node add(int key) {
        if(head == null){
            head = new Node(key);
            return head;
        }
        boolean doesExists=contains(key);

        Node temp = lookForTail(head);
        if(!doesExists){


            temp.next=new Node(key);
            return temp.next;
        }
        return temp;
    }

    public void remove(int key) {
        if(head==null) return;
        if(head.val==key){
            head=head.next;
            return;
        }

        Node temp=head;
        while(temp.next!=null){
            if(temp.next.val==key){
                temp.next=temp.next.next;
            } else {
                temp=temp.next;
            }
        }
    }

    public boolean contains(int key) {
        if(head==null) return false;
        if(head.val==key) return true;

        Node temp=head;
        while(temp.next!=null){
            if(temp.next.val==key) return true;
            temp=temp.next;
        }
        return false;
    }

    public static void main(String[] args) {
        MyHashSet myHashSet = new MyHashSet();

        myHashSet.add(1);
        myHashSet.add(2);
        myHashSet.add(3);
        myHashSet.remove(1);
        boolean param_3 = myHashSet.contains(2);

        System.out.println(myHashSet.add(1).val);
        System.out.println(myHashSet.add(2).val);
        System.out.println(param_3);
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */
