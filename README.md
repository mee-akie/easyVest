# Build da aplicação (SEM DOCKER)

## Frontend

Rode

1. `cd client/`

2. `npm start`

A aplicação estará escutando em [http://localhost:3000/](http://localhost:3000/)

## Backend (depreciado => use o docker como mostra o passo "Build da aplicação (COM DOCKER)")

Rode

1. `mvn clean install` => irá gerar o diretorio `/target`
2. `cd target/`
3. `java -jar aplication-0.0.1-SNAPSHOT.jar`

A aplicação estará escutando em [http://localhost:8080/](http://localhost:8080/)

# Build da aplicação (COM DOCKER)
Instale o [docker](https://docs.docker.com/get-docker/) caso não o tenha.

### 1. Build das imagens do Postgresql e da aplicação do backend

Para a imagem do Postgresql entre no diretorio `/docker` e rode:
* `docker build -t postgres-image -f Dockerfile.db .`

Para a imagem da aplicação do backend rode:
* `mvn clean package`
* `docker build -t easyvestbackend-image -f Dockerfile.backend .`

### 2. Subindo o docker-compose
Basta rodar `docker-compose up` para subir o docker-compose. E rode `docker-compose down` para para-lo.

Ao subir o docker-compose a aplicação do backend estará escutando em [http://localhost:8080/](http://localhost:8080/) e toda a configuração do banco de dados já será feita. Ou seja, não há necessidade de ter o banco de dados localmente.