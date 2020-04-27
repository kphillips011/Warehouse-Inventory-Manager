# Warehouse-Inventory-Manager

Group Members: 
Kendall Phillips, Eric Ulit, Justin Atteberry

Project Abstract (summary): 
This program is a warehouse inventory manager that incorporates file I/O and allows the user to manipulate the inventory in various ways. For example, by sorting the inventory items by various elements (such as name or price), adding or removing elements to/from the inventory, reading items from an input file, or printing data out to an invoice or log. The user will also be able to determine the total value of their inventory and be alerted if a certain item’s quantity is too low and products need to be ordered. We include elements that can be used by a hypothetical Point of Sale or other similar program to externally manipulate the inventory. 

Project Design:
* Language: Java
* Data structures: Maps, Lists, Arrays, File I/O, and Sorting
* Printing data out to Warehouse logs
* Inventory items organized, sorted, and managed by ID, name, price, and quantity
* Reading an input file of items and then adding them to the inventory
* Adding/removing items from the inventory
* Searching through the inventory
* Alerting the user if a certain item’s quantity is too low while removing items
* Flexibility of use for hypothetical businesses/warehouses
* Efficient space and time complexity

How to run and use the program:  
* Use inventoryIn.txt to add products into the inventory to be read by the reader (with format ID# Name Price Quantity)
* The program prints out timestamped log.md files with tables of all the items in the inventory sorted by ID, price, quantity, and alphabetical ordering
* The Main method shows the types of methods that can be called to search through and sort the inventory
* Our program can be connected to an external program or GUI if needed, such as a Point of Sale system




