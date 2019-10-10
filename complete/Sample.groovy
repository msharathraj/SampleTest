multibranchPipelineJob('example') {
    branchSources {
        git {
            id('git') // IMPORTANT: use a constant and unique identifier
            remote('ssh://git@stash.intralinks.com:7999/qe/qe-pom.git')
            credentialsId('git')
            includes('JENKINS-*')
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
}

job ('Git Move'){
parameters {
         stringParam('BUILD_TAG', '', '')
     }
     label('pr-merged-builds')
     scm {
        git {
            remote {
                name('test3')
                url('https://github.com/msharathraj/SampleTest.git')
            }
            branch('master')
            extensions {
                mergeOptions {
                    remote('origin')
                    branch('master')
                }
            }
        }
    }
	steps {
		echo "Entered steps to do"
	        
	      echo "Generating the versionlock file and pushing to the repo"
	      bat   git pull origin test3
	      bat   git add --A
	      bat   git status | grep "nothing to commit"
	      bat   git commit -am "Committing changes caused by 1.0.0"
	      bat   git push origin master
	    
     }
}	