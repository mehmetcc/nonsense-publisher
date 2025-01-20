import User.encoder
import zio.json.EncoderOps
import zio.{RIO, ZIO}

object Runner {
  val forever: RIO[Publisher with Configuration, Unit] = for {
    configuration <- ZIO.service[Configuration]
    entity         = User.next.toJson
    _             <- ZIO.foreachParDiscard(1 to configuration.parallelism)(_ => effect.forever)
  } yield ()

  private def effect: RIO[Publisher, Unit] = for {
    entity <- ZIO.succeed(User.next.toJson)
    _      <- Publisher.publish(entity)
  } yield ()
}
