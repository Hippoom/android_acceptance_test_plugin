package com.github.hippoom.gradle.plugins.android

import org.gradle.api.Plugin
import org.gradle.api.Project

class ContinuousDeliveryPlugin implements Plugin<Project> {
    void apply(Project project) {
        project.task('turnDevicePowerOn') << {
            if (isDevicePowerOn()) {
                println "Attempting to turn power on"
                project.exec {
                    executable "adb"
                    args "shell", "input", "keyevent", "26"
                }
            }
        }
    }

    private boolean isDevicePowerOn() {
        def checkDevicePower = new ByteArrayOutputStream()

        project.exec {
            executable "adb"
            args "shell", "dumpsys", "input_method"
            //store the output instead of printing to the console
            standardOutput = checkDevicePower
        }

        checkDevicePower.toString().contains("mScreenOn=false")
    }
}