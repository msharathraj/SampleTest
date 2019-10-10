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
            credentials(git)
            extensions {
                localBranch('master')
                wipeOutWorkspace()
            }
          }
        }
    }
}	