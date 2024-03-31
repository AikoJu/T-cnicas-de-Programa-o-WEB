# Objetivo: Desenvolver uma aplicação CRUD simples para gerenciar usuários.

## ⚠️ Atenção alunos:

Antes de começar a escrever seu código, leia o enunciado completamente pelo menos uma vez! Isso é essencial para garantir que você entenda todos os requisitos do projeto;

<span style="color: red; font-weight: bold;">Não utilize bibliotecas ou outras dependências externas para esse exercício. Recomendamos o uso de condicionais simples e métodos já disponíveis no Java; Faça somente o necessário para resolver o enunciado.</span>

Ao final da prova, suba um arquivo zip.


## Instruções:

Você deverá criar um sistema de gerenciamento de usuários com os seguintes endpoints:

### 1. Cadastro de usuário (máximo de 3 pontos)

Parâmetros: Recebe um objeto Usuario, exemplo:
```json
{	
    "nome": "POST Malone",
    "email": "post@malone.com",
    "senha": "post123",
    "dataNascimento": "1995-07-04"
}
```
Objetivo: Adicionar um novo usuário.

- Validações:
    - O campo e-mail é obrigatório, deve conter no mínimo 10 caracteres e ter pelo menos um “@”.
    - O e-mail fornecido não deve existir na lista de usuários.

Forneça uma resposta (código http) adequada para cada situação.

<hr>

### 2. Listagem de todos os usuários (máximo de 1 ponto)
Objetivo: Retornar uma lista com todos os usuários cadastrados.

Exemplo de resposta:
```json
[
    {	
        "id": 1,	
        "nome": "GET Malone",
        "email": "get@malone.com",
        "senha": "post123",
        "dataNascimento": "1995-07-04"
    }
]
```
Forneça uma resposta (código http) adequada para cada situação.
<hr>

### 3. Buscar usuário por ID (máximo de 1 ponto)

Parâmetros: Recebe um ID como parâmetro.

Objetivo: Retornar os dados de um usuário com base em seu ID.

Forneça uma resposta (código http) adequada para cada situação.
<hr>

### 4. Atualização de usuário por ID (máximo de 2,5 pontos)

Parâmetros: Recebe um ID e um objeto Usuario atualizado.

Objetivo: Atualizar os dados de um usuário existente.
- Validações:
    - O campo e-mail é obrigatório, não deve ser nulo, deve conter no mínimo 10 caracteres e ter pelo menos um “@”.
    - Certifique-se de que o novo e-mail não exista na lista de usuários, ou seja, não está cadastrado para outro usuário.

Fornecer uma resposta (código http) adequada para cada situação.
<hr>

### 5. Exclusão de usuário por ID (máximo de 2,5 pontos)

Parâmetros: Recebe um ID como parâmetro.

Objetivo: Remover um usuário da lista com base em seu ID.

Fornecer uma resposta (código http) adequada para cada situação.

<hr>

### Especificações do Modelo:
O usuário deve possuir os seguintes campos:

- id: int
- email: String
- nome: String
- senha: String
- dataNascimento: LocalDate

<hr>

### Dicas:

- __Armazenamento e Identificação__
    - Utilize uma estrutura de dados adequada para armazenar os usuários em memória.
    - Você precisará desenvolver uma lógica que garanta que cada novo usuário receba um ID único. Esse ID deve aumentar automaticamente a cada novo cadastro, de maneira similar à funcionalidade "auto incremento" presente em bancos de dados como o MySQL. E lembre-se: se um usuário for removido, seu ID não deve ser reutilizado por futuros usuários. Pense nisso como um número de matrícula em uma escola: mesmo que um aluno saia, ninguém mais terá o mesmo número de matrícula dele.
- __Respostas e Verbos:__
    - Ao criar seus endpoints, tenha em mente os códigos de resposta HTTP adequados para cada situação. Lembre-se que esses códigos indicam o resultado da operação realizada.
    - Adicionalmente, assegure-se de que os verbos HTTP, como "GET", "POST", "PUT" e "DELETE", estejam sendo usados corretamente.
    - Em caso de falha, apenas o código de status é necessário na resposta, sem a necessidade de mensagens detalhadas ou lançamento de exceções.
- __Métodos da classe String (utilitários):__
    - O próprio objeto "String" tem métodos que podem ser úteis para validar e manipular os dados fornecidos.

## Nota sobre a Pontuação:

- Para alcançar a pontuação máxima em cada item especificado, é essencial que todos os subitens e requisitos dentro desse item sejam atendidos corretamente. Se algum dos subitens ou requisitos não estiver conforme as instruções, haverá um desconto proporcional ao número de erros ou omissões identificados.
- Em outras palavras, somente ao cumprir 100% dos requisitos de cada item, a pontuação total designada para esse item será concedida.

__Observação: Ao copiar o JSON fornecido, é possível que caracteres invisíveis ou especiais sejam incluídos acidentalmente, o que pode causar problemas. Se encontrar alguma dificuldade, recomendamos que você digite o JSON diretamente no Insomnia.__

<hr>

# Ao final da prova, suba o projeto inteiro __.zip__

### Sobre testes automatizados:
- Os testes são disponibilizados para auxiliar o desenvolvimento, mas não são a única forma de avaliação.
- Passar nos testes automatizados não garante que a implementação está correta, mas sim que atende os casos de uso propostos.
- <b>A correção será feita por revisores humanos,</b> que podem utilizar os testes para ánalise, mas que também avaliarão a qualidade do código, a aderência aos requisitos e a eficiência da implementação.
- Caso os testes se mostrem mais um obstáculo do que um auxílio, você tem a opção de não os utilizar. Contudo, vale ressaltar que a finalidade dos testes é assegurar a correção da lógica por trás do seu código.
- Se você identificar qualquer inconveniente nos testes, não hesite em comunicá-lo ao término do exame enviando um e-mail ao professor encarregado. Diante dessa situação, adote a abordagem que considerar mais adequada para a questão.

<br>

# Boa sorte! 📓✏️😊