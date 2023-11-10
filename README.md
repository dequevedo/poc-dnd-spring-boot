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

### Generating a .csv file containing random characters
In order to test the spring batch, I included a python script that generates
characters and stores them into a .csv file which can be imported by spring.

### Some features of this project
1. Factory and Strategy patterns
2. (WIP) Read file from Bucket S3 and import using Spring Batch
3. (TODO) Sync and Async functions