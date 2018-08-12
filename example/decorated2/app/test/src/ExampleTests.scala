package app
import io.undertow.Undertow

import utest._

object ExampleTests extends TestSuite{
  def test[T](example: cask.main.BaseMain)(f: String => T): T = {
    val server = Undertow.builder
      .addHttpListener(8080, "localhost")
      .setHandler(example.defaultHandler)
      .build
    server.start()
    val res =
      try f("http://localhost:8080")
      finally server.stop()
    res
  }

  val tests = Tests{
    'Decorated2 - test(Decorated2){ host =>
      requests.get(s"$host/hello/woo").text() ==> "woo31337"
      requests.get(s"$host/internal-extra/goo").text() ==> "goo[haoyi]31337"
      requests.get(s"$host/ignore-extra/boo").text() ==> "boo[haoyi]"

    }
  }
}