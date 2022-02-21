# Changes Done 
1. Added Basic UI with Reactjs as Framework to Add and View Services
2. Used Docker to run individual components as container i.e Backend,Frontend and database
3. Single commnad to run all the container using docker-compose to avoid failure while running on cross platform
4. Auto create the table in database if not present
5. URL allowed are in below format
    1. http:// or https:// (example : http://www.google.com )

# Steps to run
1. Clone the repo on your machine
2. Create a new directory 'data' at root level of repo(i.e inside service-monitoring)
3. Run the following command from the root folder of cloned repo
    1. docker-compose up -d
4. Check if all three container are running
    docker ps
5. Access UI from http://localhost/