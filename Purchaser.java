public class Purchaser extends Thread{
    private static int nextId =1;
    private int id;
    private int itemsProcessed;
    private int itemsToProcess;
    private Inventory queue;
    private Item item;
    public Purchaser(Inventory inventory, Item item, int itemsToProcess){
        this.id = nextId;
        nextId++;
        this.queue = inventory;
        this.item = item;
        this.itemsProcessed = 0;
        this.itemsToProcess = itemsToProcess;
    }
    @Override
    public void run(){
        System.out.println("Purchaser " + this.id + " starting purchases...");
        for(int i = 0; i < itemsToProcess; i++){
            queue.addItem(item);
            itemsProcessed++;
        }
        System.out.println(id + " has purchased " + itemsProcessed + " '" + item.description + "'.");
    }
}
