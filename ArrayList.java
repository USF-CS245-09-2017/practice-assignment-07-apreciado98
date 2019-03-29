public class ArrayList<T> implements List<T> {
    public Object[] tempArray = new Object[10];
    public T[] arr=(T[])tempArray;
    public int size=0;

    public void add(T item){
        try{
            Assert.not_false(size<arr.length);
        }
        catch(Exception e){ //if array is too small, we double the size
            grow();
        }
        arr[size] = item;
        size++;
    }
    public void add(int pos, T item){
        try{
            Assert.not_false(pos<arr.length);
        }
        catch(Exception e){ //if array is too small, we double the size
            grow();
        }
        for(int i=size;i>pos;i--){
            arr[i]=arr[i-1]; //decreases indices by 1
        }
        arr[pos]=item;
        size++;

    }
    public T get(int pos){
        Assert.not_false(pos >= 0 && pos < size); //checking validity
        return arr[pos]; //just returns position
    }
    public T remove(int pos){
        Assert.not_false(pos >= 0 && pos < size); //checking

        T item = arr[pos];
        for (int i = pos + 1; i < size; i++)
        {
            arr[i-1] = arr[i];
        }
        size--;
        return item;
    }
    public int size(){
        return size;
    }
    protected void grow(){
        Object[] temp = new Object[arr.length*2];
        for(int i=0; i<arr.length;i++){
            temp[i]=arr[i];
        }
        arr=(T[])temp;
    }
}
