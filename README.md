# Build da aplicação

## Frontend (SEM DOCKER)

Rode

1. `cd client/`

2. `npm start`

A aplicação estará escutando em [http://localhost:3000/](http://localhost:3000/)

## Backend (COM DOCKER))

Instale o [docker](https://docs.docker.com/get-docker/) caso não o tenha.

Basta rodar `docker-compose up` para subir o docker-compose. E rode `docker-compose down` para para-lo.

Ao subir o docker-compose a aplicação do backend estará escutando em [http://localhost:8080/](http://localhost:8080/) e
toda a configuração do banco de dados já será feita. Ou seja, não há necessidade de ter o banco de dados localmente.

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
