node {
	agent any
	def server = Artifactory.server 'jenkins-artifactory-server' , username: 'admin', password: 'password'
	def rtMaven = Artifactory.newMavenBuild()
	
	rtMaven.resolver server: server, releaseRepo: 'sample-repo', snapshotRepo: 'sample-repo-snapshot'
	rtMaven.deployer server: server, releaseRepo: 'sample-repo-local', snapshotRepo: 'sample-repo-local'
	rtMaven.deployer.deployArtifacts = true
	
    stage ('Clone') 
        git branch: 'master', url: "https://github.com/cameronmcnz/rock-paper-scissors.git"
		bat 'git checkout dragon'
    	
    stage ('Artifactory configuration') 
        rtMaven.tool = 'MAVEN'
		rtMaven.deployer server: server, releaseRepo: 'sample-repo-local', snapshotRepo: 'sample-repo-local'
		rtMaven.resolver server: server, releaseRepo: 'sample-repo', snapshotRepo: 'sample-repo-snapshot'
		def buildInfo = Artifactory.newBuildInfo()
		
	stage ('Exec Maven') 
		rtMaven.run pom:/pom.xml, goals: 'clean install', buildInfo:buildInfo
     
    stage ('Publish build info') 
		server.rtPublishBuildInfo buildInfo
        
}