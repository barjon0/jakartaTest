# JakartaDatabase
A simple Jakarta EE Application to maintain a small database on an application server with Jakarta Persistence.
I used a GlassFish 6.2.5 local server and Advanced Rest Client for Chrome to execute Post- and Put-Requests.

# Run Application
Clone Repository  
Install Glassfish 6.2.5 https://glassfish.org/download  
Install Advanced Rest Client https://www.advancedrestclient.com/install  
Install dependencies from requirements.txt  
Run GlassFish Server -> Run Advanced Rest Client  
Endpoints: "maintain/" :
    "add"  
    "read/{id}"  
    "alter"  


# Modules
HelloResources implements GET, READ, ADD functions  
persistance.xml sets up the Database  
UserDatabase interacts wiht the Database
