# Desafio Técnico - Desenvolvedor Java

## Objetivo

O objetivo deste desafio é desenvolver um sistema simples para gerenciar veículos de uma frota.

## Tecnologias utilizadas

- Java 17
- Spring Boot
- Spring Data JPA
- MySQL
- Maven
- Docker
- Angular
- Angular Material

## Configurando o ambiente local

Para configurar o ambiente localmente é necessário ter o Docker e o Docker Compose instalados. Em seguida, basta executar o comando `docker-compose up -d --build ou docker compose up -d --build` na raiz do projeto para subir o banco de dados MySQL e rodar o script para criação do banco e das tabelas, além da carga inicial de dados.

## Executando o projeto

Para executar o projeto, basta executar o comando `./mvnw spring-boot:run` na raiz do projeto. Ou se preferir, executar o `AjucarApplication` diretamente da sua IDE.

## Documentação da API

A documentação da API foi feita utilizando CURL, é possível testar a aplicação usando os comandos abaixo:

````bash
# Listar todos os veículos (Sem Filtros)
curl -X GET "http://localhost:8080/api/veiculos" | json_pp

# Listar veículos (Com Filtros)
curl -X GET "http://localhost:8080/api/veiculos?tipoVeiculo=0&cor=Preto&modelo=Supra&fabricante=Toyota&ano=2021" | json_pp

# Criar veículo
curl -X POST "http://localhost:8080/api/veiculos" \
  -H "Content-Type: application/json" \
  -d '{
    "tipoVeiculo": 0,
    "cor": "vermelho",
    "modelo": "gol",
    "fabricante": "volkswagen",
    "ano": 2020,
    "preco": 48590,
    "quantidadePortas": 4,
    "tipoCombustivel": "Gasolina"
}'

# Buscar veículo por ID
curl -X GET "http://localhost:8080/api/veiculos/1" | json_pp

# Atualizar carro
curl -X PUT "http://localhost:8080/api/veiculos/25" \
  -H "Content-Type: application/json" \
  -d '{
    "tipoVeiculo": 0,
    "cor": "preto",
    "modelo": "gol",
    "fabricante": "volkswagen",
    "ano": 2020,
    "preco": 52342.33,
    "quantidadePortas": 4,
    "tipoCombustivel": "FLEX"
}'

# Atualizar moto
curl -X PUT "http://localhost:8080/api/veiculos/18" \
  -H "Content-Type: application/json" \
  -d '{
    "tipoVeiculo": 1,
    "cor": "preto",
    "modelo": "Rsv4",
    "fabricante": "Aprilia",
    "ano": 2024,
    "preco": 92000,
    "cilindrada": 1099
}'

# Excluir veículo
curl -X DELETE "http://localhost:8080/api/veiculos/2"
````