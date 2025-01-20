import User.encoder
import zio._
import zio.json.EncoderOps

object Main extends ZIOAppDefault {
  override def run: ZIO[Environment with ZIOAppArgs with Scope, Any, Any] =
    program.provide(Configuration.live, PublisherImpl.live)

  private val program =
    for {
      encoded <- ZIO.succeed(User.next.toJson)
      _       <- Runner.forever
    } yield ()
}
