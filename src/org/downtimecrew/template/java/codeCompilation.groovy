package downtimecrew.template.java

import org.downtimecrew.common.*
import org.downtimecrew.ci.java.*

def call(Map config = [:]) {
    def wsClean = new cleanWorkspace()
    def gitCheckOut = new checkout()
    def javaCompile = new runJavaCompilation()
    def notify = new notification()

    try {
        wsClean.call()

        gitCheckOut.call([
            branch: config.gitBranch,
            repoUrl: config.gitRepoUrl,
            creds: config.gitCredsId
        ])

        javaCompile.call([:])

        def reportLinks = [
            [name: 'Compiled .class Files', url: "${env.BUILD_URL}artifact/target/classes/"]
        ]

        notify.sendNotification([
            status: 'SUCCESS',
            slackChannel: config.slackChannel,
            slackCredId: config.slackCredId,
            emailTo: config.emailTo,
            reportLinks: reportLinks
        ], this)

    } catch (Exception e) {
        def reportLinks = [
            [name: 'Compiled .class Files', url: "${env.BUILD_URL}artifact/target/classes/"]
        ]

        notify.sendNotification([
            status: 'FAILURE',
            failureReason: e.message,
            failedStage: env.STAGE_NAME ?: 'Unknown',
            slackChannel: config.slackChannel,
            slackCredId: config.slackCredId,
            emailTo: config.emailTo,
            reportLinks: reportLinks
        ], this)

        throw e
    }
}
