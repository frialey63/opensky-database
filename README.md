# opensky-database
OpenSky Database

This SpringBoot application loads a PostgreSQL database with the aircraft database which can be downloaded from [OpenSky Network](https://opensky-network.org/aircraft-database).

The application exposes a simple REST interface for querying the database by ICAO code:

    localhost:8082/opensky/aircraft/{icao24}
    localhost:8082/opensky/aircraft/{icao24}/category
