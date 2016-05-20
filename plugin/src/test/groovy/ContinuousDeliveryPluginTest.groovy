package com.github.hippoom.gradle.plugins.android

import org.junit.Test
import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder

class ContinuousDeliveryPluginTest {
    @Test
    public void should_add_turn_device_power_on_task_to_project() {
        Project project = ProjectBuilder.builder().build()

        //project.apply plugin: 'com.github.hippoom.android.continuousdelivery'

        assert project.tasks.turnDevicePowerOn
    }
}
