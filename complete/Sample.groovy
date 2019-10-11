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
	     bat echo "Generating the versionlock file and pushing to the repo"
	     bat    git pull origin master
	     bat    git add --all
	         
		bat	 git commit -am "Committing changes caused by"
	        bat git push origin master
	         
		bat git tag -a "SampleTag"
	        bat git push --tags
             
     }
}
