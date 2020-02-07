package config

import ciris._
import ciris.ConfigValue
import config.data.AppConfig
import cats.effect.{ Async, ContextShift }
import config.environments.AppEnvironment._
import config.environments.AppEnvironment
import config.data.PostgreSQLConfig
import ciris.refined._
import eu.timepit.refined.auto._

import eu.timepit.refined._
object load {

  def apply[F[_]: Async: ContextShift]: F[AppConfig] =
    env("APP_ENV")
      .as[AppEnvironment]
      .default(Dev)
      .flatMap {
        case Test =>
          default()
        case Prod =>
          default()
        case _ =>
          default()
      }
      .load[F]

  private def default(): ConfigValue[AppConfig] =
    ConfigValue.default(
      AppConfig(
        PostgreSQLConfig(
          url = "jdbc:postgresql://localhost/pure",
          host = "localhost",
          port = 5432,
          user = "postgres",
          pass = "pass",
          database = "pure"
        )
      )
    )
}
