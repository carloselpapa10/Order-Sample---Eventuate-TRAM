pipeline {
    agent none
    tools { 
        maven 'maven-3' 
    }
stages { 
	stage('Database') {
		parallel {
			stage('MySql') {
				agent any
				steps {
					sh 'docker run -d \
					    --name mongodb \
					    -p 3306:3306 \
					    -e MYSQL_ROOT_PASSWORD=rootpassword \
					    -e MYSQL_USER=mysqluser \
					    -e MYSQL_PASSWORD=mysqlpw \
					    eventuateio/eventuate-tram-sagas-mysql:0.3.0.RELEASE'
				}
			}
			stage('MongoDB') {
				agent any
				steps {
					sh 'docker run -d \
					    --name mongodb \
					    -p 27017:27017 \
					    -e MONGO_DATA_DIR=/data/db \
					    -e MONGO_LOG_DIR=/dev/null \
					    -v ./data/db:/data/db \
					    eventuateio/eventuateio-local-zookeeper:0.14.0'
				}
			}
		}
	}
		stage('Zookeeper') {
			agent any
			steps {
				sh 'docker run -d \
					--name zookeeper \
					-p 2181:2181 \
					-p 2888:2888 \
					-p 3888:3888 \
					eventuateio/eventuateio-local-zookeeper:0.14.0'
			}
		}
	}
}
