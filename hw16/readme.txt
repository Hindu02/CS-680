Observable:
A generic class that implements the Observable pattern and manages a list of observers.

Observer:
An interface defining the update method that concrete observer classes implement to react to changes.



MobilePhone:
Monitors room temperature and sends email alerts when it goes out of the desired range.
Implements the Observer interface for observing room temperature.
The update method is called when the temperature changes, and it calls the email method to notify the user about temperature warnings.
The email method checks if the temperature is too low or too high and prints a warning message accordingly.


AirConditioner:
Maintains the desired room temperature and takes actions to adjust it when necessary.
Implements the Observer interface for observing room temperature.
It has a desired temperature (DESIRED_TEMPERATURE) that it aims to maintain.
The update method is called when the temperature changes and prints the new temperature.
The adjustTemperature method checks the current temperature against the desired temperature and takes appropriate actions (e.g., taking more air or stopping air) to adjust the temperature.


SmartHomeController:
Controls the air conditioner and makes decisions based on the room temperature to maintain comfort.
Implements the Observer interface for observing room temperature.
It also has a desired temperature (DESIRED_TEMPERATURE) to maintain.
The update method is called when the temperature changes, and it calls the temperatureChanged method to handle the temperature change.
The temperatureChanged method checks if the temperature is lower or higher than the desired temperature and takes actions accordingly.
It uses a random boolean generator in the checkIfAirConsitionerIsRunning method to simulate whether the air conditioner is running and decides whether to switch it on or off based on temperature conditions.


Sensor:
Simulates a sensor for measuring room temperature and notifies observers of temperature changes.
Extends the Observable class, which is parameterized with Float to represent the room temperature.
It's responsible for updating and notifying its observers when the room temperature changes.

