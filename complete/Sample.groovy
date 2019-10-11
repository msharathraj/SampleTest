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
	     bat(
	     echo "Generating the versionlock file and pushing to the repo"
	     )
	     
     }
}
