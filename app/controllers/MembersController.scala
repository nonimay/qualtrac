package controllers

import play.api._
import play.api.mvc._
import models._
import play.api.db.slick.Config.driver.simple._
import play.api.db._
import play.api.Play.current

object MembersController extends Controller {

  lazy val database = Database.forDataSource(DB.getDataSource())

  def index = Action {
      Ok(views.html.members(MemberDAL.findAll))
  }

}