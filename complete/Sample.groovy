job('example-2') {
    def project = 'msharathraj/SampleTest'
	def branchApi = new URL("https://github.com/msharathraj/SampleTest/branches")
	def branches = new groovy.json.JsonSlurper().parse(branchApi.newReader())
	branches.each {
    def branchName = it.name
    def jobName = "${project}-${branchName}".replaceAll('/','-')
    job(jobName) {
        scm {
            git("git://github.com/${project}.git", branchName)
        }
        steps {
            maven("test -Dproject.name=${project}/${branchName}")
        }
    }
}
}