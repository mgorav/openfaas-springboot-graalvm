# OpenFaas Template Spring Boot + GraalVM

Spring native template with
- spring boot
- rsocket
- GraalVM


mvn -Pnative-image package  -DskipTests

faas-cli template pull https://github.com/mgorav/openfaas-springboot-graalvm

faas-cli new --lang sb-native  sb-native-func


