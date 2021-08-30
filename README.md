**No Note: s**

https://github.com/kubernetes/minikube/issues/11193#issuecomment-826560971

minikube start --memory 4096 --driver=docker --ports=127.0.0.1:30080:30080,127.0.0.1:31000:31000,127.0.0.1:31001:31001,127.0.0.1:31002:31002


* 31000 kiali
* 31001 tracing
* 31002 grafana
* 30080 fleetman-webapp
* 30081 fleetman-api-gateway
