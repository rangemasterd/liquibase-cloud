#!/bin/bash

set -e

if [ -z "${DB_URL_PATH}" ]; then
  >&2 echo "Missing DB_URL_PATH env, exiting..."
  exit 1
fi
if [ -z "${DB_USERNAME_PATH}" ]; then
  >&2 echo "Missing DB_USERNAME_PATH env, exiting..."
  exit 1
fi
if [ -z "${DB_PASSWORD_PATH}" ]; then
  >&2 echo "Missing DB_PASSWORD_PATH env, exiting..."
  exit 1
fi
if [ -z "${DB_CHANGELOG_FILE}" ]; then
  DB_CHANGELOG_FILE="master.xml"
fi

local _SECRETS=($(java -jar /usr/lib/secrets-accessor.jar ${DB_URL_PATH} ${DB_USERNAME_PATH} ${DB_PASSWORD_PATH}))

local _DB_URL=${_SECRETS[0]}
local _DB_USERNAME=${_SECRETS[1]}
local _DB_PASSWORD=${_SECRETS[2]}

liquibase update --url="${_DB_URL}" --username="${_DB_USERNAME}" --password="${_DB_PASSWORD}" --changelog-file="${DB_CHANGELOG_FILE}"