# Boletim da turma

Script que calcula a média de cada aluno a partir de três notas
e informa a situação final:

- Média >= 7.0: Aprovado
- Média >= 5.0: Recuperação
- Abaixo disso: Reprovado

## Pré-requisitos

- Java 17 ou superior instalado (confira com `java -version`)

Não é preciso instalar o Gradle nem o Groovy: o projeto usa o Gradle Wrapper,
que baixa tudo automaticamente na primeira execução.

## Como executar

Na pasta do projeto, rode:

Linux / macOS:

    ./gradlew run -q

Windows:

    gradlew.bat run -q

A opção `-q` esconde as mensagens do Gradle e mostra apenas a saída do programa.
A primeira execução pode demorar um pouco, pois as dependências serão baixadas.

> Se aparecer "Permission denied" no Linux/macOS, rode `chmod +x gradlew` e tente novamente.

## Estrutura do projeto

    cacandoBugMediaEscolar/
    ├── build.gradle                     # configuração do build
    ├── settings.gradle                  # nome do projeto
    ├── gradlew / gradlew.bat            # Gradle Wrapper
    └── src/main/groovy/Boletim.groovy   # código do boletim

## Problema relatado

Os professores conferiram as notas manualmente e o resultado
esperado é:

    Ana: média 8.17 - Aprovado
    Bruno: média 6.00 - Recuperação
    Carla: média 7.00 - Aprovado
    Diego: média 7.00 - Aprovado

Mas o script está mostrando valores diferentes.

## Seu desafio

Existem **pelo menos 3 bugs** escondidos no `Boletim.groovy`.
Seu objetivo é encontrar e corrigir todos, com a ajuda de um agente de IA,
até que a saída do script fique **idêntica** ao resultado esperado acima.

Os bugs se escondem uns atrás dos outros: corrigir um deles pode fazer
aparecer um problema que antes não dava para ver. Por isso, não pare no
primeiro acerto.

### Dicas para caçar os bugs

- **Rode o script depois de cada correção** e compare a saída, linha por
  linha, com o resultado esperado. Se ainda houver diferença, ainda há bug.
- **Um código sem erros não é um código correto.** O programa pode rodar
  sem nenhuma mensagem de erro e ainda assim seguir uma regra diferente da
  que a escola definiu.
- **Dê contexto para a IA.** Ela só sabe o que você mostra a ela. Compare
  as respostas quando você envia apenas o código e quando envia também as
  regras da escola e o resultado esperado descritos neste README.
- **Preste atenção nos casos de fronteira.** Pense no que deveria acontecer
  com um aluno que tira exatamente a nota de corte.
- **Entenda antes de aceitar.** Peça para a IA explicar por que cada linha
  estava errada. Se a explicação não fizer sentido para você, pergunte de
  novo.

## Sobre o bug

1. **Índice inicial do loop incorreto:**
   - **Problema:** Na função `calcularMedia`, o loop `for` começava em `int i = 1` em vez de `int i = 0`. Isso fazia com que a primeira nota de cada aluno (índice 0) fosse ignorada no cálculo da média.
   - **Correção:** O loop foi alterado para começar em `int i = 0`, garantindo que todas as notas da lista fossem somadas.

2. **Constante de recuperação incorreta:**
   - **Problema:** A constante `MEDIA_RECUPERACAO` estava definida como `6.5`, enquanto as regras da escola estabelecem que a recuperação é a partir de `5.0`.
   - **Correção:** O valor da constante `MEDIA_RECUPERACAO` foi alterado para `5.0`.

3. **Operador de comparação estrito na aprovação:**
   - **Problema:** A função `situacao` usava `media > mediaAprovacao`, o que exigia que a média fosse estritamente maior que 7.0 para aprovação. Alunos com média exatamente 7.0 (como Carla e Diego) eram enviados incorretamente para recuperação.
   - **Correção:** O operador foi alterado para `media >= mediaAprovacao`, permitindo que alunos com média 7.0 fossem aprovados.

### Checklist

- [ ] A média de todos os alunos está igual à esperada
- [ ] A situação de todos os alunos está igual à esperada
- [ ] Consigo explicar, com minhas palavras, cada bug que corrigi
