package com.example.kafka.configuration;

import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

@Configuration
public class KafkaTopicConfiguration {
    /**
     * AdminClient를 통해서
     * Kafka를 관리하는 여러가지 동작을 할 수 있게된다.
     */
    @Bean
    public AdminClient adminClient(KafkaAdmin kafkaAdmin) {
        return AdminClient.create(kafkaAdmin.getConfigurationProperties());
    }

    /**
     * 단일 Topic  생성
     */
    @Bean
    public NewTopic topic1() {
        return TopicBuilder.name("topic1").build();
    }

    /**
     * KafkaAdmin을 이용한 설정 (설정을 false로 바꾸지 않는다면 기본적으로 initialize 할 때 생성한다)
     * Array를 통한 여러개의 토픽 생성
     * 기타 Config 설정 또한 가능하다.
     */
    @Bean
    public KafkaAdmin.NewTopics topics() {
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name("topic2").build(),
                TopicBuilder.name("topic3")
                        .partitions(3)
                        .replicas(1)
                        .config(TopicConfig.RETENTION_MS_CONFIG, String.valueOf(1000 * 60 * 60))
                        .build()
        );
    }
}
