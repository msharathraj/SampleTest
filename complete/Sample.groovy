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
job("Merge-Release-Git") {
     scm {
        git {
          remote {
			url('https://github.com/msharathraj/SampleTest.git')
            branch("develop")
            extensions {
                localBranch('develop')
            }
          }
        }
    }
    steps {
	     batchFile('echo Hello World!')
	     batchFile('git branch')
	     batchFile('git branch release')
	     batchFile('git checkout release')
	     batchFile('git merge develop')
	     batchFile('git push')
		 triggers {
			githubPush()
		}
		 mavenJob('mvn clean install') {
			postBuildSteps('SUCCESS') {
				batchFile("echo 'run after Maven'")
			}
		}
	 }
}

job("Merge-Master-Git") {
     scm {
        git {
          remote {
            url('https://github.com/msharathraj/SampleTest.git')
            branch("develop")
            extensions {
                localBranch('develop')
            }
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
			githubPush()
		}
	 }
}

job("Tag-Creation-Git") {
     scm {
        git {
          remote {
            url('https://github.com/msharathraj/SampleTest.git')
            branch("develop")
            extensions {
                localBranch('develop')
            }
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
			githubPush()
		}

	 }
}
