#!/usr/bin/env bash

HANDLER="$1"

if [ -z "${AWS_LAMBDA_RUNTIME_API}" ]; then
    exec /usr/bin/aws-lambda-rie /usr/bin/java -cp "$JAR_DIR/*" "com.amazonaws.services.lambda.runtime.api.client.AWSLambda" "$HANDLER"
else
    exec /usr/bin/java -cp "$JAR_DIR/*" "com.amazonaws.services.lambda.runtime.api.client.AWSLambda" "$HANDLER"
fi
