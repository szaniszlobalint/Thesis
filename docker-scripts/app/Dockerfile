FROM maven:3.8.3-jdk-17


# package our application code
RUN mvn clean package

# set the startup command to execute the jar
CMD exec ./docker-entry.sh