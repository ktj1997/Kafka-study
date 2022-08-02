# Consumer

- ThreadSafe 하지 않다.
- Listener를 호출하는 Thread에서만호출 할 것

## Listener 타입

### Message (한번에 하나 씩)

### Batch (배치 단위로 한번에 )

## Ack Mode

1. RECORD
    - Record를 처리한 후 Listene가 반환할 때 Commit
2. BATCH
    - poll() 메소드로 호출된 Record가 모두 처리된 이후 Commit
    - Spring Kafka Consumer의 default 값이다.
3. TIME
    - ackTime 만큼 지난 이후에 Commit
    - 시간 간격을 선언하는 ackTime 옵션을 선언해야 한다.
4. COUNT
    - ackCount로 설정된 개수만큼 Record가 처리된 이후에 Commit
    - ackCount 옵션을 선언해야 한다.
5. COUNT_TIME
    - COUNT나 TIME에 알맞는 조건이 수행되면 Commit
6. MANUAL
    - Acknowledgemenmt.acknowledge() 메소드가 호출되면 다음번 poll() 메소드 호출 시 Commit
    - AcknowledgingMessageListener 또는 BatchAcknowledgingMessageListener를 사용해야 한다.
7. MANUAL_IMMEDIATE
    - Acknowledgement.acknowledge() 메소드가 호출되면 Commit
    - AcknowledgingMessageListener 또는 BatchAcknowledgingMessageListener를 사용해야 한다.

## MessageListenerContainer

1. KafkaMessageListenerContainer
- singleThread

2. ConcurrentMessageListenerContainer
- KafkaMessageListenerContainer 인스턴스를 1개 이상 사용하는 Multi-Thread
- Listener들이 start, stop 등 메소드를 forEach로 순차적으로 실행        
- 풍부한 AckMode를 지원한다.

## @KafkaListener
- @EnableKafka를 사용하려면, 
  @Configuration 중 Bean의 이름이 KafkaListenerContainerFactory인 ConcurrentMessageListenerContainer 객체가 필요 했다.
- SpringBoot에서는 KafkaAutoConfiguration을 통해서 이미 다 설정되어 있다.