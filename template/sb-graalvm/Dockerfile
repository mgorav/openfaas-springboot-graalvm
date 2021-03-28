FROM ghcr.io/graalvm/graalvm-ce:ol7-java11-21.0.0.2 as builder


ENV APP_HOME=/root/sb-native/

RUN mkdir -p $APP_HOME/function

WORKDIR $APP_HOME

COPY ../.. .

# For SDKMAN to work we need unzip & zip
RUN yum install -y unzip zip

RUN \
    # Install SDKMAN
    curl -s "https://get.sdkman.io" | bash; \
    source "$HOME/.sdkman/bin/sdkman-init.sh"; \
    sdk install maven; \
    # Install GraalVM Native Image
    gu install native-image;

RUN source "$HOME/.sdkman/bin/sdkman-init.sh" && mvn --version

RUN native-image --version

RUN source "$HOME/.sdkman/bin/sdkman-init.sh" && cd function && mvn clean install && cd ../ &&  mvn -B clean install package  -Pnative-image  -DskipTests --no-transfer-progress



FROM openfaas/of-watchdog:0.8.2 as watchdog
FROM openjdk:11-jre-slim as ship
RUN apt-get update -qqy \
  && apt-get install -qqy \
   --no-install-recommends \
   unzip
RUN addgroup --system app \
    && adduser --system --ingroup app app

COPY --from=watchdog  /fwatchdog .
RUN chmod +x /fwatchdog

COPY --from=builder /root/sb-native/target/com.gonnect.faas.nativespringboot.springbootnativeapp sb-graalvm

ENV fprocess="./sb-graalvm"
ENV mode="http"
ENV upstream_url="http://127.0.0.1:5679"

EXPOSE 8080 5679 5680

CMD ["./fwatchdog"]