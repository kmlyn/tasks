#!/usr/bin/env bash

if ./runcrud.sh; then
  sleep 3
  echo "Starting firefox"
  /usr/bin/firefox http://localhost:8080/crud/v1/task/getTasks &
  echo "Work well done"
else
    echo "There were errors"
fi
