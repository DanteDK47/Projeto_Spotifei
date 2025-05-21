# Relatório do Projeto: Sistema de Gerenciamento de Músicas e Playlists

## 1. Introdução

Este projeto tem como objetivo desenvolver um sistema simples para gerenciamento de músicas, playlists e histórico de interações do usuário, com funcionalidades de busca, curtir, descurtir, cadastro de usuário e visualização de histórico. A proposta é criar uma aplicação desktop em Java, utilizando Swing para a interface gráfica, e PostgreSQL para o banco de dados.

- Cadastro e login de usuário  
- Busca de músicas por nome, artista ou gênero  
- Visualização e manipulação de playlists  
- Curtir e descurtir músicas  
- Visualização do histórico de músicas buscadas e interações  

---

## 2. Arquitetura e Tecnologias Utilizadas

- **Linguagem:** Java (versão X.X)  
- **Interface Gráfica:** Java Swing  
- **Banco de Dados:** PostgreSQL  
- **IDE:** NetBeans  
- **Comunicação com Banco:** JDBC  
- **Controle de versão:** Git e GitHub  

A aplicação segue uma arquitetura simples em camadas:  

- **Model:** Classes que representam as entidades do sistema (Usuário, Música, Playlist, Histórico)  
- **DAO:** Classes responsáveis pelas operações de banco de dados (CRUD)  
- **View:** Telas gráficas que o usuário interage (login, cadastro, buscar música, playlist, histórico)  
- **Controller:** Parte integrada no View/DAO para manipular a lógica e ações do usuário  

---

## 3. Banco de Dados

### Estrutura das principais tabelas

| Tabela           | Descrição                                           |
|------------------|----------------------------------------------------|
| **usuario**      | Guarda informações dos usuários cadastrados         |
| **musica**       | Armazena músicas com atributos: nome, artista e gênero |
| **playlist**     | Playlists criadas pelos usuários                    |
| **playlist_musica** | Associação entre playlists e músicas               |
| **musica_curtida** | Registro das curtidas e descurtidas, com status (curtiu/descurtiu) |
| **historico**    | Histórico das músicas buscadas pelo usuário         |

### Observações

- A tabela `musica_curtida` possui um campo `status` para identificar se a música foi "curtiu" ou "descurtiu".  
- O histórico das buscas é armazenado na tabela `historico`.  

---

## 4. Funcionalidades Desenvolvidas

### 4.1 Cadastro e Login

- Usuários podem se cadastrar com nome, email e senha.  
- Validação simples para evitar cadastro duplicado.  
- Após login, o usuário acessa as demais funcionalidades.  

### 4.2 Busca de Músicas

- Pesquisa por nome, artista ou gênero usando filtro via combo box.  
- Resultados exibidos em tabela com colunas nome, artista e gênero.  
- Permite curtir e descurtir músicas diretamente na tela de busca.  

### 4.3 Playlists

- Usuário pode criar playlists com nome personalizado.  
- Adicionar e remover músicas nas playlists.  
- Visualizar músicas contidas em cada playlist.  

### 4.4 Curtir e Descurtir Músicas

- Estado "curtiu" ou "descurtiu" registrado no banco, atualizando ou inserindo conforme necessário.  
- Aplicação mantém o registro dessas interações para exibição no histórico.  

### 4.5 Histórico

- Exibe as últimas 10 músicas buscadas pelo usuário.  
- Lista músicas curtidas e descurtidas separadamente.  
- Dados carregados dinamicamente do banco para a interface.  

---

## 5. Desafios e Soluções

- **Persistência do usuário logado:** Passagem do objeto `Usuario` entre telas para manter contexto.  
- **Atualização do modelo de dados:** Criação de tabelas associativas para playlists e controle de curtidas/descurtidas.  
- **Melhoria na interface:** Uso de `JTable` para exibir músicas, facilitando a visualização e manipulação.  
- **Tratamento de erros:** Mensagens claras para erros de banco e ações inválidas, melhorando a experiência do usuário.  

---

## 6. Como Executar o Projeto

1. Importe o projeto na IDE NetBeans.  
2. Configure a conexão com o banco PostgreSQL no arquivo `Conexao.java`.  
3. Execute os scripts SQL na pasta `/sql` para criar as tabelas e inserir dados.  
4. Compile e execute o projeto.  
5. Gere o arquivo `.jar` pela IDE para distribuição.  
6. Gere o Javadoc pela IDE, disponível na pasta `/dist/javadoc`.  

---

## 7. Músicas para Testes

| Nome                    | Artista        | Gênero       |
|-------------------------|----------------|--------------|
| Shape of You            | Ed Sheeran     | Pop          |
| Blinding Lights         | The Weeknd     | Pop          |
| Smells Like Teen Spirit | Nirvana        | Rock         |
| Someone Like You        | Adele          | Soul         |
| Bossa Nova Baby         | Elvis Presley  | Bossa Nova   |

---
