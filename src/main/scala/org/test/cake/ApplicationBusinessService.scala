package org.test.cake

class ApplicationBusinessService extends BusinessService{
  this: BusinessLogicModule =>

  override def run: Boolean = {
    val user = User("3", "U-CCC")
    dbService.getUser(user.id).isDefined && userService.auth(user)
  }
}
