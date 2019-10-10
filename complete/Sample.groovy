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