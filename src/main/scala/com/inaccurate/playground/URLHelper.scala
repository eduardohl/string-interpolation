package com.inaccurate.playground

import scala.io.{BufferedSource, Source}

object URLHelper {
  implicit class GetURLHelper(val sc: StringContext) {
    def usage = throw new RuntimeException("Interpolator usage: url(get|post ${address}")
    def url(args: Any*): BufferedSource = {
      (sc.parts.headOption, args.headOption.map(_.toString)) match {
        case (None, _) => usage
        case (_, None) => usage
        case (Some("get"), Some(addr)) => Source.fromURL(addr)
        case (Some("post"), Some(_)) => ???
        case (Some("delete"), Some(_)) => ???
        case (Some("option"), Some(_)) => ???
        case (Some(_), _) => usage
      }
    }
  }
}
