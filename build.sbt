name := "scala-cassandra-example"

version := "1.0"

scalaVersion := "2.11.8"

val cassandraDriverVersion = "3.0.0"
libraryDependencies += "com.datastax.cassandra" % "cassandra-driver-core" % cassandraDriverVersion

mainClass in (Compile, run) := Some("com.tsoft.tutorials.scala_cassandra_exampel.ConnectToCassandra")

