job('example-2') {
    scm {
        git {
            remote {
                name('origin')
                url('https://github.com/msharathraj/SampleTest.git')
            }
            remote {
                name('upstream')
                url('https://github.com/msharathraj/SampleTest.git')
            }
            branch('test3')
            extensions {
                mergeOptions {
                    remote('test3')
                    branch('master')
                }
            }
        }
    }
}