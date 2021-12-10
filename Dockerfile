FROM postgres:latest
ENV POSTGRES_PASSWORD postgres
ENV POSTGRES_DB redmineapp
COPY create.sql /docker-entrypoint-initdb.d/