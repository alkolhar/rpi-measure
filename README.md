# Measure all the things 

During my studies I received a [sensor kit from Joy IT](https://sensorkit.joy-it.net/de/), which is now looking for a new use. 

In a first step, temperature, air pressure and relative humidity are measured and stored in a database.
The recorded data should then be made accessible with a RESTful API.

## The Measurement
To record the data a python script is written. This should cyclically store measurement points in a database.

## The Database
The database should be on the same Raspberry Pi. The following are suitable for this:
- MongoDB: open-source database that stores data in a document structure (as opposed to the more common SQL-table structure)
- PostgreSQL: free, open-source database which is incredibly popular. It uses a relational model where data is stored in tables
- SQLite: easy to install and easy to use SQL database. It’s designed to have a light footprint so that it can run on devices such as phones, cars, and other low power / low CPU applications

## The API
To further improve my Java skills and learn new frameworks, [Spring](https://spring.io/) is used to design a RESTful API.
