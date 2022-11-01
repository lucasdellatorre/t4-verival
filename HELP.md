# Documentação dos testes

### Autores: Eduardo D'alençon, Lucas Dellatorre e Pedro Semensato

Para os testes unitários da classe CalculoDeJuros, foi utilizada a técnica de cobertura de código, onde todas as linhas de código e estruturas de decisão são exercitadas.

Tendo em vista que os dois métodos da classe funcionam de maneira extremamente similar, seus casos de teste seguiram a mesma lógica de funcionamento. Para cada um dos métodos, foram criados casos de teste tanto para o cenário no qual a taxa correspondente ao seguro é adicionada quanto para o cenário no qual ela não é adicionada.

Já para os testes de integração, preferimos a utilização do Mockito para a injeção de dependências.

Na classe EmprestimoController, utilizamos a Autoconfiguração fornecida pelo Spring para instanciar o MockMvc.

Utilizamos um método de teste para cada requisição e modelamos o resultado esperado. Como neste caso o recebimento se dá através de uma requisição, transformamos o arquivo JSON em uma string antes de extrairmos o resultado.

Na classe de Empréstimo, utilizamos o Mock da classe responsável pelo calculo de Juros e instanciamos um conjunto de valores iniciais. Deste, testamos apenas o comportamento esperado acessar a API. 



