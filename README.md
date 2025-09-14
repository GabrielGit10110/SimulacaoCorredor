# 🚪 Simulador de Corredores com Porta Única

Simulação de quatro pessoas caminhando por corredores diferentes terminando em uma única porta com acesso controlado.

## 🎯 Funcionalidades

- 4 pessoas caminhando simultaneamente em corredores diferentes
- Cada corredor com 200m de comprimento
- Velocidade variável: 4-6 m/s por pessoa
- Porta única com acesso controlado por semáforo
- Tempo de abertura da porta: 1-2 segundos
- Sistema de seleção aleatória de corredores

## 🚀 Como executar

### Pré-requisitos
- JDK 8 ou superior
- Git instalado

### Passo a passo
1. Clone o repositório:
```bash
git clone https://github.com/GabrielGit10110/SimulacaoCorredor
```

2. Acesse o diretório do projeto:
```bash
cd SimulacaoCorredor
```

3. Compile o código:
```bash
javac -d bin src/controller/*.java src/utils/*.java src/view/*.java
```

4. Execute a aplicação:
```bash
java -cp bin view.Corredor
```

## 🏃‍♂️ Corredores Disponíveis

- **🚪 Setor A**: Corredor 1
- **🚪 Setor B**: Corredor 2  
- **🚪 Setor C**: Corredor 3
- **🚪 Setor D**: Corredor 4

## 🛠️ Tecnologias utilizadas
- Java SE
- Programação multithread
- Semáforos para controle de acesso à porta
- Cálculo de distância e velocidade
- Sistema de logs com timestamps
- JDK 8+

## 📋 Exemplo de saída

```
[14:25:30] 🚶 Pessoa: 16 esta andando no Setor B
[14:25:30] 🚶 Pessoa: 17 esta andando no Setor A
[14:25:30] 🚶 Pessoa: 18 esta andando no Setor C
[14:25:30] 🚶 Pessoa: 19 esta andando no Setor D

[14:25:41] ✅ Pessoa: 16 chegou ate a porta...
[14:25:41] 🚪 Pessoa: 16 esta abrindo a porta...
[14:25:42] ✅ Pessoa: 16 abriu a porta e foi embora! Levou 1.2 segundos para abrir a porta.

[14:25:43] ✅ Pessoa: 17 chegou ate a porta...
[14:25:43] 🚪 Pessoa: 17 esta abrindo a porta...
[14:25:45] ✅ Pessoa: 17 abriu a porta e foi embora! Levou 1.8 segundos para abrir a porta.

[14:25:46] ✅ Pessoa: 18 chegou ate a porta...
[14:25:46] 🚪 Pessoa: 18 esta abrindo a porta...
[14:25:47] ✅ Pessoa: 18 abriu a porta e foi embora! Levou 1.1 segundos para abrir a porta.

[14:25:48] ✅ Pessoa: 19 chegou ate a porta...
[14:25:48] 🚪 Pessoa: 19 esta abrindo a porta...
[14:25:50] ✅ Pessoa: 19 abriu a porta e foi embora! Levou 1.9 segundos para abrir a porta.

🏁 Todas as pessoas completaram o percurso!
```

## ⚙️ Características do Sistema

- **Distância do corredor**: 200 metros
- **Velocidade das pessoas**: 4-6 m/s (variável)
- **Tempo de abertura da porta**: 1-2 segundos
- **Controle de acesso**: Apenas 1 pessoa por vez na porta
- **Seleção de corredor**: Aleatória e exclusiva

## 📊 Cálculos do Sistema

- **Tempo estimado de caminhada**: 33-50 segundos (200m ÷ 4-6m/s)
- **Tempo total por pessoa**: Tempo caminhada + tempo porta
- **Ordem de chegada**: Depende da velocidade de cada pessoa

## 👨‍💻 Desenvolvido por
[GabrielGit10110](https://github.com/GabrielGit10110)

---

**Nota**: Esta simulação demonstra conceitos de concorrência e controle de acesso a recursos compartilhados, onde múltiplas threads competem por um recurso único (a porta) enquanto realizam tarefas independentes (caminhar pelo corredor).
