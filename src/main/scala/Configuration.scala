import zio._
import zio.config.magnolia.deriveConfig
import zio.config.typesafe.TypesafeConfigProvider

case class Configuration(bootstrapServers: String, topic: String)

object Configuration {
  private val config: Config[Configuration] = deriveConfig[Configuration].nested("application")

  val live: Layer[Config.Error, Configuration] = ZLayer.fromZIO {
    ZIO
      .config[Configuration](config)
      .withConfigProvider(TypesafeConfigProvider.fromResourcePath().kebabCase)
  }
}
