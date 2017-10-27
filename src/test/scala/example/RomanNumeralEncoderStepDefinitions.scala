package example

import cucumber.api.Scenario
import cucumber.api.scala.{ScalaDsl, EN}
import org.scalatest._
import scala.collection.mutable.Map

class RomanNumeralsEncoderStepDefinitions extends ScalaDsl with EN with Matchers {

  val context: Map[String,String] = Map()

  When("^I give (\\d+)$"){ (arg1: Int) =>
    context.put("converted", RomanNumeralEncoder.encode(arg1))
  }

  Then("^I get the roman numeral ([^\\s]+)$") { expected: String => {
    context.get("converted") match {
      case Some(converted) =>
        converted shouldEqual expected
      case _ => fail
    }
  }}

  Before("not @foo"){ scenario : Scenario =>
    println("Runs before scenarios *not* tagged with @foo")
  }
}