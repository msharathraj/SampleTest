job('Test') {
	node('master'){
	stage('test'){
	step{
    scm {
       git {
            remote {
                name('test3')
                url('https://github.com/msharathraj/SampleTest.git')
            }
            echo "git checkedout code"
        }
    }
	}
	}
	}
}
