# This specific liquibase version is in line with the java version used to build the jar
# If you want to update the version, please check the liquibase java version matches the used one
FROM liquibase/liquibase:4.27

ARG CLOUD_PROVIDER
ARG APP_VERSION

COPY ./provider-${CLOUD_PROVIDER}/target/provider-${CLOUD_PROVIDER}-${APP_VERSION}.jar /usr/lib/secrets-accessor.jar
COPY .docker/docker-entrypoint.sh .

ENTRYPOINT ["bash", "docker-entrypoint.sh"]