package models

import play.api.db.slick.Config.driver.simple._

/**
 * Created by fiona on 30/07/2014.
 */


case class Model(id: Option[Int] = None, firstName: String)

class Models(tag: Tag) extends Table[Model](tag, "MODEL") {
  def id = column[Int]("ID", O.PrimaryKey, O.AutoInc)
  def firstName = column[String]("FIRST_NAME")
  def * = (id.?, firstName) <> (Model.tupled, Model.unapply _)
}
