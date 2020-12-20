package com.example.firstAkka

import akka.actor.Actor
import akka.event.Logging

import scala.collection.mutable.HashMap

case class SetRequest(key: String, value: Object)

class FirstAkka extends Actor {
  val map = new HashMap[String, Object]
  val log = Logging(context.system, this)

  override def receive = {
    case SetRequest(key, value) => {
      log.info(s"received SetRequest key:${key},value:${value}")
      map.put(key, value)
    }
    case o =>
      log.info(s"receive unknown message:${o}")
  }
}
