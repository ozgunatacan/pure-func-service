package config

import eu.timepit.refined.types.string.NonEmptyString
import eu.timepit.refined.types.net.UserPortNumber

object data {
  case class PostgreSQLConfig(
      url: NonEmptyString,
      host: NonEmptyString,
      port: UserPortNumber,
      user: NonEmptyString,
      pass: NonEmptyString,
      database: NonEmptyString
  )

  case class AppConfig(
      postgreSql: PostgreSQLConfig
  )
}
