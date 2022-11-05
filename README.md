# Build da aplicação

## Frontend (SEM DOCKER)

Rode

1. `cd client/`

2. `npm start`

A aplicação estará escutando em [http://localhost:3000/](http://localhost:3000/)

## Backend (COM DOCKER))

Instale o [docker](https://docs.docker.com/get-docker/) caso não o tenha.

Basta rodar `docker-compose up` para subir o docker-compose. E rode `docker-compose down` para para-lo.

Ao subir o docker-compose a aplicação do backend estará escutando em [http://localhost:8080/](http://localhost:8080/) e toda a configuração do banco de dados já será feita. Ou seja, não há necessidade de ter o banco de dados localmente.