pipeline {
	agent none 
	tools { 
		maven 'maven-3' 
	}
stages {	
	stage('Building') {
		agent any
		steps{
			sh'mvn clean install'
		}
	}
}
