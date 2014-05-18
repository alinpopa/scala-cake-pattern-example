package org.test.cake

class ApplicationBusinessService extends BusinessService{
  this: BusinessLogicModule =>

  override def run: Boolean = {
    val user = User("3", "U-CCC")
    val existingUser = dbService.getUser(user.id) match {
      case None => false
      case Some(_) => true
    }
    if(existingUser && userService.auth(user)) true
    else false
  }
}
