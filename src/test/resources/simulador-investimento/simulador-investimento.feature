Feature: Simular um Investimento na Poupanca

Scenario Outline: Simular investimento positivo
  Given o usuario esta na pagina do simulador
	When informa o valor a aplicar "<valor>"
	And informa o valor que quer poupar todo mes "<mensal>"
	And informa o tempo "<tempo>"
	And clicar em Simular
	Then visualiza a tabela com simulacao
	

Examples:	
|  valor |  mensal  |  tempo  |
| 20.00  |  20.00   |  24     |


Scenario Outline: Simular investimento positivo valor mensal abaixo do permitido
  #Given que clico no botao refazer
  Given o usuario esta novamente na pagina do simulador
	When informa o valor a aplicar menor que vinte reais"<valor>"
	And clico no campo valor mensal 
	Then visualiza a mensagem "<mensagem>"
	
	
	Examples:	
| valor  |  mensal  |  tempo  | mensagem                  |
| 18.00  |  15.00   |  12     | Valor minimo de R$ 20.00  |
