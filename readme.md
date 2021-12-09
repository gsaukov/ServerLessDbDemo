YOU REALLY HAVE TO UNDERSTAND WHAT YOU ARE DOING
SERVERLESS IS INFINITE PAIN IN THE ASS

1. Lambda is just a container with function that AWS will start and stop for you. While it is stating, you should be very patient and wait. 
2. The only use case for lambda I see is sporadic/spontaneous infrequent heavy work load once a month or even less often. 
3. make sure you have gradle wrapper in every subproject otherwise you will not be able to run lambdas locally.
4. Sam template Fn::ImportValue is not supported locally, should work in cloud see: https://stackoverflow.com/questions/59928691/aws-sam-local-start-api-cannot-resolve-fnimportvalue
5. Make sure that lambda uses proper layer version and environment runtime, it may result in classnotfound error.
6. JAVA Layer should be packaged in java/lib (CLASSPATH) folder. Not just root! Otherwise classnotfound error.
   https://docs.aws.amazon.com/lambda/latest/dg/configuration-layers.html#configuration-layers-path
7. Poll cloud about resources you need and describe them, pass them into variables. Example: ``` aws rds describe-db-engine-versions --engine aurora-postgresql --query 'DBEngineVersions[?contains(SupportedEngineModes,`provisioned`)].EngineVersion' ```
8. Testing you can get/find some test events in Test Event section of lambda.
9. Required IAM right for methods are usually listed in Methods Javadocs for example com.amazonaws.services.secretsmanager.AWSSecretsManager.getSecretValue
10. com.amazonaws.services.lambda.runtime.Context is not that scary and canbe just mocked.
11. Catch everything, base Exceptions not Specific extensions, there is n framework to catch and log it for you, things will be just missed.
12. Try https://github.com/localstack/localstack to mock AWS resources locally.
13. Start up time is crucial. 
14. Connection, Exception, Transaction handlers is now your responsibility.
15. Lambda must have access to your VPC/Subnet/Security Group to access resources such as database and EC2.
16. CloudFormation stacks is the best way to understand what your cloud is. Both at Macro and Micro levels. You can search across you resources and see the references between them. It is a lot more visual and transparent way to have a grip on your cloud resources. Neither CLI, nor console gives you such posibilities. You can also decorate your stacks with comments which is not possible with UI or console.
17. I strongly recommend create AWS resources only through CloudFormation to avoid human mistakes, using visual preview and resources review, reuse content and configuration, standard templates, roll back whole stack and don't loose something running.
18. Integration events library aws-lambda-java-events 
19. Use CloudFormationCustomResourceEvent to respond to cloud formation.
20. Lack of framework may turn code in to a mess full of different approaches and functions, you should be very cautious. 
21. Lambda hybrid environment with supportive lambda functions and EKS/ECS cluster.
22. Who will close the connections when Lambda container is killed? - No one lambda is just a container.
23. Lambda authorizer is additional auth layer used to produce policy to that will allow lambda invocation. For authorization better do it inside invoked lambda? https://medium.com/@Da_vidgf/http-basic-auth-with-api-gateway-and-serverless-5ae14ad0a270 
24. If you need to access VPC/Subnet from lambda you will need ENI(Elastic network interface, i.e. virtual network card) its creation significantly increase your cold start time.


Some good articles:
https://towardsdatascience.com/aws-lambda-7-things-i-wished-someone-told-me-63ec2021a772  
https://medium.com/hackernoon/im-afraid-you-re-thinking-about-aws-lambda-cold-starts-all-wrong-7d907f278a4f  
https://dzone.com/articles/how-to-use-mongodb-connection-pooling-on-aws-lambd  
https://blog.ippon.tech/lambda-execution-context-demystified/  
https://medium.com/@iamarkadyt/3-things-i-wish-i-knew-about-aws-lambda-functions-early-on-4dbb2b176d8f  
https://towardsaws.com/starter-guide-things-i-wish-i-knew-before-for-aws-lambda-fe36ce2fd4cb  
https://docs.aws.amazon.com/lambda/latest/dg/best-practices.html  
https://stackoverflow.com/questions/48878490/how-to-create-a-class-with-multiple-functions-in-aws-lambda-funciton  


AWS Serverless with spring:  
https://github.com/awslabs/aws-serverless-java-container
