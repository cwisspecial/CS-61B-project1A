public class ArrayDeque<Item> {
    private Item[] items;
    private int size;

    private int X_Y = size / items.length;

    public ArrayDeque() {
        items = (Item[]) new Object [8];
        size = 0;
    }

    //调节数组大小
    public void resize_add(int capacity) {
            Item[] a = (Item[]) new Object[capacity];
            System.arraycopy(items,0,a,0,size);
            items = a;
    }

    public void resize_remove(int capacity) {
        Item[] a = (Item[]) new Object[capacity];
        System.arraycopy(items,0,a,0,size);
        items = a;
    }



    public void addLast(Item x) {
        if(size == items.length) {
            resize_add(size * 2);
        }
        items[size] = x;
        size += 1;
    }

    public Item getLast() {
        return items[size - 1];
    }

    public Item get(int i) {
        return items[i];
    }

    public int size() {
        return size;
    }

    public Item remove() {
        Item remove = items[size - 1];
        items[size - 1] = null;
        size = size -1;
        if(X_Y <= 0.25) {
            resize_remove(size / 2);
        }
        return remove;
    }
}
