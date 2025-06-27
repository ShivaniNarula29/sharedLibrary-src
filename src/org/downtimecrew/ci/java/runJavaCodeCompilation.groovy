package org.teamdowntimecrew.ci.java

def call(Map config = [:]) {
    stage(config.stageName ?: 'Java Compile & Archive') {
        sh 'mvn clean compile'
        archiveArtifacts artifacts: 'target/classes/**/*.class', fingerprint: true
    }
}
