# Countdown Timer

A desktop countdown timer built with **Java 21** and **JavaFX**.

The application allows users to configure a countdown duration, start, pause, resume and reset the timer, with an alarm sound when the countdown reaches zero.

## Features

* Configure minutes and seconds
* Start, pause and resume the countdown
* Reset the timer using the selected duration
* Prevent duration changes while the timer is running or paused
* Play an alarm sound when the countdown reaches zero
* Prevent starting a countdown with a zero duration
* Dark-themed user interface
* Resource cleanup when the application closes

## Technologies

* **Java 21**
* **JavaFX**
* **FXML**
* **JavaFX CSS**
* **Maven**
* **JUnit 5**
* **GitHub Actions**

## Architecture

The application follows a simple **MVC-based architecture**:

* **Model** — manages the timer duration, remaining time and current state.
* **View** — defines the user interface using FXML and JavaFX CSS.
* **Controller** — handles user interactions and coordinates the timer model, view and countdown timeline.

The project also uses an enum to represent the timer states:

* `STOPPED`
* `RUNNING`
* `PAUSED`

## Project Structure

```text
src/
├── main/
│   ├── java/
│   │   └── dp/dev/countdowntimer/
│   │       ├── TimerApplication.java
│   │       ├── controller/
│   │       │   └── TimerController.java
│   │       └── model/
│   │           ├── TimeState.java
│   │           └── TimerModel.java
│   │
│   └── resources/
│       └── dp/dev/countdowntimer/
│           ├── timer-view.fxml
│           ├── styles.css
│           └── sounds/
│               └── alarm_sound.wav
```

## Requirements

* Java 21 or later
* Maven 3.9 or later

## Getting Started

Clone the repository:

```bash
git clone <repository-url>
cd countdown-timer
```

Build the project:

```bash
mvn clean package
```

The application can then be launched from IntelliJ IDEA using the configured JavaFX run configuration.

## Distribution

Pre-built installers are available for:

* **Linux** — `.deb` package
* **Windows** — `.exe` installer

The installers include a bundled Java runtime, so Java does not need to be installed separately on the target system.

See the [Releases](../../releases) section to download the latest version.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.
