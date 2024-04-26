# Cloud provider to load
ARG CLOUD_PROVIDER

FROM liquibase/liquibase:4.27

ARG CLOUD_PROVIDER

COPY ./provider-${CLOUD_PROVIDER}/target/provider-${CLOUD_PROVIDER}.jar /usr/lib/secrets-accessor.jar
COPY --chmod=550 .docker/docker-entrypoint.sh .

ENTRYPOINT ["bash", "docker-entrypoint.sh"]