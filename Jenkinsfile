pipeline {
    agent none
    tools { 
        maven 'maven-3' 
    }
stages {
	stage('Building Projects') {
		agent any
	     	steps {
			sh 'mvn clean package'
		}
	}
	
	}
}
