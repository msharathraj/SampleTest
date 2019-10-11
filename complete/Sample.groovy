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
	     batchFile(echo "Generating the versionlock file and pushing to the repo")
	     batchFile(git pull origin master)
	     batchFile(git add --all)
	     batchFile(git commit -am "Committing changes caused by")
	     batchFile( git push origin master)
	     batchFile( git tag -a "SampleTag")
	        batchFile( git push --tags)
             
     }
}
