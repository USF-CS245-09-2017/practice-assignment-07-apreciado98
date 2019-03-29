public class LinkedList<T> implements List<T> {
    Node<T> head = null;
    int size=0;

    public void add(T item) {
        if (head == null) { //if empty
            Node<T> newNode = new Node<T>(item);
            head = newNode; //make the head the new item
            size++; //increase size of list
        }
        //get prev to last item, create node, update previous next, update size
        else {
            Node<T> prev = head;
            while(prev.get_next()!=null) {
                prev = prev.get_next();
            }
            Node<T> newNode = new Node<T>(item);
            prev.set_next(newNode);
            size++;
        }
    }

    public void add(int pos, T item){
        Assert.not_false(pos<=size+1 && pos>=0);
        size++; //increase size
        if(pos==0){ //if adding to head
            Node<T> node = new Node<T>(item);
            node.set_next(head);
            head=node;
        }
        else{
            Node<T> prev=head; //create prev node
            for(int i=0;i<pos-1;i++){ //getting prev position
                prev=prev.get_next();
            }
            Node<T> node=new Node<T>(item);
            node.set_next(prev.get_next());
            prev.set_next(node);
        }
    }

    public T get(int pos){
        Assert.not_false(pos>=0 && pos<=size);
        Node<T> curr=head;
        for(int i=0;i<pos;i++){
            curr=curr.get_next();
        }
        return curr.get_data();
    }

    public T remove(int pos){
        Assert.not_false(pos>=0 && pos<size);
        if(pos==0){ //removing head
            Node<T> curr=head;
            head=curr.get_next();
            size--;
            return curr.get_data();
        }
        else{ //otherwise
            Node<T> prev=head;
            for(int i=0;i<pos-1;i++){
                prev=prev.get_next();
            }
            Node<T> curr=prev.get_next();
            prev.set_next(curr.get_next());
            size--;
            return curr.get_data();
        }
    }

    public int size(){
        return size;
    }
}
