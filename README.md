# Pubsub
``` bash
docker compose run -it kafka-create-topics /bin/sh
```

``` bash
kafka-console-producer --bootstrap-server broker:29092 --topic 'sismico.pubsub'
kafka-console-consumer --bootstrap-server broker:29092 --topic 'sismico.pubsub' --group laboratorio
kafka-console-consumer --bootstrap-server broker:29092 --topic 'sismico.pubsub' --group consultoria

```

``` bash
KAFKA_GROUPID=laboratorio SERVER_PORT=10000 java -jar build/libs/kafka-credit-0.0.1-SNAPSHOT.jar
KAFKA_GROUPID=consultoria SERVER_PORT=10001 java -jar build/libs/kafka-credit-0.0.1-SNAPSHOT.jar
```
