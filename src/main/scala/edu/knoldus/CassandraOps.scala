package edu.knoldus

import com.datastax.driver.core.{Row, Session}

import scala.collection.JavaConverters._


class CassandraOps {

  val session: Session = CassandraConnector.getSession

  def getByEmail(email: String): List[Row] = {
    session.execute(s"SELECT * FROM user WHERE email = '$email'")
      .asScala.toList
  }

  def getByVideoName(videoName: String): List[Row] = {
    session.execute(s"SELECT * FROM video WHERE video_name = '$videoName'")
      .asScala.toList
  }

  def getByYear(year: String): List[Row] = {
    val formattedYear = yearFormat(year)
    session.execute(s"SELECT * FROM videobyyear  WHERE year > '$formattedYear' ALLOW FILTERING ;")
      .asScala.toList
  }

  def yearFormat(year: String): String = {
    year match {
      case str: String if !str.contains('-') => s"$str-12-31"
      case year: String => year
    }
  }

  def getByUserDescYear(id: String): List[Row] = {
    session.execute(s"select * from videoByYear where userId = $id ORDER BY year DESC LIMIT 5;")
      .asScala.toList
  }

}
