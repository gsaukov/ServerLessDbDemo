# install jq
#brew install jq

vpc_id=$(aws ec2 describe-vpcs --filters "Name=isDefault, Values=true" | jq -r '.Vpcs[0].VpcId')
echo 'Creating stack in VPC: ' ${vpc_id}

echo 'Creating s3 bucket deployment-lambdas-...'
aws s3 mb s3://my-new-lambda-bucket-6328764287365 --region us-east-1

echo '==================   Copying resource to s3 STARTED   =========================='
aws s3 cp ../SLDBInitializer/build/libs/SLDBInitializer-0.1.0.jar s3://my-new-lambda-bucket-6328764287365/
aws s3 cp ../SLDBInitializer/build/distributions/SLDBInitializer-dependencies.zip s3://my-new-lambda-bucket-6328764287365/

aws s3 cp ./cf-deploy/cf-network.yaml s3://my-new-lambda-bucket-6328764287365/
aws s3 cp ./cf-deploy/cf-aurora-serverless.yaml s3://my-new-lambda-bucket-6328764287365/
aws s3 cp ./cf-deploy/cf-sldb-initializer.yaml s3://my-new-lambda-bucket-6328764287365/
echo '==================   Copying resource to s3 COMPLETE    =========================='

# run cloudformation template
#echo 'Creating stack...'
echo '==================   Stack creation STARTED        =========================='
aws cloudformation create-stack --stack-name cf-network --template-url https://s3.amazonaws.com/my-new-lambda-bucket-6328764287365/cf-network.yaml --region=us-east-1 --parameters ParameterKey=VPCID,ParameterValue=$vpc_id
aws cloudformation wait stack-create-complete --stack-name cf-network
aws cloudformation create-stack --stack-name cf-aurora-serverless --template-url https://s3.amazonaws.com/my-new-lambda-bucket-6328764287365/cf-aurora-serverless.yaml --region=us-east-1
aws cloudformation wait stack-create-complete --stack-name cf-aurora-serverless
aws cloudformation create-stack --stack-name cf-sldb-initializer --template-url https://s3.amazonaws.com/my-new-lambda-bucket-6328764287365/cf-sldb-initializer.yaml --capabilities CAPABILITY_AUTO_EXPAND CAPABILITY_IAM --region=us-east-1
aws cloudformation wait stack-create-complete --stack-name cf-sldb-initializer
echo '==================   Stack creation COMPLETE        =========================='
