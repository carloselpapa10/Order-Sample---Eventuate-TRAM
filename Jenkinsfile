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
				agent any
				steps{
					sh 'mvn -f customer-service/pom.xml docker:build'
				}
			}
		}
	}
	
  }
}
