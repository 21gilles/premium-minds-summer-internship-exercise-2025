# Mouse Path - Summer Internship Exercise

## O Problema

Brincar aos labirintos é divertido mas alguém tem que verificar se os caminhos realmente funcionam.
Vamos então criar um validador de caminhos!

* Um caminho é definido por dois pontos finais indicados pelo X (são o início/fim).
* E as linhas podem ser o seguintes caracteres : 
* `-` = direita/esquerda
* `|` = cima/baixo
* `+` = canto

## Regras

* O caminho mais fácil a ser feito é quando temos dois pontos finais juntos :
```
XX
  
```
* ou 
```
X 
X 
```
* O canto (`+`) deve ser utilizado para todos os cantos mas só mesmo para os cantos. Isto é se tiveres num canto , tens que virar.
* Deve ser possível seguir a linha sem qualquer ambiguidade (antecipação de apenas um passo e nunca pisar o mesmo sítio duas vezes).
* A linha pode seguir qualquer caminho entre os dois pontos.
* Por vezes, uma linha pode ser válida numa direção, mas não na outra. Essa linha continua a ser considerada válida.
* Todos os “caracteres” de linha encontrados na grelha devem fazer parte da linha. Se forem encontrados extras, a linha não é válida.

 ## Exemplo

Linhas aceites : 

![alt text](good.png?raw=true)

Linhas não aceites :

![alt text](bad.png?raw=true)

## Pista
Imagina-te a percorrer um caminho onde só consegues ver o passo seguinte. Consegues saber qual o passo que deves dar, ou não?

## O que é preciso fazer?

* Implementar o método `isValidGrid` em `MousePathService`.
* Implementar mais testes em `MousePathServiceTest`

Vai ser valorizado: o facto de fazerem testes extras, assim como, o algoritmo escolhido de verificação e o facto do código estar escrito de forma perceptível e organizada.

## Como correr os testes

* Correr `./mvnw test`

## Dúvidas

Quaisquer dúvidas que tenhas, cria um issue aqui no github :)

