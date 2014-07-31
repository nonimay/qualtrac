package models

import org.scalatest._
import scala.slick.driver.H2Driver.simple._
import scala.slick.jdbc.meta._
import org.h2.jdbc.JdbcSQLException

class MemberSpec extends FunSpec with BeforeAndAfter {
  
  implicit var session: Session = _
  
  val members = TableQuery[Members]
  
  before {
    session = Database.forURL("jdbc:h2:mem:test1", driver = "org.h2.Driver").createSession()
    members.ddl.create
  }
  
  describe("Validation") {
    it("should validate the presence of firstName") {
      intercept[JdbcSQLException] {
        members += new Member(None, null)
      }
    }
  }

}