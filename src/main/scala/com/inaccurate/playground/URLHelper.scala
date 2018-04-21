package com.inaccurate.playground

import scala.io.{BufferedSource, Source}

object URLHelper {
  implicit class GetURLHelper(val sc: StringContext) {
    def url(args: Any*): BufferedSource = {
      (sc.parts.headOption, args.headOption.map(_.toString)) match {
        case (Some("get"), Some(addr)) => Source.fromURL(addr)
        case _ => throw new RuntimeException("Interpolator usage: url(get|post ${address}")
      }
    }
  }
}
