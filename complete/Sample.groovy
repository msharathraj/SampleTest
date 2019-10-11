job("testjob") {
     scm {
        git {
          remote {
            url('https://github.com/msharathraj/SampleTest.git')
            branch("test3")
            extensions {
                localBranch('master')
            }
          }
        }
    }
    steps {
	      batchFile('echo Hello World!')
	     batchFile('git status')
	     batchFile('git branch')
	     
     }
}
