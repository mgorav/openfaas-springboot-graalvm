mvn -Pnative-image package  -DskipTests

faas-cli template pull https://github.com/mgorav/openfaas-springboot-graalvm

faas-cli new --lang  sb-graalvm   sb-graalvm-func
