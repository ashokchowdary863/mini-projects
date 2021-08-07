### Redis Cluster ###

```shell

redis-cli --cluster create 127.0.0.1:1111 127.0.0.1:1112 127.0.0.1:1113 127.0.0.1:1114 127.0.0.1:1115 127.0.0.1:1116 --cluster-replicas 1
```