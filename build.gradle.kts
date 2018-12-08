plugins {
    java
    application
}

repositories {
    mavenCentral()
}


dependencies {
    implementation("org.apache.commons:commons-lang3:3.8.1")
}

application {
    mainClassName = "de.skerkewitz.brainfuck.BrainfuckGen"
}


