job('pull-request-job') {
    scm {
        git {
            remote {
                name 'origin'
                url('https://github.com/msharathraj/SampleTest.git')
            }

           
            extensions {
                mergeOptions {
                    remote 'origin'
                    branch 'test3'
					localBranch 'master'
                }
            }
        }
    }
}
