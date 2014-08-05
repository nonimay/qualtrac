package models

import play.api.Play.current
import play.api.db.slick.Config.driver.simple._
import play.api.db.slick.DB

/**
 * Created by fiona on 30/07/2014.
 */



case class Member(id: Option[Int] = None, firstName: String, lastName: String, membershipNumber: Int)

object MemberDAL {
  def findAll: List[Member] = DB.withSession { implicit session =>
    TableQuery[Members].list
  }
}

class Members(tag: Tag) extends Table[Member](tag, "MEMBER") {
  
  def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)
  def firstName = column[String]("FIRST_NAME")
  def lastName = column[String]("LAST_NAME")
  def membershipNumber = column[Int]("MEMBERSHIP_NUMBER")
  def * = (id.?, firstName, lastName, membershipNumber) <> (Member.tupled, Member.unapply _)
  
}
