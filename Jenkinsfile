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
			sh'mvn clean package -s settings.xml docker:build'
		}
	}
	stage('Database') {
		parallel {
			stage('MySql') {
				agent any
				steps {
					sh 'docker run -d \
					    --name mysql \
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
					    -v /data/db:/data/db \
					    mongo:3.0.15'
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
	stage('Kafka') {
			agent any
			steps {
				sh 'docker run -d \
				    --name kafka \
				    -p 9092:9092 \
				    --link zookeeper \
				    -e ADVERTISED_HOST_NAME=${DOCKER_HOST_IP} \
				    -e KAFKA_HEAP_OPTS=-Xmx320m -Xms320m \
				    -e ZOOKEEPER_SERVERS=zookeeper:2181 \
				    eventuateio/eventuateio-local-kafka:0.14.0'
			}
	}
	
  }
}
