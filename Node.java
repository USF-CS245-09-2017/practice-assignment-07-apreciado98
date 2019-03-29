public class Node<T> { //node class is used by linkedlist
    public T data;
    public Node next;

    public Node(T data) {
        this.data = data;
        next = null;
    }
    public void set_next(Node next) {
        this.next = next;
    }
    public Node<T> get_next(){
        return next;
    }
    public void set_data(T data){
        this.data=data;
    }
    public T get_data(){
        return data;
    }
}