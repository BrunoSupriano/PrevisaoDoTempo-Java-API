# Projeto BackEnd - Web Service Java :coffee:
### Previsão do Tempo (API OpenWeatherMap)

--- 

## Sobre o Projeto

Esse é um projeto para a disciplina de BackEnd desenvolvido em Java e urilizando Spring Boot. A API fornece informações de previsão do tempo com base em consultas de cidade diretamente pelo endereço da URL.

## Requisitos

- :coffee: Java 11 ou superior
- :pencil2: Maven

## Configurações

1. Clone este repositório para o seu ambiente de desenvolvimento.
2. Certifique-se de ter uma chave de API válida do OpenWeatherMap. Você pode obter uma em https://openweathermap.org/api.
3. Adicione a sua chave de API no arquivo `application.properties` no seguinte formato:

```properties
openweathermap.api.key=SuaChaveAqui
```
4. Após configurado, rode a aplicação `PrevisaoDoTempoApplication` e abra o endereço local na rota `http://localhost:8080/previsao/nomedacidadeaqui` substituindo `nomedacidadeaqui` pelo nome da cidade escolhida. O Resultado desse app será um json com todas as informações de previsão do tempo atual da cidade que escolher.

