#!/bin/bash
mvn clean install
cp target/solo-project.war ~/Apps/wildfly-10.1.0.Final/standalone/deployments