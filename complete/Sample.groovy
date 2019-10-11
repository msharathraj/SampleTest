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
     branchSources  {
        git {
          
            remote('https://github.com/msharathraj/SampleTest.git')
            branch("develop")
            extensions {
            localBranch('develop')
            
          }
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

