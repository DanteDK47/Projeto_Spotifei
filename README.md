# Projeto Spotifei

## 1. Introdução  
Este projeto teve como objetivo desenvolver um sistema de música que permite aos usuários realizar cadastro e login, buscar músicas por nome, artista ou gênero, curtir e descurtir músicas, gerenciar playlists e visualizar o histórico de músicas buscadas, curtidas e descurtidas.

O sistema foi implementado em Java com interface gráfica Swing, utilizando banco de dados PostgreSQL para armazenamento dos dados.

## 2. Funcionalidades Desenvolvidas

### Cadastro e Login de Usuário  
- Permite que o usuário se cadastre e faça login para utilizar o sistema, garantindo que as ações sejam vinculadas ao usuário autenticado.

### Busca de Músicas  
- O usuário pode buscar músicas utilizando filtros por nome, artista ou gênero.  
- A busca é dinâmica, apresentando os resultados em uma tabela.

### Curtir e Descurtir Músicas  
- O sistema registra as músicas que o usuário curtiu e descurtiu, atualizando o status no banco de dados.  
- Evita duplicidade, atualizando o status se o usuário já tiver realizado alguma ação anterior.

### Gerenciamento de Playlists  
- Criação de playlists personalizadas por usuário.  
- Adição e remoção de músicas nas playlists.  
- Exibição das músicas contidas em cada playlist.

### Histórico de Músicas  
- Visualização das últimas 10 músicas buscadas pelo usuário.  
- Listagem das músicas curtidas e descurtidas, permitindo o acompanhamento das interações do usuário.

## 3. Aspectos Técnicos

### Banco de Dados  
- Utilização do PostgreSQL com tabelas para Usuário, Música, Playlist, Histórico e Música_Curtida.  
- As tabelas possuem chaves estrangeiras para garantir integridade referencial.  
- A tabela `musica_curtida` armazena o status ('curtiu' ou 'descurtiu') para permitir o registro do comportamento do usuário.

### Backend  
- Acesso ao banco feito via JDBC em DAOs (Data Access Objects) separados por entidade (MusicaDAO, PlaylistDAO, HistoricoDAO).  
- Os DAOs implementam métodos para CRUD, buscas e atualizações específicas.

### Frontend  
- Interfaces em Java Swing com JFrame, JTable, JComboBox e JTextArea para interação do usuário.  
- Uso de `DefaultTableModel` para exibição dinâmica dos dados nas tabelas.  
- Interfaces para buscar músicas, gerenciar playlists e visualizar histórico.

## 4. Estrutura do Projeto

- **model/**: Classes que representam as entidades do sistema (Usuário, Música, Playlist, Histórico).  
- **dao/**: Classes responsáveis pela comunicação com o banco de dados.  
- **view/**: Interfaces gráficas para interação com o usuário.  
- **conexao/**: Classe para conexão com o banco PostgreSQL.
