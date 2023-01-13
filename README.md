# DCC042
DCC042-2022.3 TURMA A - REDES DE COMPUTADORES

## Grupo:
  - Gabriel Toledo Netto Gribel - 201976004
  - Pedro do Couto Filgueiras - 201935015

## Propósito:
Criar um chat de mensagens entre usuários com a opção de conversa em grupo ou em particular


## Para compilar:
  Na pasta  ```./src/main/java/```  execute o comando:
  ```
  javac *.java
  ```
  Este comando irá compilar todos os arquivos ```.java``` presentes no diretório.
  
## Para executar:
  Primeiro inicie o Servidor com:
  ```
  java Server
  ```
 
 Para executar o 'Cliente' utilize o comando:
  ```
  java Client
  ```
  
  ## Mensagens
  - ``` [Mensagem comum] ```
    - O servidor irá retornar para todos os usuários (exceto o que enviou a mensagem) o corpo da mensagem juntamente com o nome da pessoa que enviou.
    
  - ``` [nome_usuario];[mensagem] ```
    - O servidor irá enviar a mensagem ao usuário que foi pedido no copo da mensagem.
    
  - ``` quit ```
    - O servidor deve desconectar o usuário usuário.
 
  
