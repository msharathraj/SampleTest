job('Test') {
	stage('test'){
	step{
    scm {
       git {
            remote {
                name('test3')
                url('https://github.com/msharathraj/SampleTest.git')
            }
            branch('test2')
            extensions {
                mergeOptions {
                    remote('upstream')
                    branch('master')
                }
            }
        }
    }
	}
	}
}
