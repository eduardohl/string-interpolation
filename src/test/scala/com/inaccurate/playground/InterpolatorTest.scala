package com.inaccurate.playground

import org.scalatest.{FeatureSpec, Matchers}


class InterpolatorTest extends FeatureSpec with Matchers {

  feature ("Testing different types of String Interpolation") {
    scenario ("Testing the s string interpolation") {
      val worldString = "world"
      s"hello $worldString" should be ("hello world")
    }
    scenario ("Testing the f string interpolation (similar to printf)") {
      val percentageoOfWater = 71.444f
      val waterString = "water"
      f"the world is $percentageoOfWater%2.1f percent covered by $waterString%s" should be (
        "the world is 71.4 percent covered by water"
      )
    }
    scenario ("Testing the raw string interpolation") {
      val worldString = "world"
      raw"hello \n $worldString" should be ("""hello \n world""")
    }
    scenario ("Testing custom url string interpolation") {
      import com.inaccurate.playground.URLHelper._
      val worldString = "https://inaccuratethoughts.com/"
      url"get$worldString" shouldNot be(empty)
    }
  }

}
