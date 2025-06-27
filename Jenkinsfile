@Library('shivani-shared-library') _

node {
    env.GIT_BRANCH = 'main'
    env.GIT_REPO_URL = 'https://github.com/snaatak-Downtime-Crew/salary-api.git'
    env.GIT_CREDS_ID = 'downtime_github'
    env.SLACK_CHANNEL = 'java-notification'
    env.SLACK_CRED_ID = 'downtime-crew'
    env.EMAIL_TO = 'shivani.narula.snaatak@mygurukulam.co'

    def codeCompilation = new org.teamdowntimecrew.template.java.codeCompilation()
    codeCompilation.call([
        gitBranch: env.GIT_BRANCH,
        gitRepoUrl: env.GIT_REPO_URL,
        gitCredsId: env.GIT_CREDS_ID,
        slackChannel: env.SLACK_CHANNEL,
        slackCredId: env.SLACK_CRED_ID,
        emailTo: env.EMAIL_TO
    ])
}
