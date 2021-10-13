1. make sure you have gradle wrapper in every subproject otherwise you will not be able to run lambdas locally.
2. Sam template Fn::ImportValue is not supported locally, should work in cloud see: https://stackoverflow.com/questions/59928691/aws-sam-local-start-api-cannot-resolve-fnimportvalue
3. Make sure that lambda uses proper layer version and environment runtime, it may result in classnotfound error.
4. JAVA Layer should be packaged in java/lib (CLASSPATH) folder. Not just root! Otherwise classnotfound error.
   https://docs.aws.amazon.com/lambda/latest/dg/configuration-layers.html#configuration-layers-path
5. Poll cloud about resources you need and describe them, pass them into variables.
6. Testing you can get/find some test events in Test Event section of lambda.
7. Required IAM right for methods are usually listed in Methods Javadocs for example com.amazonaws.services.secretsmanager.AWSSecretsManager.getSecretValue
8. com.amazonaws.services.lambda.runtime.Context is not that scary and canbe just mocked.
9. Catch everything, base Exceptions not Specific extensions, there is n framework to catch and log it for you, things will be just missed.
