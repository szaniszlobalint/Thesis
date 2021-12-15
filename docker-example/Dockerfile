FROM node:16.3.0-slim

ARG NPM_TOKEN
ENV NPM_TOKEN "$NPM_TOKEN"

WORKDIR /usr/src/app

COPY ./server/ .
RUN npm install
RUN npm run build

COPY docker-scripts/nabel-simple-server/docker-entry.sh /usr/src/docker-entry.sh
RUN chmod +x /usr/src/docker-entry.sh

EXPOSE 4200

CMD exec /usr/src/docker-entry.sh