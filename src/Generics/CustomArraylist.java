package Generics;

import java.util.Arrays;

public class CustomArraylist {

    private int[] data;
    private static int DEFAULT_SIZE = 10;
    private int size = 0;

    public CustomArraylist(){
        this.data = new int[DEFAULT_SIZE];
    }

    public void add (int num){
        if (isFull()){
            resize();
        }

        data[size++] = num;
    }

    private boolean isFull(){
        return size == data.length;
    }

    private void resize(){
        int[] temp = new int[data.length * 2];

        // Copy all the item into the new one
        for(int i = 0; i < data.length; i++){
            temp[i] = data[i];
        }
        data = temp;
    }

    public int remove(){
        int removed = data[--size];
        return removed;
    }

    public int size(){
        return size;
    }

    public int get(int index){
        return data[index];
    }

    public void set(int index, int value){
        data[index] = value;
    }

    @Override
    public String toString(){
        return "CustomArrayList{" +
                "data= " + Arrays.toString(data) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {

        CustomArraylist list = new CustomArraylist();
        list.add(3);
        list.add(4);
        list.add(38);

        System.out.println(list);

        for(int i = 0; i < 14; i++){
            list.add(i);
        }

        System.out.println(list);
    }




}
