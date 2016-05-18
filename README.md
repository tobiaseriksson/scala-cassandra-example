# scala-cassandra-example
A very simple template for setting up Scala with Cassandra
with some made up data for individuals and their addresses

##Setup
###Create Keyspace and Tables

####Create the keyspace

####Create the table

```cql
CREATE TABLE playground.individual (
    id uuid,
    lastname text,
    firstname text,
    address_id uuid,
    dateofbirth timestamp,
    gender text,
    lucene__ text,
    maritialstatus text,
    marriedto_id uuid,
    parent_id uuid,
    PRIMARY KEY (id, lastname, firstname)
) WITH CLUSTERING ORDER BY (lastname ASC, firstname ASC)
```

```cql
CREATE TABLE playground.address (
    id uuid,
    city text,
    street text,
    number text,
    PRIMARY KEY (id, city, street, number)
) WITH CLUSTERING ORDER BY (city ASC, street ASC, number ASC)
```

### Import bogus data
use cqlsh to import some (bogus) data to the tables
```shell
>cqlsh
use playground;
COPY individual FROM 'individuals.csv';
COPY address FROM 'addresses.csv'
```
##Run / Test the program
```
>sbt run
```

```
info] Loading global plugins from /Users/tobias/.sbt/0.13/plugins
[info] Loading project definition from /Users/tobias/qvantel/scala-cassandra-example/project
[info] Set current project to scala-cassandra-example (in build file:/Users/tobias/qvantel/scala-cassandra-example/)
[info] Running com.tsoft.tutorials.scala_cassandra_exampel.ConnectToCassandra
SLF4J: Failed to load class "org.slf4j.impl.StaticLoggerBinder".
SLF4J: Defaulting to no-operation (NOP) logger implementation
SLF4J: See http://www.slf4j.org/codes.html#StaticLoggerBinder for further details.
Clara Mattsson
Sonja Lundqvist
Alexandra Johansson
Yassin Viklund
Jakob Blom
Sanna Eriksson
Noak Sjögren
.
.
.
```