package sample

import com.datastax.driver.core.Cluster

object Connector extends App{

  val cluster = Cluster.builder().addContactPoint("127.0.0.1").build()

  val session = cluster.connect("kip")

  println(session.execute("select * from songs").iterator().next())

  session.execute("insert into songs (id, album, artist, data, title) values (6, 'unknown', 'nasya', '....', 'mein tenu samjhawan')")

  println(session.execute("select * from songs where id = 6").iterator().next())


}
