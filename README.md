# Desafio Encurtador de URLs ✂️

Desafio proposto pela comunidade [Back-End Brasil](https://github.com/backend-br).  
Saiba mais: [Encurtador de URLs](https://github.com/backend-br/desafios/blob/master/url-shortener/PROBLEM.md).
 
---

#### ☕ Tecnologias utilizadas:

- Java
- Spring Boot
- MongoDB

---

## ⚙️ Passo a passo

#### 1 - Instale o [Docker](https://www.docker.com) em sua máquina. 

#### 2 - Abra o terminal na pasta raiz do projeto e execute o seguinte comando:

`docker compose up`

#### 3 - Crie o banco de dados necessário para a aplicação

- MongoDB:   
Crie um banco com o nome: db_urls  
`Usuário: mongo`   
`Senha: gustavo`   

#### 4 - Após terminar a configuração, inicie a aplicação e ela estará disponível em:

- http://localhost:8080/v1/shorten-url


#### 5 - Abra algum aplicativo para realizar suas requisições

- Algumas recomendações:  
[Insomnia](https://insomnia.rest/)  
[Postman](https://www.postman.com/)  
[Bruno](https://www.usebruno.com/)  

--- 

## 📨 Requisições

| Método | URL                            | Descrição                       | Corpo da requisição     |
| ------ | ------------------------------ | ------------------------------- | ----------------------- |
| POST   | /v1/shorten-url                | Encurte uma nova URL.           | [JSON](#encurtarurl)    |

---

## 📄 Corpo das requisições

##### <a id="encurtarurl">/v1/shorten-url - Encurtando uma URL.</a>

```json
{
  "url": "https://github.com/"
}
```




