package db

import config.data
import cats.effect.Sync
import org.flywaydb.core.Flyway

import eu.timepit.refined.auto._

final class FlywayDatabaseMigrator[F[_]: Sync] extends DatabaseMigrator[F] {
  def migrate(config: data.PostgreSQLConfig): F[Int] =
    Sync[F].delay {
      val flyway: Flyway = Flyway.configure().dataSource(config.url, config.user, config.pass).load()
      flyway.migrate()
    }
}
