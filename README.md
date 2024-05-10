# Liquicloud
Extends [liquibase](https://github.com/liquibase/liquibase) by configuring a client to retrieve the database coordinates (url, username and password) from the specific cloud provider's secret manager.

Before applying the DB changes the secrets are read from the secret manager and set to be used by the liquibase command.

## Supported Cloud Providers
* Google Cloud Platform

## Usage
Please visit [https://hub.docker.com/r/rangemasterd/liquicloud](https://hub.docker.com/r/rangemasterd/liquicloud)