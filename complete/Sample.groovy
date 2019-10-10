job('pull-request-job') {
    scm {
        git {
            remote {
                name 'origin'
                url('https://github.com/msharathraj/SampleTest.git')
            }

            branch '**/pull-requests/**'

            extensions {
                mergeOptions {
                    remote 'origin'
                    branch 'master'
					localBranch 'master'
                }
            }
        }
    }
}