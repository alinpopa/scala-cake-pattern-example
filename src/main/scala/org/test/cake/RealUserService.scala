package org.test.cake

class RealUserService extends UserService{
  private val authUsers = Map("1" -> User("1", "U-AAA"),
                              "2" -> User("2", "U-BBB"))
  override def auth(user: User): Boolean = {
    authUsers.get(user.id) match {
      case Some(_) => true
      case None => false
    }
  }
}
