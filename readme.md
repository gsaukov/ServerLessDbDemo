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
10. Try https://github.com/localstack/localstack to mock AWS resources locally.
11. Start up time is crucial. 
12. Connection, Exception, Transaction handlers is now your responsibility.
13. Lambda must have access to your VPC/Subnet/Security Group to access resources such as database and EC2.
14. CloudFormation stacks is the best way to understand what your cloud is. Both at Macro and Micro levels. You can search across you resources and see the references between them. It is a lot more visual and transparent way to have a grip on your cloud resources. Neither CLI, nor console gives you such posibilities.
15. I strongly recommend create AWS resources only through CloudFormation to avoid human mistakes, using visual preview and resources review, reuse content and configuration, standard templates, roll back whole stack and don't loose something running.
16. Connectivity between 
