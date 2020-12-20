package com.example.firstAkka

import akka.actor.ActorSystem
import akka.actor.testkit.typed.scaladsl.ActorTestKit
import akka.testkit.TestActorRef
import akka.util.Timeout
import org.scalatest.BeforeAndAfterAll
import org.scalatest.matchers.must.Matchers.convertToAnyMustWrapper
import org.scalatest.matchers.should.Matchers
import org.scalatest.wordspec.AnyWordSpec

import scala.concurrent.duration._

class FirstAkkaTest extends AnyWordSpec with Matchers {

  "first akka actor" should {
    "say nb" in {
      implicit val system = ActorSystem()
      implicit val timeout = Timeout(5 seconds)
      val actorRef = TestActorRef(new FirstAkka(), "firstAkka")
      actorRef ! SetRequest("hello", "nb")

      val akkademy = actorRef.underlyingActor
      akkademy.map.get("hello") mustBe Option("nb")
    }
  }
}
