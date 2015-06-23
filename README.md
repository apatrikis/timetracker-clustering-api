# Time Tracker
Time Tracker is a self educational application for timesheet tracking. The application mainly has three parts:
- a JEE7 REST server, connecting to a database for storing users, projects and timesheets, as well as an WebSocket interface to notify registered clients about status changes.
- a common library with interfaces, entities and exceptions.
- a AngularJS web client that is consuming the servers's REST API and registers for status changes.

# Time Tracker - Clustering API
## Main desicions
During the creation and modification of `TimeRecord`s a notification message is created. A notification is to be send to a receiver.
The messaging between the server and the client is handeled in `Timetracker Websocket`.

In case a cluster is used, the messaging must span over all server instances.

Much like `Timetracker Websocket`, `Event`s are use for decoupling this `Clustering API` from other functionalities.
The `Timetracker Clustering` receives events, and uses a `JMS Topic` for broadcasting messages into the cluster.

## Used software and versions
- IDE : Oracle NetBeans 8.0.2 (https://netbeans.org/downloads/, choose the `Java EE` edition)

The IDE is allready installed for the development of `Timetracker Server`.

For the following descriptions the base installation directory `\time-tracker` is assumed.

## Development
The directory structure described below is like this:
```
\time-tracker
   \timetracker-clustering-api
```

### Requirements
1. Download the `timetracker-clustering-api` project from https://github.com/apatrikis/timetracker-clustering-api

In case NetBeans IDE is not already installed refer to `timetracker-server`.


### Initial configuration
This is covered by `timetracker-server`, no special setup is required.

## Test
Currently there are no `Unit test` for this project.
The classes are involved in test for the `timetracker-server`.

## Build (CI)
For `CI` the `Maven POM` is to be used within `Jenkins`.
For more information see the `timetracker-server` project.

## Run
The packaging type of this project is `JAR`.
In case cluster support should be available for the `timetracker-server` the artifact needs to be included in the `timetracker-server` artifact.
See the `timetracker-clustering-impl` project for more details.
