package org.downtimecrew.common

def call(Map config = [:]) {
    stage(config.stageName ?: 'Clean Workspace') {
        cleanWs()
    }
}
