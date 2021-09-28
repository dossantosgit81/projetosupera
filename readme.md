# Processo seletivo supera

<p>Esse projeto foi dedicado ao processo seletivo. Bom, foi um desafio e tanto pra mim. Eu achei que eu ia terminar antes ,pois já havia feito um projeto parecido no front end. Porém acabei tomando alguns caminhos errados, que me custaram muito tempo. Aprendi muito. A lição mais importante, seria: modelar bem as classes, e usar TDD.
Eu deixei os testes para o final e acabei não conseguindo entregar os teste. Além do 
calculo do frete, subtotal, e total que só consegui implementar parcialmente quando cadastro um carrinho. Então é isso. Abaixo os recursos.
Utilizei banco de dados H2. username:sa, password:password <- credenciais de acesso ao banco de testedb.
Eu disponibilizei todos os dados necessarios no resources/import.sql
</p>

### Versão do java -> 11

#### Gerar build
 <p>na pasta raiz do projeto execute: mvn clean package</p>

#### Executar aplicação  
<p>Na pasta target execute o seguinte comando: java -jar projetosupera-0.0.1-SNAPSHOT.jar</p>

#### Os valores exibidos no checkout (frete, subtotal e total) devem ser calculados 
<p>Implementado parcialmente em: HTTP.post/cart</p>

## O usuário poderá adicionar e remover produtos do carrinho

#### HTTP.post/cart 
<p>aqui eu adiciono um produto ou atualizo a quantidade. Se já existe um usuario com as informações do body, eu atualiza a quantidade e as informações do carrinho</p>
    {
    "customer":{
        "id":1
    },
    "product":{
        "id":1
    }
}

#### HTTP.put/cart
<p> aqui eu deleto um produto do carrinho</p>
    {
    "customer":{
        "id":1
    },
    "product":{
        "id":1
    }
}

### O usuário poderá ordenar os produtos por preço, popularidade (score) e ordem alfabética.

#### HTTP.get/products/order-price  
<p>Ordena por preço</p>

#### HTTP.get/products/order-score  
<p>Ordena por score</p>

#### HTTP.get/products/order-description <- 
<p>Ordena por ordem alfabetica</p>

## A cada produto adicionado, deve-se somar R$ 10,00 ao frete.
#### HTTP.post/cart -> 
<p>Aqui ele fará essa logica de frete quando eu adiciono o produto no carrinho</p>
    {
    "customer":{
        "id":1
    },
    "product":{
        "id":1
    }
}

## Quando o valor dos produtos adicionados ao carrinho for igual ou superior a R$ 250,00, o frete é grátis.

#### HTTP.post/cart 
<p>Quando eu salvo um produto no carrinho, ele já faz esse calculo pra mim e injeta as informações na base de dados</p>
    {
    "customer":{
        "id":1
    },
    "product":{
        "id":1
    }
}