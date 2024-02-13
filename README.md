# Helicopter Madness 
<div align="center">

![CI](https://img.shields.io/github/actions/workflow/status/SverreNystad/helicopter-madness/ci.yml)
![CodeQL](https://img.shields.io/github/actions/workflow/status/SverreNystad/helicopter-madness/codeql.yml)
![GitHub top language](https://img.shields.io/github/languages/top/SverreNystad/helicopter-madness)
![GitHub language count](https://img.shields.io/github/languages/count/SverreNystad/helicopter-madness)
[![Project Version](https://img.shields.io/badge/version-2.2-blue)](https://img.shields.io/badge/version-2.2-blue)

</div>

Helicopter Madness is a simple 2D game developed using the LibGDX framework. It is designed as a series of exercises focusing on sprite manipulation, user input handling, animation, and basic collision detection.
![Helicopter madness](/docs/images/helicopter-game.png)

The gameplay is simple: The player controls every helicopter on the screen at once. Crash them together or keep them apart, it's up to you.

[![Image from Gyazo](https://i.gyazo.com/c8a2c23770e380bcdf68d1cf7aba0709.gif)](https://gyazo.com/c8a2c23770e380bcdf68d1cf7aba0709)



## Installation and Setup

### Prerequisites
<ul>
<details> <summary><b> Git </b> </summary>
  Git is a distributed version control system that is used to manage the source code of this project. It is essential for cloning the project from GitHub and collaborating with other developers.

  * Git - Version Control System
    * Download and install Git from the official [Git website](https://git-scm.com/downloads).
    * After installation, verify the installation by running ```git --version``` in your command line or terminal.
</details>
</ul>

<ul>
  <details> <summary><b> Java JDK 17 (Download from Oracle's website) </b></summary>
  This project requires Java JDK to be installed. The project is tested with JDK 17.

  * Java JDK 17 - Java Development Kit is essential for compiling and running Java applications.
    * Download and install it from [Oracle's Java JDK Download Page](https://www.oracle.com/java/technologies/downloads/#java17) or adopt an open-source JDK like AdoptOpenJDK.
    * After installation, verify the installation by running ```java -version``` and ```javac -version``` in your command line or terminal.
  </details>
</ul>
<ul>
  <details> 
  <summary><b> Gradle 6.7 </b></summary>
  Gradle is used as the build tool for this project. It automates the process of building, testing, and deploying the application.

  * Gradle 6.7 - Gradle brings advanced build toolkit to manage dependencies and other aspects of the build process.
    * You can download Gradle from the [Gradle Download Page](https://gradle.org/install/).
    * Alternatively, if you are using a Gradle Wrapper script (gradlew or gradlew.bat), you do not need to manually install Gradle, as the wrapper script will handle the installation for you.
    * To confirm that Gradle is properly installed, run ```gradlew -v``` in your command line or terminal which will display the installed Gradle version.
  </details>
</ul>

<ul>
  <details> 
    <summary><b>Android SDK (if you want to run the game on Android)</b></summary>
    When testing the Android app one can run it either by connecting your Android phone via USB to your computer, or you could use an Android emulator (virtual device). To do this, you need to have the Android SDK installed. 
</ul>
Ensure that both Java and Gradle are properly installed and configured in your system's PATH environment variable for being able to run the game.

### Installing
To install the project, you can use the following commands:
```cmd
git clone https://github.com/SverreNystad/helicopter-madness.git
```

## How to Play
The game can be played on both desktop and Android.

To start the game, you can start it on desktop using the following command:
```cmd
gradlew desktop:run
```

To start the game on Android, you can use the following command:
```cmd
gradlew android:run
```

## Architecture
The game is built using the Model-View-Controller (MVC) pattern. The game logic is contained in the `World` class, which is the model. The `WorldAnimator` and `HelicopterAnimator` classes is the view, and the `GameApp` class is the controller. The `World` class contains the game objects and the game logic. The `WorldAnimator` and `HelicopterAnimator` class contains the rendering logic. 

The `World` class follows the Singleton pattern. 
![Helicopter madness](/docs/HelicopterMadnessClassDiagram.svg)