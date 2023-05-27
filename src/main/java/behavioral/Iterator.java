package behavioral;

import java.util.ArrayList;
import java.util.List;

interface IteratorInterface {
    int next();
    boolean hasNext();
}

class ListIterator implements IteratorInterface{

    public List<Integer> list;
    public Integer cursor;

    public ListIterator(){
        list = new ArrayList<Integer>();
        cursor = -1;
    }

    public void addItems(Integer value){
        list.add(value);
    }

    @Override
    public int next() {
        if(hasNext()){
            cursor += 1;
            return list.get(cursor);
        }
        throw new RuntimeException("No available values");
    }

    @Override
    public boolean hasNext() {
        return (cursor+1 < list.size());
    }
}


public class Iterator {
    public static void main(String[] args) {
        ListIterator it = new ListIterator();
        it.addItems(10);
        it.addItems(20);
        it.addItems(30);

        IteratorInterface iti = it;
        while(iti.hasNext()){
            System.out.println("Value: " + iti.next());
        }
    }
}
