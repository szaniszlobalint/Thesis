FROM postgres:9.6.23
-ENV POSTGRES_PASSWORD postgres
-ENV POSTGRES_DB redmineapp
COPY ./docker-scripts/database/create.sql /docker-entrypoint-initdb.d/