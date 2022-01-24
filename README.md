# Service Discovery
[![Build Status](https://app.travis-ci.com/kva-devops/job4j_discovery.svg?branch=master)](https://app.travis-ci.com/kva-devops/job4j_discovery)

## О проекте
#### Описание
Учебный проект демонстрирующий работу Service Discovery, а точнее Client Side Service Discovery.
Приложение *discoveryserver* выступает в роли Discovery Server.
Экземпляры приложения *discoveryclient* будут передавать друг другу данные, при этом URL для 
передачи они будут запрашивать у *discoveryserver*. Все экземпляры приложения в данном проекте
запускаются на хостовой машине, на разных портах.

#### Технологии
>JDK14, Maven, SpringBoot, SpringCloudEurekaServer, SpringCloudEurekaClient, REST API,

## Сборка
0. Загружаем исходники проекта
1. Собираем *discoveryserver* `mvn install`
2. Собираем *discoveryclient* `cd discoveryclient` `mvn install`
3. Запускаем EurekaServer: `mvn spring-boot:run`
4. Запускаем двух клиентов EurekaClient:

    `java -jar target/discoveryclient-0.0.1-SNAPSHOT.jar --spring.config.location=file:///home/kustoff/projects/discoveryserver/discoveryclient/cfg/client1.properties`
    
    `java -jar target/discoveryclient-0.0.1-SNAPSHOT.jar --spring.config.location=file:///home/kustoff/projects/discoveryserver/discoveryclient/cfg/client2.properties`

## Как пользоваться
После запуска проверяем логи EurekaServer, если все прошло успешно в них должны появиться следующие строки:
    
![Success](images/Selection_211.png)
  
Со стороны клиентов проверяем доступ к списку всех клиентов, зарегистрированных в ServiceRegistry:
     
![CheckListClientFromClient1](images/Selection_212.png)
     
![CheckListClientFromClient2](images/Selection_213.png)  
       
Отправляем сообщение от клиента №1 клиенту №2, затем проверяем факт доставки:
    
![SendMessageFromClient1ToClient2](images/Selection_214.png)
         
![CheckMessageClient2](images/Selection_215.png)  
    
## Контакты
Кутявин Владимир

skype: tribuna87

email: tribuna87@mail.ru

telegram: @kutiavinvladimir
