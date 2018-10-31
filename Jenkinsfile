#!groovy​

properties([[$class: 'BuildDiscarderProperty', strategy: [$class: 'LogRotator', numToKeepStr: '10']]])

def utilities
def scmVars
def appname = "sb-rest"
def downstreamJob = "sb-update-manifest"
if(!env.BRANCH_NAME){
    BRANCH_NAME = ""
} else {
    BRANCH_NAME = "/${env.BRANCH_NAME}"
}
echo "BRANCH_NAME=$BRANCH_NAME"

def v = 0

stage('Checkout and Unit Test') {
    node {
    	git 'https://github.com/mmneri/sb-deploy.git'
      	utilities = load 'utilities.groovy'  
        scmVars = checkout scm
        // scmVars contains the following values
        // GIT_BRANCH=origin/mybranch
        // GIT_COMMIT=fc8279a107ebaf806f2e310fce15a7a54238eb71
        // GIT_PREVIOUS_COMMIT=6f2e319a1fc82707ebaf800fce15a7a54238eb71
        // GIT_PREVIOUS_SUCCESSFUL_COMMIT=310fce159a1fc82707ebaf806f2ea7a54238eb71
        // GIT_URL= 
	
	
	if(!BRANCH_NAME){
	    BRANCH_NAME = "/${scmVars.GIT_BRANCH}"
	}
	    
        v = version()
        currentBuild.displayName = "${env.BRANCH_NAME}-${v}-${env.BUILD_NUMBER}"
        utilities.mvn "clean verify"
    }
}

stage('build') {
    node {
        utilities.mvn "clean package -DskipTests"
    }
}

stage('Create build output'){
    node {	    
	    // Archive the build output artifacts.
	    archiveArtifacts artifacts: 'target/*.war' , fingerprint: true
	    // junit '**/target/surefire-reports/TEST-*.xml'
    }
}

stage('Trigger Release Build') {
       build job: downstreamJob, parameters: [[$class: 'StringParameterValue', name: "app", value: "${appname}${BRANCH_NAME}"], [$class: 'StringParameterValue', name: 'revision', value: v]], wait: false
}

def branch_type = utilities.get_branch_type "${env.BRANCH_NAME}"
def branch_deployment_environment = utilities.get_branch_deployment_environment branch_type

if (branch_deployment_environment) {
    stage('deploy') {
        if (branch_deployment_environment == "prod") {
            timeout(time: 1, unit: 'DAYS') {
                input "Deploy to ${branch_deployment_environment} ?"
            }
        }
        node {
            echo "Deploying to ${branch_deployment_environment}"
            //TODO specify the deployment
        }
    }
}


def version() {
    def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
    return matcher ? matcher[0][1] : null
}

