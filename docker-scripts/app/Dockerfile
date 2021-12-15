FROM maven:3.8.3-openjdk-17

WORKDIR /usr/src/app

COPY ./backend/ ./backend
COPY ./frontend/ ./frontend
COPY ./pom.xml .

RUN echo "aa"
RUN ls .
RUN ls /usr/src/app/backend
RUN ls /usr/src/app/frontend

RUN mvn clean package

COPY docker-scripts/app/docker-entry.sh /usr/src/docker-entry.sh
RUN chmod +x /usr/src/docker-entry.sh

CMD exec /usr/src/docker-entry.sh