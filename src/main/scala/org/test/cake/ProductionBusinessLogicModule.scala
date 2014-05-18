package org.test.cake

trait ProductionBusinessLogicModule extends BusinessLogicModule{
  val userService = new RealUserService
  val dbService = new RealDbService
}
