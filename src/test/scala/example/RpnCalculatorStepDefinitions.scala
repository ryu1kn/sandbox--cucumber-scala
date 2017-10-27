package example

import cucumber.api.Scenario
import cucumber.api.scala.{ScalaDsl, EN}
import org.scalatest._

class RpnCalculatorStepDefinitions extends ScalaDsl with EN with Matchers {

  val calc = new RpnCalculator

  When("""^I add (\d+) and (\d+)$"""){ (arg1: Double, arg2: Double) =>
    calc push arg1
    calc push arg2
    calc push "+"
  }

  Then("^the result is (\\d+)$") { expected: Double =>
    calc.value shouldEqual expected
  }

  Before("not @foo"){ scenario : Scenario =>
    println("Runs before scenarios *not* tagged with @foo")
  }
}
