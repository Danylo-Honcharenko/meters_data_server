# Meters data server
More information in the [Wiki](https://github.com/Danylo-Honcharenko/meters_data_server/wiki) tab
### How to run Dockerfile?
We go to our directory with the project, run 
cmd in this directory. Using the 
command `docker build --platform linux/amd64 -t 
meters_data_server .` collecting image. 
After this, create a **.env** file and set our 
environment variables:
```
DB_NAME_METERS=*your db name*
DB_USER_METERS=*your db user*
DB_PASSWORD_METERS=*your db user password*
DB_IP_PORT_METERS=0.0.0.0:3306
```
Now we launch our image with the command 
`docker run --env-file .env -p 8080:8080 -t 
meters_data_server`. If you specified the 
correct database connection details, 
you will see that the server started 
successfully.