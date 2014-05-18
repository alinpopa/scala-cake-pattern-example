package org.test.cake

class ApplicationBusinessService extends BusinessService{
  this: BusinessLogicModule =>

  override def run: Boolean = {
    val user = User("3", "U-CCC")
    if(dbService.getUser(user.id).isDefined && userService.auth(user)) true
    else false
  }
}
