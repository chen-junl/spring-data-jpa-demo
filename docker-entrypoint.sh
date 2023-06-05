#!/bin/bash
java ${JAVA_OPTS} -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/tmp/dockertest/dump -jar /app.jar --spring.profiles.active=${PROFILE}
exec "$@"