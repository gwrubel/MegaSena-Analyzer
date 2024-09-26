
# Análise de Resultados da Mega Sena

Esta aplicação em Java realiza a leitura e análise dos resultados históricos dos concursos da Mega Sena. Ela permite ao usuário explorar dados dos sorteios passados e simular novos sorteios aleatórios.

## 📋 Visão Geral do Projeto

A aplicação realiza as seguintes funções:

1. **Leitura de Dados dos Sorteios:** Carrega os dados históricos de todos os concursos da Mega Sena a partir de um arquivo Excel.
2. **Análise dos Dados:**
   - Conta a frequência de cada número sorteado.
   - Identifica quantos concursos não tiveram ganhadores que acertaram as 6 dezenas.
   - Mostra o maior e menor valor pago para apostas que acertaram 4, 5 e 6 dezenas.
   - Conta o total de ganhadores com 4, 5 e 6 dezenas.
3. **Interação com o Usuário:**
   - Permite que o usuário insira 6 dezenas e verifica se essas dezenas já foram sorteadas em algum concurso anterior, mostrando o número do concurso e a data, caso tenham sido sorteadas.
   - Gera um sorteio aleatório de 6 dezenas e verifica se a combinação já foi sorteada em algum concurso anterior.

## 🛠️ Funcionalidades

- **Análise de Dados Históricos:** Calcula várias estatísticas sobre os concursos passados.
- **Validação de Entrada do Usuário:** Garante que o usuário insira números válidos para a consulta.
- **Simulação de Sorteio Aleatório:** Simula um sorteio de 6 dezenas e verifica se já foi sorteado anteriormente.

## 🚀 Como Executar

### Pré-requisitos

- [Java JDK](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) (versão 8 ou superior).
- Biblioteca [Apache POI](https://poi.apache.org/) para manipulação de arquivos Excel.
- IDE para Java (como IntelliJ IDEA, Eclipse ou NetBeans).

### Instalação

1. Clone este repositório:

   ```bash
   git clone https://github.com/username/AnaliseMegaSena.git
   ```

2. Abra o projeto em sua IDE de preferência.

3. Certifique-se de que a biblioteca Apache POI está incluída nas dependências do projeto.

4. Baixe o arquivo com os resultados históricos da Mega Sena no site [Caixa Econômica Federal](https://loterias.caixa.gov.br/Paginas/Mega-Sena.aspx).

5. Mova o arquivo `.xlsx` baixado para o diretório raiz do projeto.

### Executando a Aplicação

1. Compile e execute a classe `Main` em sua IDE.

2. A aplicação solicitará que você selecione o arquivo `.xlsx` com os resultados da Mega Sena. Escolha o arquivo baixado anteriormente.

3. A interface gráfica será exibida, e você poderá começar a explorar os dados e utilizar as funcionalidades da aplicação.

## 📊 Funcionalidades da Aplicação

### Frequência dos Números

Exibe quantas vezes cada número foi sorteado na história da Mega Sena.

### Análise dos Ganhadores

- Mostra quantos concursos não tiveram ganhadores das 6 dezenas.
- Informa os maiores e menores valores pagos para apostas com 4, 5 e 6 dezenas.

### Verificação de Apostas do Usuário

Permite ao usuário inserir 6 dezenas e verificar se essas dezenas já foram sorteadas, mostrando o número do concurso e a data, caso tenha ocorrido.

### Simulação de Sorteio Aleatório

A aplicação pode gerar sorteios aleatórios e verificar se a combinação gerada já foi sorteada em algum concurso anterior.

## 🔧 Tecnologias Utilizadas

- **Java SE**
- **Apache POI** - Biblioteca para leitura e manipulação de arquivos Excel.
- **Swing** - Framework para criação de interface gráfica.

## 📁 Estrutura do Projeto

```bash
.
├── AnaliseMegaSena
│   ├── src
│   │   ├── com
│   │   │   ├── megasena
│   │   │   │   ├── Leitura.java     # Classe responsável pela leitura e processamento dos dados do arquivo.
│   │   │   │   ├── Analise.java     # Classe que contém as funções para análise dos dados.
│   │   │   │   ├── Simulacao.java   # Classe que gera sorteios aleatórios e verifica se já foram sorteados.
│   │   │   │   ├── Main.java        # Classe principal que inicializa a aplicação.
```

## 🤝 Contribuições

Contribuições são bem-vindas! Se você encontrar problemas ou tiver sugestões para melhorias, sinta-se à vontade para abrir uma issue ou enviar um pull request.

## 📜 Licença

Este projeto está licenciado sob a Licença MIT - consulte o arquivo [LICENSE](LICENSE) para mais detalhes.

---

