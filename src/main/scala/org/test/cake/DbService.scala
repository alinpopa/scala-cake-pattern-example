package org.test.cake

trait DbService {
  def getUser(userid: String): Option[User]
}
