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
		agent{
			docker {
			    image 'maven:3-alpine'
			    args '-v $HOME/.m2:/root/.m2'
			}
		}
		steps{
			sh'mvn -f pom2.xml docker:build'
		}
	}
	
  }
}
