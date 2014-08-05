import play.api.db.slick.DB
import play.api.GlobalSettings
import play.api.db.slick.Config.driver.simple._
import play.api.Application
import play.api.Play.current
import models.Members

object Global extends GlobalSettings {

  override def onStart(app: Application) {

    DB.withSession { implicit session =>
      TableQuery[Members].ddl.create
    }
  }
}