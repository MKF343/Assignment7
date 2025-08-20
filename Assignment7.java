import java.util.*;
public class Assignment7 {
    public static void main(String[] args) throws InterruptedException {
        Scanner input = new Scanner(System.in);
        Inventory inventory = new Inventory();
        //item initialization
        Item tShirt = new Item("t-shirt",6.50);
        Item Sweater = new Item("sweater", 8.50);
        Item Sweatpants = new Item("sweatpants", 10.00);
        Item Skirt = new Item("skirt",25.50);
        Item Dress = new Item("dress", 15.50);
        System.out.println("[Order Queue Simulator]");
        System.out.print("Purchase how many 't-shirt' at $6.50?");
        int tShirtProcess = input.nextInt();
        System.out.print("Purchase how many 'sweater' at $8.50?");
        int sweaterProcess = input.nextInt();
        System.out.print("Purchase how many 'sweatpants' at $10.00?");
        int sweatpantsProcess = input.nextInt();
        System.out.print("Purchase how many 'skirt' at $25.50?");
        int skirtProcess = input.nextInt();
        System.out.print("Purchase how many 'sweater' at $15.50?");
        int dressProcess = input.nextInt();
        //purchaser initialization
        Purchaser[] purchasers = {
                new Purchaser(inventory, tShirt, tShirtProcess),
                new Purchaser(inventory, Sweater, sweaterProcess),
                new Purchaser(inventory, Sweatpants, sweatpantsProcess),
                new Purchaser(inventory, Skirt, skirtProcess),
                new Purchaser(inventory, Dress, dressProcess)
        };
        System.out.println("Purchasers created. Press 'enter' to start purchases...");
        input.nextLine();
        input.nextLine();
        System.out.println("\nPurchasers have started working...");
        for(Purchaser p: purchasers){
            p.start();
        }
        for(Purchaser p: purchasers){
            p.join();
        }
        System.out.println("\nPurchasers are done working. A total of " + inventory.getQueueSize() + " items are awaiting processing.\n");
        System.out.print("Create how many processors? ");
        int processorCount = input.nextInt();
        Processor[] processors = new Processor[processorCount];
        for(int i = 0; i < processorCount; i++){
            processors[i] = new Processor(inventory);
        }
        System.out.println("OrderProcessors created. Press 'enter' to start processing orders...");
        input.nextLine();
        input.nextLine();
        System.out.println("\nProcessors are now working...");
        for(Processor p: processors){
            p.start();
        }
        for(Processor p: processors){
            p.join();
        }
        System.out.println("\nAll OrderProcessors are done processing orders.\n");
        System.out.println(inventory.getItemsProcessed() + " items were processed for a total of $" + inventory.retrieveBalance());
        System.out.println("Simulation complete");
        input.close();
    }
}