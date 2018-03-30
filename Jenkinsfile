pipeline {
	agent none    
stages {	
        stage('Building') {
		agent{
			docker {
			    image 'maven:3-alpine'
			    args '-v $HOME/.m2:/root/.m2'
			}
		}
		steps{
			sh'mvn clean package -s settings.xml'
		}
	}
	stage('Docker Build') {
		parallel {
			stage('Customer Service') {
				agent{
					docker {
					    image 'maven:3-alpine'
					    args '-v $HOME/.m2:/root/.m2'
					}
				}
				steps{
					sh 'mvn -f customer-service/pom.xml docker:build'
				}
			}
			stage('Invoice Service') {
				agent{
					docker {
					    image 'maven:3-alpine'
					    args '-v $HOME/.m2:/root/.m2'
					}
				}
				steps{
					sh 'mvn -f invoice-service/pom.xml docker:build'
				}
			}
			stage('Order Service') {
				agent{
					docker {
					    image 'maven:3-alpine'
					    args '-v $HOME/.m2:/root/.m2'
					}
				}
				steps{
					sh 'mvn -f order-service/pom.xml docker:build'
				}
			}
			stage('Order View Service') {
				agent{
					docker {
					    image 'maven:3-alpine'
					    args '-v $HOME/.m2:/root/.m2'
					}
				}
				steps{
					sh 'mvn -f order-view-service/pom.xml docker:build'
				}
			}
		}
	}
	
  }
}
