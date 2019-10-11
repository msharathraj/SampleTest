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
	     shell('''
	         env
	         echo "Generating the versionlock file and pushing to the repo"
	         git pull origin master
	         git add --all
	         
		 git commit -am "Committing changes caused by ${BUILD_TAG}"
	         it push origin master
	         
		 git tag -a "SampleTag"
	         git push --tags
             '''.stripIndent())
     }
}
