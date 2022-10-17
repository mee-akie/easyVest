# Build da aplicação

## Frontend

Rode

1. `cd client/`

2. `npm start`

A aplicação estará escutando em [http://localhost:3000/](http://localhost:3000/)

## Backend

Rode

1. `mvn clean install` => irá gerar o diretorio `/target`
2. `cd target/`
3. `java -jar aplication-0.0.1-SNAPSHOT.jar`

A aplicação estará escutando em [http://localhost:8080/](http://localhost:8080/)

## Banco de Dados (provisorio)

* Nome do banco: **easyvest**
* Url: **jdbc:postgresql://localhost:5432/easyvest**
* Username: **easyvestadmin**
* Password: **easyvestadmin**

### Windows

Abra o shell do postgres (psql) e rode

2. `CREATE USER easyvestadmin WITH ENCRYPTED PASSWORD 'easyvestadmin';`
3. `CREATE DATABASE easyvest WITH OWNER = easyvestadmin;`
4. `GRANT ALL PRIVILEGES ON DATABASE easyvest TO easyvestadmin;`

(ou crie o banco e o usuario usando o PgAdmin)

### Linux

Rode

1. `sudo -u postgres psql`
2. `CREATE USER easyvestadmin WITH ENCRYPTED PASSWORD 'easyvestadmin';`
3. `CREATE DATABASE easyvest WITH OWNER = easyvestadmin;`
4. `GRANT ALL PRIVILEGES ON DATABASE easyvest TO easyvestadmin;`
