package controllers

import org.scalatest._
import scala.slick.driver.H2Driver.simple._
import models.Members
import models.Member
import play.api.test._
import play.api.test.Helpers._

class MembersControllerSpec extends FunSpec with BeforeAndAfter with Matchers {

  implicit var session: Session = _

  val members = TableQuery[Members]

  before {
    session = Database.forURL("jdbc:h2:mem:test1", driver = "org.h2.Driver").createSession()
    members.ddl.create
  }

  after {
    session.close()
  }

  describe("GET #index") {

    it("render the index page") {
      running(FakeApplication()) {
        val index = route(FakeRequest(GET, "/members")).get
        status(index) should equal(OK)
      }
    }

    it("should return a list of members") {
      members += Member(None, "Bobby", "Brown", 1234)
      members += Member(None, "Whitney", "Houston", 5678)
    }
  }

}