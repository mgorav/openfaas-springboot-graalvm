# OpenFaas Template for Spring Boot + GraalVM

This is an OpenFaas template, which provides following environments:
- spring boot
- RSocket
- GraalVM
- jdk 11
- spring native

Write your business loginc in function, i.e. just provide implementation of RequestHandler. By DI, the implementation
relayed from the function REST class.

Hence, just code, function - RequestHandler, DO NOT worry about the docker,k8s etc.

It's worth mentioning that GraalVM provide, supersonic spped to the container, providing HOT start to the containers.







