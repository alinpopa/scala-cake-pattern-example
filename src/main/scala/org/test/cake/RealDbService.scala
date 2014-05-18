package org.test.cake

class RealDbService extends DbService{
  private val users = Map("1" -> User("1", "U-AAA"),
                          "2" -> User("2", "U-BBB"))
  override def getUser(userid: String): Option[User] = {
    users.get(userid)
  }
}
