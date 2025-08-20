This Java program simulates a multi-threaded order processing system. It involves "Purchasers" who add items to an inventory and "Processors" who process these items.
The simulation demonstrates the use of threads to handle concurrent purchasing and processing of items in a shared inventory.

How It Works:

The program will first prompt you to enter the number of each item to purchase. After you provide the input, the simulation will start.

    Purchasing Phase:

        Multiple Purchaser threads are created, one for each type of item.

        Each Purchaser adds a specified quantity of its assigned item to a shared Inventory queue.

        The main thread waits for all Purchaser threads to complete their work.

    Processing Phase:

        You will be prompted to enter the number of Processor threads to create.

        The Processor threads are created and started.

        Each Processor retrieves items from the Inventory queue and processes them, updating the total revenue.

        The main thread waits for all Processor threads to finish.

    Simulation Complete:

        Once all items are processed, the program prints a summary, including the total number of items processed and the total revenue generated.

Class Overview

    Assignment7.java: This is the main class that drives the simulation. It takes user input, initializes the items, purchasers, and processors, and manages the overall flow of the program.

    Item.java: A simple class that represents an item with a description and a cost.

    Inventory.java: This class manages a shared queue of items (processingQueue), the total balance, and the count of itemsProcessed. It uses synchronized methods to ensure thread-safe access to the queue.

    Purchaser.java: A Thread subclass that adds a specific type of item to the Inventory's processing queue. Each purchaser is responsible for a set number of items.

    Processor.java: A Thread subclass that retrieves items from the Inventory's processing queue. Each processor continuously takes items until the queue is empty, and it keeps track of the number of orders it has processed and the revenue it has generated.
