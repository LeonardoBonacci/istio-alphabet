**No Note: s**

https://discuss.istio.io/t/kafka-istio-native-support-for-tracing/8155

docker run -d --name jaeger -e COLLECTOR_ZIPKIN_HTTP_PORT=9411 -p 5775:5775/udp -p 6831:6831/udp -p 6832:6832/udp -p 5778:5778 -p 16686:16686 -p 14268:14268 -p 9411:9411 jaegertracing/all-in-one:1.8

docker run -d --name jaeger -e COLLECTOR_ZIPKIN_HTTP_PORT=9411 -p 16686:16686 -p 9411:9411 jaegertracing/all-in-one:1.8

https://github.com/kubernetes/minikube/issues/11193#issuecomment-826560971

minikube start --driver=docker --ports=127.0.0.1:30080:30080,127.0.0.1:31000:31000,127.0.0.1:31001:31001,127.0.0.1:31002:31002

docker build -t leonardobonacci/istio-alpha:1.0 .
docker build -t leonardobonacci/istio-beta:1.0 .

docker run -p 9000:8090 leonardobonacci/istio-beta:1.0

minikube image load leonardobonacci/istio-alpha:1.0
minikube image load leonardobonacci/istio-beta:1.0

* 31000 kiali
* 31001 tracing
* 31002 grafana
* 30080 fleetman-webapp
* 30081 fleetman-api-gateway

* curl localhost:30080
