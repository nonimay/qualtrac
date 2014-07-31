package models

import org.scalatest._
import scala.slick.driver.H2Driver.simple._
import scala.slick.jdbc.meta._
import org.h2.jdbc.JdbcSQLException

class MemberSpec extends FunSpec with BeforeAndAfter with Matchers {
  
  implicit var session: Session = _
  
  val members = TableQuery[Members]
  
  before {
    session = Database.forURL("jdbc:h2:mem:test1", driver = "org.h2.Driver").createSession()
    members.ddl.create
  }
  
  after {
    session.close()
  }
  
  describe("Validation") {
    it("should validate the presence of firstName") {
      intercept[JdbcSQLException] {
        members += new Member(None, null, "Brown", 1370)
      }
    }
    
    it("should validate the presence of lastName") {
      intercept[JdbcSQLException] {
        members += new Member(None, "Bobby", null, 1370)
      }
    }
  }
  
  describe("Save") {
    it("should create an ID") {
      val memberId = (members returning members.map(_.id)) += Member(None, "Bobby", "Brown", 1370)
      memberId should be > 0
    }
  }

}