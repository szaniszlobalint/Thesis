# Redmine Web Application #

The application implements communication between two Redmine sites. When a new issue is created on Redmine 1 within a project, the application creates it on Redmine 2 in a traceable manner based on the configurations we have formulated. The application has a frontend part (built in Angular) where projects on Redmines are displayed. It also has a backend part (written in Java Spring boot). The data is stored in a PostgreSQL database. The communication between the components is done through a REST interface between the components. The finished frontend and backend are stored in a Docker container and the database in another separate container. The whole application is hosted in a Docker Compose file for local execution.

### Main functions of the web application ###

1. User authentication, helping to ensure that only the users in the system are authenticated.
people in the system can use the app.
2. Displaying users in the database in two lists, from
depending on which system they belong to.
3. Displaying the projects in the database in two lists, depending on the system,
depending on which system they belong to.
4. Within the lists of users, continuously check that only
elements that have no counterpart, and if you select an element that has no counterpart, you must
that has a pair, it will select it for us.
5. linking the two users in Redmine using the two lists, and then
saving it to a database, indicating that one of the users in Redmine
which user in one Redmine corresponds to which user in the other Redmine, since
usernames may be different.
6. Delete the link between linked users or projects visually
7. Delete links between projects or projects that are connected to each other in a visual interface, which will also be deleted in the database.
8. update the users in the two lists with a single click, possible
changes occur.
9. Within the lists of projects, a continuous check that only
items that have no counterparts, and if an item is selected
that has a pair, it will select it for us.
10. Updating the two lists of projects at the touch of a button, if necessary
changes that may occur.
11. link the two projects in Redmine using the two lists, and then
saving it to a database, indicating that one of the two projects in Redmine
which project in one Redmine corresponds to which project in the other Redmine, since the project names may be different.
12. Indicate which system the synchronisation is being done from and to, present
for example, from Redmine A to Redmine B, and the choice of
option if we want to change this.
13. issue synchronization between Redmines, i.e. checking the issues in the starting Redmine if they exist in the target Redmine, and then checking the non-existing ones
create them in the right place, assigned to the right person.

### Technologies used ###

* Angular
* Java
* Spring Boot
* PostgreSQL
* Docker
* Redmine
* REST API
* Angular Material

### Running the application ###

To run it, you need a docker. Once in the project folder, use the docker compose up --build command, and then manually start any containers that would not have started. The Redmine setup is discussed within the thesis.

