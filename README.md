# Desafio-Conversor-Moedas
Projeto de conversor de moedas em Java com taxas em tempo real
# 💱 Conversor de Moedas em Java

Este é um projeto simples de um **Conversor de Moedas** desenvolvido em **Java**, que permite converter valores entre diferentes moedas usando **taxas de câmbio em tempo real** obtidas via API.

O projeto foi desenvolvido como parte do curso da Alura (Programa ONE) e tem como objetivo praticar:

───
### 📌 Conceitos aplicados

- Estruturas de decisão (`switch`)  
- Entrada de dados pelo console (`Scanner`)  
- Requisições HTTP com `HttpClient`  
- Manipulação de JSON com a biblioteca `Gson`  
- Modularização com métodos  

───
### 💡 Funcionalidades

- Conversão entre pelo menos **6 pares de moedas**:  
  - BRL ↔ USD  
  - BRL ↔ ARS  
  - USD ↔ CLP  
  - CLP ↔ USD  
- Menu interativo via console  
- Taxas de câmbio atualizadas em tempo real usando API  

───
### ⚙️ Como rodar o projeto

1. Clone o repositório:
2. Abra o projeto no **IntelliJ IDEA** ou outra IDE Java.  

3. Configure a variável de ambiente **EXCHANGE_API_KEY** com sua chave da API:

- No IntelliJ:  
  - Run → Edit Configurations  
  - Environment Variables → `EXCHANGE_API_KEY=<sua_chave_aqui>`  

> ⚠️ Não exponha a chave publicamente.  

4. Compile e execute o programa.  
5. Escolha a opção do menu e digite o valor a converter.  

───
## 🛠 Tecnologias

- 💻 Java 11+  
- 📦 Gson (manipulação de JSON)  
- 🌐 API [ExchangeRate-API](https://www.exchangerate-api.com/)  

───
## 📌 Observações

- Projeto destinado a fins **educacionais** e de prática de programação.  
- A conversão depende da **disponibilidade da API** e da chave correta.  

---

**👩‍💻 Desenvolvido por Valéria Aparecida Rodrigues Vieira**

```bash
git clone https://github.com/SEU_USUARIO/conversor-moedas.git
