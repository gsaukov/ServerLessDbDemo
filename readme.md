1. make sure you have gradle wrapper in every subproject otherwise you will not be able to run lambdas locally.
2. Sam template Fn::ImportValue is not supported locally, should work in cloud see: https://stackoverflow.com/questions/59928691/aws-sam-local-start-api-cannot-resolve-fnimportvalue
3. Make sure that lambda uses proper layer version and environment runtime, it may result in classnotfound error.
4. JAVA Layer should be packaged in java/lib (CLASSPATH) folder. Not just root! Otherwise classnotfound error.
   https://docs.aws.amazon.com/lambda/latest/dg/configuration-layers.html#configuration-layers-path
5. Poll cloud about resources you need and describe them, pass them into variables.
