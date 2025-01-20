import zio._
import User.encoder
import zio.json.EncoderOps

object Main extends ZIOAppDefault {
  override def run: ZIO[Environment with ZIOAppArgs with Scope, Any, Any] =
    for {
      encoded <- ZIO.succeed(User.next.toJson)
      _       <- ZIO.log(encoded)
    } yield ()
}
