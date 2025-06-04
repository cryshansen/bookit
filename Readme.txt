#Readme launch app in docker

Step 1. Start the mysql instance in docker

docker run -d --name mysql-container -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=booking -p 3306:3306 -v mysql_data:/var/lib/mysql mysql:latest
or 
docker start mysql-container



Step 2 mvn clean package ## creates the jar file
# mvn spring-boot:run we dont want to do this we want to run through docker instance


## steps to run the app in docker
#in order to run package in docker we must first set up application properties server address and port that point to server and make accessible through the port
mvn clean package
run in terminal doesnt work in vs.code

#Open Docker and run in docker terminal but navigate to the folder the app resides in (eclipse/)
#if docker is running the container can also stop within interface however this may be buggy
docker stop bookit-container mysql-container
docker rm bookit-container mysql-container
docker rmi bookit  # Remove old app image (optional)


#docker stop bookit-container && docker rm bookit-container


docker build -t bookit .
docker run -d --name mysql-container -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=booking -p 3306:3306 mysql:latest
docker run -d --name bookit-container --link mysql-container -p 8181:8181 bookit
docker logs -f bookit-container
#confirm its running
docker ps

#test run in conttaainer:
docker exec -it bookit-container curl http://localhost:8080
#outside the container test:
curl http://localhost:8181
#verify database conncction
docker exec -it bookit-container ping mysql-container

docker network inspect bridge
docker network create bookit-network
docker network connect bookit-network bookit-container
docker network connect bookit-network mysql-container



#docker exec -it infallible_torvalds bash

#docker exec -it mysql-container bash
#open a treminal window in terminal  or in docker in user root directory so navigate to where you want docker to run#
#navigate to eclipse/bookit   #docker exec -it <mysql-container-name> mysql -u root -p
#docker exec -it mysql-container bash
#mysql -v
#then mysql is started

#navigate to the docker bookit instance and terminal
#docker stop bookit-container
#docker rm bookit-container
#docker build -t bookit . # rebuild docker container
#docker network create bookit-network
#docker run --name mysql-container --network=bookit-network -e MYSQL_ROOT_PASSWORD=root -e MYSQL_DATABASE=booking -d mysql:latest
#docker run --name bookit-container --network=bookit-network -p 8181:8080 -e SPRING_DATASOURCE_URL=jdbc:mysql://mysql-container:3306/booking -e SPRING_DATASOURCE_USERNAME=root -e SPRING_DATASOURCE_PASSWORD=root bookit
