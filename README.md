# MajorKey Prode Qatar 2022


## Create Docker MySQL DB
```
docker run -d -p 3306:3306 --name mysql -e MYSQL_ROOT_PASSWORD=261289 mysql:8.0.31
docker exec -it mysql mysql -u root -p
--Ingresar 261289 como password

mysql> create database hackaton;
mysql> exit
```

