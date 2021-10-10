# For macbook users to install python
# # Before installing Python, you’ll need to install GCC. GCC can be obtained by downloading x-code
# xcode-select --install
# # install homebrew
# ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
# brew install python

#install pip
# python -m ensurepip --default-pip
# python -m pip install --upgrade pip setuptools wheel

# # install awscli and aws-saml-cli thru pip manager
# pip install awscli --upgrade --user
# pip install aws-sam-cli

# install jq
#brew install jq

echo 'Creating s3 bucket deployment-lambdas-...'
aws s3 mb s3://my-new-lambda-bucket-6328764287365 --region us-east-1

echo '==================   Copying resource to s3 STARTED   =========================='
aws s3 cp ../SLDBInitializer/build/libs/SLDBInitializer-0.1.0.jar s3://my-new-lambda-bucket-6328764287365/
aws s3 cp ../SLDBInitializer/build/distributions/SLDBInitializer-dependencies.zip s3://my-new-lambda-bucket-6328764287365/
aws s3 cp ../SLDB/build/libs/SLDB-0.1.0.jar s3://my-new-lambda-bucket-6328764287365/
aws s3 cp ../SLDB/build/distributions/SLDB-dependencies.zip s3://my-new-lambda-bucket-6328764287365/

aws s3 cp ./cf-deploy/cf-network.yaml s3://my-new-lambda-bucket-6328764287365/
aws s3 cp ./cf-deploy/cf-aurora-serverless.yaml s3://my-new-lambda-bucket-6328764287365/
echo '==================   Copying resource to s3 COMPLETE    =========================='

# run cloudformation template
#echo 'Creating stack...'
echo '==================   Stack creation STARTED        =========================='
aws cloudformation create-stack --stack-name cf-network --template-url https://s3.amazonaws.com/my-new-lambda-bucket-6328764287365/cf-network.yaml --region=us-east-1 --parameters ParameterKey=VPCID,ParameterValue=vpc-0677fa4f943931f0b
aws cloudformation create-stack --stack-name cf-aurora-serverless --template-url https://s3.amazonaws.com/my-new-lambda-bucket-6328764287365/cf-aurora-serverless.yaml --region=us-east-1
echo '==================   Stack creation COMPLETE        =========================='

#create s3 bucket and upload java application jar
echo 'Copying file to s3'

#create role for lambda
echo 'creating role for lambda...'
aws iam create-role --role-name lambda_basic_execution --assume-role-policy-document file://trust-policy.json
echo 'attaching policies for lambda'
aws iam attach-role-policy --policy-arn arn:aws:iam::aws:policy/AmazonRDSFullAccess --role-name lambda_basic_execution
aws iam attach-role-policy --policy-arn arn:aws:iam::aws:policy/AmazonAPIGatewayInvokeFullAccess --role-name lambda_basic_execution
aws iam attach-role-policy --policy-arn arn:aws:iam::aws:policy/AmazonVPCFullAccess --role-name lambda_basic_execution
aws iam attach-role-policy --policy-arn  arn:aws:iam::aws:policy/service-role/AmazonAPIGatewayPushToCloudWatchLogs  --role-name lambda_basic_execution
echo '==========lambda_basic_execution role created successfully with policies attached.========='
#lambdarole=$(aws iam get-role --role-name lambda_basic_execution | jq '."Role".Arn')
lambdarole=$(aws iam get-role --role-name lambda_basic_execution)
export lambdarole

#create cognito user pool
#echo 'creating cognito user pool'
#aws cognito-idp create-user-pool --pool-name app-pool
#echo '===================app-pool user pool CREATED ===================='

# deploy new stack that creates all lambdas in new account
echo 'Deploying all lambdas'
sam deploy --template-file /lambda/deploy_lambdas.yaml   --stack-name stack-all-lambdas
echo '======================== Lambdas all created =============================='
#in case failed: aws cloudformation delete-stack --stack stack-all-lambdas
