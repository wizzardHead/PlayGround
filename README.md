# PlayGround/asynctask


Playing around with asynchronous operations in Java using Spring Async Task. The concept is efficient when doing side 
transactions which user is not dependent on eg: Writing audit log transactions in DB for every request asynchronously. 
I tried to use it here to call rest based sample urls (thanks to http://jsonplaceholder.typicode.com/ ). When clicked, client will make t
he request and after that poll the server to check if data is available. ( Polling can be dangerous and can slow / break the app down. )
