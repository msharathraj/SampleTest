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
            url('ssh://git@stash.intralinks.com:7999/qe/qe-pom.git')
            branch("develop")
            credentials('git')
            extensions {
                localBranch('master')
                wipeOutWorkspace()
            }
          }
        }
    }
	steps {
	     shell('''
	         env
	         set -e

	         echo "Generating the versionlock file and pushing to the repo"
	         git pull origin master
	         git add --all
	         set +e
	         git status | grep "nothing to commit"
	         git commit -am "Committing changes caused by 1.0.0"
	         git push origin master
	         
	     '''.stripIndent())
     }
}	