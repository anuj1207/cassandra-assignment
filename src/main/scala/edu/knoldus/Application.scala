package edu.knoldus

object Application {

  def main(args: Array[String]): Unit = {
    val cassandraOps = new CassandraOps
    val email = "anuj.633@live.com"
    val video_name = "kafka-1"
    val year = "1990-12-31"
    val userId = "2022"

    println(s"Value associated with $email:")
    cassandraOps.getByEmail(email).foreach(println)
    println(s"Video associated with name: $video_name")
    cassandraOps.getByVideoName(video_name).foreach(println)
    println(s"songs released after year: $year")
    cassandraOps.getByYear(year).foreach(println)
    println(s"songs by userId $userId descending year:")
    cassandraOps.getByUserDescYear(userId).foreach(println)

  }

}
