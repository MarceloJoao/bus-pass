# Documentação da API

**Base URL:** `http://localhost:8080`

---

## Usuários (`/users`)

### 1. Criar Usuário

* **Método:** `POST`
* **URL:** `/users`
* **Body (JSON):**
```json
{
  "name": "João Silva",
  "email": "joao@email.com",
  "phone": "84911111111"
}

```


### 2. Listar todos

* **Método:** `GET`
* **URL:** `/users`

### 3. Buscar por ID

* **Método:** `GET`
* **URL:** `/users/{id}`
* **Exemplo:** `/users/1`

---

## Viagens (`/trips`)

### 1. Cadastrar Viagem

* **Método:** `POST`
* **URL:** `/trips`
* **Body (JSON):**
* *Formatos de data: ISO8601 (AAAA-MM-DDTHH:mm:ss)*
* *Tipos: `EMPRESA` ou `PREFEITURA*`


```json
{
  "origin": "São Paulo",
  "destination": "Rio de Janeiro",
  "departureTime": "2024-12-25T08:00:00",
  "type": "EMPRESA",
  "details": "Parada do viaduto, chegar com pelo menos 20 minutos de antecedência"
}

```



### 2. Listar Viagens

* **Método:** `GET`
* **URL:** `/trips`

### 3. Buscar Viagem por ID

* **Método:** `GET`
* **URL:** `/trips/{id}`

---

## Passagens (`/tickets`)

### 1. Comprar Passagem

**Atenção:** Este endpoint usa **Query Parameters**, não JSON no corpo.

* **Método:** `POST`
* **URL:** `/tickets/buy?userId={userId}&tripId={tripId}&seatNumber={seat}`
* **Exemplo de chamada:**
`POST /tickets/buy?userId=1&tripId=5&seatNumber=12`

### 2. Listar Passagens Vendidas

* **Método:** `GET`
* **URL:** `/tickets`

---

## Documentos (`/documents`)

### 1. Enviar Documento (Vincular a Usuário)

* **Método:** `POST`
* **URL:** `/documents/user/{userId}`
* **Body (JSON):**
* *Status iniciais recomendados: `PENDENTE*`


```json
{
  "nomeArquivo": "comprovante_residencia.pdf",
  "urlArquivo": "http://s3.aws.../arquivo.pdf",
  "status": "PENDENTE"
}

```



### 2. Listar Documentos de um Usuário

* **Método:** `GET`
* **URL:** `/documents/user/{userId}`

### 3. Aprovar Documento

* **Método:** `PUT`
* **URL:** `/documents/{id}/aprove`

### 4. Rejeitar Documento

* **Método:** `PUT`
* **URL:** `/documents/{id}/reject`

---

## Enums Disponíveis

### TipoViagem

* `EMPRESA`
* `PREFEITURA`

### StatusDocumento

* `PENDENTE`
* `APROVADO`
* `REPROVADO`
* `REJEITADO`