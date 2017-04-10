package edu.knoldus

import com.datastax.driver.core.{Cluster, Session}

object CassandraConnector {

  private val cluster: Cluster = Cluster.builder().addContactPoint("127.0.0.1").build()
  private val session: Session = cluster.connect("kip")

  def getSession: Session = {
    session
  }

}
