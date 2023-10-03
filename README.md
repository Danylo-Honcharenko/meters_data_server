# Meters data server
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
### How to start a server on a host machine? (Windows)
In development, I always use Windows, 
so an example of starting a server 
will be for users using this operating system.

**Do not start the IDE before setting 
the environment variables, when you 
set the environment variables with 
the IDE running and save them, for 
the IDE they will not exist, so they 
will be null and as a result the server 
will crash.** [More details](https://stackoverflow.com/a/29784161)

For convenience, let's create a file **env.cmd** 
and write there the data for 
connecting to the database.
```
@echo=off
setx DB_NAME_METERS *your db name*
setx DB_USER_METERS *your db user*
setx DB_PASSWORD_METERS *your db user password*
setx DB_IP_PORT_METERS 0.0.0.0:3306
```
Of course, you can open cmd and set 
the data for connecting to the database one by one.
Once installed just start the server.