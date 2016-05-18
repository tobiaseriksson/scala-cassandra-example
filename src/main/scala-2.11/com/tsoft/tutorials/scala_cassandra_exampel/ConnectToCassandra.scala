package com.tsoft.tutorials.scala_cassandra_exampel

import com.datastax.driver.core.{Cluster, Session}
import scala.collection.JavaConversions

object ConnectToCassandra {
  var cluster:Cluster = null
  var session:Session = null

  def setup(keyspaceName:String, host:String, port:Int) :(Cluster,Session) = {
    cluster = Cluster.builder().addContactPoint(host).withPort(port).build()
    session = cluster.connect(keyspaceName)
    (cluster,session)
  }

  def close() = {
    if( session != null ) session.close()
    if( cluster != null ) cluster.close()
  }

  def demo() = {
    try {
      val keyspace = "playground"
      val (cluster, session) = ConnectToCassandra.setup(keyspace, "localhost", 9042)

      val cql = "SELECT * FROM individual"
      val resultSet = session.execute( cql )
      val itr = JavaConversions.asScalaIterator(resultSet.iterator)
      itr.foreach( row => {
        val firstName = row.getString("firstname")
        val lastName = row.getString("lastname")
        println(s"$firstName $lastName")
      })

    }
    finally {
      ConnectToCassandra.close()
      println("Done!")
    }
  }

  def main(args: Array[String]) {
    ConnectToCassandra.demo()
  }

}
