import zio._
import zio.config.magnolia.deriveConfig
import zio.config.typesafe.TypesafeConfigProvider

case class Configuration(bootstrapServers: List[String], topic: String, parallelism: Int)

object Configuration {
  private val config: Config[Configuration] = deriveConfig[Configuration].nested("application")

  val live: Layer[Config.Error, Configuration] = ZLayer.fromZIO {
    ZIO
      .config[Configuration](config)
      .withConfigProvider(TypesafeConfigProvider.fromResourcePath().kebabCase)
      .tap(configuration => ZIO.logInfo(s"""
                                           |application configuration:
                                           |bootstrap-servers: ${configuration.bootstrapServers.mkString(",")}
                                           |topics: ${configuration.topic}
                                           |""".stripMargin))
  }
}
