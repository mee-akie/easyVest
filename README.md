# Build da aplicação

## Requisitos

- Instale o [docker](https://docs.docker.com/get-docker/) caso não o tenha.
- Instale o [node](https://nodejs.org/en/download/) caso não o tenha.
- Criar as imagens dos containers da aplicação (backend). Para isso, rode os seguintes comandos em sequencia:

  ```
  cd docker/

  docker build -t postgres-image -f Dockerfile.db .

  cd ..

  docker build -t easyvestbackend-image -f Dockerfile.backend .
  ```

## Subir a aplicação (frontend e backend)

### Backend
Execute o seguinte comando para executar a aplicação backend:

```
docker-compose up
```

E utilize o seguinte comando para remove-la:

```
docker-compose down
```

### Frontend
Execute os seguintes comandos em sequencia para executar a aplicação frontend:

```
cd /client

npm start
```

**A aplicação estará sendo executada em [http://localhost:3000/](http://localhost:3000/)**


# APIs

## Usuario

- [GET] `/api/usuario/listar` => ira fornecer uma lista (JSON) contendo os dados de todos os usuarios existentes no
  banco de dados.
- [GET] `/api/usuario/{id}` => ira fornecer os dados (JSON) do usuario com o ID fornecido no path da requisicao.
- [POST] `/api/usuario/add` => ira adicionar um usuario novo, cujos dados sao enviados no body da requisicao.
- [PUT] `/api/usuario/alterarDados/{id}` => altera os dados de um usuario, cujo ID é aquele fornecido no path da
  requisicao.
- [DELETE] `/api/usuario/remover/{id}` => remove do banco o usuario cujo ID é fornecido no path da requisição.

## Campus

- [GET] `/api/campus/listar` => ira fornecer uma lista (JSON) contendo os dados de todos os campus existentes no
  banco de dados.
- [GET] `/api/campus/{id}` => ira fornecer os dados (JSON) do campus com o ID fornecido no path da requisicao.

## Curso

- [GET] `/api/curso/listar` => ira fornecer uma lista (JSON) contendo os dados dos cursos existentes no
  banco de dados.
- [GET] `/api/curso/{id}` => ira fornecer os dados (JSON) do curso com o ID fornecido no path da requisicao.

## Vestibular

- [GET] `/api/vestibular/listar` => ira fornecer uma lista (JSON) contendo os dados dos vestibulares existentes no
  banco de dados.
- [GET] `/api/vestibular/{id}` => ira fornecer os dados (JSON) do vestibular com o ID fornecido no path da requisicao.

## Universidade

- [GET] `/api/universidade/listar` => ira fornecer uma lista (JSON) contendo os dados das universidades existentes no
  banco de dados.
- [GET] `/api/universidade/{id}` => ira fornecer os dados (JSON) do vestibular com o ID fornecido no path da requisicao.
- [GET] `/api/universidade/listarCursos/{idUniversidade}` => ira fornecer os dados (JSON) dos cursos disponiveis da
  universidade cujo ID é fornecido no path da requisicao.
- [GET] `/api/universidade/listarCampus/{idUniversidade}` => ira fornecer os dados (JSON) dos campus da universidade
  cujo ID é fornecido no path da requisicao.

## Aula

- [GET] `/api/aula/listar` => ira fornecer uma lista (JSON) contendo os dados das aulas existentes no
  banco de dados.
- [GET] `/api/aula/{id}` => ira fornecer os dados (JSON) da aula cujo ID é fornecido no path da requisicao.

## Tema

- [GET] `/api/tema/listar` => ira fornecer uma lista (JSON) contendo os dados dos temas das disciplinas existentes no
  banco de dados.
- [GET] `/api/tema/{id}` => ira fornecer os dados (JSON) do tema com o ID fornecido no path da requisicao.

## Disciplina

- [GET] `/api/disciplina/listar` => ira fornecer uma lista (JSON) contendo os dados das disciplinas existentes no
  banco de dados.
- [GET] `/api/disciplina/{id}` => ira fornecer os dados (JSON) da disciplina cujo ID é fornecido no path da requisicao.

## Exercicio

- [GET] `/api/exercicio/listar` => ira fornecer uma lista (JSON) contendo os exercicios de todos os campus existentes no
  banco de dados.
- [GET] `/api/exercicio/{id}` => ira fornecer os dados (JSON) do exercicio com o ID fornecido no path da requisicao.

## Lista de exercicio

- [GET] `/api/lista/listar` => ira fornecer uma lista (JSON) contendo os dados das listas de exercicios existentes no
  banco de dados.
- [GET] `/api/lista/{id}` => ira fornecer os dados (JSON) da lista de exercicio cujo ID é fornecido no path da
  requisicao.
  
  
# Testes do front-end com Cypress
  
Na pasta client, rode `npm install cypress`.

Em seguida, rode `npm test` para inicializar o Cypress. Na janela que abrir, selecione a opção de teste end-to-end e escolha um dos specs criados para teste (agenda_tests.cy.jsx, por exemplo).
  
