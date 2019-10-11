gitCreds = 'git'

listView('Git-Flow-Jobs') {
	description("All Git Flow Jobs.")
    filterBuildQueue(true)
    filterExecutors(true)
    jobs {
        regex('.*-Git')
    }
    columns {
        status()
     	weather()
        name()
        lastSuccess()
        lastFailure()
        lastDuration()
        buildButton()
    }
}




multibranchPipelineJob("Merge-Master-Git") {

branchSources {
        git {
            //id('123456789') // IMPORTANT: use a constant and unique identifier
            remote('https://github.com/msharathraj/SampleTest.git')
            //credentialsId('github-ci')
            includes('JENKINS-*')
        }
    }
    orphanedItemStrategy {
        discardOldItems {
            numToKeep(20)
        }
    }
     
    steps {
	     batchFile('echo Hello World!')
	     batchFile('git branch')
	     batchFile('git checkout master')
	     batchFile('git merge develop')
		 batchFile('git push')
		 triggers {
			bitbucketPush()
		}
	 }
}

