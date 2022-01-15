# Service Discovery
[![Build Status](https://app.travis-ci.com/kva-devops/job4j_discovery.svg?branch=master)](https://app.travis-ci.com/kva-devops/job4j_discovery)

## О проекте
Учебный проект демонстрирующий работу Service Discovery

## Сборка
JDK14, Maven, SpringBoot, SpringCloudEurekaServer, SpringCloudEurekaClient

## Как пользоваться
1. Запускаем EurekaServer: "mvn spring-boot:run"

2. Запускаем двух клиентов EurekaClient:

    "java -jar target/discoveryclient-0.0.1-SNAPSHOT.jar --spring.config.location=file:///home/kustoff/projects/discoveryserver/discoveryclient/cfg/client1.properties"
    
    "java -jar target/discoveryclient-0.0.1-SNAPSHOT.jar --spring.config.location=file:///home/kustoff/projects/discoveryserver/discoveryclient/cfg/client2.properties"

3. Проверяем логи EurekaServer, если все прошло успешно в них должны появиться следующие строки:
    
    ![Success](images/Selection_211.png)
  
4. Со стороны клиентов проверяем доступ к списку всех клиентов, зарегистрированных в ServiceRegistry:
     
     ![CheckListClientFromClient1](images/Selection_212.png)
     
     ![CheckListClientFromClient2](images/Selection_213.png)  
       
5. Отправляем сообщение от клиента №1 клиенту №2, затем проверяем факт доставки:
    
     ![SendMessageFromClient1ToClient2](images/Selection_214.png)
         
     ![CheckMessageClient2](images/Selection_215.png)  
    
## Контакты
Кутявин Владимир

skype: tribuna87

email: tribuna87@mail.ru

telegram: @kutiavinvladimir