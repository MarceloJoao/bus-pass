# Documentação da API

**Base URL:** `http://localhost:8080`

---

## Usuários (`/usuarios`)

### 1. Criar Usuário

* **Método:** `POST`
* **URL:** `/usuarios`
* **Body (JSON):**
```json
{
  "name": "João Silva",
  "email": "joao@email.com"
}

```



### 2. Listar todos

* **Método:** `GET`
* **URL:** `/usuarios`

### 3. Buscar por ID

* **Método:** `GET`
* **URL:** `/usuarios/{id}`
* **Exemplo:** `/usuarios/1`

---

## Viagens (`/viagens`)

### 1. Cadastrar Viagem

* **Método:** `POST`
* **URL:** `/viagens`
* **Body (JSON):**
* *Formatos de data: ISO8601 (AAAA-MM-DDTHH:mm:ss)*
* *Tipos: `EMPRESA` ou `PREFEITURA*`


```json
{
  "origem": "São Paulo",
  "destino": "Rio de Janeiro",
  "horarioPartida": "2024-12-25T08:00:00",
  "tipo": "EMPRESA"
}

```



### 2. Listar Viagens

* **Método:** `GET`
* **URL:** `/viagens`

### 3. Buscar Viagem por ID

* **Método:** `GET`
* **URL:** `/viagens/{id}`

---

## Passagens (`/passagens`)

### 1. Comprar Passagem

**Atenção:** Este endpoint usa **Query Parameters**, não JSON no corpo.

* **Método:** `POST`
* **URL:** `/passagens/comprar?userId={userId}&tripId={tripId}&numeroAssento={assento}`
* **Exemplo de chamada:**
`POST /passagens/comprar?userId=1&tripId=5&numeroAssento=12`

### 2. Listar Passagens Vendidas

* **Método:** `GET`
* **URL:** `/passagens`

---

## Documentos (`/documentos`)

### 1. Enviar Documento (Vincular a Usuário)

* **Método:** `POST`
* **URL:** `/documentos/usuario/{userId}`
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
* **URL:** `/documentos/usuario/{userId}`

### 3. Aprovar Documento

* **Método:** `PUT`
* **URL:** `/documentos/{id}/aprovar`

### 4. Rejeitar Documento

* **Método:** `PUT`
* **URL:** `/documentos/{id}/rejeitar`

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