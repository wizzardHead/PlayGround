# PlayGround/asynctask


Playing around with asynchronous operations in Java using Spring Async utility. The concept is efficient when doing side 
transactions which user is not dependent on eg: Writing audit log transactions in DB for every request asynchronously. 
I tried to use it here in a Java webapp to call rest based sample urls (thanks to http://jsonplaceholder.typicode.com/ ). When clicked, client will make the request and after that poll the server to check if data is available. ( Polling can be dangerous and can slow / break the app down. )

