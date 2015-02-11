#!/bin/bash
set -ev
if [ "${TRAVIS_PULL_REQUEST}" = "false" ]; then
  echo "<settings><servers><server><id>github</id><password>\${env.GITHUB_AUTH_TOKEN}</password></server></servers></settings>" > ~/settings.xml
  mvn site --settings ~/settings.xml
fi