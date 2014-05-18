package org.test.cake

import org.scalatest.{Matchers, FlatSpec}

class ApplicationBusinessServiceSuite extends FlatSpec with Matchers{
  it should "return true when user exists and authenticated" in {
    val applicationBusinessService = new ApplicationBusinessService with BusinessLogicModule {
      val userService = new UserService {
        override def auth(user: User): Boolean = true
      }
      val dbService = new DbService {
        override def getUser(userid: String): Option[User] = Some(User(userid, "test-user"))
      }
    }
    applicationBusinessService.run should be (true)
  }

  it should "return false when user doesn't exists but it's authenticated" in {
    val applicationBusinessService = new ApplicationBusinessService with BusinessLogicModule {
      val userService = new UserService {
        override def auth(user: User): Boolean = true
      }
      val dbService = new DbService {
        override def getUser(userid: String): Option[User] = None
      }
    }
    applicationBusinessService.run should be (false)
  }

  it should "return false when user exists and it's not authenticated" in {
    val applicationBusinessService = new ApplicationBusinessService with BusinessLogicModule {
      val userService = new UserService {
        override def auth(user: User): Boolean = false
      }
      val dbService = new DbService {
        override def getUser(userid: String): Option[User] = Some(User(userid, "test-user"))
      }
    }
    applicationBusinessService.run should be (false)
  }

  it should "return false when user doesn't exists nor it's authenticated" in {
    val applicationBusinessService = new ApplicationBusinessService with BusinessLogicModule {
      val userService = new UserService {
        override def auth(user: User): Boolean = false
      }
      val dbService = new DbService {
        override def getUser(userid: String): Option[User] = None
      }
    }
    applicationBusinessService.run should be (false)
  }
}
