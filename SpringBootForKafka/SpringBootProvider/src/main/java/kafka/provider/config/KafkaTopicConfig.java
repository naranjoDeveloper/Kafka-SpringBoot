package kafka.provider.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.common.config.TopicConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Bean
    public NewTopic generateTopic(){


        Map<String , String> configurations = new HashMap<>();

        configurations.put(TopicConfig.CLEANUP_POLICY_CONFIG , TopicConfig.CLEANUP_POLICY_COMPACT);//(delete borra el mensaje) (compact guarda el dato mas actual)
        configurations.put(TopicConfig.RETENTION_MS_CONFIG,"86400000"); //Tiempo de retencion de mensajes (En milisegundos)
        //defecto -1 no se borran nunca
        configurations.put(TopicConfig.SEGMENT_BYTES_CONFIG, "1073741824"); //1GIGABYTE EN BYTES - Tamaño maximo del segemento viene 1gb por defecto
        configurations.put(TopicConfig.MAX_MESSAGE_BYTES_CONFIG,"1000012"); //PESO O TAMANIO MAXIMO DE MENSAJE - DEFECTO 1MB



        return TopicBuilder.name("naranjo-topic")
                .partitions(2)
                .replicas(2)
                .configs(configurations)
                .build();
    }
}
