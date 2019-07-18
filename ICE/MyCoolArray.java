

public class MyCoolArray {
    int[] data;
    int size;
    public MyCoolArray(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public void add(int value) {
        if(size < data.length){
            data[size] = value;
            size++;
        } else{
            //out of space
            int[] tmp = new int[data.length*2];
            for (int i=0; i < data.length; i++) {
                tmp[i] = data[i];
            }
            tmp[size] = value;
            size++;
            data = tmp;
        }
    

    }

    public int get(int index) {
        return data[index];
    }
    
    public static void main(String args[]) {
        MyCoolArray arr = new MyCoolArray(2);
        arr.add(22);
        System.out.println(arr.get(0));
    }





}