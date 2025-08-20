public class Processor extends Thread{
    private static int nextId;
    private int id;
    private Inventory queue;
    private int numberOfOrders;
    private double revenue;
    public Processor(Inventory queue){
        this.numberOfOrders = 0;
        this.revenue = 0.0;
        this.id = nextId;
        nextId++;
        this.queue = queue;
    }
    @Override
    public void run(){
        System.out.println("OrderProcessor " + id + " starting order processing...");
        while(true){
            Item item = queue.retrieveItem();
            if(item == null){
                break;
            }
            queue.incrementBalance(item.cost);
            numberOfOrders++;
            revenue += item.cost;
        }
        System.out.println("OrderProcessor " + id + " processed a total of " + numberOfOrders + " orders for a total of $" + this.revenue);
    }
}
