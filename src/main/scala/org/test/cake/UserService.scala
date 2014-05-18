package org.test.cake

trait UserService {
  def auth(user: User): Boolean
}
