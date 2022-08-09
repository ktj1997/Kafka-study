# Producer

## KafkaTemplate
- 설정을 아무것도 해주지 않아도 사용 가능하다.
  - KafkaAutoConfiguration
- applicaiton.yml 설정으로 사용 가능하다.
  - ```yaml
      spring:
         kafka:
         producer:
         bootstrap-servers: ${KAFKA_BOOTSTRAP_SERVER:localhost:9002}
         acks: all
         enable.idempotence: true
         retries: 3
     ```
- Java 설정으로도 가능하다.
  - Bean으로 등록

## RoutingKafkaTemplate
- Topic 별로 다른 Producer를 사용하게 Routing이 가능하다.
= 

## ReplyingKafkaTemplate
- Produce 후 Consumer의 응답을 받을 수 있다.
- Header에 Producer 정보를 갖고있기 떄문에, 응답을 받을 수 있는 것이다.