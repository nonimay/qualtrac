package models

import org.scalatest._
import play.api.db.slick.Config.driver.simple._
import scala.slick.jdbc.meta._
import org.scalatestplus.play._
import play.api.db.slick.DB
import java.sql.SQLException

class MemberSpec extends PlaySpec with OneServerPerSuite with BeforeAndAfter {

  val members = TableQuery[Members]

  "Validation" must {
    "validate the presence of firstName" in DB.withSession { implicit session =>
        intercept[SQLException] {
          members += new Member(None, null, "Brown", 1370)
      }
    }

    "validate the presence of lastName" in DB.withSession { implicit session =>
      intercept[SQLException] {
        members += new Member(None, "Bobby", null, 1370)
      }
    }
  }

  "Save" must {
    " create an ID" in DB.withSession { implicit session =>
      val memberId = (members returning members.map(_.id)) += Member(None, "Bobby", "Brown", 1370)
      memberId must be > 0
    }
  }

}