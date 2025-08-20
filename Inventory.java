import java.util.*;
public class Inventory {
    private double balance;
    private int itemsProcessed;
    private List<Item> processingQueue;
    public Inventory(){
        this.balance = 0.0;
        this.itemsProcessed = 0;
        this.processingQueue = new LinkedList<>();
    }
    public synchronized void addItem(Item item){
        processingQueue.add(item);
    }
    public synchronized Item retrieveItem(){
        if(processingQueue.isEmpty()) {
            return null;
        }
        Item item = processingQueue.removeFirst();
        itemsProcessed++;
        return item;
    }
    public void incrementBalance(double amount){
        balance += amount;
    }
    public double retrieveBalance(){
        return balance;
    }
    public int getQueueSize(){
        return processingQueue.size();
    }
    public int getItemsProcessed(){
        return itemsProcessed;
    }
}
