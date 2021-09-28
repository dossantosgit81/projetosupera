# Processo seletivo supera

<p>Esse projeto foi dedicado ao processo seletivo. Bom, foi um desafio e tanto pra mim. Eu achei que eu ia terminar antes ,pois já havia feito um projeto parecido no front end. Porém acabei tomando alguns caminhos errados, que me custaram muito tempo. Aprendi muito. A lição mais importante, seria: modelar bem as classes, e usar TDD.
Eu deixei os testes para o final e acabei não conseguindo entregar os teste. Além do 
calculo do frete, subtotal, e total que só consegui implementar parcialmente quando cadastro um carrinho. Então é isso. Abaixo os recursos</p>

## Os valores exibidos no checkout (frete, subtotal e total) devem ser calculados 

### Implementado parcialmente em: HTTP.post/cart

## O usuário poderá adicionar e remover produtos do carrinho

### HTTP.post/cart -> aqui eu adiciono um produto ou atualizo a quantidade
    {
    "customer":{
        "id":1
    },
    "product":{
        "id":1
    }
}

### HTTP.put/cart -> aqui eu deleto um produto do carrinho
    {
    "customer":{
        "id":1
    },
    "product":{
        "id":1
    }
}

## O usuário poderá ordenar os produtos por preço, popularidade (score) e ordem alfabética.

### HTTP.get/products/order-price <- Ordena por preço

### HTTP.get/products/order-score <- Ordena por score

### HTTP.get/products/order-description <- Ordena por ordem alfabetica

## A cada produto adicionado, deve-se somar R$ 10,00 ao frete.

### HTTP.post/cart -> aqui eu adiciono um produto ou atualizo a quantidade, freight, subtotal, total
    {
    "customer":{
        "id":1
    },
    "product":{
        "id":1
    }
}

## Quando o valor dos produtos adicionados ao carrinho for igual ou superior a R$ 250,00, o frete é grátis.

### HTTP.post/cart -> aqui eu adiciono um produto ou atualizo a quantidade, freight, subtotal, total dinamicamente
    {
    "customer":{
        "id":1
    },
    "product":{
        "id":1
    }
}