#!/bin/bash

set -e

if [ -z "${SECRET_URL_PATH}" ]; then
  >&2 echo "Missing SECRET_URL_PATH env, exiting..."
  exit 1
fi
if [ -z "${SECRET_USERNAME_PATH}" ]; then
  >&2 echo "Missing SECRET_USERNAME_PATH env, exiting..."
  exit 1
fi
if [ -z "${SECRET_PASSWORD_PATH}" ]; then
  >&2 echo "Missing SECRET_PASSWORD_PATH env, exiting..."
  exit 1
fi
if [ -z "${DB_CHANGELOG_FILE}" ]; then
  DB_CHANGELOG_FILE="master.xml"
fi

_SECRETS=($(java -jar /usr/lib/secrets-accessor.jar ${SECRET_URL_PATH} ${SECRET_USERNAME_PATH} ${SECRET_PASSWORD_PATH}))

_DB_URL=${_SECRETS[0]}
_DB_USERNAME=${_SECRETS[1]}
_DB_PASSWORD=${_SECRETS[2]}

liquibase update --url="${_DB_URL}" --username="${_DB_USERNAME}" --password="${_DB_PASSWORD}" --changelog-file="${DB_CHANGELOG_FILE}"