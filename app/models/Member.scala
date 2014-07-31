package models

import scala.slick.driver.H2Driver.simple._



/**
 * Created by fiona on 30/07/2014.
 */


case class Member(id: Option[Int] = None, firstName: String)

class Members(tag: Tag) extends Table[Member](tag, "MODEL") {
  def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)
  def firstName = column[String]("FIRST_NAME")
  def * = (id.?, firstName) <> (Member.tupled, Member.unapply _)
}
