import java.util.*;

class MyPriorityQueue<E> implements PriorityQueueADT<E> {
   
    // you can use either of the following declarations for your heap
    //ArrayList<E> heap;
    //E[] heap;
	
	ArrayList<E> heap;

   Comparator<E> comparator;
      
   MyPriorityQueue(Comparator<E> comparator){
      this.comparator = comparator;
      heap = new ArrayList<E>();
      //heap = new ArrayList<E>();
      // or
      //heap = (E[]) new Object[/* initial length */];
   }
   
   public boolean add(E item){
	   int pointer = 0;
      while(comparator.compare(item, heap.get(pointer)) > 0)
      return true;
   }
   
   public E remove(){
      return heap.get(this.size()-1);
   }
   
   public boolean isEmpty(){
	   return heap.isEmpty();
   }
   
   public int size(){
       return heap.size();
   }

   public void clear(){
       heap.clear();
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