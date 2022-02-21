# Changes Done 
1. Added Basic UI with Reactjs as Framework to Add and View Services
2. Used Docker to run individual components as container i.e Backend,Frontend and database
3. Single commnad to run all the container using docker-compose to avoid failure while running on cross platform
4. Auto create the table in database if not present

# Steps to run
1. Clone the repo on your machine
2. Run the following command from the root folder of cloned repo
    1. docker-compose up -d
3. Check if all three container are running
    docker ps
4. Access UI from http://localhost/8080