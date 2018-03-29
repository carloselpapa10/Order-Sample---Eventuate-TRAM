pipeline {
	agent{
		docker {
		    image 'maven:3-alpine'
		    args '-v $HOME/.m2:/root/.m2'
		}
	}
    
stages {
	stage('Building Projects') {
		steps {
			sh 'mvn clean package -X -s settings.xml'
		}
	}	
	
	}
}
