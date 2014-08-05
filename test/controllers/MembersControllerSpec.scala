package controllers

import org.scalatest._
import play.api.test._
import play.api.test.Helpers._
import org.scalatestplus.play._

class MembersControllerSpec extends PlaySpec with OneServerPerSuite {

  "GET #index" must {

    "render the index page OK" in {
        val index = route(FakeRequest(GET, "/members")).get
        status(index) must equal(OK)
    }

    "render the index template" in {
      val index = route(FakeRequest(GET, "/members")).get
      contentAsString(index) must include("Current Members")
    }
  }

}