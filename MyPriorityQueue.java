import java.util.*;

class MyPriorityQueue<E> implements PriorityQueueADT<E> {
   
    // you can use either of the following declarations for your heap
    //ArrayList<E> heap;
    //E[] heap;

   Comparator<E> comparator;
      
   MyPriorityQueue(Comparator<E> comparator){
      this.comparator = comparator;
      //heap = new ArrayList<E>();
      // or
      //heap = (E[]) new Object[/* initial length */];
   }
   
   public boolean add(E item){
      //TODO:  Write this method
      return true;
   }
   
   public E remove(){
      //TODO:  Write this method
      return null;
   }
   
   public boolean isEmpty(){
      //TODO:  Write this method
      return false;
   }
   
   public int size(){
       //TODO:  Write this method
       return -1;
   }

   public void clear(){
       //TODO:  Write this method
   }

   public String toString(){
      //TODO:  Write this method
      return "";
   }
   
   private void siftUp(){
      //TODO:  Write this method
   }
         
   private void siftDown(){
      //TODO:  Write this method
   }   

   private int parent(int x){
       //TODO:  Write this method
       return -1;
   }
   
   private int leftChild(int x){
       //TODO:  Write this method
       return -1;
   }
   
   private int rightChild(int x){
       //TODO:  Write this method
       return -1;
   }
   
}