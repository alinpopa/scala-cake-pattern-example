package org.test.cake

object Main {
  def main(args: Array[String]){
    val applicationBusinessService = new ApplicationBusinessService with ProductionBusinessLogicModule
    println(applicationBusinessService.run)
  }
}
