### Requirements to run this project locally
1. Java SDK 19
2. Docker

### Running Docker containers
1. Access the folder where docker-compose.yml is located
2. Run the command:
```
docker compose up -d 
```
### Connecting to Postgres using PGAdmin
1. Access PGAdmin on any web browser using the address: http://localhost:5050/
2. Create a server with the following configuration:
```
Name: Any Name
Host name/address: host.docker.internal
Port: 5432
Username: postgres
Password: changeme
```

### 💡 Testing Spring Batch by importing a local .csv file
In order to test the spring batch using a local file, I included a python script 
that generates Characters and stores them into a .csv file which can be imported by the application.

### 💡 Testing Spring Batch by importing a file from Bucket S3
In order to test the spring batch using S3, ... WIP

### ✅ Some features of this project
1. Factory and Strategy patterns
2. (WIP) Read file from Bucket S3 and import using Spring Batch
3. (TODO) Sync and Async functions

### 📖 Developer`s Notes
* Why should we use **Spring Batch**?
1. Spring Batch is ideal for processing large volumes of data. 
2. State Management and Transactions: It provides resources to control transactions and avoid data loss.
3. Recovering: In case of an error it can recover from the last control point.
4. Chunks: The usage of chunks avoids high memory consumption
  